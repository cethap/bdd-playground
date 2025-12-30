package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import com.microsoft.playwright.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SearchSteps {

    // Selenium State
    private WebDriver driver;

    // Playwright State
    private Playwright playwright;
    private Browser browser;
    private Page page;

    // RestAssured State
    private String apiUrl;
    private Response response;

    // --- Selenium Steps ---

    @Before("@selenium")
    public void setupSelenium() {
    }

    @Given("I open Sauce Demo using Selenium")
    public void openSauceSelenium() {
        // Using main page
        org.openqa.selenium.chrome.ChromeOptions options = new org.openqa.selenium.chrome.ChromeOptions();
        options.addArguments("--headless=new");
        driver = new ChromeDriver(options);
        driver.get("https://sauce-demo.myshopify.com/");
    }

    @When("I search for {string} using Selenium")
    public void searchSelenium(String query) {
        // Find search button/link or input. 
        // Based on analysis, let's go to /search page to be safe or try to find an input.
        // Direct navigation to search is safer for automation stability in this demo.
        driver.get("https://sauce-demo.myshopify.com/search");
        
        // Shopify search input usually has name='q'
        WebElement searchBox = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.name("q")));
                
        searchBox.clear();
        searchBox.sendKeys(query);
        searchBox.sendKeys(Keys.RETURN);
    }

    @Then("the title should contain {string} using Selenium")
    public void checkTitleSelenium(String query) {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.titleContains(query));
        assertTrue(driver.getTitle().contains(query));
        driver.quit();
    }

    // --- Playwright Steps ---

    @Given("I open Sauce Demo using Playwright")
    public void openSaucePlaywright() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(true));
        page = browser.newPage();
        page.navigate("https://sauce-demo.myshopify.com/");
    }

    @When("I search for {string} using Playwright")
    public void searchPlaywright(String query) {
        page.navigate("https://sauce-demo.myshopify.com/search");
        page.fill("input[name='q']", query);
        page.press("input[name='q']", "Enter");
    }

    @Then("the title should contain {string} using Playwright")
    public void checkTitlePlaywright(String query) {
        page.waitForTimeout(2000); 
        String title = page.title();
        // Since the title might be "Search: 1 result for ..." or just "Sauce Demo", we check what's passed
        assertTrue(title.contains(query));
        browser.close();
        playwright.close();
    }

    // --- RestAssured Steps ---

    @Given("I target the JSONPlaceholder API")
    public void targetApi() {
        apiUrl = "https://jsonplaceholder.typicode.com";
    }

    @When("I request the user with ID {int}")
    public void requestUser(int id) {
        response = RestAssured.get(apiUrl + "/users/" + id);
    }

    @Then("the response status code should be {int}")
    public void checkStatusCode(int statusCode) {
        assertEquals(statusCode, response.getStatusCode());
    }

    @Then("the username should be {string}")
    public void checkUsername(String expectedName) {
        String actualName = response.jsonPath().getString("username");
        assertEquals(expectedName, actualName);
    }
}
