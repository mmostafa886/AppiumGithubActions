package tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import utils.ConfigFileReader;

import java.net.MalformedURLException;
import java.net.URL;

public class TestBase{
    public static AppiumDriver driver;

    public static void genericSetUp() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();

        // Retrieve the config file path from command line
        String configFilePath = System.getProperty("configFilePath");
        // Initialize ConfigReader with the specified config file path
        ConfigFileReader config = new ConfigFileReader(configFilePath);

        caps.setCapability("automationName", config.getAutomationName());
        caps.setCapability("platformName", config.getPlatformName());
        caps.setCapability("deviceName", config.getDeviceName());
        caps.setCapability("platformVersion", config.getPlatformVersion());
        caps.setCapability("app", System.getProperty("user.dir") +config.getAppPath());
        driver = new AndroidDriver(new URL("http://localhost:4723"), caps);
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
}
