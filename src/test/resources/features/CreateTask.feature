Feature: Create New Task
  Scenario: The user can add a new Task
    Given Click Add new Task
    Given Enter Task Title
    Given Enter Task Description
    When Click on Save button
    Then Task Added successfully