@TodoBR4
Feature: br4_admin_user_menu
  I as an administrator want to access the application and validate the User Management options

  @TestCaseBR4Scenario1
  Scenario: Validate that the management module shows the inbox option
    Given I am authenticated in the aplication
      | userName                   | password |
      | portal-test-20@conexia.com | C0n3x1a$ |
    Then the portal must show the User Management module

  @TestCaseBR4Scenario2
  Scenario: Validate that the management module shows the Create User option
    Given I am authenticated in the aplication
      | userName                   | password |
      | portal-test-20@conexia.com | C0n3x1a$ |
    Then the portal must show create new users option in the management module

  @TestCaseBR4Scenario3
  Scenario: Validate that the management module shows the search User option
    Given I am authenticated in the aplication
      | userName                   | password |
      | portal-test-20@conexia.com | C0n3x1a$ |
    Then the portal should show option search users in the module management

  @TestCaseBR4Scenario4
  Scenario: Validate that the management module shows the inbox option
    Given I am authenticated in the aplication
      | userName                   | password |
      | portal-test-20@conexia.com | C0n3x1a$ |
    Then the portal must show the inbox option in the management module

  @TestCaseBR4Scenario5
  Scenario: Validate that the Portal does not show the User Management module
    Given I am authenticated in the aplication
      | userName        | password  |
      | automation-user | C0n3x1a$$ |
    Then the portal must not show the user management module

  @TestCaseBR4Scenario6
  Scenario: Validate that the Portal does not show create user option
    Given I am authenticated in the aplication
      | userName        | password  |
      | automation-user | C0n3x1a$$ |
    Then the portal must not show the create user option in the management module

  @TestCaseBR4Scenario7
  Scenario: Validate that the Portal does not show search user option
    Given I am authenticated in the aplication
      | userName        | password  |
      | automation-user | C0n3x1a$$ |
    Then the portal must not show the search user option in the management module

  @TestCaseBR4Scenario8
  Scenario: Validate that the Portal does not show inbox user option
    Given I am authenticated in the aplication
      | userName        | password  |
      | automation-user | C0n3x1a$$ |
    Then the portal must not show the inbox user option in the management module
