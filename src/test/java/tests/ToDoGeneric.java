package tests;

import PageObjects.CreateTaskPage;
import PageObjects.HomePage;
import PageObjects.TaskListPage;
import org.json.simple.parser.ParseException;
import org.testng.annotations.*;
import utils.AllureRename;
import utils.JsonReader;

import java.io.IOException;
import java.net.MalformedURLException;

import static java.lang.Thread.*;

//Epic & Feature can be set either on the 'Class' level or on the 'Test' level
//@Epic("Dynamic Epic")
//@Feature("Dynamic Feature")
public class ToDoGeneric extends TestBase {

    CreateTaskPage createTaskPage;
    TaskListPage taskListPage;
    HomePage homePage;

    @DataProvider(name = "task data")
    public Object[][] passData() throws IOException, ParseException {
        return JsonReader.getJsonData(System.getProperty("user.dir") + "/data/TaskData.json", "Task Data", 2);
    }

    @BeforeMethod
    public void testSetup() throws MalformedURLException {
        genericSetUp();
    }

    @Test(dataProvider = "task data")
    public void addTaskGeneric001(String taskName, String taskDesc) throws InterruptedException {
        //Get the current method name
        String currentTestMethodName = currentThread().getStackTrace()[1].getMethodName();
        //Using a method from the utils.AllureRename
        AllureRename.renameTestCase("Main Epic", "Feature001", "Suite001", currentTestMethodName);
// TestCase steps start here
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

        sleep(1000);

    }

    //    ========================================
    @Test(dataProvider = "task data")
    public void addTaskGeneric002(String taskName, String taskDesc) throws InterruptedException {
        //Get the current method name
        String currentTestMethodName = currentThread().getStackTrace()[1].getMethodName();
        //Using a method from the utils.AllureRename to dynamically give name to the Epics, Features & Suites
        AllureRename.renameTestCase("Main Epic", "Feature002", "Suite002", currentTestMethodName);
// TestCase steps start here
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

        sleep(1000);

    }

    @AfterMethod
    public void testTearDown() {
        tearDown();
    }

}
