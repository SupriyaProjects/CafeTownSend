Feature:
  As a owner
  I want to be able to login in the system to manage my employees


  Scenario: Login as a valid user
    Given the owner is on the Login Page
    When the owner enters his details "Luke" and "Skywalker"
    Then greeting should have username "Luke"


  Scenario: Validation message for incorrect login details
    Given the owner is on the Login Page
    When the owner enters his details "blah" and "blah "
    Then system should throw an error message.


  Scenario: Validation message for blank username
    Given the owner is on the Login Page
    When the owner enters his details "" and "blah"
    Then system should validate the message