Feature: Create a Non-Claim RFA
  I want to create a Non-Claim RFA on State Fund

  @TestCaseRuleEngineANonClaimRFA
  Scenario Outline: Create a Non-Claim RFA proccess from worker information
    Given I am authenticated in the aplication
      | userName | password |
    When Submit a Non-Claim RFA with a worker information
      | workerFirstName | workerMiddleName | workerLastName | dateOfBirth | dateOfInjury | employerName | rfaType |
    And Fill the Requesting Physician Information
      | physicianName |
    And Fill the Claim Administrator Information
    And Fil the Treatment Details
      | diagnosisCode | procedureType | procedutreCode | RelatedBodyPart | relatedDiagnosis | urTreatmentType | additionalComments | frequency | period | quantity | startDate | endDate |
    And Fill the Document Attachment
      | documentType | attachment |
    Then The Non-Claim RFA proccess is correctly registred

    Examples: 
      | data |
#  @TestCase1
#  Scenario: Create a Non-Claim RFA proccess from worker information
#    Given I am authenticated in the aplication
#      | userName        | password |
#      | automation-user | C0n3x1a$$ |
#    When Submit a Non-Claim RFA with a worker information
#      | workerFirstName | workerMiddleName | workerLastName | dateOfBirth | dateOfInjury | employerName | rfaType     |
#      | Pepito          | P                | Perez          |    11121991 |     09122019 | Test         | New Request |
#    And Fill the Requesting Physician Information
#      | physicianName  |
#      | ALAR GROHH  SL |
#    And Fill the Claim Administrator Information
#    And Fil the Treatment Details
#      | diagnosisCode | procedureType | procedutreCode | RelatedBodyPart | relatedDiagnosis | urTreatmentType | additionalComments  | frequency | period | quantity | startDate | endDate  |
#      | G54;G54.1;G55 | CPT           |          62200 | Other           | All              | Acupuncture     | Automation Comments |         3 | Daily  |        5 |  12122019 | 12122019 |
#    And Fill the Document Attachment
#      | documentType | attachment |
#      | DFR;NR       |            |
#    Then The Non-Claim RFA proccess is correctly registred
