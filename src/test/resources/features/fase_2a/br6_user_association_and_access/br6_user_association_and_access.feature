@TodoBR6
Feature: br6_user_association_and_access
  I want to verify the different user access

  @TestCaseBR6Scenario1
  Scenario: Verify the Portal displays the information related to the associated provider agency.
    Given I am authenticated in the aplication
      | userName                  | password |
      | portal-test-4@conexia.com | C0n3x1a$ |
    When Search an existing Claim
      | searchBy | claimNumber |
      | Claim    |    00000000 |
    Then The portal is shows a message No Claim Found

  @TestCaseBR6Scenario2
  Scenario: Verify if the portal restricts the access to a user without a physician associated
    Given I am authenticated in the aplication
      | userName                   | password |
      | portal-test-20@conexia.com | C0n3x1a$ |
    When Access to create new user module
    And The Admin User fills all the form whitout the information in Physicians field
      | firstName | middleInitial | lastName | user       | emailAddress     | telephone  | mobile     | startDate  | endDate    | accessLevel          | workplaces | physicians | active |
      | Jhon      | D             | Perez    | jhonDperez | jhon@hotmail.com | 3112532511 | 3115256333 | 06/12/2019 | 06/30/2019 | USER_PORTAL_LEVEL_2B | Workplacea |            | yes    |
    Then The portal is shows the error message This field is required

  #		Examples:
  #			| data |
  #  ##@externaldata@./src/test/resources/datadriven/users/user_association_and_access/user_association_and_access.xlsx@TestCaseBR6Scenario2
  @TestCaseBR6Scenario3
  Scenario: Verify if the portal allows the user with a level 2a or above to look up Client Demographics Information
    Given I am authenticated in the aplication
      | userName                  | password |
      | portal-test-4@conexia.com | C0n3x1a$ |
    When Search an existing Claim
      | searchBy | claimNumber |
      | Claim    |    01200210 |
    Then The portal displays the demographics information

  @TestCaseBR6Scenario4
  Scenario: Verify if the portal allows the user with a level 2a or above to look up Claims using the Worker´s information tab
    Given I am authenticated in the aplication
      | userName                  | password |
      | portal-test-4@conexia.com | C0n3x1a$ |
    When Enter data in the fields on worker information
      | workerFirstName | workerLastName |
      | GLOIWO          | MOROTKH        |
    Then The portal displays the results

  @TestCaseBR6Scenario5
  Scenario: Verify if the portal allows the user with a level 2a or above to look up Claims using the Claim tab
    Given I am authenticated in the aplication
      | userName                  | password |
      | portal-test-4@conexia.com | C0n3x1a$ |
    When Search an existing Claim
      | searchBy | claimNumber |
      | Claim    |    01200210 |
    Then The portal displays the results

  @TestCaseBR6Scenario6
  Scenario: Verify if the portal allows the user with a level 2b or above to look up submitted RFA for a claim
    Given I am authenticated in the aplication
      | userName                  | password |
      | portal-test-4@conexia.com | C0n3x1a$ |
    When Search an existing Claim
      | searchBy | claimNumber |
      | Claim    |    01200210 |
    And Access to Claim Details
    Then The portal displays the information of the selected RFA

  @TestCaseBR6Scenario7
  Scenario: Verify if the Portal allow to a user with level 20 assigned to access the administrative tool
    Given I am authenticated in the aplication
      | userName                   | password |
      | portal-test-20@conexia.com | C0n3x1a$ |
    Then Access to the the options from User Management

  @TestCaseBR6Scenario8
  Scenario: Verify if the portal allows the user with a level 2b or above to look up Document attachments for a claim
    Given I am authenticated in the aplication
      | userName                  | password |
      | portal-test-4@conexia.com | C0n3x1a$ |
    When Search an existing Claim
      | searchBy | claimNumber |
      | Claim    |    01200210 |
    And Access to Claim Details
    Then can see all the attachments

  @TestCaseBR6Scenario9
  Scenario: Verify if the portal Allow the user with a level 4 to be able to submit RFA
    Given I am authenticated in the aplication
      | userName                  | password |
      | portal-test-4@conexia.com | C0n3x1a$ |
    When Search an existing Claim
      | searchBy | claimNumber |
      | Claim    |    01200210 |
    And Access to Claim Details
    And Entry to send RFA
    And Fill the Requesting Physician Information with RFA type
      | rfaType     | physicianName  |
      | New Request | ALAR GROHH  SL |
    And Fill the Claim Administrator Information
    And Fill the Treatment Details
      | diagnosisCode | procedureType | procedutreCode | RelatedBodyPart | relatedDiagnosis | urTreatmentType | additionalComments  | frequency | period | quantity | startDate | endDate  |
      | G54;G54.1;G55 | CPT           |          62200 | Other           | All              | Acupuncture     | Automation Comments |         3 | Daily  |        5 |  12122019 | 12122019 |
    And Fill the Document Attachment
      | documentType | attachment |
      | DFR          |            |

  @TestCaseBR6Scenario10
  Scenario: Verify if the portal allow the user with a level 4 to edit the RFA saved draft
    Given I am authenticated in the aplication
      | userName                  | password |
      | portal-test-4@conexia.com | C0n3x1a$ |
    When Search an existing Claim
      | searchBy | claimNumber |
      | Claim    |    01200210 |
    And Access to Claim Details
    And Enter saved drafts
    Then Can edit a record

  @TestCaseBR6Scenario11
  Scenario: Verify if the portal allow the user with a level 4 to delete the RFA saved draft
    Given I am authenticated in the aplication
      | userName                  | password |
      | portal-test-4@conexia.com | C0n3x1a$ |
    When Search an existing Claim
      | searchBy | claimNumber |
      | Claim    |    01200210 |
    And Access to Claim Details
    And Enter saved drafts
    Then Can delete a record

  @TestCaseBR6Scenario12
  Scenario: Verify if the portal Allow the user with a level 4 to be able to Saved an RFA as a draft
    Given I am authenticated in the aplication
      | userName                  | password |
      | portal-test-4@conexia.com | C0n3x1a$ |
    When Search an existing Claim
      | searchBy | claimNumber |
      | Claim    |    01200210 |
    And Access to Claim Details
    And Entry to send RFA
    And Fill the Requesting Physician Information with RFA type
      | rfaType     | physicianName  |
      | New Request | ALAR GROHH  SL |
    And Fill the Claim Administrator Information
    And Fill the Treatment Details
      | diagnosisCode | procedureType | procedutreCode | RelatedBodyPart | relatedDiagnosis | urTreatmentType | additionalComments  | frequency | period | quantity | startDate | endDate  |
      | G54;G54.1;G55 | CPT           |          62200 | Other           | All              | Acupuncture     | Automation Comments |         3 | Daily  |        5 |  12122019 | 12122019 |
    And Fill the Document Attachment
      | documentType | attachment |
      | DFR          |            |

  @TestCaseBR6Scenario13
  Scenario: Verify if the portal allow the user with a level 4 to edit the RFA saved draft
    Given I am authenticated in the aplication
      | userName                  | password |
      | portal-test-4@conexia.com | C0n3x1a$ |
    When Search an existing Claim
      | searchBy | claimNumber |
      | Claim    |    01200210 |
    And Access to Claim Details
    And Enter saved drafts
    Then Can edit a record

  @TestCaseBR6Scenario14
  Scenario: Verify if the portal allow the user with a level 4 to delete the RFA saved draft
    Given I am authenticated in the aplication
      | userName                  | password |
      | portal-test-4@conexia.com | C0n3x1a$ |
    When Search an existing Claim
      | searchBy | claimNumber |
      | Claim    |    01200210 |
    And Access to Claim Details
    And Enter saved drafts
    Then Can delete a record

  @TestCaseBR6Scenario15
  Scenario: Verify if the portal Allow the user with a level 4 to be able to Saved an RFA as a draft
    Given I am authenticated in the aplication
      | userName                  | password |
      | portal-test-4@conexia.com | C0n3x1a$ |
    When Search an existing Claim
      | searchBy | claimNumber |
      | Claim    |    01200210 |
    And Access to Claim Details
    And Entry to send RFA
    And Fill the Requesting Physician Information with RFA type
      | rfaType     | physicianName  |
      | New Request | ALAR GROHH  SL |
    And Fill the Claim Administrator Information
    And Fill the Treatment Details
      | diagnosisCode | procedureType | procedutreCode | RelatedBodyPart | relatedDiagnosis | urTreatmentType | additionalComments  | frequency | period | quantity | startDate | endDate  |
      | G54;G54.1;G55 | CPT           |          62200 | Other           | All              | Acupuncture     | Automation Comments |         3 | Daily  |        5 |  12122019 | 12122019 |
    And Fill the Document Attachment and save as draft
      | documentType | attachment |
      | DFR          |            |
    Then The portal redirects to the Claim Details
