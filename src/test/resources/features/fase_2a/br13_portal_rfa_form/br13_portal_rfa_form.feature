@TodoBR13
Feature: br13_portal_rfa_form
  I want to validate the funcionality from RFA form

  @TestCaseBR13Scenario1
  Scenario: To validate the portal RFA form
    Given I am authenticated in the aplication
      | userName        | password  |
      | automation-user | C0n3x1a$$ |
    When Search an existing Claim
      | searchBy | claimNumber |
      | Claim    |    01200210 |
    And Access to Claim Details
    And Entry to send RFA
    Then Verify the fields displayed the portal RFA form
      | rfaType     | physicianName  | diagnosisCode | procedureType | procedutreCode | RelatedBodyPart | relatedDiagnosis | urTreatmentType | additionalComments  | frequency | period | quantity | startDate | endDate  |
      | New Request | ALAR GROHH  SL | G54;G54.1;G55 | CPT           |          62200 | Other           | All              | Acupuncture     | Automation Comments |         3 | Daily  |        5 |  12122019 | 12122019 |

  @TestCaseBR13Scenario2
  Scenario: To validate the displayed options from field RFA type
    Given I am authenticated in the aplication
      | userName        | password  |
      | automation-user | C0n3x1a$$ |
    When Search an existing Claim
      | searchBy | claimNumber |
      | Claim    |    01200210 |
    And Access to Claim Details
    And Entry to send RFA
    Then Verify the displayed options from field RFA type

  @TestCaseBR13Scenario3
  Scenario: To validate that is able to select only one value in the field RFA type
    Given I am authenticated in the aplication
      | userName        | password  |
      | automation-user | C0n3x1a$$ |
    When Search an existing Claim
      | searchBy | claimNumber |
      | Claim    |    01200210 |
    And Access to Claim Details
    And Entry to send RFA
    Then Verify that is able to select only one value in the field RFA type

  @TestCaseBR13Scenario4
  Scenario: To validate that is able to change the RFA type option before submitting the RFA form
    Given I am authenticated in the aplication
      | userName        | password  |
      | automation-user | C0n3x1a$$ |
    When Search an existing Claim
      | searchBy | claimNumber |
      | Claim    |    01200210 |
    And Access to Claim Details
    And Entry to send RFA
    Then Verify that is able to change the RFA type option

  @TestCaseBR13Scenario5
  Scenario: To validate a contextual help text is a displayed when the user hovers over the New Request RFA type option
    Given I am authenticated in the aplication
      | userName        | password  |
      | automation-user | C0n3x1a$$ |
    When Search an existing Claim
      | searchBy | claimNumber |
      | Claim    |    01200210 |
    And Access to Claim Details
    And Entry to send RFA
    Then Verify a contextual help text is a displayed when the user hovers over the New Request RFA type option

  @TestCaseBR13Scenario6
  Scenario: To validate a contextual help text is a displayed when the user hovers over the Resubmission RFA type option
    Given I am authenticated in the aplication
      | userName        | password  |
      | automation-user | C0n3x1a$$ |
    When Search an existing Claim
      | searchBy | claimNumber |
      | Claim    |    01200210 |
    And Access to Claim Details
    And Entry to send RFA
    Then Verify a contextual help text is a displayed when the user hovers over the Resubmission RFA type option

  @TestCaseBR13Scenario7
  Scenario: To validate a contextual help text is a displayed when the user hovers over the Expedited RFA type option
    Given I am authenticated in the aplication
      | userName        | password  |
      | automation-user | C0n3x1a$$ |
    When Search an existing Claim
      | searchBy | claimNumber |
      | Claim    |    01200210 |
    And Access to Claim Details
    And Entry to send RFA
    Then Verify a contextual help text is a displayed when the user hovers over the Expedited RFA type option

  @TestCaseBR13Scenario8
  Scenario: To validate a contextual help text is a displayed when the user hovers over the Written Confirmation or Prior Oral Request RFA type option
    Given I am authenticated in the aplication
      | userName        | password  |
      | automation-user | C0n3x1a$$ |
    When Search an existing Claim
      | searchBy | claimNumber |
      | Claim    |    01200210 |
    And Access to Claim Details
    And Entry to send RFA
    Then Verify a contextual help text is a displayed when the user hovers over the Written Confirmation or Prior Oral Request RFA type option

  #  @TestCaseBR13Scenario9
  #  Scenario: To validate the Treatment Requests are legally escalated when the legal flag is true and claim decision is Accepted
  #    Given I am authenticated in the aplication
  #      | userName		 | password  |
  #      | automation-user | C0n3x1a$$ |
  #    When Search an existing Claim
  #      | searchBy | claimNumber |
  #      | Claim    |    01200210 |
  #    And Access to Claim Details
  #    And Entry to send RFA
  #    Then Verify a contextual help text is a displayed when the user hovers over the Written Confirmation or Prior Oral Request RFA type option
  #  @TestCaseBR13Scenario10
  #  Scenario: To validate the Treatment Requests are legally escalated when the legal flag is true and claim decision is Delayed
  #    Given I am authenticated in the aplication
  #      | userName		 | password  |
  #      | automation-user | C0n3x1a$$ |
  #    When Search an existing Claim
  #      | searchBy | claimNumber |
  #      | Claim    |    01200210 |
  #    And Access to Claim Details
  #    And Entry to send RFA
  #    Then Verify a contextual help text is a displayed when the user hovers over the Written Confirmation or Prior Oral Request RFA type option
  @TestCaseBR13Scenario11
  Scenario: To validate the legal flag description is sent back to State Fund in the comments section of the portal RFA form
    Given I am authenticated in the aplication
      | userName        | password  |
      | automation-user | C0n3x1a$$ |
    When Search an existing Claim
      | searchBy | claimNumber |
      | Claim    |    02200302 |
    And Access to Claim Details
    And Entry to send RFA
    Then Verify the legal flag description is sent back to State Fund in the comments section of the portal RFA form
      | comment                    | submittedDate |
      | Claim is settled with C&R. | 11/05/2019    |

  #  @TestCaseBR13Scenario12
  #  Scenario: To validate the source of decision is Portal when the Treatment Requests are Legally Escalated
  #    Given I am authenticated in the aplication
  #      | userName		| password	|
  #      | automation-user | C0n3x1a$$ |
  #    When Search an existing Claim
  #      | searchBy | claimNumber |
  #      | Claim	 |    02200302 |
  #    And Access to Claim Details
  #    And Entry to send RFA
  #    Then Verify the source of decision is Portal when the Treatment Requests are Legally Escalated
  #  @TestCaseBR13Scenario13
  #  Scenario: To validate the treatment requests are processed through the Custom Rules Engine
  #    Given I am authenticated in the aplication
  #      | userName		| password	|
  #      | automation-user | C0n3x1a$$ |
  #    When Search an existing Claim
  #      | searchBy | claimNumber |
  #      | Claim	 |    02200302 |
  #    And Access to Claim Details
  #    And Entry to send RFA
  #    Then Verify the the treatment requests are processed through the Custom Rules Engine when the following conditions are true: Legal Flag is False, Body Part Decision is Accepted and RFA Type is New Request
  #  @TestCaseBR13Scenario14
  #  Scenario: To validate the treatment requests are legally escalated through the Custom Rules Engine
  #    Given I am authenticated in the aplication
  #      | userName		| password	|
  #      | automation-user | C0n3x1a$$ |
  #    When Search an existing Claim
  #      | searchBy | claimNumber |
  #      | Claim	 |    02200302 |
  #    And Access to Claim Details
  #    And Entry to send RFA
  #    Then Verify the the treatment requests are legally escalated through the Custom Rules Engine when the following conditions are true: Legal Flag is False, Body Part Decision is Rejected and RFA Type is New Request
  #  @TestCaseBR13Scenario15
  #  Scenario: To validate the treatment requests are legally escalated through the Custom Rules Engine
  #    Given I am authenticated in the aplication
  #      | userName		| password	|
  #      | automation-user | C0n3x1a$$ |
  #    When Search an existing Claim
  #      | searchBy | claimNumber |
  #      | Claim	 |    02200302 |
  #    And Access to Claim Details
  #    And Entry to send RFA
  #    Then Verify the the treatment requests are legally escalated through the Custom Rules Engine when the following conditions are true: Legal Flag is False, Body Part Decision is Delayed and RFA Type is New Request
  #  @TestCaseBR13Scenario16
  #  Scenario: To validate the treatment requests are legally escalated through the Custom Rules Engine
  #    Given I am authenticated in the aplication
  #      | userName		| password	|
  #      | automation-user | C0n3x1a$$ |
  #    When Search an existing Claim
  #      | searchBy | claimNumber |
  #      | Claim	 |    02200302 |
  #    And Access to Claim Details
  #    And Entry to send RFA
  #    Then Verify the the treatment requests are legally escalated through the Custom Rules Engine when the following conditions are true: Legal Flag is False, Body Part Decision is Blank and RFA Type is New Request
  #  @TestCaseBR13Scenario17
  #  Scenario: To validate the treatment requests are processed through the Custom Rules Engine
  #    Given I am authenticated in the aplication
  #      | userName		| password	|
  #      | automation-user | C0n3x1a$$ |
  #    When Search an existing Claim
  #      | searchBy | claimNumber |
  #      | Claim	 |    02200302 |
  #    And Access to Claim Details
  #    And Entry to send RFA
  #    Then Verify the the treatment requests are processed through the Custom Rules Engine when the following conditions are true: Legal Flag is False, Body Part Decision is Accepted and RFA Type is Expedited
  #  @TestCaseBR13Scenario18
  #  Scenario: To validate the treatment requests are legally escalated through the Custom Rules Engine
  #    Given I am authenticated in the aplication
  #      | userName		| password	|
  #      | automation-user | C0n3x1a$$ |
  #    When Search an existing Claim
  #      | searchBy | claimNumber |
  #      | Claim	 |    02200302 |
  #    And Access to Claim Details
  #    And Entry to send RFA
  #    Then Verify the the treatment requests are legally escalated through the Custom Rules Engine when the following conditions are true: Legal Flag is False, Body Part Decision is Rejected and RFA Type is Expedited
  #  @TestCaseBR13Scenario19
  #  Scenario: To validate the treatment requests are legally escalated through the Custom Rules Engine
  #    Given I am authenticated in the aplication
  #      | userName		| password	|
  #      | automation-user | C0n3x1a$$ |
  #    When Search an existing Claim
  #      | searchBy | claimNumber |
  #      | Claim	 |    02200302 |
  #    And Access to Claim Details
  #    And Entry to send RFA
  #    Then Verify the the treatment requests are legally escalated through the Custom Rules Engine when the following conditions are true: Legal Flag is False, Body Part Decision is Delayed and RFA Type is Expedited
  #  @TestCaseBR13Scenario20
  #  Scenario: To validate the treatment requests are legally escalated through the Custom Rules Engine
  #    Given I am authenticated in the aplication
  #      | userName		| password	|
  #      | automation-user | C0n3x1a$$ |
  #    When Search an existing Claim
  #      | searchBy | claimNumber |
  #      | Claim	 |    02200302 |
  #    And Access to Claim Details
  #    And Entry to send RFA
  #    Then Verify the the treatment requests are legally escalated through the Custom Rules Engine when the following conditions are true: Legal Flag is False, Body Part Decision is Blank and RFA Type is Expedited
  #  @TestCaseBR13Scenario21
  #  Scenario: To validate the treatment requests are processed through the Custom Rules Engine
  #    Given I am authenticated in the aplication
  #      | userName		| password	|
  #      | automation-user | C0n3x1a$$ |
  #    When Search an existing Claim
  #      | searchBy | claimNumber |
  #      | Claim	 |    02200302 |
  #    And Access to Claim Details
  #    And Entry to send RFA
  #    Then Verify the the treatment requests are processed through the Custom Rules Engine when the following conditions are true: Legal Flag is False, Body Part Decision is Accepted and RFA Type is Written Confirmation of Prior Oral Request
  #  @TestCaseBR13Scenario22
  #  Scenario: To validate the treatment requests are legally escalated through the Custom Rules Engine
  #    Given I am authenticated in the aplication
  #      | userName		| password	|
  #      | automation-user | C0n3x1a$$ |
  #    When Search an existing Claim
  #      | searchBy | claimNumber |
  #      | Claim	 |    02200302 |
  #    And Access to Claim Details
  #    And Entry to send RFA
  #    Then Verify the the treatment requests are legally escalated through the Custom Rules Engine when the following conditions are true: Legal Flag is False, Body Part Decision is Rejected and RFA Type is Written Confirmation of Prior Oral Request
  #  @TestCaseBR13Scenario23
  #  Scenario: To validate the treatment requests are legally escalated through the Custom Rules Engine
  #    Given I am authenticated in the aplication
  #      | userName		| password	|
  #      | automation-user | C0n3x1a$$ |
  #    When Search an existing Claim
  #      | searchBy | claimNumber |
  #      | Claim	 |    02200302 |
  #    And Access to Claim Details
  #    And Entry to send RFA
  #    Then Verify the the treatment requests are legally escalated through the Custom Rules Engine when the following conditions are true: Legal Flag is False, Body Part Decision is Delayed and RFA Type is Written Confirmation of Prior Oral Request
  #  @TestCaseBR13Scenario24
  #  Scenario: To validate the treatment requests are legally escalated through the Custom Rules Engine
  #    Given I am authenticated in the aplication
  #      | userName		| password	|
  #      | automation-user | C0n3x1a$$ |
  #    When Search an existing Claim
  #      | searchBy | claimNumber |
  #      | Claim	 |    02200302 |
  #    And Access to Claim Details
  #    And Entry to send RFA
  #    Then Verify the the treatment requests are legally escalated through the Custom Rules Engine when the following conditions are true: Legal Flag is False, Body Part Decision is Blank and RFA Type is Written Confirmation of Prior Oral Request
  #  @TestCaseBR13Scenario25
  #  Scenario: To validate the treatment requests are medically escalated through the Custom Rules Engine
  #    Given I am authenticated in the aplication
  #      | userName		| password	|
  #      | automation-user | C0n3x1a$$ |
  #    When Search an existing Claim
  #      | searchBy | claimNumber |
  #      | Claim	 |    02200302 |
  #    And Access to Claim Details
  #    And Entry to send RFA
  #    Then Verify the the treatment requests are medically escalated through the Custom Rules Engine when the following conditions are true: Legal Flag is False and RFA Type is Resubmission
  #  @TestCaseBR13Scenario26
  #  Scenario: To validate the treatment requests are legally escalated through the Custom Rules Engine
  #    Given I am authenticated in the aplication
  #      | userName		| password	|
  #      | automation-user | C0n3x1a$$ |
  #    When Search an existing Claim
  #      | searchBy | claimNumber |
  #      | Claim	 |    02200302 |
  #    And Access to Claim Details
  #    And Entry to send RFA
  #    Then Verify the the treatment requests are medically escalated through the Custom Rules Engine when the following conditions are true: Legal Flag is True and RFA Type is Resubmission
  @TestCaseBR13Scenario27
  Scenario: To validate is able to enter a numeric value in the NPI Number field in the Requesting Physician Information section
    Given I am authenticated in the aplication
      | userName        | password  |
      | automation-user | C0n3x1a$$ |
    When Search an existing Claim
      | searchBy | claimNumber |
      | Claim    |    01200210 |
    And Access to Claim Details
    And Entry to send RFA
    Then Verify is able to enter a numeric value in the NPI Number field
      | npiNumber     |
      | 12d8f8d535435 |

  @TestCaseBR13Scenario28
  Scenario: To validate is able to enter the Requesting Physicians Email Address in the Requesting Physician Information section
    Given I am authenticated in the aplication
      | userName        | password  |
      | automation-user | C0n3x1a$$ |
    When Search an existing Claim
      | searchBy | claimNumber |
      | Claim    |    01200210 |
    And Access to Claim Details
    And Entry to send RFA
    Then Verify is able to enter the Requesting Physicians Email Address
      | rfaType     | physicianName  | faxNumber  | emailAddress                |
      | New Request | ALAR GROHH  SL | 0000000000 | test.automation@conexia.com |

  @TestCaseBR13Scenario29
  Scenario: To validate the error message when the value is incorrect in the Email Address from Requesting Physician Information section
    Given I am authenticated in the aplication
      | userName        | password  |
      | automation-user | C0n3x1a$$ |
    When Search an existing Claim
      | searchBy | claimNumber |
      | Claim    |    01200210 |
    And Access to Claim Details
    And Entry to send RFA
    Then Display the error message The email is invalid, Please enter a valid email address on Requesting Physician Information section
      | rfaType     | physicianName  | faxNumber  | emailAddress            |
      | New Request | ALAR GROHH  SL | 0000000000 | test.automation@conexia |

  @TestCaseBR13Scenario30
  Scenario: To validate the value displayed is State Compensation Insurance Fund in the Company Name field
    Given I am authenticated in the aplication
      | userName        | password  |
      | automation-user | C0n3x1a$$ |
    When Search an existing Claim
      | searchBy | claimNumber |
      | Claim    |    01200210 |
    And Access to Claim Details
    And Entry to send RFA
    And Fill the Requesting Physician Information with RFA type
      | rfaType     | physicianName  |
      | New Request | ALAR GROHH  SL |
    Then Verify the value displayed is State Compensation Insurance Fund in the Company Name field

  @TestCaseBR13Scenario31
  Scenario: To validate is unable to edit the Company Name field
    Given I am authenticated in the aplication
      | userName        | password  |
      | automation-user | C0n3x1a$$ |
    When Search an existing Claim
      | searchBy | claimNumber |
      | Claim    |    01200210 |
    And Access to Claim Details
    And Entry to send RFA
    And Fill the Requesting Physician Information with RFA type
      | rfaType     | physicianName  |
      | New Request | ALAR GROHH  SL |
    Then Verify is unable to edit the Company Name field

  @TestCaseBR13Scenario32
  Scenario: To validate the address PO Box 3171, Suisun City, CA, 94585 displayed from Address field in the Claim Administrator Information
    Given I am authenticated in the aplication
      | userName        | password  |
      | automation-user | C0n3x1a$$ |
    When Search an existing Claim
      | searchBy | claimNumber |
      | Claim    |    01200210 |
    And Access to Claim Details
    And Entry to send RFA
    And Fill the Requesting Physician Information with RFA type
      | rfaType     | physicianName  |
      | New Request | ALAR GROHH  SL |
    Then Verify the address PO Box 3171, Suisun City, CA, 94585 displayed from Address field

  @TestCaseBR13Scenario33
  Scenario: To validate the address PO Box 65005, Fresno, CA, 93650 displayed from Address field in the Claim Administrator Information
    Given I am authenticated in the aplication
      | userName        | password  |
      | automation-user | C0n3x1a$$ |
    When Search an existing Claim
      | searchBy | claimNumber |
      | Claim    |    01200210 |
    And Access to Claim Details
    And Entry to send RFA
    And Fill the Requesting Physician Information with RFA type
      | rfaType     | physicianName  |
      | New Request | ALAR GROHH  SL |
    Then Verify the address PO Box 65005, Fresno, CA, 93650 displayed from Address field

  @TestCaseBR13Scenario34
  Scenario: To validate the address PO Box 11828, Santa Ana, CA, 92711 displayed from Address field in the Claim Administrator Information
    Given I am authenticated in the aplication
      | userName        | password  |
      | automation-user | C0n3x1a$$ |
    When Search an existing Claim
      | searchBy | claimNumber |
      | Claim    |    01200210 |
    And Access to Claim Details
    And Entry to send RFA
    And Fill the Requesting Physician Information with RFA type
      | rfaType     | physicianName  |
      | New Request | ALAR GROHH  SL |
    Then Verify the address PO Box 11828, Santa Ana, CA, 92711 displayed from Address field

  @TestCaseBR13Scenario35
  Scenario: To validate the select an address any from Address field, and the City, State and Zip Code fields must be auto-populated in the Claim Administrator Information
    Given I am authenticated in the aplication
      | userName        | password  |
      | automation-user | C0n3x1a$$ |
    When Search an existing Claim
      | searchBy | claimNumber |
      | Claim    |    01200210 |
    And Access to Claim Details
    And Entry to send RFA
    And Fill the Requesting Physician Information with RFA type
      | rfaType     | physicianName  |
      | New Request | ALAR GROHH  SL |
    Then Verify the select an value any from Address field, and the City, State, Zip Code fields must be auto-populated
      | address                            |
      | PO Box 11828, Santa Ana, CA, 92711 |

  @TestCaseBR13Scenario36
  Scenario: To validate is able to enter a numeric value in the Telephone field in the Claim Administrator Information section
    Given I am authenticated in the aplication
      | userName        | password  |
      | automation-user | C0n3x1a$$ |
    When Search an existing Claim
      | searchBy | claimNumber |
      | Claim    |    01200210 |
    And Access to Claim Details
    And Entry to send RFA
    And Fill the Requesting Physician Information with RFA type
      | rfaType     | physicianName  |
      | New Request | ALAR GROHH  SL |
    Then Verify is able to enter a numeric value in the Telephone field
      | telephone        |
      | s54d86s0325adf64 |

  @TestCaseBR13Scenario37
  Scenario: To validate is able to enter a numeric value in the Fax Number field in the Claim Administrator Information section
    Given I am authenticated in the aplication
      | userName        | password  |
      | automation-user | C0n3x1a$$ |
    When Search an existing Claim
      | searchBy | claimNumber |
      | Claim    |    01200210 |
    And Access to Claim Details
    And Entry to send RFA
    And Fill the Requesting Physician Information with RFA type
      | rfaType     | physicianName  |
      | New Request | ALAR GROHH  SL |
    Then Verify is able to enter a numeric value in the Fax Number field
      | faxNumber       |
      | l5801k63l8k7i98 |

  @TestCaseBR13Scenario38
  Scenario: To validate is able to search for a Diagnosis by entering the diagnosis code in the Diagnosis Code/Desc. field
    Given I am authenticated in the aplication
      | userName        | password  |
      | automation-user | C0n3x1a$$ |
    When Search an existing Claim
      | searchBy | claimNumber |
      | Claim    |    01200210 |
    And Access to Claim Details
    And Entry to send RFA
    And Fill the Requesting Physician Information with RFA type
      | rfaType     | physicianName  |
      | New Request | ALAR GROHH  SL |
    Then Verify is able to search for a Diagnosis by entering the diagnosis code
      | diagnosisCode |
      | D61.81        |

  @TestCaseBR13Scenario39
  Scenario: To validate is able to search for a Diagnosis by entering the diagnosis description in the Diagnosis Code/Desc. field
    Given I am authenticated in the aplication
      | userName        | password  |
      | automation-user | C0n3x1a$$ |
    When Search an existing Claim
      | searchBy | claimNumber |
      | Claim    |    01200210 |
    And Access to Claim Details
    And Entry to send RFA
    And Fill the Requesting Physician Information with RFA type
      | rfaType     | physicianName  |
      | New Request | ALAR GROHH  SL |
    Then Verify is able to search for a Diagnosis by entering the diagnosis description
      | diagnosisDescription |
      | Pancytopenia         |

  @TestCaseBR13Scenario40
  Scenario: To validate when the diagnosis code entered is invalid in the Diagnosis Code/Desc. field
    Given I am authenticated in the aplication
      | userName        | password  |
      | automation-user | C0n3x1a$$ |
    When Search an existing Claim
      | searchBy | claimNumber |
      | Claim    |    01200210 |
    And Access to Claim Details
    And Entry to send RFA
    And Fill the Requesting Physician Information with RFA type
      | rfaType     | physicianName  |
      | New Request | ALAR GROHH  SL |
    And Fill the Claim Administrator Information
    Then Verify when the diagnosis code entered is invalid with the message No matches found
      | diagnosisCode |
      |          6789 |

  @TestCaseBR13Scenario41
  Scenario: To validate when the diagnosis description entered is invalid in the Diagnosis Code/Desc. field
    Given I am authenticated in the aplication
      | userName        | password  |
      | automation-user | C0n3x1a$$ |
    When Search an existing Claim
      | searchBy | claimNumber |
      | Claim    |    01200210 |
    And Access to Claim Details
    And Entry to send RFA
    And Fill the Requesting Physician Information with RFA type
      | rfaType     | physicianName  |
      | New Request | ALAR GROHH  SL |
    And Fill the Claim Administrator Information
    Then Verify when the diagnosis description entered is invalid with the message No matches found
      | diagnosisDescription       |
      | Robotic process automation |

  @TestCaseBR13Scenario42
  Scenario: To validate the procedure type CPT displayed from Procedure Type field in the Treatment Details
    Given I am authenticated in the aplication
      | userName        | password  |
      | automation-user | C0n3x1a$$ |
    When Search an existing Claim
      | searchBy | claimNumber |
      | Claim    |    01200210 |
    And Access to Claim Details
    And Entry to send RFA
    And Fill the Requesting Physician Information with RFA type
      | rfaType     | physicianName  |
      | New Request | ALAR GROHH  SL |
    Then Verify the procedure type CPT displayed from Procedure Type field

  @TestCaseBR13Scenario43
  Scenario: To validate the procedure type HCPCS displayed from Procedure Type field in the Treatment Details
    Given I am authenticated in the aplication
      | userName        | password  |
      | automation-user | C0n3x1a$$ |
    When Search an existing Claim
      | searchBy | claimNumber |
      | Claim    |    01200210 |
    And Access to Claim Details
    And Entry to send RFA
    And Fill the Requesting Physician Information with RFA type
      | rfaType     | physicianName  |
      | New Request | ALAR GROHH  SL |
    Then Verify the procedure type HCPCS displayed from Procedure Type field

  @TestCaseBR13Scenario44
  Scenario: To validate the procedure type GPI displayed from Procedure Type field in the Treatment Details
    Given I am authenticated in the aplication
      | userName        | password  |
      | automation-user | C0n3x1a$$ |
    When Search an existing Claim
      | searchBy | claimNumber |
      | Claim    |    01200210 |
    And Access to Claim Details
    And Entry to send RFA
    And Fill the Requesting Physician Information with RFA type
      | rfaType     | physicianName  |
      | New Request | ALAR GROHH  SL |
    Then Verify the procedure type GPI displayed from Procedure Type field

  @TestCaseBR13Scenario45
  Scenario: To validate the procedure type CDT displayed from Procedure Type field in the Treatment Details
    Given I am authenticated in the aplication
      | userName        | password  |
      | automation-user | C0n3x1a$$ |
    When Search an existing Claim
      | searchBy | claimNumber |
      | Claim    |    01200210 |
    And Access to Claim Details
    And Entry to send RFA
    And Fill the Requesting Physician Information with RFA type
      | rfaType     | physicianName  |
      | New Request | ALAR GROHH  SL |
    Then Verify the procedure type CDT displayed from Procedure Type field

  @TestCaseBR13Scenario46
  Scenario: To validate when the procedure code entered is invalid in the Procedure Code/Desc. field
    Given I am authenticated in the aplication
      | userName        | password  |
      | automation-user | C0n3x1a$$ |
    When Search an existing Claim
      | searchBy | claimNumber |
      | Claim    |    01200210 |
    And Access to Claim Details
    And Entry to send RFA
    And Fill the Requesting Physician Information with RFA type
      | rfaType     | physicianName  |
      | New Request | ALAR GROHH  SL |
    And Fill the Claim Administrator Information
    Then Verify when the procedure code entered is invalid with the message No matches found
      | procedureCode |
      |        987345 |

  @TestCaseBR13Scenario47
  Scenario: To validate when the procedure description entered is invalid in the Procedure Code/Desc. field
    Given I am authenticated in the aplication
      | userName        | password  |
      | automation-user | C0n3x1a$$ |
    When Search an existing Claim
      | searchBy | claimNumber |
      | Claim    |    01200210 |
    And Access to Claim Details
    And Entry to send RFA
    And Fill the Requesting Physician Information with RFA type
      | rfaType     | physicianName  |
      | New Request | ALAR GROHH  SL |
    And Fill the Claim Administrator Information
    Then Verify when the procedure description entered is invalid with the message No matches found
      | procedureDescription       |
      | Robotic process automation |

  @TestCaseBR13Scenario48
  Scenario: To validate displays up to 20 partially matched results in the Procedure Search field
    Given I am authenticated in the aplication
      | userName        | password  |
      | automation-user | C0n3x1a$$ |
    When Search an existing Claim
      | searchBy | claimNumber |
      | Claim    |    01200210 |
    And Access to Claim Details
    And Entry to send RFA
    And Fill the Requesting Physician Information with RFA type
      | rfaType     | physicianName  |
      | New Request | ALAR GROHH  SL |
    And Fill the Claim Administrator Information
    Then Verify displays up to 20 partially matched results in the Procedure Search field
      | procedure |
      |       682 |

  @TestCaseBR13Scenario49
  Scenario: To validate of the Quantity field in the Requested Treatment section, when this field has no value
    Given I am authenticated in the aplication
      | userName        | password  |
      | automation-user | C0n3x1a$$ |
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
      | G54;G54.1;G55 | CPT           |          62200 | Other           | All              | Acupuncture     | Automation Comments |         3 | Daily  |          |  12122019 | 12122019 |
    Then The portal is shows the error message Quantity is required.

  @TestCaseBR13Scenario50
  Scenario: To validate the period Daily displayed from Period field in the Procedure Diagnosis table
    Given I am authenticated in the aplication
      | userName        | password  |
      | automation-user | C0n3x1a$$ |
    When Search an existing Claim
      | searchBy | claimNumber |
      | Claim    |    01200210 |
    And Access to Claim Details
    And Entry to send RFA
    And Fill the Requesting Physician Information with RFA type
      | rfaType     | physicianName  |
      | New Request | ALAR GROHH  SL |
    And Fill the Claim Administrator Information
    Then Verify the period Daily displayed from Period field to Treatment Details
      | diagnosisCode | procedureType | procedutreCode | RelatedBodyPart | relatedDiagnosis | urTreatmentType | additionalComments  | frequency | period | quantity | startDate | endDate  |
      | G54;G54.1;G55 | CPT           |          62200 | Other           | All              | Acupuncture     | Automation Comments |         3 |        |        5 |  12122019 | 12122019 |

  @TestCaseBR13Scenario51
  Scenario: To validate the period Weekly displayed from Period field in the Procedure Diagnosis table
    Given I am authenticated in the aplication
      | userName        | password  |
      | automation-user | C0n3x1a$$ |
    When Search an existing Claim
      | searchBy | claimNumber |
      | Claim    |    01200210 |
    And Access to Claim Details
    And Entry to send RFA
    And Fill the Requesting Physician Information with RFA type
      | rfaType     | physicianName  |
      | New Request | ALAR GROHH  SL |
    And Fill the Claim Administrator Information
    Then Verify the period Weekly displayed from Period field to Treatment Details
      | diagnosisCode | procedureType | procedutreCode | RelatedBodyPart | relatedDiagnosis | urTreatmentType | additionalComments  | frequency | period | quantity | startDate | endDate  |
      | G54;G54.1;G55 | CPT           |          62200 | Other           | All              | Acupuncture     | Automation Comments |         3 |        |        5 |  12122019 | 12122019 |

  @TestCaseBR13Scenario52
  Scenario: To validate the period Bi-Weekly displayed from Period field in the Procedure Diagnosis table
    Given I am authenticated in the aplication
      | userName        | password  |
      | automation-user | C0n3x1a$$ |
    When Search an existing Claim
      | searchBy | claimNumber |
      | Claim    |    01200210 |
    And Access to Claim Details
    And Entry to send RFA
    And Fill the Requesting Physician Information with RFA type
      | rfaType     | physicianName  |
      | New Request | ALAR GROHH  SL |
    And Fill the Claim Administrator Information
    Then Verify the period Bi-Weekly displayed from Period field to Treatment Details
      | diagnosisCode | procedureType | procedutreCode | RelatedBodyPart | relatedDiagnosis | urTreatmentType | additionalComments  | frequency | period | quantity | startDate | endDate  |
      | G54;G54.1;G55 | CPT           |          62200 | Other           | All              | Acupuncture     | Automation Comments |         3 |        |        5 |  12122019 | 12122019 |

  @TestCaseBR13Scenario53
  Scenario: To validate the period Monthly displayed from Period field in the Procedure Diagnosis table
    Given I am authenticated in the aplication
      | userName        | password  |
      | automation-user | C0n3x1a$$ |
    When Search an existing Claim
      | searchBy | claimNumber |
      | Claim    |    01200210 |
    And Access to Claim Details
    And Entry to send RFA
    And Fill the Requesting Physician Information with RFA type
      | rfaType     | physicianName  |
      | New Request | ALAR GROHH  SL |
    And Fill the Claim Administrator Information
    Then Verify the period Monthly displayed from Period field to Treatment Details
      | diagnosisCode | procedureType | procedutreCode | RelatedBodyPart | relatedDiagnosis | urTreatmentType | additionalComments  | frequency | period | quantity | startDate | endDate  |
      | G54;G54.1;G55 | CPT           |          62200 | Other           | All              | Acupuncture     | Automation Comments |         3 |        |        5 |  12122019 | 12122019 |

  @TestCaseBR13Scenario54
  Scenario: To validate the period Bi-Monthly displayed from Period field in the Procedure Diagnosis table
    Given I am authenticated in the aplication
      | userName        | password  |
      | automation-user | C0n3x1a$$ |
    When Search an existing Claim
      | searchBy | claimNumber |
      | Claim    |    01200210 |
    And Access to Claim Details
    And Entry to send RFA
    And Fill the Requesting Physician Information with RFA type
      | rfaType     | physicianName  |
      | New Request | ALAR GROHH  SL |
    And Fill the Claim Administrator Information
    Then Verify the period Bi-Monthly displayed from Period field to Treatment Details
      | diagnosisCode | procedureType | procedutreCode | RelatedBodyPart | relatedDiagnosis | urTreatmentType | additionalComments  | frequency | period | quantity | startDate | endDate  |
      | G54;G54.1;G55 | CPT           |          62200 | Other           | All              | Acupuncture     | Automation Comments |         3 |        |        5 |  12122019 | 12122019 |

  @TestCaseBR13Scenario55
  Scenario: To validate the period Yearly displayed from Period field in the Procedure Diagnosis table
    Given I am authenticated in the aplication
      | userName        | password  |
      | automation-user | C0n3x1a$$ |
    When Search an existing Claim
      | searchBy | claimNumber |
      | Claim    |    01200210 |
    And Access to Claim Details
    And Entry to send RFA
    And Fill the Requesting Physician Information with RFA type
      | rfaType     | physicianName  |
      | New Request | ALAR GROHH  SL |
    And Fill the Claim Administrator Information
    Then Verify the period Yearly displayed from Period field to Treatment Details
      | diagnosisCode | procedureType | procedutreCode | RelatedBodyPart | relatedDiagnosis | urTreatmentType | additionalComments  | frequency | period | quantity | startDate | endDate  |
      | G54;G54.1;G55 | CPT           |          62200 | Other           | All              | Acupuncture     | Automation Comments |         3 |        |        5 |  12122019 | 12122019 |

  @TestCaseBR13Scenario56
  Scenario: To validate a calendar table is displayed when the Start Date field is selected in the Procedure Diagnosis table
    Given I am authenticated in the aplication
      | userName        | password  |
      | automation-user | C0n3x1a$$ |
    When Search an existing Claim
      | searchBy | claimNumber |
      | Claim    |    01200210 |
    And Access to Claim Details
    And Entry to send RFA
    And Fill the Requesting Physician Information with RFA type
      | rfaType     | physicianName  |
      | New Request | ALAR GROHH  SL |
    And Fill the Claim Administrator Information
    Then Verify a calendar table is displayed when the Start Date field is selected
      | diagnosisCode | procedureType | procedutreCode | RelatedBodyPart | relatedDiagnosis | urTreatmentType | additionalComments  | frequency | period | quantity |
      | G54;G54.1;G55 | CPT           |          62200 | Other           | All              | Acupuncture     | Automation Comments |         3 | Daily  |        5 |

  @TestCaseBR13Scenario57
  Scenario: To validate a calendar table is displayed when the End Date field is selected in the Procedure Diagnosis table
    Given I am authenticated in the aplication
      | userName        | password  |
      | automation-user | C0n3x1a$$ |
    When Search an existing Claim
      | searchBy | claimNumber |
      | Claim    |    01200210 |
    And Access to Claim Details
    And Entry to send RFA
    And Fill the Requesting Physician Information with RFA type
      | rfaType     | physicianName  |
      | New Request | ALAR GROHH  SL |
    And Fill the Claim Administrator Information
    Then Verify a calendar table is displayed when the End Date field is selected
      | diagnosisCode | procedureType | procedutreCode | RelatedBodyPart | relatedDiagnosis | urTreatmentType | additionalComments  | frequency | period | quantity | startDate |
      | G54;G54.1;G55 | CPT           |          62200 | Other           | All              | Acupuncture     | Automation Comments |         3 | Daily  |        5 |  12122019 |

  @TestCaseBR13Scenario58
  Scenario: To validate is able to select a value up to 180 days in the future in the Start Date field in the Procedure Diagnosis table
    Given I am authenticated in the aplication
      | userName        | password  |
      | automation-user | C0n3x1a$$ |
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
      | diagnosisCode | procedureType | procedutreCode | RelatedBodyPart | relatedDiagnosis | urTreatmentType | additionalComments  | frequency | period | quantity | startDate | endDate |
      | G54;G54.1;G55 | CPT           |          62200 | Other           | All              | Acupuncture     | Automation Comments |         3 | Daily  |        5 |  12122029 |         |
    Then The portal is shows alert with the error message 2 = Start Date can not be greater than 180 days from Actual Date.

  @TestCaseBR13Scenario59
  Scenario: To validate of the End Date, when the End Date is prior to Start Date
    Given I am authenticated in the aplication
      | userName        | password  |
      | automation-user | C0n3x1a$$ |
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
      | G54;G54.1;G55 | CPT           |          62200 | Other           | All              | Acupuncture     | Automation Comments |         3 | Daily  |        5 |  08012020 | 03032020 |
    Then The portal is shows alert with the error message 2 = End date must be greater or equal than Start Date.

  @TestCaseBR13Scenario60
  Scenario: To validate is displaying UR Treatment Type based on the CPT Procedure Type
    Given I am authenticated in the aplication
      | userName        | password  |
      | automation-user | C0n3x1a$$ |
    When Search an existing Claim
      | searchBy | claimNumber |
      | Claim    |    01200210 |
    And Access to Claim Details
    And Entry to send RFA
    And Fill the Requesting Physician Information with RFA type
      | rfaType     | physicianName  |
      | New Request | ALAR GROHH  SL |
    And Fill the Claim Administrator Information
    Then Verify is displaying UR Treatment Type based on the CPT: Procedure Type

  @TestCaseBR13Scenario61
  Scenario: To validate is displaying UR Treatment Type based on the HCPCS Procedure Type
    Given I am authenticated in the aplication
      | userName        | password  |
      | automation-user | C0n3x1a$$ |
    When Search an existing Claim
      | searchBy | claimNumber |
      | Claim    |    01200210 |
    And Access to Claim Details
    And Entry to send RFA
    And Fill the Requesting Physician Information with RFA type
      | rfaType     | physicianName  |
      | New Request | ALAR GROHH  SL |
    And Fill the Claim Administrator Information
    Then Verify is displaying UR Treatment Type based on the HCPCS: Procedure Type

  @TestCaseBR13Scenario62
  Scenario: To validate is displaying UR Treatment Type based on the GPI Procedure Type
    Given I am authenticated in the aplication
      | userName        | password  |
      | automation-user | C0n3x1a$$ |
    When Search an existing Claim
      | searchBy | claimNumber |
      | Claim    |    01200210 |
    And Access to Claim Details
    And Entry to send RFA
    And Fill the Requesting Physician Information with RFA type
      | rfaType     | physicianName  |
      | New Request | ALAR GROHH  SL |
    And Fill the Claim Administrator Information
    Then Verify is displaying UR Treatment Type based on the GPI: Procedure Type

  @TestCaseBR13Scenario63
  Scenario: To validate is displaying UR Treatment Type based on the CDT Procedure Type
    Given I am authenticated in the aplication
      | userName        | password  |
      | automation-user | C0n3x1a$$ |
    When Search an existing Claim
      | searchBy | claimNumber |
      | Claim    |    01200210 |
    And Access to Claim Details
    And Entry to send RFA
    And Fill the Requesting Physician Information with RFA type
      | rfaType     | physicianName  |
      | New Request | ALAR GROHH  SL |
    And Fill the Claim Administrator Information
    Then Verify is displaying UR Treatment Type based on the CDT: Procedure Type
