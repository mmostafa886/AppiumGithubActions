package PageObjects;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

import static utils.CustomLocator.customElementLocator;

public class TaskListPage extends PageBase {
    public WebElement addTaskBtn;
    public TaskListPage(AppiumDriver appiumDriver) {
        super(appiumDriver);
        initializeTaskListElements();
    }

    public void initializeTaskListElements() {
        String platform = String.valueOf(driver.getCapabilities().getPlatformName());
        //Based on the platform retrieved from the current test, The locator is retrieved (whether Android or iOS)
        if ("Android".equalsIgnoreCase(platform)) {
            addTaskBtn= customElementLocator("id","fab");
        }else if ("iOS".equalsIgnoreCase(platform)) {
            addTaskBtn= customElementLocator("accessbilityid", "Add");
        }else {
            throw new IllegalArgumentException("Driver is not initialized properly.");
        }
    }
    public void clickAddTaskBtn() {
        waitForVisibility(addTaskBtn);
        click(addTaskBtn);
    }

}
