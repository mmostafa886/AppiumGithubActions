package steps;

import PageObjects.CreateTaskPage;
import PageObjects.TaskListPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tests.TestBase;

import java.net.MalformedURLException;

public class CreateNewTaskWithData extends TestBase {
TaskListPage taskListPage;
CreateTaskPage createTaskPage;

    @Given("Click add new Task")
    public void clickAddNewTask() throws MalformedURLException {
        Android_setUp();
        taskListPage = new TaskListPage(driver);
        createTaskPage = new CreateTaskPage(driver);
        taskListPage.initializeElements();
        taskListPage.clickAddTaskBtn();
    }

    @Given("Enter {string} and {string}")
    public void taskTitleAndDescription(String taskName, String taskDesc) {
        createTaskPage.initializeCreateTaskElements();
        createTaskPage.enterTaskName(taskName);
        createTaskPage.enterTaskDescription(taskDesc);
    }


    @When("Click on Save Btn")
    public void clickOnSaveBtn() {
        createTaskPage.clickAddTaskBtn();
    }

    @Then("Task  Success")
    public void taskSuccess() {
        tearDown();
    }
}
