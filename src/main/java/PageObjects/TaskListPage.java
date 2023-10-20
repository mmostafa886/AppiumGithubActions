package PageObjects;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TaskListPage extends PageBase {
    public TaskListPage(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }
    public WebElement addTaskBtn;


    public void initializeElements() {
        if ("Android".equalsIgnoreCase(String.valueOf(driver.getCapabilities().getPlatformName()))) {
            addTaskBtn = driver.findElement(new By.ById("fab"));
        }else if ("iOS".equalsIgnoreCase(String.valueOf(driver.getCapabilities().getPlatformName()))) {
            addTaskBtn = driver.findElement(new AppiumBy.ByAccessibilityId("Add"));

        }else {
            throw new IllegalArgumentException("Driver is not initialized properly.");
        }
    }
    public void clickAddTaskBtn() {
        waitForVisibility(addTaskBtn);
        click(addTaskBtn);
    }

}
