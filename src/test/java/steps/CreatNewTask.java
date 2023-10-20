package steps;

import PageObjects.CreateTaskPage;
import PageObjects.TaskListPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tests.TestBase;

import java.net.MalformedURLException;

public class CreatNewTask extends TestBase {

    CreateTaskPage createTaskPage;
    TaskListPage taskListPage;
    @Given("Click Add new Task")
    public void clickAddNewTask() throws MalformedURLException {
        Android_setUp();
        taskListPage = new TaskListPage(driver);
        createTaskPage = new CreateTaskPage(driver);
        taskListPage.initializeElements();
        taskListPage.clickAddTaskBtn();
    }

    @Given("Enter Task Title")
    public void enterTaskTitle() {
        createTaskPage.initializeCreateTaskElements();
        createTaskPage.enterTaskName("Task Title 001");
    }

    @Given("Enter Task Description")
    public void enterTaskDescription() {
        createTaskPage.enterTaskDescription("Task Description 001");
    }

    @When("Click on Save button")
    public void clickOnSaveButton() {
        createTaskPage.clickAddTaskBtn();
    }

    @Then("Task Added successfully")
    public void taskAddedSuccessfully() {
        tearDown();
    }

}
