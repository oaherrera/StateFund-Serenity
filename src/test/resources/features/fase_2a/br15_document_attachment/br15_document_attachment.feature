@TodoBR15
Feature: br15_document_attachment
  I want to verify the different user access

  @TestCaseBR15Scenario1
  Scenario: Verify if the Portal user is able to attach a PR-2 file(s) to a RFA
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
      | PR2          |            |
    Then the portal shows the summary screen

  @TestCaseBR15Scenario2
  Scenario: Verify if the Portal user is able to delete the PR-2 file(s) from a RFA before submission
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
    And Fill the Document Attachment and remove
      | documentType | attachment |
      | PR2          |            |
    Then shows that the record was deleted

  @TestCaseBR15Scenario3
  Scenario: Verify if the Portal User is able to download the PR-2 files(2) from a RFA after submission
    Given I am authenticated in the aplication
      | userName                  | password |
      | portal-test-4@conexia.com | C0n3x1a$ |
    When Search an existing Claim
      | searchBy | claimNumber |
      | Claim    |    01200210 |
    And Access to Claim Details
    Then can see all the attachments and view document to download

  @TestCaseBR15Scenario4
  Scenario: Verify if the Portal user is able to attach a DFR file(s) to a RFA
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
    Then the portal shows the summary screen

  @TestCaseBR15Scenario5
  Scenario: Verify if the Portal user is able to delete the DFR file(s) from a RFA before submission
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
    And Fill the Document Attachment and remove
      | documentType | attachment |
      | DFR          |            |
    Then shows that the record was deleted

  @TestCaseBR15Scenario6
  Scenario: Verify if the Portal User is able to download the DFR files(2) from a RFA after submission
    Given I am authenticated in the aplication
      | userName                  | password |
      | portal-test-4@conexia.com | C0n3x1a$ |
    When Search an existing Claim
      | searchBy | claimNumber |
      | Claim    |    01200210 |
    And Access to Claim Details
    Then can see all the attachments and view document to download

  @TestCaseBR15Scenario7
  Scenario: Verify if the Portal user is able to attach a Narrative Report file(s) to a RFA
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
      | NR           |            |
    Then the portal shows the summary screen

  @TestCaseBR15Scenario8
  Scenario: Verify if the Portal user is able to delete the Narrative Report file(s) from a RFA before submission
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
    And Fill the Document Attachment and remove
      | documentType | attachment |
      | NR           |            |
    Then shows that the record was deleted

  @TestCaseBR15Scenario9
  Scenario: Verify that the portal restricts the user to upload a PR-2 file(s) in a format other than PDF
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
    And Fill the Document Attachment other than pdf
      | documentType | attachment |
      | PR2          |            |
    Then Error message Invalid file type is displayed

  @TestCaseBR15Scenario10
  Scenario: Verify that the portal restricts the user to upload a DFR file(s) in a format other than PDF
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
    And Fill the Document Attachment other than pdf
      | documentType | attachment |
      | DFR          |            |
    Then Error message Invalid file type is displayed

  @TestCaseBR15Scenario11
  Scenario: Verify that the portal restricts the user to upload a Narrative Report file(s) in a format other than PDF
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
    And Fill the Document Attachment other than pdf
      | documentType | attachment |
      | NR           |            |
    Then Error message Invalid file type is displayed

  @TestCaseBR15Scenario12
  Scenario: Verify that the portal restricts the user to upload a PR-2 file(s) bigger than 32MB
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
    And Fill the Document Attachment bigger than 32MB
      | documentType | attachment |
      | PR2          |            |
    Then Error message Invalid file size is show

  @TestCaseBR15Scenario13
  Scenario: Verify that the portal restricts the user to upload a DFR file(s) bigger than 32MB
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
    And Fill the Document Attachment bigger than 32MB
      | documentType | attachment |
      | DFR          |            |
    Then Error message Invalid file size is show

  @TestCaseBR15Scenario14
  Scenario: Verify that the portal restricts the user to upload a Narrative Report file(s) bigger than 32MB
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
    And Fill the Document Attachment bigger than 32MB
      | documentType | attachment |
      | NR           |            |
    Then Error message Invalid file size is show
