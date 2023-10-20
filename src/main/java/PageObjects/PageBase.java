package PageObjects;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Map;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class PageBase {

    AppiumDriver driver;
    WebDriverWait wait;
    public static final long WAIT = 10;
    public PageBase(AppiumDriver appiumDriver){

        driver = appiumDriver;
//       wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT));
    }

    public void waitForVisibility(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void clear(WebElement element){
        waitForVisibility(element);
        element.clear();
    }

    public void click(WebElement element){
        waitForVisibility(element);
        element.click();
    }

    public void sendText(WebElement element, String text){
        waitForVisibility(element);
        element.sendKeys(text);

    }

    public String getElementAttribute(WebElement element, String attribute){
        waitForVisibility(element);
        return element.getAttribute(attribute);
    }


}
