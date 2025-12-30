package steps;

import pages.SearchPageAppium;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;

import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SearchSteps {

    // Appium State
    private AppiumDriver appiumDriver;

    // --- Appium Steps ---

    @Given("I open Sauce Demo using Appium on {string}")
    public void openSauceAppium(String platform) throws MalformedURLException {
        if (platform.equalsIgnoreCase("Android")) {
            UiAutomator2Options options = new UiAutomator2Options()
                    .setDeviceName("Android Emulator")
                    .setPlatformName("Android")
                    .setAutomationName("UiAutomator2")
                    .withBrowserName("Chrome"); // Use mobile browser
            appiumDriver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), options);
        } else if (platform.equalsIgnoreCase("iOS")) {
            XCUITestOptions options = new XCUITestOptions()
                    .setDeviceName("iPhone Simulator")
                    .setPlatformName("iOS")
                    .setAutomationName("XCUITest")
                    .withBrowserName("Safari"); // Use mobile safari
            appiumDriver = new IOSDriver(new URL("http://127.0.0.1:4723/"), options);
        } else {
            throw new IllegalArgumentException("Unsupported platform: " + platform);
        }
        
        SearchPageAppium searchPage = new SearchPageAppium(appiumDriver);
        searchPage.gotoPage();
    }

    @When("I search for {string} using Appium")
    public void searchAppium(String query) {
        SearchPageAppium searchPage = new SearchPageAppium(appiumDriver);
        searchPage.searchFor(query);
    }

    @Then("the title should contain {string} using Appium")
    public void checkTitleAppium(String query) {
        SearchPageAppium searchPage = new SearchPageAppium(appiumDriver);
        searchPage.verifyTitle(query);
        if (appiumDriver != null) {
            appiumDriver.quit();
        }
    }
}
