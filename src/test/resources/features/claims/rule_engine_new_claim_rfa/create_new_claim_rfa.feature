Feature: Create a New Claim RFA
  I want to create a New Claim RFA on State Fund

  @TestCase1
  Scenario: Create a New Claim RFA proccess from worker information
    Given I am authenticated in the aplication
      | userName        | password |
      | automation-user | C0n3x1a$ |
    When Submit a New Claim RFA with a worker information
      | searchBy | workerFirstName | workerMiddleName | workerLastName | claimNumber | rfaType     |
      | Claim    | Pepito          | P                | Perez          |  1001002010 | New Request |
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
