package com.conexia.qa.statefund.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;

public class CreateNewUserPage {

	private CreateNewUserPage() {
	}

	public static final Target USER_MANAGEMENT = Target.the("User management")
			.locatedBy("//label[contains(text(),' User management')]");
	public static final Target CREATE_NEW_USER = Target.the("Create new User")
			.locatedBy("//a[normalize-space(.)='Create new user']");
	public static final Target FIRST_NAME = Target.the("First Name")
			.locatedBy("//input[contains(@id,'inputFirstNameId')]");
	public static final Target MIDDLE_INITIAL = Target.the("Middle Initial")
			.locatedBy("//input[contains(@id,'inputMiddleNameId')]");
	public static final Target LAST_NAME = Target.the("Last Name")
			.locatedBy("//input[contains(@id,'inputLastNameId')]");
	public static final Target USER_NAME = Target.the("User Name")
			.locatedBy("//input[contains(@id,'inputUsernameId')]");
	public static final Target EMAIL_ADDRESS = Target.the("Email Address")
			.locatedBy("//input[contains(@id,'inputEmailId')]");
	public static final Target TELEPHONE = Target.the("Telephone")
			.locatedBy("//input[contains(@id,'inputTelephoneId')]");
	public static final Target MOBILE = Target.the("Mobile").locatedBy("//input[contains(@id,'inputMobileId')]");
	public static final Target START_DATE = Target.the("Start Date")
			.locatedBy("//input[contains(@id,'inputStartDateId_input')]");
	public static final Target END_DATE = Target.the("End Date")
			.locatedBy("//input[contains(@id,'inputEndDateId_input')]");
	public static final Target ACCESS_LEVEL_LIST = Target.the("Access Level")
			.locatedBy("//*[@id='formCreateUserId:seccionCreateUserId:selectAccessLevelId_label']");
	public static final Target ACCESS_LEVEL = Target.the("Access Level {0}")
			.locatedBy("//*[@id='formCreateUserId:seccionCreateUserId:selectAccessLevelId_items']/li[text()='{0}']");
	public static final Target WORKPLACES_LIST = Target.the("Workplaces")
			.locatedBy("//*[@id='formCreateUserId:seccionCreateUserId:selectWorkplaceId']/ul");
	public static final Target WORKPLACES = Target.the("Workplaces {0}").locatedBy(
			"//*[@id='formCreateUserId:seccionCreateUserId:selectWorkplaceId_panel']//ul/li[normalize-space(.)='{0}']");
	public static final Target PHYSICIANS_LIST = Target.the("Physicians")
			.locatedBy("//*[@id='formCreateUserId:seccionCreateUserId:selectPhysicianId']/ul");
	public static final Target PHYSICIANS = Target.the("Physicians {0}").locatedBy(
			"//*[@id='formCreateUserId:seccionCreateUserId:selectPhysicianId_panel']//ul/li[normalize-space(.)='{0}']");
	public static final Target ACTIVE = Target.the("Active").locatedBy(
			"//*[@id=\"formCreateUserId:seccionCreateUserId:checkboxActiveId\"]//div[contains(@class, 'ui-chkbox-box')]");
	public static final Target SAVE = Target.the("Save").locatedBy("//span[.='Save']/ancestor-or-self::button");

	public static final Target TITTLE = Target.the("Create User").locatedBy("//h1[text()='Create User']");
	public static final Target USERNAME = Target.the("Username").locatedBy("//input[@placeholder='Username']");
	public static final Target E_MAIL_ADRESS = Target.the("E-mail Address")
			.locatedBy("//input[@placeholder='E-mail Address']");
	public static final Target STAR_DATE = Target.the("End Date")
			.locatedBy("//input[contains(@id,'inputStartDateId')]");
	public static final Target ACCES_LEVEL = Target.the("Acces level")
			.locatedBy("//label[contains(@id,'selectAccessLevelId_label')]");
	public static final Target ACCES_LEVEL_OPTION = Target.the("Acces level {0}")
			.locatedBy("//li[contains(text(),'{0}')]");
	public static final Target WORKPLACES_OPTIONS = Target.the("{0}")
			.locatedBy("//div[contains(@id,'selectWorkplaceId_panel')]//label[.='{0}']");
	public static final Target PHYSICIANS_OPTIONS = Target.the("{0}")
			.locatedBy("//div[contains(@id,'selectPhysicianId_panel')]//label[.='{0}']");

	public static final Target MESSAGE_USER_CREATED = Target.the("Message {0}")
			.locatedBy("//div[contains(@id,'dialogCreateSuccessConfirmReturnId_content')]//label[.='{0}']");

	public static final Target FIRST_NAME_MSG_ERROR = Target.the("First name {0}")
			.locatedBy("//div[contains(@id,'msginputFirstNameId')]/span[.='{0}']");
	public static final Target LAST_NAME_MSG_ERROR = Target.the("Last name {0}")
			.locatedBy("//div[contains(@id,'msginputLastnameId')]/span[.='{0}']");
	public static final Target EMAIL_ADDRESS_MSG_ERROR = Target.the("Email Adress {0}")
			.locatedBy("//div[contains(@id,'msginputEmailId')]/span[.='{0}']");
	public static final Target USERNAME_MSG_ERROR = Target.the("Username {0}")
			.locatedBy("//div[contains(@id,'inputUserMsg')]/span[.='{0}']");
	public static final Target TELEPHONE_MSG_ERROR = Target.the("Telephone {0}")
			.locatedBy("//div[contains(@id,'msginputTelephoneId')]/span[.='{0}']");
	public static final Target START_DATE_MSG_ERROR = Target.the("Strart Date {0}")
			.locatedBy("//div[contains(@id,'msginputStartDateId')]/span[.='{0}']");
	public static final Target END_DATE_MSG_ERROR = Target.the("End Date {0}")
			.locatedBy("//div[contains(@id,'msginputEndDateId')]/span[.='{0}']");
	public static final Target ACCESS_LEVEL_MSG_ERROR = Target.the("Access Level {0}")
			.locatedBy("//div[contains(@id,'msgselectAccessLevelId')]/span[.='{0}']");
	public static final Target WORKPLACES_MSG_ERROR = Target.the("Workplaces {0}")
			.locatedBy("//div[contains(@id,'msgselectWorkplaceId')]/span[.='{0}']");
	public static final Target PHYSICIANS_MSG_ERROR = Target.the("Physicians {0}")
			.locatedBy("//div[contains(@id,'msgsselectPhysicianId')]/span[.='{0}']");

}