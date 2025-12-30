package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;
import utils.BasePageSelenium;

public class SearchPageSelenium extends BasePageSelenium {
    private final By searchInputName = By.name("q");
    private final String baseUrl = "https://sauce-demo.myshopify.com/";

    public SearchPageSelenium(WebDriver driver) {
        super(driver);
    }

    public void gotoPage() {
        navigate(baseUrl);
    }

    public void searchFor(String term) {
        navigate(baseUrl + "/search");
        fill(searchInputName, term);
        press(searchInputName, Keys.RETURN);
    }

    public void verifyTitle(String text) {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.titleContains(text));
        assertTrue(driver.getTitle().contains(text));
    }
}
