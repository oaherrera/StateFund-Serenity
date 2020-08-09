@TodoBR5
Feature: br5_portal_admin_screen_user_mngmt
  I as an administrator want to access the application and validate the User Management options

  @TestCaseBR5Scenario1
  Scenario: Verify if the Admin user can perform a User search using a User Name in the Search user screen.
    Given I am authenticated in the aplication
      | userName                   | password |
      | portal-test-20@conexia.com | C0n3x1a$ |
    When looking for the user acastro00
    Then the portal must show the module the result of the user search

  @TestCaseBR5Scenario2
  Scenario: Verify if the Admin user can perform a User search using an email in the Search user screen
    Given I am authenticated in the aplication
      | userName                   | password |
      | portal-test-20@conexia.com | C0n3x1a$ |
    When looking for the mail hurtamispo@desoz.com
    Then the portal must show the module the result of the email search

  @TestCaseBR5Scenario3
  Scenario: Verify if the Portal display the existent results or partially matches after performing a search using a First Name.
    Given I am authenticated in the aplication
      | userName                   | password |
      | portal-test-20@conexia.com | C0n3x1a$ |
    When looking for the FirstName A
    Then The portal must show one or more search matches.

  @TestCaseBR5Scenario4
  Scenario: Verify if the Portal display the existent results or partially matches after performing a search using a Middle Initial field.
    Given I am authenticated in the aplication
      | userName                   | password |
      | portal-test-20@conexia.com | C0n3x1a$ |
    When looking for the middleInitial B
    Then The portal must show search matches.

  @TestCaseBR5Scenario5
  Scenario: Verify if the Portal display the existent or partially matches results after performing a search using a Last name.
    Given I am authenticated in the aplication
      | userName                   | password |
      | portal-test-20@conexia.com | C0n3x1a$ |
    When looking for the lastName B
    Then The portal must show search matches related to the last name.

  @TestCaseBR5Scenario6
  Scenario: Verify if the Portal display a "No results found" message after performing a search using "Username" field and no results are found using the search criteria
    Given I am authenticated in the aplication
      | userName                   | password |
      | portal-test-20@conexia.com | C0n3x1a$ |
    When looking for the mail no-user-found@conexia.com
    Then Display the message No records found.

  @TestCaseBR5Scenario7
  Scenario: Verify if the Portal display a "The User email is invalid. Please enter a valid email address" message after performing a search using "Email" field and no results are found using the search criteria
    Given I am authenticated in the aplication
      | userName                   | password |
      | portal-test-20@conexia.com | C0n3x1a$ |
    When looking for the mail no-user-found@@conexia.com
    Then The portal must display the informational message The User email is invalid. Please enter a valid email addres

  @TestCaseBR5Scenario8
  Scenario: Verify if the Portal display a "No Result Found" message after performing a search using "First Name","Middle initial" or "Last Name" fields and no results are found using the search criteria
    Given I am authenticated in the aplication
      | userName                   | password |
      | portal-test-20@conexia.com | C0n3x1a$ |
    When looking for the fields First Name, Middle initial or Last Name
      | firstName | middleInitial | lastName |
      | noUser    | b             | noUser   |
    Then Display the message No records found.

  @TestCaseBR5Scenario9
  Scenario: Verify if the Admin user can access to the Modify user screen after performing a search user using a Username
    Given I am authenticated in the aplication
      | userName                   | password |
      | portal-test-20@conexia.com | C0n3x1a$ |
    When looking for the user testautomat@conexia.com
    And Select the option edit of Row 1
    Then The Portal displays the Modify user screen

  @TestCaseBR5Scenario10
  Scenario: Verify if the Admin user can access to the Modify user screen after performing a search user using a email address
    Given I am authenticated in the aplication
      | userName                   | password |
      | portal-test-20@conexia.com | C0n3x1a$ |
    When looking for the mail cschottlaender@conexia.com
    And Select the option edit of Row 1
    Then The Portal displays the Modify user screen

  @TestCaseBR5Scenario11
  Scenario: Verify if the Admin user can access to the Modify user screen after performing a search user using a FirstName
    Given I am authenticated in the aplication
      | userName                   | password |
      | portal-test-20@conexia.com | C0n3x1a$ |
    When looking for the FirstName tester
    And Select the option edit of Row 1
    Then The Portal displays the Modify user screen

  @TestCaseBR5Scenario12
  Scenario: Verify if the Admin user can access to the Modify user screen after performing a search user using a middle Initial
    Given I am authenticated in the aplication
      | userName                   | password |
      | portal-test-20@conexia.com | C0n3x1a$ |
    When looking for the middleInitial A
    And Select the option edit of Row 1
    Then The Portal displays the Modify user screen

  @TestCaseBR5Scenario13
  Scenario: Verify if the Admin user can access to the Modify user screen after performing a search user using a last Name
    Given I am authenticated in the aplication
      | userName                   | password |
      | portal-test-20@conexia.com | C0n3x1a$ |
    When looking for the lastName Automation
    And Select the option edit of Row 1
    Then The Portal displays the Modify user screen

  @TestCaseBR5Scenario14
  Scenario: Verify if the Admin user can´t modify the following fields from a user: First Name, Last Name, User Name, Email, Telephone and Mobile at modify user screen
    Given I am authenticated in the aplication
      | userName                   | password |
      | portal-test-20@conexia.com | C0n3x1a$ |
    When looking for the user testautomat@conexia.com
    And Select the option edit of Row 1
    Then The fields: First Name, Last Name, User Name, Email, Telephone and Mobile are disable

  #this case is faid dont show the message "The changes have been saved"
  @TestCaseBR5Scenario15
  Scenario: Verify if the Admin user can modify the start and end dates to a user in Modify User Screen
    Given I am authenticated in the aplication
      | userName                   | password |
      | portal-test-20@conexia.com | C0n3x1a$ |
    When looking for the user testautomat@conexia.com
    And Select the option edit of Row 1
    And Edit user with Start Date 01/31/2020 and End Date 01/30/2022
    Then The Portal displays a confirmation message: The changes have been saved

  #this case is faid dont show the message "The changes have been saved"
  @TestCaseBR5Scenario16
  Scenario: Verify if the Admin user can modify the access level related to a User in Modify User Screen
    Given I am authenticated in the aplication
      | userName                   | password |
      | portal-test-20@conexia.com | C0n3x1a$ |
    When looking for the user testautomat@conexia.com
    And Select the option edit of Row 1
    And Edit user access Level USER_PORTAL_LEVEL_1
    Then The Portal displays a confirmation message: The changes have been saved

  #this case is faid dont show the message "The changes have been saved"
  @TestCaseBR5Scenario17
  Scenario: Verify if the Admin user can modify the workplaces related to a User in Modify User Screen
    Given I am authenticated in the aplication
      | userName                   | password |
      | portal-test-20@conexia.com | C0n3x1a$ |
    When looking for the user testautomat@conexia.com
    And Select the option edit of Row 1
    And Edit user the workplaces Workplacea
    Then The Portal displays a confirmation message: The changes have been saved

  #this case is faid dont show the message "The changes have been saved"
  @TestCaseBR5Scenario18
  Scenario: Verify if the Admin user can modify the Physicians related to a User in Modify User Screen
    Given I am authenticated in the aplication
      | userName                   | password |
      | portal-test-20@conexia.com | C0n3x1a$ |
    When looking for the user testautomat@conexia.com
    And Select the option edit of Row 1
    And Edit user the Physicians related to a User with Physician DANWKT LIN L.Q.
    Then The Portal displays a confirmation message: The changes have been saved

  #this case is faid dont show the message "The changes have been saved"
  @TestCaseBR5Scenario19
  Scenario: Verify if the Admin user can modify the active mark for a user to activate it in Modify User Screen
    Given I am authenticated in the aplication
      | userName                   | password |
      | portal-test-20@conexia.com | C0n3x1a$ |
    When looking for the user testautomat@conexia.com
    And Select the option edit of Row 1
    And Edit user the Active mark
    Then The Portal displays a confirmation message: The changes have been saved

  #this case is faid dont show the message "The changes have been saved"
  @TestCaseBR5Scenario20
  Scenario: Verify if the Admin user can modify the active mark for a user to inactivate it in Modify User Screen
    Given I am authenticated in the aplication
      | userName                   | password |
      | portal-test-20@conexia.com | C0n3x1a$ |
    When looking for the user testautomat@conexia.com
    And Select the option edit of Row 1
    And Edit user the Active mark
    Then The Portal displays a confirmation message: The changes have been saved

  @TestCaseBR5Scenario21
  Scenario: Verify if the Admin user can exit the Modify user screen without saving the changes in Modify User screen
    Given I am authenticated in the aplication
      | userName                   | password |
      | portal-test-20@conexia.com | C0n3x1a$ |
    When looking for the user testautomat@conexia.com
    And Select the option edit of Row 1
    And Cancel Edit user
    Then The portal must show search matches related to the last name.

  @TestCaseBR5Scenario22
  Scenario: Verify if the portal validate all the mandatory fields when a user is modified
    Given I am authenticated in the aplication
      | userName                   | password |
      | portal-test-20@conexia.com | C0n3x1a$ |
    When looking for the user testautomat@conexia.com
    And Select the option edit of Row 1
    And Clear mandatory fields in edit form
    Then The portal displays an alert message: This field is required at edit user

  # pendiente la parte de creación del correo automaticamente puede ser userDDMMAAAAHHMM@gmail.com
  @TestCaseBR5Scenario23
  Scenario: Verify if the portal allows to the Admin user to Create a new user using all the mandatory fields completed: First Name, Last Name, User Name, Email, Telephone, Start date, End Date, Workplace, Access level, Physicians, Active.
    Given I am authenticated in the aplication
      | userName                   | password |
      | portal-test-20@conexia.com | C0n3x1a$ |
    When Access to create new user module
    And Admin User fills all the form the information
      | firstName | middleInitial | lastName | user              | emailAddress                | telephone  | mobile     | startDate | endDate    | accessLevel          | workplaces | physicians      | active |
      | Jhon      | D             | Perez    | testSF12022001317 | testSF12022001317@gmail.com | 3112532511 | 3115256333 | now       | 06/30/2050 | USER_PORTAL_LEVEL_2B | Workplacea | DANWKT LIN L.Q. | yes    |
    Then The Portal displays the message: The changes have been saved.

  @TestCaseBR5Scenario24
  Scenario: Verify if the portal restricst to the Admin user to Create a new user without all the mandatory fields completed: First Name, Last Name, User Name, Email, Telephone, Start date, End Date, Workplace, Access level, Physicians, Active.
    Given I am authenticated in the aplication
      | userName                   | password |
      | portal-test-20@conexia.com | C0n3x1a$ |
    When Access to create new user module
    And Selects the Save button to confirm the transaction
    Then The portal displays an alert message: This field is required, at new user

  @TestCaseBR5Scenario25
  Scenario: Verify if the portal restricst to the Admin user to Create a new user and set an start date earlier than current created date
    Given I am authenticated in the aplication
      | userName                   | password |
      | portal-test-20@conexia.com | C0n3x1a$ |
    When Access to create new user module
    And Admin User fills all the form the information
      | firstName | middleInitial | lastName | user           | emailAddress             | telephone  | mobile     | startDate  | endDate    | accessLevel          | workplaces | physicians      | active |
      | Jhon      | D             | Perez    | validatefields | validatefields@gmail.com | 3112532511 | 3115256333 | 02/04/2000 | 06/30/2050 | USER_PORTAL_LEVEL_2B | Workplacea | DANWKT LIN L.Q. | yes    |
    Then The Portal highligths start date field with the message: The start Date cannot be earlier than today

  @TestCaseBR5Scenario26
  Scenario: Verify if the portal restricst to the Admin user to Create a new user and set an end date earlier than Start Date
    Given I am authenticated in the aplication
      | userName                   | password |
      | portal-test-20@conexia.com | C0n3x1a$ |
    When Access to create new user module
    And Admin User fills all the form the information
      | firstName | middleInitial | lastName | user           | emailAddress             | telephone  | mobile     | startDate | endDate    | accessLevel          | workplaces | physicians      | active |
      | Jhon      | D             | Perez    | validatefields | validatefields@gmail.com | 3112532511 | 3115256333 | now       | 06/30/2000 | USER_PORTAL_LEVEL_2B | Workplacea | DANWKT LIN L.Q. | yes    |
    Then The Portal highligths end date field with the message: The End Date must be: Greater or equal than the Actual Date / Greater or equal than the Start Date

  @TestCaseBR5Scenario27
  Scenario: Verify if the portal restricts to the Admin user to Create a new user using a username that already exists on the portal
    Given I am authenticated in the aplication
      | userName                   | password |
      | portal-test-20@conexia.com | C0n3x1a$ |
    When Access to create new user module
    And Admin User fills all the form the information
      | firstName | middleInitial | lastName | user                       | emailAddress             | telephone  | mobile     | startDate | endDate    | accessLevel          | workplaces | physicians      | active |
      | Jhon      | D             | Perez    | portal-test-20@conexia.com | validatefields@gmail.com | 3112532511 | 3115256333 | now       | 06/30/2100 | USER_PORTAL_LEVEL_2B | Workplacea | DANWKT LIN L.Q. | yes    |
    Then The Portal highligths username field with the message: The Username is not available. Please enter another Username.

  @TestCaseBR5Scenario28
  Scenario: Verify if the portal restricts to the Admin user to Create a new user that does not have an access level assigned
    Given I am authenticated in the aplication
      | userName                   | password |
      | portal-test-20@conexia.com | C0n3x1a$ |
    When Access to create new user module
    And Admin User fills all the form the information
      | firstName | middleInitial | lastName | user           | emailAddress             | telephone  | mobile     | startDate | endDate    | accessLevel | workplaces | physicians      | active |
      | Jhon      | D             | Perez    | validatefields | validatefields@gmail.com | 3112532511 | 3115256333 | now       | 06/30/2100 |             | Workplacea | DANWKT LIN L.Q. | yes    |
    Then The Portal highligths access level field with the message: This field is required

  ##tener presente para cambio de nuevo usuario y correo
  @TestCaseBR5Scenario29
  Scenario: Verify if the portal allows to the Admin user to Create a new user without fill the optional fields: Middle Initial, Mobile
    Given I am authenticated in the aplication
      | userName                   | password |
      | portal-test-20@conexia.com | C0n3x1a$ |
    When Access to create new user module
    And Admin User fills all the form the information
      | firstName | middleInitial | lastName | user             | emailAddress               | telephone  | mobile | startDate | endDate    | accessLevel          | workplaces | physicians      | active |
      | Jhon      |               | Perez    | testSF1102201317 | testSF1102201317@gmail.com | 3112532511 |        | now       | 06/30/2050 | USER_PORTAL_LEVEL_2B | Workplacea | DANWKT LIN L.Q. | yes    |
    Then The Portal displays the message: The changes have been saved.

  @TestCaseBR5Scenario30
  Scenario: Verify if the portal restricts to the Admin user to Create a new user that does not have a workplace assigned
    Given I am authenticated in the aplication
      | userName                   | password |
      | portal-test-20@conexia.com | C0n3x1a$ |
    When Access to create new user module
    And Admin User fills all the form the information
      | firstName | middleInitial | lastName | user           | emailAddress             | telephone  | mobile     | startDate | endDate    | accessLevel          | workplaces | physicians      | active |
      | Jhon      | D             | Perez    | validatefields | validatefields@gmail.com | 3112532511 | 3115256333 | now       | 06/30/2100 | USER_PORTAL_LEVEL_2B |            | DANWKT LIN L.Q. | yes    |
    Then The Portal highligths workplace field with the message: This field is required

  #this case is not possible
  #@TestCaseBR5Scenario31
  #Scenario: Verify if the portal does not sends an Email to the New User's email address when an error is displayed on the creation process.
  #this case is pending
  @TestCaseBR5Scenario32
  Scenario: Verify if the portal sends an Email to the New User's email address with the Portal User information (link to access) when it's successfully created.
    Given I am authenticated in the aplication
      | userName                   | password |
      | portal-test-20@conexia.com | C00n3x1a$ |
    Then The portal must display the informational message taking into account the search criteria.

  @TestCaseBR5Scenario33
  Scenario: Verify if the portal restricts to the Admin user to Create a new user that does not have a Physician assigned
    Given I am authenticated in the aplication
      | userName                   | password |
      | portal-test-20@conexia.com | C0n3x1a$ |
    When Access to create new user module
    And Admin User fills all the form the information
      | firstName | middleInitial | lastName | user           | emailAddress             | telephone  | mobile     | startDate | endDate    | accessLevel          | workplaces | physicians | active |
      | Jhon      | D             | Perez    | validatefields | validatefields@gmail.com | 3112532511 | 3115256333 | now       | 06/30/2100 | USER_PORTAL_LEVEL_2B | Workplacea |            | yes    |
    Then The Portal highligths physician field with the message: This field is required

  @TestCaseBR5Scenario34
  Scenario: Verify if the portal allow to the admin user to cancel the creation of the user whitout saving the changes
    Given I am authenticated in the aplication
      | userName                   | password |
      | portal-test-20@conexia.com | C0n3x1a$ |
    When Access to create new user module
    And Admin User fills all the form the information and Cancel process
      | firstName | middleInitial | lastName | user           | emailAddress             | telephone  | mobile     | startDate | endDate    | accessLevel          | workplaces | physicians      | active |
      | Jhon      | D             | Perez    | validateCancel | validateCancel@gmail.com | 3112532511 | 3115256333 | now       | 06/30/2100 | USER_PORTAL_LEVEL_2B | Workplacea | DANWKT LIN L.Q. | yes    |
    Then The Portal must redirect to the Create User Page

  #pendiente realizar y validar no se encuentra funcionalidad para hacer request for permission
  @TestCaseBR5Scenario35
  Scenario: Verify if the portal allows to the admin user to receive notifications when a portal user request for permission
    Given I am authenticated in the aplication
      | userName                   | password |
      | portal-test-20@conexia.com | C0n3x1a$ |
    Then The portal must display the informational message taking into account the search criteria.

  #pendiente realizar y validar no se encuentra funcionalidad para hacer request for permission
  @TestCaseBR5Scenario36
  Scenario: Verify if the portal allow to the admin user to vizualize the grid with all the pending request access in Inbox Screen
    Given I am authenticated in the aplication
      | userName                   | password |
      | portal-test-20@conexia.com | C0n3x1a$ |
    Then The portal must display the informational message taking into account the search criteria.

  #pendiente realizar y validar no se encuentra funcionalidad para hacer request for permission
  @TestCaseBR5Scenario37
  Scenario: Verify if the portal allow to the admin user to delete a single notification in the admin inbox screen
    Given I am authenticated in the aplication
      | userName                   | password |
      | portal-test-20@conexia.com | C0n3x1a$ |
    Then The portal must display the informational message taking into account the search criteria.

  #pendiente realizar y validar no se encuentra funcionalidad para hacer request for permission
  @TestCaseBR5Scenario38
  Scenario: Verify if the portal allow to the admin user to delete more than one single notification in the admin inbox screen
    Given I am authenticated in the aplication
      | userName                   | password |
      | portal-test-20@conexia.com | C0n3x1a$ |
    Then The portal must display the informational message taking into account the search criteria.

  #pendiente realizar y validar no se encuentra funcionalidad para hacer request for permission
  @TestCaseBR5Scenario39
  Scenario: Verify if the portal allow to the admin user to edit a notification in the admin inbox screen
    Given I am authenticated in the aplication
      | userName                   | password |
      | portal-test-20@conexia.com | C0n3x1a$ |
    Then The portal must display the informational message taking into account the search criteria.

  #pendiente realizar y validar no se encuentra funcionalidad para hacer request for permission
  @TestCaseBR5Scenario40
  Scenario: Verify if the portal restrict to the admin user to edit more than one notification at the same time in the admin inbox screen
    Given I am authenticated in the aplication
      | userName                   | password |
      | portal-test-20@conexia.com | C0n3x1a$ |
    Then The portal must display the informational message taking into account the search criteria.

  #pendiente realizar y validar no se encuentra funcionalidad para hacer request for permission
  @TestCaseBR5Scenario41
  Scenario: Verify if the portal allow to the admin user to see the deleted notifications
    Given I am authenticated in the aplication
      | userName                   | password |
      | portal-test-20@conexia.com | C0n3x1a$ |
    Then The portal must display the informational message taking into account the search criteria.

  #Caso fallido el admin tiene mas de un provider asignado
  @TestCaseBR5Scenario42
  Scenario: Verify if the portal restrict to the admin user to belonging to more than one Provider Agency
    Given I am authenticated in the aplication
      | userName                   | password |
      | portal-test-20@conexia.com | C0n3x1a$ |
    When looking for the mail portal-test-20@conexia.com
    And Select the option edit of Row 1
    Then Displays the Portal users portal-test-20@conexia.com founded with the same assigned provider IDs

  @TestCaseBR5Scenario43
  Scenario: Verify if the portal restric to the admin user the actions based the associated Workplace
    Given I am authenticated in the aplication
      | userName                   | password |
      | portal-test-20@conexia.com | C0n3x1a$ |
    When looking for the user Workplacea
    Then Display the message No records found.

  #Caso fallido no permite ingresar a editar permiso
  @TestCaseBR5Scenario44
  Scenario: Verify if the portal allow to the admin user to assigned access rigths to a portal user
    Given I am authenticated in the aplication
      | userName                   | password |
      | portal-test-20@conexia.com | C0n3x1a$ |
    Then The portal must display the informational message taking into account the search criteria.

  @TestCaseBR5Scenario45
  Scenario: Verify if the portal restrict to the admin user to edit ourselves access rigths
    Given I am authenticated in the aplication
      | userName                   | password |
      | portal-test-20@conexia.com | C0n3x1a$ |
    When looking for the mail portal-test-20@conexia.com
    And Select the option edit of Row 1
    Then The fields: Acces Level, Workplace, Physcian, Active and Dates are disable

  @TestCaseBR5Scenario46
  Scenario: Verify if the portal allow to the admin user to remove access rigths to a portal user
    Given I am authenticated in the aplication
      | userName                   | password |
      | portal-test-20@conexia.com | C0n3x1a$ |
    Then The portal must display the informational message taking into account the search criteria.
