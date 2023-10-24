package utils;

import PageObjects.PageBase;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CustomLocator extends PageBase {


    public CustomLocator(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    public static WebElement customElementLocator(String locatorType, String locatorValue) {
        switch (locatorType.toLowerCase()) {
            case "id":
                return driver.findElement(new By.ById(locatorValue));
            case "xpath":
                return driver.findElement(By.xpath(locatorValue));
            case "accessbilityid":
                return driver.findElement(new AppiumBy.ByAccessibilityId(locatorValue));
            case "iosn":
                return driver.findElement(AppiumBy.iOSNsPredicateString(locatorValue));
            default:
                throw new UnsupportedOperationException("The used Locator doesn't reveal any element!");
        }
    }

}
