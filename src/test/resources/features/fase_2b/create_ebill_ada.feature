@TodoEbillADA
Feature: Create a ADA Ebill
  I want to create a ADA Ebill

  @TestCaseEbillADA
  Scenario: Create a ADA Ebill
    Given I am authenticated in the aplication
      | userName                  | password  |
      | portal-test-5@conexia.com | C0n3x1a$$ |
    When I create an ADA Ebill with RFA ID P000000000011
    Then The Ebill number is displayed
    And The history shows the Ebill
