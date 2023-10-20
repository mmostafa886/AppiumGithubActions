package tests;

import PageObjects.CreateTaskPage;
import PageObjects.TaskListPage;
import org.json.simple.parser.ParseException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.JsonReader;

import java.io.IOException;
import java.net.MalformedURLException;

public class ToDoIOS extends TestBase {

    CreateTaskPage createTaskPage;
    TaskListPage taskListPage;
    @DataProvider(name = "task data")
    public Object[][] passData() throws IOException, ParseException {
        return JsonReader.getJsonData(System.getProperty("user.dir")
                + "/data/TaskData.json", "Task Data", 2);
    }
    @Test(dataProvider = "task data")
    public void firstAddTaskIOS(String taskName, String taskDesc) throws MalformedURLException {
        iOS_setUp();
        taskListPage = new TaskListPage(driver);
        createTaskPage = new CreateTaskPage(driver);
        taskListPage.initializeElements();
        taskListPage.clickAddTaskBtn();
        createTaskPage.initializeCreateTaskElements();
        createTaskPage.enterTaskName(taskName);
        createTaskPage.enterTaskDescription(taskDesc );
        createTaskPage.clickAddTaskBtn();
        tearDown();
    }

    @Test(dataProvider = "task data")
    public void secondAddTaskIOS(String taskName, String taskDesc) throws MalformedURLException {
        iOS_setUp();
        taskListPage = new TaskListPage(driver);
        createTaskPage = new CreateTaskPage(driver);
        taskListPage.initializeElements();
        taskListPage.clickAddTaskBtn();
        createTaskPage.initializeCreateTaskElements();
        createTaskPage.enterTaskName(taskName);
        createTaskPage.enterTaskDescription(taskDesc );
        createTaskPage.clickAddTaskBtn();
        tearDown();
    }
}
