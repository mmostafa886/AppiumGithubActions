package tests;

import PageObjects.CreateTaskPage;
import PageObjects.TaskListPage;
import io.appium.java_client.AppiumBy;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.*;
import utils.JsonReader;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Map;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class ToDoAndroid extends TestBase {

    CreateTaskPage createTaskPage;
    TaskListPage taskListPage;

    @DataProvider(name = "task data")
    public Object[][] passData() throws IOException, ParseException {
        return JsonReader.getJsonData(System.getProperty("user.dir")
                + "/data/TaskData.json", "Task Data", 2);
    }

    @BeforeMethod
    public void androidTestSetup() throws MalformedURLException {
        Android_setUp();
    }

    @Test(dataProvider = "task data")
    public void addTaskAndroidV2(String taskName, String taskDesc) throws InterruptedException, MalformedURLException {
//        Android_setUp();
        taskListPage = new TaskListPage(driver);
        createTaskPage = new CreateTaskPage(driver);
        taskListPage.initializeElements();
        taskListPage.clickAddTaskBtn();
        createTaskPage.initializeCreateTaskElements();
        createTaskPage.enterTaskName(taskName);
        createTaskPage.enterTaskDescription(taskDesc);
        createTaskPage.clickAddTaskBtn();
//tearDown();

        Thread.sleep(2000);
    }

@AfterMethod
    public void testTearDown() {
        tearDown();
    }

}
