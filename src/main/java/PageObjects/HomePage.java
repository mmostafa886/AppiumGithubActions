package PageObjects;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends PageBase{
    public WebElement nextBtn = driver.findElement(AppiumBy.iOSNsPredicateString("label == 'Next' AND name == 'Next' AND type == 'XCUIElementTypeButton'"));
    public HomePage(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    public void clickNextBtn() {
        waitForVisibility(nextBtn);
        click(nextBtn);
    }
}
