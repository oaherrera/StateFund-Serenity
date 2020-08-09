@TodoBR2
Feature: br2_login_and_security
  I want to validate the scenarios of login and security of State Fund

  @TestCaseBR2Scenario1
  Scenario: Validate the message when I try to login with invalid credentials
    When Login with the next credentials
      | userName | password | acceptTermsAndPolicies |
      | Pepe     | Carnitas | yes                    |
    Then Display the error message You have entered an incorrect Username or Password on login page

  @TestCaseBR2Scenario2
  Scenario: Validate the message when the username field is empty
    When Login with the next credentials
      | userName | password | acceptTermsAndPolicies |
      |          | Carnitas | yes                    |
    Then Display the error message Username field is required on login page

  @TestCaseBR2Scenario3
  Scenario: Validate the message when the password field is empty
    When Login with the next credentials
      | userName | password | acceptTermsAndPolicies |
      | Pepe     |          | yes                    |
    Then Display the error message Password field is required on login page

  @TestCaseBR2Scenario4
  Scenario: Validate the message when I don't Accept Terms ans Policies
    When Login with the next credentials
      | userName | password | acceptTermsAndPolicies |
      | Pepe     | Carnitas | no                     |
    Then Display the error message You must accept the Terms & Policies. on login page

  @TestCaseBR2Scenario5
  Scenario: Validate the pop up with the terms and policies
    When Open the link Accept Terms and Policies on login page
    Then Display the window of Terms and Policies

  @TestCaseBR2Scenario6
  Scenario: Validate redirect to option Forgot your password
    When Open the link Forgot your password on login page
    Then Display the window of Forgot your password

  @TestCaseBR2Scenario7
  Scenario: Validate redirect to option to Sign up
    When Open the link Sign up on login page
    Then Display the window of Sign up

  @TestCaseBR2Scenario8
  Scenario Outline: Verify the login screen displays a warning message about locking the account after 4 unsuccessful login attempts.
    When Login with the next credentials
      | userName   | password   | acceptTermsAndPolicies   |
      | <userName> | <password> | <acceptTermsAndPolicies> |
      | <userName> | <password> | <acceptTermsAndPolicies> |
      | <userName> | <password> | <acceptTermsAndPolicies> |
      | <userName> | <password> | <acceptTermsAndPolicies> |
    Then Display the span error message You have entered your credentials incorrectly four times in a row. The next incorrect attempt will temporarily block your User Account. on login page

    Examples: 
      | userName               | password | acceptTermsAndPolicies |
      | portal-test-17@conexia | C0n3x1a$ | yes                    |

  @TestCaseBR2Scenario9
  Scenario Outline: Verify the login screen display the “Fifth Attempt Error” message when the Username/Password combination is incorrect after the fifth failed attempt.
    When Login with the next credentials
      | userName   | password   | acceptTermsAndPolicies   |
      | <userName> | <password> | <acceptTermsAndPolicies> |
      | <userName> | <password> | <acceptTermsAndPolicies> |
      | <userName> | <password> | <acceptTermsAndPolicies> |
      | <userName> | <password> | <acceptTermsAndPolicies> |
      | <userName> | <password> | <acceptTermsAndPolicies> |
    Then Display the span error message You have incorrectly entered your credentials five times in a row. For security reasons, your User Account has been temporarily blocked. For further information, please contact your Administrator. on login page

    Examples: 
      | userName         | password | acceptTermsAndPolicies |
      | portal-3@conexia | C0n3x1a$ | yes                    |

  @TestCaseBR2Scenario10
  Scenario Outline: Verify a Portal User’s locked account is reactivated automatically after 30 minutes.
    When Login with the next credentials
      | userName   | password   | acceptTermsAndPolicies   |
      | <userName> | <password> | <acceptTermsAndPolicies> |
      | <userName> | <password> | <acceptTermsAndPolicies> |
      | <userName> | <password> | <acceptTermsAndPolicies> |
      | <userName> | <password> | <acceptTermsAndPolicies> |
      | <userName> | <password> | <acceptTermsAndPolicies> |
      | <userName> | <password> | <acceptTermsAndPolicies> |
    Then Display the error access denied message You have incorrectly entered your credentials five times in a row. For security reasons, your User Account has been temporarily blocked. For further information, please contact your Administrator. on login page

    Examples: 
      | userName         | password | acceptTermsAndPolicies |
      | portal-6@conexia | C0n3x1a$ | yes                    |
