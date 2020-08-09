@TodoBR8
Feature: br8_user_interface_validation
  I want to do validations of the fields in Claim Search for Workers Information

  @TestCaseBR8Scenario1
  Scenario: To validate the asterisk sign, in fields first name and last name
    Given I am authenticated in the aplication
      | userName        | password  |
      | automation-user | C0n3x1a$$ |
    When Access to the Claim Search module
    Then The portal is shows the symbol in mandatory fields

  @TestCaseBR8Scenario2
  Scenario: To validate the alert in mandatory fields that does not complete of first name
    Given I am authenticated in the aplication
      | userName        | password  |
      | automation-user | C0n3x1a$$ |
    When Enter data in the fields on Claim Search
      | workerLastName |
      | doe            |
    Then The portal is shows the error message This field is required

  @TestCaseBR8Scenario3
  Scenario: To validate the alert in mandatory fields that does not complete of last name
    Given I am authenticated in the aplication
      | userName        | password  |
      | automation-user | C0n3x1a$$ |
    When Enter data in the fields on Claim Search
      | workerFirstName |
      | john            |
    Then The portal is shows the error message This field is required

  @TestCaseBR8Scenario4
  Scenario: To validate the selection of date using the calendar
    Given I am authenticated in the aplication
      | userName        | password  |
      | automation-user | C0n3x1a$$ |
    When Access to the Claim Search module
    Then Select the actual date in the field Date of Injury

  @TestCaseBR8Scenario5
  Scenario: To validate the enter of date in the field Date of Injury
    Given I am authenticated in the aplication
      | userName        | password  |
      | automation-user | C0n3x1a$$ |
    When Access to the Claim Search module
    Then Enter the actual date in the field Date of Injury

  @TestCaseBR8Scenario6
  Scenario: To validate that the complete fields has been cleaned using the button clear
    Given I am authenticated in the aplication
      | userName        | password  |
      | automation-user | C0n3x1a$$ |
    When Enter data in the fields on Claim Search
      | workerFirstName | workerLastName | dateOfInjury |
      | john            | doe            |     06062019 |
    Then The fields remain empty after cleaning them

  @TestCaseBR8Scenario7
  Scenario: To do the query using the button search
    Given I am authenticated in the aplication
      | userName        | password  |
      | automation-user | C0n3x1a$$ |
    When Enter data in the fields on Claim Search
      | workerFirstName | workerLastName | dateOfInjury |
      | john            | doe            |     05102019 |
    Then A record with the generated query is displayed

  @TestCaseBR8Scenario8
  Scenario: To validate in name and last name fields that special characters are not allowed
    Given I am authenticated in the aplication
      | userName        | password  |
      | automation-user | C0n3x1a$$ |
    When Enter data in the fields on Claim Search
      | workerFirstName | workerLastName   |
      | +-*/.,:;        | -_{}´!"#$%&()=?¡ |
    Then The fields are empty
