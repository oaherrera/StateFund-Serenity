@TodoBR9
Feature: br9_claim_search_and_results
  I want to validate the scenarios of Claim Search of State Fund

  #  @TestCaseBR9Scenario1
  #  Scenario: Search an existing claim by worker information
  #    Given I am authenticated in the aplication
  #      | userName        | password |
  #      | automation-user | C0n3x1a$$ |
  #    When Search an existing Claim
  #      | searchBy           | workerFirstName | workerLastName | dateOfInjury |
  #      | Worker Information | JOHN            | DOE            |     10052019 |
  #    Then Display the claim information
  @TestCaseBR9Scenario2
  Scenario: Search an existing claim by claim number
    Given I am authenticated in the aplication
      | userName        | password  |
      | automation-user | C0n3x1a$$ |
    When Search an existing Claim
      | searchBy | claimNumber |
      | Claim    |    01200205 |
    Then Display the claim information

  @TestCaseBR9Scenario3
  Scenario: Search an no existing claim by worker information
    Given I am authenticated in the aplication
      | userName        | password  |
      | automation-user | C0n3x1a$$ |
    When Search an existing Claim
      | searchBy           | workerFirstName | workerLastName | dateOfInjury |
      | Worker Information | Jose            | Carnitas       |     10052019 |
    Then Display the label No Claim Found

  @TestCaseBR9Scenario4
  Scenario: Search an no existing claim by claim number
    Given I am authenticated in the aplication
      | userName        | password  |
      | automation-user | C0n3x1a$$ |
    When Search an existing Claim
      | searchBy | claimNumber |
      | Claim    |  1001992010 |
    Then Display the label No Claim Found

  @TestCaseBR9Scenario5
  Scenario: Validate the message when I try to claim search with the First Name field is empty
    Given I am authenticated in the aplication
      | userName        | password  |
      | automation-user | C0n3x1a$$ |
    When Search an existing Claim
      | searchBy           | workerFirstName | workerLastName | dateOfInjury |
      | Worker Information |                 | Carnitas       |     10052019 |
    Then Display the error message This field is required on claim search page

  @TestCaseBR9Scenario6
  Scenario: Validate the message when I try to claim search with the Last Name field is empty
    Given I am authenticated in the aplication
      | userName        | password  |
      | automation-user | C0n3x1a$$ |
    When Search an existing Claim
      | searchBy           | workerFirstName | workerLastName | dateOfInjury |
      | Worker Information | Jose            |                |     10052019 |
    Then Display the error message This field is required on claim search page

  @TestCaseBR9Scenario7
  Scenario: Validate the message when I try to claim search with the Claim Number field is empty
    Given I am authenticated in the aplication
      | userName        | password  |
      | automation-user | C0n3x1a$$ |
    When Search an existing Claim
      | searchBy | claimNumber |
      | Claim    |             |
    Then Display the error message This field is required on claim search page
