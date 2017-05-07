Feature:
    As a owner
    I want to be able to add new employees in the system
    So that i can add accounting data for that employee

Scenario: Sign up a new employee and delete after creation
    Given the owner is on the Login Page
    And the owner is logged in
    When the owner enters all the employee details as follows:
      |firstname | lastname | doj        | email       |
      |supriya   | nyayapati| 2017-05-22 | sup@sup.com |
    Then the saved employee "supriya nyayapati" should be listed
    When the owner deletes the employee "supriya nyayapati"
    Then the employee record should be deleted