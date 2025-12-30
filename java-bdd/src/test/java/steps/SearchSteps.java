package steps;

import pages.SearchPagePlaywright;
import pages.SearchPageSelenium;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import com.microsoft.playwright.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

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
        SearchPageSelenium searchPage = new SearchPageSelenium(driver);
        searchPage.gotoPage();
    }

    @When("I search for {string} using Selenium")
    public void searchSelenium(String query) {
        SearchPageSelenium searchPage = new SearchPageSelenium(driver);
        searchPage.searchFor(query);
    }

    @Then("the title should contain {string} using Selenium")
    public void checkTitleSelenium(String query) {
        SearchPageSelenium searchPage = new SearchPageSelenium(driver);
        searchPage.verifyTitle(query);
        driver.quit();
    }

    // --- Playwright Steps ---

    @Given("I open Sauce Demo using Playwright")
    public void openSaucePlaywright() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(true));
        page = browser.newPage();
        SearchPagePlaywright searchPage = new SearchPagePlaywright(page);
        searchPage.gotoPage();
    }

    @When("I search for {string} using Playwright")
    public void searchPlaywright(String query) {
        SearchPagePlaywright searchPage = new SearchPagePlaywright(page);
        searchPage.searchFor(query);
    }

    @Then("the title should contain {string} using Playwright")
    public void checkTitlePlaywright(String query) {
        SearchPagePlaywright searchPage = new SearchPagePlaywright(page);
        searchPage.verifyTitle(query);
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
