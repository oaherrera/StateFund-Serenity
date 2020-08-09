@TodoEbill1450
Feature: Create a 1450 Ebill
  I want to create a 1450 Ebill

  @TestCaseEbill1450
  Scenario: Create a 1450 Ebill
    Given I am authenticated in the aplication
      | userName                  | password  |
      | portal-test-5@conexia.com | C0n3x1a$$ |
    When I create a 1450 Ebill with RFA ID P000000000537
    Then The Ebill number is displayed
    And The history shows the Ebill
