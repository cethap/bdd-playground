package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.BasePageAppium;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SearchPageAppium extends BasePageAppium {
    private final By searchInputName = By.name("q");
    private final String baseUrl = "https://sauce-demo.myshopify.com/";

    public SearchPageAppium(AppiumDriver driver) {
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
