package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import utils.BasePageAppium;
import org.openqa.selenium.By;

public class FilesPageAppium extends BasePageAppium {

    // Locators
    // Accessibility ID is often best for iOS
    private final By browseTab = AppiumBy.accessibilityId("Browse");
    private final By onMyIphoneText = AppiumBy.accessibilityId("On My iPhone");

    public FilesPageAppium(AppiumDriver driver) {
        super(driver);
    }

    public void tapBrowseTab() {
        click(browseTab);
    }

    public boolean isOnMyIphoneVisible() {
        return find(onMyIphoneText).isDisplayed();
    }
}
