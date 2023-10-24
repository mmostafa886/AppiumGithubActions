package tests;

import PageObjects.CreateTaskPage;
import PageObjects.TaskListPage;
import org.json.simple.parser.ParseException;
import org.testng.annotations.*;
import utils.JsonReader;

import java.io.IOException;
import java.net.MalformedURLException;

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
        taskListPage = new TaskListPage(driver);
        taskListPage.clickAddTaskBtn();

        createTaskPage = new CreateTaskPage(driver);
        createTaskPage.enterTaskName(taskName);
        createTaskPage.enterTaskDescription(taskDesc);
        createTaskPage.clickAddTaskBtn();

        Thread.sleep(1000);
    }

@AfterMethod
    public void testTearDown() {
        tearDown();
    }

}
