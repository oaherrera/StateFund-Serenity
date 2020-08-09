@TodoBR3
Feature: br3_password_recovery
  I want to validate the funcionality of password recovery

  @TestCaseBR3Scenario1
  Scenario: To validate that the email field is displayed on the screen Forgot my password
    When Open the link Forgot your password on login page
    Then Verify the Email field displayed

  @TestCaseBR3Scenario2
  Scenario: To validate that allows to submit a password recovery request
    When Open the link Forgot your password on login page
    Then Submit a password recovery request
      | email                       |
      | test.automation@outlook.com |

  @TestCaseBR3Scenario3
  Scenario: To validate that displays the "Terms and Policies" text in a popup when selects the hiperlink
    When Open the link Forgot your password on login page
    When Open the link Terms and Policies on login page
    Then Display the window of Terms and Policies in the Forgot password

  @TestCaseBR3Scenario4
  Scenario: To validate redirects to the Login page when the 'Back to Login' link is selected on the screen Forgot my password
    When Open the link Forgot your password on login page
    Then Return to login page trought the link Back to Login

  @TestCaseBR3Scenario11
  Scenario: To validate that the aplication saves the password in an encrypted field in the database
    When Open the link Forgot your password on login page
    Then Verify the password encrypted saved in the database
      | userName        | password  |
      | automation-user | C0n3x1a$$ |
