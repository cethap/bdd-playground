package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePageSelenium {
    protected WebDriver driver;

    public BasePageSelenium(WebDriver driver) {
        this.driver = driver;
    }

    public void navigate(String url) {
        driver.get(url);
    }

    public WebElement find(By locator) {
        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public void click(By locator) {
        find(locator).click();
    }

    public void fill(By locator, String text) {
        WebElement element = find(locator);
        element.clear();
        element.sendKeys(text);
    }

    public void press(By locator, Keys key) {
        find(locator).sendKeys(key);
    }
}
