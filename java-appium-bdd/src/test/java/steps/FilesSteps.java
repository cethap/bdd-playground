package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import pages.FilesPageAppium;

import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class FilesSteps {
    private AppiumDriver driver;
    private FilesPageAppium filesPage;

    @Given("I launch the Files app on iOS")
    public void launchFilesApp() throws MalformedURLException {
        XCUITestOptions options = new XCUITestOptions()
                .setDeviceName("iPhone 16e")
                .setPlatformName("iOS")
                // .setPlatformVersion("17.2")
                .setAutomationName("XCUITest")
                .setBundleId("com.apple.DocumentsApp"); // Files app Bundle ID
        
        driver = new IOSDriver(new URL("http://127.0.0.1:4723/"), options);
        filesPage = new FilesPageAppium(driver);
    }

    @When("I tap on the \"Browse\" tab")
    public void tapBrowse() {
        filesPage.tapBrowseTab();
    }

    @Then("I should see the \"On My iPhone\" folder")
    public void checkOnMyIphone() {
        assertTrue(filesPage.isOnMyIphoneVisible(), "The 'On My iPhone' folder should be visible");
        if (driver != null) {
            driver.quit();
        }
    }
}
