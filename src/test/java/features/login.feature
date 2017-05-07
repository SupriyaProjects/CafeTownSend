Feature:
    As a owner
    I want to be able to login in the system to manage my employees

Scenario: Login as a valid user
    Given the owner is on the Login Page
    When the owner enters his details
    Then he should be logged in

  @test
  Scenario: Edit the existing employee
    Given the owner is on the Login Page
    And the owner is logged in
    When the owner enters all the employee details as follows:
      |firstname | lastname | doj        | email       |
      |sups      | pawar    | 2017-05-22 | sup@sup.com |
    And the owner edits the employee details as follows:
      |firstname | lastname | doj        | email       |
      |neha      | pawar    | 2017-05-01 | neha@sup.com |
    Then the saved employee "neha pawar" should be listed
    When the owner deletes the employee "neha pawar"
    Then the employee record should be deleted