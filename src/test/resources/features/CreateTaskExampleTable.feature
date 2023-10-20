Feature: Create New Task

  Scenario Outline: The user can add a new Task
    Given Click add new Task
    Given Enter "<TaskName>" and "<TaskDesc>"
    When Click on Save Btn
    Then Task  Success

    Examples:
      | TaskName          | TaskDesc             |
      | Cucumber Task 001 | Task Description 001 |
      | Cucumber Task 002 | Task Description 002 |