@TodoBR1
Feature: br1_user_registration
  I as a user want to be able to register my data in the application to have access

  @TestCaseBR1Scenario1
  Scenario: Verify the Portal displays the Registration Form when the Portal User selects the Sign-up button on Login Screen
    When Open the link Sign up on login page
    Then Display the window of Sign up

  @TestCaseBR1Scenario2
  Scenario: Verify the Portal displays the Registration fields and validates the mandatory fields
    When Open the link Sign up on login page
    And Confirm without filling out the form
    Then The portal is shows the error message This field is required

  @TestCaseBR1Scenario3
  Scenario: Verify the Portal validates the username field with the existent users in the Database and displays an error when the Username already exists.
    When Open the link Sign up on login page
    And diligence the form with existing user
      | firstName | middleInitial | lastName  | userName   | email               | confirmEmail        | telephone  | mobile     | password       | confirmPassword | active |
      | oscar     | h             | hernandez | oaherreram | oscarhr@conexia.com | oscarhr@conexia.com | 3225226363 | 3225226363 | Colombia2020.* | Colombia2020.*  | yes    |
    Then The portal is shows alert with the error message 1 = The Username entered exists already. Please enter a unique Username to create an account. If you have already registered, please proceed to Log In screen.

  @TestCaseBR1Scenario4
  Scenario: Verify the Portal redirects the User to the Login page when the “Back to Login” button is selected in the User Registration screen
    When Open the link Sign up on login page
    Then The user can return to login

  @TestCaseBR1Scenario5
  Scenario: Verify the Portal validates the email address field with the existent emails in the Database and displays an error when the Email address already exists.
    When Open the link Sign up on login page
    And diligence the form with existing user
      | firstName | middleInitial | lastName | userName   | email             | confirmEmail      | telephone  | mobile     | password       | confirmPassword | active |
      | test      | h             | Perez    | testqperez | oscar@conexia.com | oscar@conexia.com | 3225226361 | 3225226361 | Colombia2022.* | Colombia2022.*  | yes    |
    Then The portal is shows alert with the error message 1 = The Email Address entered exists already. Please enter a unique Email Address to create an account. If you have already registered, please proceed to Log In screen.

  @TestCaseBR1Scenario6
  Scenario Outline: Verify the Portal validates the Password criteria properly
    When Open the link Sign up on login page
    And diligence the form with existing user

      | firstName   | middleInitial   | lastName   | userName   | email   | confirmEmail   | telephone   | mobile   | password   | confirmPassword   | active   |
      | <firstName> | <middleInitial> | <lastName> | <userName> | <email> | <confirmEmail> | <telephone> | <mobile> | <password> | <confirmPassword> | <active> |
    Then The portal is shows alert with the error message 1 = Password must include: •At least 8 characters •An UPPERCASE letter •A lowercase letter •A symbol •A number •Must not contain the word 'Password', 'Test' or 'Changeme' •Must not contain the username, first name, last name or part of them

    Examples: 
      | firstName | middleInitial | lastName | userName   | email             | confirmEmail      | telephone  | mobile     | password  | confirmPassword | active |
      | test      | h             | Perez    | testhperez | oscar@conexia.com | oscar@conexia.com | 3225226361 | 3225226361 | Conexia   | Conexia         | yes    |
      | test      | h             | Perez    | testhperez | oscar@conexia.com | oscar@conexia.com | 3225226361 | 3225226361 | conexia#1 | conexia#1       | yes    |
      | test      | h             | Perez    | testhperez | oscar@conexia.com | oscar@conexia.com | 3225226361 | 3225226361 | CONEXIA#1 | CONEXIA#1       | yes    |
      | test      | h             | Perez    | testhperez | oscar@conexia.com | oscar@conexia.com | 3225226361 | 3225226361 | Conexia1  | Conexia1        | yes    |
      | test      | h             | Perez    | testhperez | oscar@conexia.com | oscar@conexia.com | 3225226361 | 3225226361 | Conexia#  | Conexia#        | yes    |

  @TestCaseBR1Scenario7
  Scenario Outline: Verify the Portal validates the Password restricted words
    When Open the link Sign up on login page
    And diligence the form with existing user
      | firstName   | middleInitial   | lastName   | userName   | email   | confirmEmail   | telephone   | mobile   | password   | confirmPassword   | active   |
      | <firstName> | <middleInitial> | <lastName> | <userName> | <email> | <confirmEmail> | <telephone> | <mobile> | <password> | <confirmPassword> | <active> |
    Then The portal is shows alert with the error message 1 = Password must include: •At least 8 characters •An UPPERCASE letter •A lowercase letter •A symbol •A number •Must not contain the word 'Password', 'Test' or 'Changeme' •Must not contain the username, first name, last name or part of them

    Examples: 
      | firstName | middleInitial | lastName | userName   | email             | confirmEmail      | telephone  | mobile     | password  | confirmPassword | active |
      | test      | h             | Perez    | testhperez | oscar@conexia.com | oscar@conexia.com | 3225226361 | 3225226361 | Password  | Password        | yes    |
      | test      | h             | Perez    | testhperez | oscar@conexia.com | oscar@conexia.com | 3225226361 | 3225226361 | password  | password        | yes    |
      | test      | h             | Perez    | testhperez | oscar@conexia.com | oscar@conexia.com | 3225226361 | 3225226361 | Test      | Test            | yes    |
      | test      | h             | Perez    | testhperez | oscar@conexia.com | oscar@conexia.com | 3225226361 | 3225226361 | Changeme  | Changeme        | yes    |
      | test      | h             | Perez    | testhperez | oscar@conexia.com | oscar@conexia.com | 3225226361 | 3225226361 | changeme  | changeme        | yes    |
      | test      | h             | Perez    | testhperez | oscar@conexia.com | oscar@conexia.com | 3225226361 | 3225226361 | testuser2 | testuser2       | yes    |
      | test      | h             | Perez    | testhperez | oscar@conexia.com | oscar@conexia.com | 3225226361 | 3225226361 | test      | test            | yes    |

  @TestCaseBR1Scenario8
  Scenario: Verify the Portal validates the Password and the Password confirmation field to match
    When Open the link Sign up on login page
    And diligence the form with existing user
      | firstName | middleInitial | lastName  | userName    | email              | confirmEmail       | telephone  | mobile     | password       | confirmPassword | active |
      | Pablo     | E             | Contreras | pecontreras | pabloe@conexia.com | pabloe@conexia.com | 3225226361 | 3225226361 | Colombia2023.* | Colombia2022.*  | yes    |
    Then The portal is shows alert with the error message 1 = The password and the password confirmation must match.

  @TestCaseBR1Scenario9
  Scenario: Verify the Portal displays the “Terms and Policies” text in a pop-up screen when The Portal User selects the Terms and Policies link.
    When Open the link Sign up on login page
    Then Display the window of Sign up and Verify the Portal displays the “Terms and Policies” text in a pop-up screen when The Portal User selects the Terms and Policies link.

  @TestCaseBR1Scenario10
  Scenario: Verify the User Management Application restricts the Portal User from submitting the User Registration Form when the Terms and Policies checkbox is not selected.
    When Open the link Sign up on login page
    And diligence the form with existing user
      | firstName | middleInitial | lastName  | userName   | email               | confirmEmail        | telephone  | mobile     | password       | confirmPassword | active |
      | oscar     | h             | hernandez | oaherreram | oscarhr@conexia.com | oscarhr@conexia.com | 3225226363 | 3225226363 | Colombia2020.* | Colombia2020.*  |        |
    Then The portal is shows alert with the error message 1 = Please indicate that you have read and agree the Terms and Policies.

  @TestCaseBR1Scenario11
  Scenario: Verify the User Management Application displays the required message when the Portal User account is created.
    When Open the link Sign up on login page
    And diligence the form with existing user and check email
      | firstName | middleInitial | lastName | userName | email | confirmEmail | telephone  | mobile     | password       | confirmPassword | active |
      | Carlos    | q             | cubillos |          |       |              | 3224125123 | 3224125123 | Colombia2020.* | Colombia2020.*  | yes    |
    And Account message created successfully is displayed
    Then mail delivery is validated
