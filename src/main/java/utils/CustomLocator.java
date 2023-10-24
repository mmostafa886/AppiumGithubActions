package utils;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
public class CustomLocator {


    public static By elementLocator(String locatorType, String locatorValue) {
        switch (locatorType.toLowerCase()) {
            case "id":
                return new By.ById(locatorValue);
            case "xpath":
                return By.xpath(locatorValue);
            // Add more cases for other locator types as needed
            case "accessbilityid":
                return new AppiumBy.ByAccessibilityId(locatorValue);
            default:
                throw new UnsupportedOperationException("Locator type not supported for Android!");
        }
    }

}
