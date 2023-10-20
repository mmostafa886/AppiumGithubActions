package PageObjects;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CreateTaskPage extends PageBase {
    public CreateTaskPage(AppiumDriver appiumDriver) {
        super(appiumDriver);
//        initializeCreateTaskElements();
    }

    WebElement taskTitle;
    WebElement taskDescription;
    WebElement saveBtn;

public void initializeCreateTaskElements() {
    if ("Android".equalsIgnoreCase(String.valueOf(driver.getCapabilities().getPlatformName()))) {
        taskTitle = driver.findElement(By.xpath("//*[@text='Title']"));
        taskDescription = driver.findElement(new By.ById("editTextNote"));
        saveBtn = driver.findElement(new By.ById("action_save"));
    }else if ("iOS".equalsIgnoreCase(String.valueOf(driver.getCapabilities().getPlatformName()))) {
        taskTitle = driver.findElement(AppiumBy.iOSNsPredicateString("value == 'Enter task name'"));
        taskDescription = driver.findElement(AppiumBy.iOSNsPredicateString("type == 'XCUIElementTypeTextView'"));
        saveBtn = driver.findElement(AppiumBy.iOSNsPredicateString("label == 'add'"));
    }else {
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

    public void clickAddTaskBtn(){
        waitForVisibility(saveBtn);
        saveBtn.click();
    }
}
