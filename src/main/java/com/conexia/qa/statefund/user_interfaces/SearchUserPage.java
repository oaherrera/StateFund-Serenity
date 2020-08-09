package com.conexia.qa.statefund.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;

public class SearchUserPage {

	private SearchUserPage() {
	}

	public static final Target TITTLE = Target.the("User Search").locatedBy("//h1[text()='User Search']");
	public static final Target USERNAME = Target.the("Username").locatedBy("//input[@placeholder='Username']");
	public static final Target EMAIL = Target.the("E-mail").locatedBy("//input[@placeholder='E-mail']");
	public static final Target FIRST_NAME = Target.the("First Name").locatedBy("//input[@placeholder='First Name']");
	public static final Target MIDDLE_INITIAL = Target.the("Middle Initial")
			.locatedBy("//input[@placeholder='Middle Initial']");
	public static final Target LAST_NAME = Target.the("Last Name").locatedBy("//input[@placeholder='Last Name']");
	public static final Target EDIT_NAME = Target.the("Edit Name").locatedBy("(//span[contains(text(),'Edit')])[1]");
	public static final Target SEARCH = Target.the("Search")
			.locatedBy("//button[@id='formUserSearch:seccionUserSearch:buttonSearchUsers']");
	public static final Target USER_RESULT = Target.the("User Result")
			.locatedBy("//tbody[contains(@id,'formUserSearch')]/tr[1]/td[1]/span");
	public static final Target EMAIL_RESULT = Target.the("Email Result")
			.locatedBy("//*[contains(@id,':usersTable_data')]/tr[1]/td[5]/span");
	public static final Target FIRSTNAME_RESULT = Target.the("Email Result")
			.locatedBy("//*[contains(@id,':usersTable_data')]/tr[1]/td[2]/span");
	public static final Target MIDDLE_INITIAL_RESULT = Target.the("LastName Result")
			.locatedBy("//*[contains(@id,':usersTable_data')]/tr[1]/td[3]/span");
	public static final Target LASTNAME_RESULT = Target.the("LastName Result")
			.locatedBy("//*[contains(@id,':usersTable_data')]/tr[1]/td[4]/span");

	public static final Target MESSAGE_EMAIL_INVALID = Target.the("Message valid email address")
			.locatedBy("//div[contains(@id,'userSearchEmailIdmsg')]/span[.='Please enter a valid email address']");

}