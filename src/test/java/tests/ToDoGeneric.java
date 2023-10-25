package tests;

import PageObjects.CreateTaskPage;
import PageObjects.HomePage;
import PageObjects.TaskListPage;
import org.json.simple.parser.ParseException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.JsonReader;

import java.io.IOException;
import java.net.MalformedURLException;

public class ToDoGeneric extends TestBase {

    CreateTaskPage createTaskPage;
    TaskListPage taskListPage;
    HomePage homePage;

    @DataProvider(name = "task data")
    public Object[][] passData() throws IOException, ParseException {
        return JsonReader.getJsonData(System.getProperty("user.dir")
                + "/data/TaskData.json", "Task Data", 2);
    }

    @BeforeMethod
    public void testSetup() throws MalformedURLException {
        genericSetUp();
    }

    @Test(dataProvider = "task data")
    public void addTaskGeneric(String taskName, String taskDesc) throws InterruptedException {
        if ("ios".equalsIgnoreCase(String.valueOf(driver.getCapabilities().getPlatformName()))) {
            homePage = new HomePage(driver);
            homePage.clickNextBtn();
        }

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
