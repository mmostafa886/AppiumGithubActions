package tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;

public class TestBase extends AbstractTestNGCucumberTests {
    public static AppiumDriver driver;
    protected AndroidDriver androidDriver;
    protected IOSDriver iosDriver;

    public static void Android_setUp() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("automationName","UiAutomator2");
        caps.setCapability("platformName", "Android");
//        caps.setCapability("platformVersion", "12");
        caps.setCapability("deviceName", "Android Emulator");
        caps.setCapability("app",
                System.getProperty("user.dir") + "/apps/ToDo.apk");
//        caps.setCapability("noReset", true);
        driver = new AndroidDriver(new URL("http://localhost:4723"), caps);

//       In case we want to deal dynamically with the setup method (for the desired capabilities)
//        URL url = new URL("http://localhost:4723/wd/hub");
//        if (capabilities.getCapability("platformName").equals("Android")) {
//            androidDriver = new AndroidDriver(url, capabilities);
//        } else if (capabilities.getCapability("platformName").equals("iOS")) {
//            iosDriver = new IOSDriver(url, capabilities);
//        }
    }

    public static void iOS_setUp() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("automationName","XCUITest");
        caps.setCapability("platformName", "iOS");
        caps.setCapability("platformVersion", "16.4");
        caps.setCapability("deviceName", "iPhone 12");
//        caps.setCapability("isHeadless", true); //In case of using CI pipeline(Like Github Actions)
        caps.setCapability("app",
                System.getProperty("user.dir") + "/apps/To-Do.app");
//        caps.setCapability("noReset", true);
        driver = new IOSDriver(new URL("http://localhost:4723"), caps);
    }

    public static void tearDown() {
//        String command = "killall Simulator";
//        String closeApp = "adb emu kill";
//
        if (null != driver) {
            driver.quit();
        }
//        try {
//            // Execute the command
//            Process process = Runtime.getRuntime().exec(command);
//
//            // Wait for the process to complete
//            process.waitFor();
//            System.out.println("Test Finished.");
//        } catch (IOException | InterruptedException e) {
//            e.printStackTrace();
//        }
    }

    public static boolean isAndroid() {
        return driver instanceof AndroidDriver;
    }

    public static boolean isIOS() {
        return driver instanceof IOSDriver;
    }
    protected WebElement findElement(By locator) {
        if (androidDriver != null) {
            return androidDriver.findElement(locator);
        } else if (iosDriver != null) {
            return iosDriver.findElement(locator);
        }
        return null;
    }
}
