package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SearchPageSelenium {
    private final WebDriver driver;
    private final By searchInputName = By.name("q");
    private final String baseUrl = "https://sauce-demo.myshopify.com/";
    private final String searchUrl = "https://sauce-demo.myshopify.com/search";

    public SearchPageSelenium(WebDriver driver) {
        this.driver = driver;
    }

    public void gotoPage() {
        driver.get(baseUrl);
    }

    public void searchFor(String term) {
        driver.get(searchUrl);
        
        WebElement searchBox = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(searchInputName));
                
        searchBox.clear();
        searchBox.sendKeys(term);
        searchBox.sendKeys(Keys.RETURN);
    }

    public void verifyTitle(String text) {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.titleContains(text));
        assertTrue(driver.getTitle().contains(text));
    }
}
