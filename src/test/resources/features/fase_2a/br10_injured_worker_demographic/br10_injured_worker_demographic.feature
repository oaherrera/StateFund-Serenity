@TodoBR10
Feature: br10_injured_worker_demographic
  I want to do validations of information in Claim Details

  @TestCaseBR10Scenario1
  Scenario: To validate display the avaliable Injured Worker Demographic Information
    Given I am authenticated in the aplication
      | userName        | password  |
      | automation-user | C0n3x1a$$ |
    When Search an existing Claim
      | searchBy           | workerFirstName | workerLastName | dateOfInjury |
      | Worker Information | John            | Doe            |     05102019 |
    And Access to Claim Details
    Then Verify the demograpchic information of the claim searched
