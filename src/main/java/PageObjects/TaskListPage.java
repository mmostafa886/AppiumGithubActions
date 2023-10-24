package PageObjects;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

public class TaskListPage extends PageBase {
    public WebElement addTaskBtn;
    public TaskListPage(AppiumDriver appiumDriver) {
        super(appiumDriver);
        initializeTaskListElements();
    }

    public void initializeTaskListElements() {
        String platform = String.valueOf(driver.getCapabilities().getPlatformName());
        if ("Android".equalsIgnoreCase(platform)) {
//            addTaskBtn = driver.findElement(new By.ById("fab"));
        }else if ("iOS".equalsIgnoreCase(platform)) {
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
