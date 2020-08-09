@TodoBR7
Feature: br7_home_screen
  I as a user wish to observe the graphic environment of the portal

  @TestCaseBR7Scenario1
  Scenario: Verify the Portal displays the Home Screen after the Portal User logs in.
    Given I am authenticated in the aplication
      | userName                  | password |
      | portal-test-4@conexia.com | C0n3x1a$ |
    Then The portal should display the home screen

  @TestCaseBR7Scenario2
  Scenario: Verify if the Portal displays the Header Section at the top of the Home Screen and a Menu section at the left of the screen
    Given I am authenticated in the aplication
      | userName                  | password |
      | portal-test-4@conexia.com | C0n3x1a$ |
    Then The portal should show the header session

  @TestCaseBR7Scenario3
  Scenario: Verify the Portal displays the State Fund logo on the left side of the Header Section
    Given I am authenticated in the aplication
      | userName                  | password |
      | portal-test-4@conexia.com | C0n3x1a$ |
    Then The portal must show the state logo

  @TestCaseBR7Scenario4
  Scenario: Verify the Portal displays the Portal User’s First Name and Last Name in the Header section as a hyperlink
    Given I am authenticated in the aplication
      | userName                  | password |
      | portal-test-4@conexia.com | C0n3x1a$ |
    Then The portal must show the first and last name

  @TestCaseBR7Scenario5
  Scenario: Verify if the Portal displays all the Workplaces assigned to the Portal User in the Workplace dropdown at the Header Section
    Given I am authenticated in the aplication
      | userName                  | password |
      | portal-test-4@conexia.com | C0n3x1a$ |
    Then The portal must show job names

  @TestCaseBR7Scenario7
  Scenario: Verify if the Portal displays all the Physicians assigned to the Portal User in the Physician dropdown at the Header Section.
    Given I am authenticated in the aplication
      | userName                  | password |
      | portal-test-4@conexia.com | C0n3x1a$ |
    Then The portal shows the doctors ALAR GROHH  SL assigned in the drop-down menu

  @TestCaseBR7Scenario8
  Scenario: Verify if the Portal User is able to select the Physician in the Header Screen
    Given I am authenticated in the aplication
      | userName                  | password |
      | portal-test-4@conexia.com | C0n3x1a$ |
    Then The user can select the doctor ALAR GROHH  SL

  @TestCaseBR7Scenario9
  Scenario: Verify if the Portal displays the Local Date and Time at the Header Section
    Given I am authenticated in the aplication
      | userName                  | password |
      | portal-test-4@conexia.com | C0n3x1a$ |
    Then The portal shows the time and date in the header

  @TestCaseBR7Scenario10
  Scenario: Check if the Portal shows the notification and alert icon in a visual alert
    Given I am authenticated in the aplication
      | userName                  | password |
      | portal-test-4@conexia.com | C0n3x1a$ |
    Then The portal shows the visual alert

  #Pendiente buscar la forma de actualizar el expiration password en la bd
  @TestCaseBR7Scenario11
  Scenario: Verify if the Portal displays a Password Expiration notification
    Given I am authenticated in the aplication
      | userName                  | password |
      | portal-test-4@conexia.com | C0n3x1a$ |
    Then The Portal displays a Password Expiration notification

  @TestCaseBR7Scenario12
  Scenario: Verify that the Portal shows an Authorization notification when there is a change in the authorization status and displays the message "Authorization notification"
    Given I am authenticated in the aplication
      | userName                  | password |
      | portal-test-4@conexia.com | C0n3x1a$ |
    And Go to notifications for user portal-test-4@conexia.com
    Then The Portal displays the message Description Notification: You have an Update for Claim Number/RFA Number Claim Number

  @TestCaseBR7Scenario13
  Scenario: Verify the Portal displays the Logout button in the Header section.
    Given I am authenticated in the aplication
      | userName                  | password |
      | portal-test-4@conexia.com | C0n3x1a$ |
    Then The portal shows the close assignment button

  @TestCaseBR7Scenario14
  Scenario Outline: Verify the Portal displays on the Portal Menu the Portal Modules assigned by the Portal User Access Levels
    Given I am authenticated in the aplication
      | userName   | password   |
      | <userName> | <password> |
    Then The Portal displays the modules <modules>

    Examples: 
      | userName                   | password | modules              |
      | portal-test-1@conexia.com  | C0n3x1a$ | Home                 |
      | portal-test-2a@conexia.com | C0n3x1a$ | Home,Claim           |
      | portal-test-2b@conexia.com | C0n3x1a$ | Home,Claim           |
      | portal-test-4@conexia.com  | C0n3x1a$ | Home,Claim           |
      | portal-test-20@conexia.com | C0n3x1a$ | Home,User management |

  @TestCaseBR7Scenario15And16
  Scenario: Verify that the Portal has default access to the home screen module for the Portal User when logging into the Portal
    Given I am authenticated in the aplication
      | userName                  | password |
      | portal-test-4@conexia.com | C0n3x1a$ |
    Then The Portal displays the Home screen module

  @TestCaseBR7Scenario17
  Scenario: Verify if the Portal displays the Carrousel News Slider
    Given I am authenticated in the aplication
      | userName                  | password |
      | portal-test-4@conexia.com | C0n3x1a$ |
    Then The Portal displays the image in the Carrousel News Slider

  @TestCaseBR7Scenario18
  Scenario: Verify if the Portal displays the Footer message “© Copyright 2019 Conexia /| All rights reserved” in the Footer Section at the bottom part of the Home Screen
    Given I am authenticated in the aplication
      | userName                  | password |
      | portal-test-4@conexia.com | C0n3x1a$ |
    Then The Portal displays the message for Copyright
