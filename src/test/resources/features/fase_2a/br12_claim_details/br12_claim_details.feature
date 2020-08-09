@TodoBR12
Feature: br12_claim_details
  I want to do validations in Claim Details

  @TestCaseBR12Scenario1
  Scenario: To validate the specification from Claim Details
    Given I am authenticated in the aplication
      | userName        | password  |
      | automation-user | C0n3x1a$$ |
    When Search an existing Claim
      | searchBy | claimNumber |
      | Claim    |    01200210 |
    And Access to Claim Details
    Then Verify the specification of the claim searched

  @TestCaseBR12Scenario2
  Scenario: To validate the Requested Body Parts button
    Given I am authenticated in the aplication
      | userName        | password  |
      | automation-user | C0n3x1a$$ |
    When Search an existing Claim
      | searchBy | claimNumber |
      | Claim    |    01200210 |
    And Access to Claim Details
    Then Verify the Requested Body Parts button is displayed

  @TestCaseBR12Scenario3
  Scenario: To validate the Requested Body Parts pop-up
    Given I am authenticated in the aplication
      | userName        | password  |
      | automation-user | C0n3x1a$$ |
    When Search an existing Claim
      | searchBy | claimNumber |
      | Claim    |    01200210 |
    And Access to Claim Details
    Then Verify the information from Requested Body Parts pop-up

  @TestCaseBR12Scenario4
  Scenario: To validate the Related Claim button
    Given I am authenticated in the aplication
      | userName        | password  |
      | automation-user | C0n3x1a$$ |
    When Search an existing Claim
      | searchBy | claimNumber |
      | Claim    |    01200210 |
    And Access to Claim Details
    Then Verify the Related Claim button is displayed

  @TestCaseBR12Scenario5
  Scenario: To validate the Related Claim pop-up
    Given I am authenticated in the aplication
      | userName        | password  |
      | automation-user | C0n3x1a$$ |
    When Search an existing Claim
      | searchBy | claimNumber |
      | Claim    |    01200210 |
    And Access to Claim Details
    Then Verify the information from Related Claim pop-up

  @TestCaseBR12Scenario6
  Scenario: To validate the pagination from the Related Claim pop-up
    Given I am authenticated in the aplication
      | userName        | password  |
      | automation-user | C0n3x1a$$ |
    When Search an existing Claim
      | searchBy | claimNumber |
      | Claim    |    01200210 |
    And Access to Claim Details
    Then Verify the pagination from Related Claim pop-up

  #  @TestCaseBR12Scenario7
  #  Scenario: To validate disables the RFA button when the Claim Type is New
  #    Given I am authenticated in the aplication
  #      | userName        | password	|
  #      | automation-user | C0n3x1a$$ |
  #    When Search an existing Claim
  #      | searchBy | claimNumber |
  #      | Claim    |    01200210 |
  #    And Access to Claim Details
  #    Then The RFA button is disable and the Claim Type is New
  @TestCaseBR12Scenario8
  Scenario: To validate disables the RFA button when the Claim Type is Legal No
    Given I am authenticated in the aplication
      | userName        | password  |
      | automation-user | C0n3x1a$$ |
    When Search an existing Claim
      | searchBy | claimNumber |
      | Claim    |    01100002 |
    And Access to Claim Details
    Then The RFA button is disable and the Claim Type is Legal No

  #  @TestCaseBR12Scenario9
  #  Scenario: To validate disables the RFA button when the Claim Type is First AID
  #    Given I am authenticated in the aplication
  #      | userName        | password  |
  #      | automation-user | C0n3x1a$$ |
  #    When Search an existing Claim
  #      | searchBy | claimNumber |
  #      | Claim    |    01200202 |
  #    And Access to Claim Details
  #    Then The RFA button is disable and the Claim Type is First AID
  #  @TestCaseBR12Scenario10
  #  Scenario: To validate disables the RFA button when the Claim Type is No Action Required
  #    Given I am authenticated in the aplication
  #      | userName        | password  |
  #      | automation-user | C0n3x1a$$ |
  #    When Search an existing Claim
  #      | searchBy | claimNumber |
  #      | Claim    |    01200201 |
  #    And Access to Claim Details
  #    Then The RFA button is disable and the Claim Type is No Action Required
  #  @TestCaseBR12Scenario11
  #  Scenario: To validate enables the RFA button when the Claim Type is Non-Disability and Claim Decision is Accept
  #    Given I am authenticated in the aplication
  #      | userName        | password  |
  #      | automation-user | C0n3x1a$$ |
  #    When Search an existing Claim
  #      | searchBy | claimNumber |
  #      | Claim    |    01200213 |
  #    And Access to Claim Details
  #    Then The RFA button is enable, the Claim Type is Non-Disability and Claim Decision is Accept
  #  @TestCaseBR12Scenario12
  #  Scenario: To validate enables the RFA button when the Claim Type is Non-Disability and Claim Decision is Delay
  #    Given I am authenticated in the aplication
  #      | userName        | password  |
  #      | automation-user | C0n3x1a$$ |
  #    When Search an existing Claim
  #      | searchBy | claimNumber |
  #      | Claim    |    01200223 |
  #    And Access to Claim Details
  #    Then The RFA button is enable, the Claim Type is Non-Disability and Claim Decision is Delay
  #  @TestCaseBR12Scenario13
  #  Scenario: To validate disables the RFA button when the Claim Type is Non-Disability and Claim Decision is Reject
  #    Given I am authenticated in the aplication
  #      | userName        | password  |
  #      | automation-user | C0n3x1a$$ |
  #    When Search an existing Claim
  #      | searchBy | claimNumber |
  #      | Claim    |    01200215 |
  #    And Access to Claim Details
  #    Then The RFA button is disable, the Claim Type is Non-Disability and Claim Decision is Reject
  #  @TestCaseBR12Scenario14
  #  Scenario: To validate disables the RFA button when the Claim Type is Non-Disability and Claim Decision is Blank
  #    Given I am authenticated in the aplication
  #      | userName        | password  |
  #      | automation-user | C0n3x1a$$ |
  #    When Search an existing Claim
  #      | searchBy | claimNumber |
  #      | Claim    |    01200216 |
  #    And Access to Claim Details
  #    Then The RFA button is disable, the Claim Type is Non-Disability and Claim Decision is Blank
  #  @TestCaseBR12Scenario15
  #  Scenario: To validate enables the RFA button when the Claim Type is Disability and Claim Decision is Accept
  #    Given I am authenticated in the aplication
  #      | userName        | password  |
  #      | automation-user | C0n3x1a$$ |
  #    When Search an existing Claim
  #      | searchBy | claimNumber |
  #      | Claim    |    01200209 |
  #    And Access to Claim Details
  #    Then The RFA button is enable, the Claim Type is Disability and Claim Decision is Accept
  @TestCaseBR12Scenario16
  Scenario: To validate enables the RFA button when the Claim Type is Disability and Claim Decision is Delay
    Given I am authenticated in the aplication
      | userName        | password  |
      | automation-user | C0n3x1a$$ |
    When Search an existing Claim
      | searchBy | claimNumber |
      | Claim    |    01100003 |
    And Access to Claim Details
    Then The RFA button is enable, the Claim Type is Disability and Claim Decision is Delay

  @TestCaseBR12Scenario17
  Scenario: To validate disables the RFA button when the Claim Type is Disability and Claim Decision is Reject
    Given I am authenticated in the aplication
      | userName        | password  |
      | automation-user | C0n3x1a$$ |
    When Search an existing Claim
      | searchBy | claimNumber |
      | Claim    |    01200211 |
    And Access to Claim Details
    Then The RFA button is disable, the Claim Type is Disability and Claim Decision is Reject

  #  @TestCaseBR12Scenario18
  #  Scenario: To validate disables the RFA button when the Claim Type is Disability and Claim Decision is Blank
  #    Given I am authenticated in the aplication
  #      | userName        | password  |
  #      | automation-user | C0n3x1a$$ |
  #    When Search an existing Claim
  #      | searchBy | claimNumber |
  #      | Claim    |    01200220 |
  #    And Access to Claim Details
  #    Then The RFA button is disable, the Claim Type is Disability and Claim Decision is Blank
  #  @TestCaseBR12Scenario19
  #  Scenario: To validate enables the RFA button when the Claim Type is Maintenance and Claim Decision is Accept
  #    Given I am authenticated in the aplication
  #      | userName        | password  |
  #      | automation-user | C0n3x1a$$ |
  #    When Search an existing Claim
  #      | searchBy | claimNumber |
  #      | Claim    |    01200205 |
  #    And Access to Claim Details
  #    Then The RFA button is enable, the Claim Type is Maintenance and Claim Decision is Accept
  @TestCaseBR12Scenario20
  Scenario: To validate enables the RFA button when the Claim Type is Maintenance and Claim Decision is Delay
    Given I am authenticated in the aplication
      | userName        | password  |
      | automation-user | C0n3x1a$$ |
    When Search an existing Claim
      | searchBy | claimNumber |
      | Claim    |    02200302 |
    And Access to Claim Details
    Then The RFA button is enable, the Claim Type is Maintenance and Claim Decision is Delay

  #  @TestCaseBR12Scenario21
  #  Scenario: To validate disables the RFA button when the Claim Type is Maintenance and Claim Decision is Reject
  #    Given I am authenticated in the aplication
  #      | userName        | password  |
  #      | automation-user | C0n3x1a$$ |
  #    When Search an existing Claim
  #      | searchBy | claimNumber |
  #      | Claim    |    01200207 |
  #    And Access to Claim Details
  #    Then The RFA button is disable, the Claim Type is Maintenance and Claim Decision is Reject
  @TestCaseBR12Scenario22
  Scenario: To validate disables the RFA button when the Claim Type is Maintenance and Claim Decision is Blank
    Given I am authenticated in the aplication
      | userName        | password  |
      | automation-user | C0n3x1a$$ |
    When Search an existing Claim
      | searchBy | claimNumber |
      | Claim    |    01200208 |
    And Access to Claim Details
    Then The RFA button is disable, the Claim Type is Maintenance and Claim Decision is Blank

  @TestCaseBR12Scenario23
  Scenario: To validate the restriction to view the Treatment History for a Restricted Claim
    Given I am authenticated in the aplication
      | userName        | password  |
      | automation-user | C0n3x1a$$ |
    When Search an existing Claim
      | searchBy | claimNumber |
      | Claim    |    01200211 |
    And Access to Claim Details
    Then The Treatment History no is visible for a Restricted Claim

  @TestCaseBR12Scenario24
  Scenario: To validate the displays the Treatment History for the RFAs displayed in the Treatment History section
    Given I am authenticated in the aplication
      | userName        | password  |
      | automation-user | C0n3x1a$$ |
    When Search an existing Claim
      | searchBy | claimNumber |
      | Claim    |    01200210 |
    And Access to Claim Details
    Then The Treatment History is displayed for the RFAs displayed

  @TestCaseBR12Scenario25
  Scenario: To validate the specification from Treatment History section
    Given I am authenticated in the aplication
      | userName        | password  |
      | automation-user | C0n3x1a$$ |
    When Search an existing Claim
      | searchBy | claimNumber |
      | Claim    |    01200210 |
    And Access to Claim Details
    Then Verify the specification of the RFA selected

  @TestCaseBR12Scenario26
  Scenario: To validate the select a document in the Attachments Document pop-up
    Given I am authenticated in the aplication
      | userName        | password  |
      | automation-user | C0n3x1a$$ |
    When Search an existing Claim
      | searchBy | claimNumber |
      | Claim    |    01200210 |
    And Access to Claim Details
    Then Access a document from Attachments Document pop-up

  @TestCaseBR12Scenario27
  Scenario: To validate the RFA button
    Given I am authenticated in the aplication
      | userName        | password  |
      | automation-user | C0n3x1a$$ |
    When Search an existing Claim
      | searchBy | claimNumber |
      | Claim    |    01200210 |
    And Access to Claim Details
    Then Verify the RFA button is displayed

  @TestCaseBR12Scenario28
  Scenario: To validate the Saved Draft button
    Given I am authenticated in the aplication
      | userName        | password  |
      | automation-user | C0n3x1a$$ |
    When Search an existing Claim
      | searchBy | claimNumber |
      | Claim    |    01200210 |
    And Access to Claim Details
    Then Verify the Saved Draft button is displayed
