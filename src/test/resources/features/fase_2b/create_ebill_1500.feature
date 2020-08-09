@TodoEbill1500
Feature: Create a 1500 Ebill
  I want to create a 1500 Ebill

  @TestCaseEbill1500
  Scenario: Create a 1500 Ebill
    Given I am authenticated in the aplication
      | userName                  | password  |
      | portal-test-5@conexia.com | C0n3x1a$$ |
    When I create a 1500 Ebill with RFA ID P000000000171
    Then The Ebill number is displayed
    And The history shows the Ebill
