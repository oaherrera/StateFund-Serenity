@TodoBR14
Feature: br14_saved_draft
  I want to validate the scenarios of saved draft of State Fund

  @TestCaseBR14Scenario1-3-9
  Scenario: Verifly the fields and results in the from Saved Draft
    Given I am authenticated in the aplication
      | userName        | password  |
      | automation-user | C0n3x1a$$ |
    When Search an existing Claim
      | searchBy | claimNumber |
      | Claim    |    01200210 |
    And Access to Claim Details
    And Enter saved drafts
    Then Display the drafts in order and fields created by user
      | createBy        | claimNumber | claimNumberField | injuredWorkerField | dateOfInjuryField | savedDateField | orderBy    |
      | automation-user |    01200210 | Claim number     | Injured worker     | Date of injury    | Saved date     | descending |

  @TestCaseBR14Scenario2And4
  Scenario: Select the Saved Draft and delete
    Given I am authenticated in the aplication
      | userName        | password  |
      | automation-user | C0n3x1a$$ |
    When Search an existing Claim
      | searchBy | claimNumber |
      | Claim    |    01200210 |
    And Access to Claim Details
    And Enter saved drafts
    And Click on the checkbox in row number 1 of a saved draft
    And Click on Delete in row number 1
    Then Draft is delete

  @TestCaseBR14Scenario5
  Scenario: Select more than one saved draft and delete
    Given I am authenticated in the aplication
      | userName        | password  |
      | automation-user | C0n3x1a$$ |
    When Search an existing Claim
      | searchBy | claimNumber |
      | Claim    |    01200210 |
    And Access to Claim Details
    And Enter saved drafts
    And Click on the checkbox in row number 1 of a saved draft
    And Click on the checkbox in row number 2 of a saved draft
    And Click on Delete Drafts
    Then Display the drafts in order and fields created by user
      | createBy        | claimNumber | claimNumberField | injuredWorkerField | dateOfInjuryField | savedDateField | orderBy    |
      | automation-user |    01200210 | Claim number     | Injured worker     | Date of injury    | Saved date     | descending |

  @TestCaseBR14Scenario6
  Scenario: Select more than one saved draft and edit
    Given I am authenticated in the aplication
      | userName        | password  |
      | automation-user | C0n3x1a$$ |
    When Search an existing Claim
      | searchBy | claimNumber |
      | Claim    |    01200210 |
    And Access to Claim Details
    And Enter saved drafts
    And Click on the checkbox in row number 1 of a saved draft
    And Click on Edit in row number 1
    Then See the Rfa form edit for Claim number 01200210

  @TestCaseBR14Scenario10
  Scenario: Select more than one saved draft and edit
    Given I am authenticated in the aplication
      | userName        | password  |
      | automation-user | C0n3x1a$$ |
    When Search an existing Claim
      | searchBy | claimNumber |
      | Claim    |    01200210 |
    And Access to Claim Details
    And Enter saved drafts
    And Click on the checkbox in row number 1 of a saved draft
    And Click on Edit in row number 1
    And Click on Cancel edit Rfa
    Then The portal displays the information of the selected RFA

  @TestCaseBR14Scenario7
  Scenario: Select more than one saved draft, delete and cancel Delete
    Given I am authenticated in the aplication
      | userName        | password  |
      | automation-user | C0n3x1a$$ |
    When Search an existing Claim
      | searchBy | claimNumber |
      | Claim    |    01200210 |
    And Access to Claim Details
    And Enter saved drafts
    And Click on the checkbox in row number 1 of a saved draft
    And Click on the checkbox in row number 2 of a saved draft
    And Click on Delete Drafts and Cancel
    Then Display the drafts in order and fields created by user
      | createBy        | claimNumber | claimNumberField | injuredWorkerField | dateOfInjuryField | savedDateField | orderBy    |
      | automation-user |    01200210 | Claim number     | Injured worker     | Date of injury    | Saved date     | descending |

  @TestCaseBR14Scenario8
  Scenario: Validate the message when don have Drift
    Given I am authenticated in the aplication
      | userName        | password  |
      | automation-user | C0n3x1a$$ |
    When Search an existing Claim
      | searchBy | claimNumber |
      | Claim    |    02200302 |
    And Access to Claim Details
    And Enter saved drafts
    Then Display the message No records found.

  @TestCaseBR14Scenario12
  Scenario: Select one saved draft, edit and saved RFA
    Given I am authenticated in the aplication
      | userName        | password  |
      | automation-user | C0n3x1a$$ |
    When Search an existing Claim
      | searchBy | claimNumber |
      | Claim    |    01200210 |
    And Access to Claim Details
    And Enter saved drafts
    And Click on the checkbox in row number 1 of a saved draft
    And Click on Edit in row number 1
    And Fill the Requesting Physician Information
      | physicianName  |
      | ALAR GROHH  SL |
    And Fill the Claim Administrator Information
    And Fill the Treatment Details
      | diagnosisCode | procedureType | procedutreCode | RelatedBodyPart | relatedDiagnosis | urTreatmentType | additionalComments  | frequency | period | quantity | startDate | endDate  |
      | G54;G54.1;G55 | CPT           |          62200 | Other           | All              | Acupuncture     | Automation Comments |         3 | Daily  |        5 |  12122019 | 12122019 |
    And Fill the Document Attachment
      | documentType | attachment |
      | DFR          |            |
    Then The New Claim RFA proccess is correctly registred
