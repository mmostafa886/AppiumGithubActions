package PageObjects;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

import static utils.CustomLocator.customElementLocator;

public class CreateTaskPage extends PageBase {
    public WebElement taskTitle;
    public WebElement taskDescription;
    public WebElement saveBtn;

    public CreateTaskPage(AppiumDriver appiumDriver) {
        super(appiumDriver);
        initializeCreateTaskElements();
    }

    public void initializeCreateTaskElements() {
        String platform = String.valueOf(driver.getCapabilities().getPlatformName());
        if ("Android".equalsIgnoreCase(platform)) {
            taskTitle = customElementLocator("xpath","//*[@text='Title']");
            taskDescription = customElementLocator("id", "editTextNote");
            saveBtn = customElementLocator("id", "action_save");
        } else if ("iOS".equalsIgnoreCase(platform)) {
            taskTitle = customElementLocator("iosn","value == 'Enter task name'");
            taskDescription = customElementLocator("iosn","type == 'XCUIElementTypeTextView'");
            saveBtn = customElementLocator("iosn","label == 'add'");
        } else {
            throw new IllegalArgumentException("Driver is not initialized properly.");
        }
    }

    public void enterTaskName(String taskName) {
        waitForVisibility(taskTitle);
        clear(taskTitle);
        sendText(taskTitle, taskName);
    }

    public void enterTaskDescription(String taskDesc) {
        waitForVisibility(taskDescription);
        clear(taskDescription);
        sendText(taskDescription, taskDesc);
    }

    public void clickAddTaskBtn() {
        waitForVisibility(saveBtn);
        saveBtn.click();
    }
}
