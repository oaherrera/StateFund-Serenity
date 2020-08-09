package com.conexia.qa.statefund.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;

public class SignUpPage {

	private SignUpPage() {
	}

	public static final Target LABEL_CREATE_YOUR_ACCOUNT = Target.the("Create your account")
			.locatedBy("//h1[.='Create your account']");
	public static final Target FIRST_NAME = Target.the("First Name")
			.locatedBy("//input[@id='form:rioSeccionCreateUser:name']");
	public static final Target MIDDLE_INITIAL = Target.the("Middle Initial")
			.locatedBy("//input[@id='form:rioSeccionCreateUser:middleName']");
	public static final Target LAST_NAME = Target.the("Last Name")
			.locatedBy("//input[@id='form:rioSeccionCreateUser:userLastName']");
	public static final Target USERNAME = Target.the("Username")
			.locatedBy("//input[@id='form:rioSeccionCreateUser:userName']");
	public static final Target EMAIL = Target.the("Email")
			.locatedBy("//input[@id='form:rioSeccionCreateUser:userEmail']");
	public static final Target CONFIRM_EMAIL = Target.the("Confirm Email")
			.locatedBy("//input[@id='form:rioSeccionCreateUser:userConfirmEmail']");
	public static final Target TELEPHONE = Target.the("Telephone")
			.locatedBy("//input[@id='form:rioSeccionCreateUser:userTelephone']");
	public static final Target MOBILE = Target.the("Mobile")
			.locatedBy("//input[@id='form:rioSeccionCreateUser:userMobile']");
	public static final Target PASSWORD = Target.the("Password")
			.locatedBy("//input[@id='form:rioSeccionCreateUser:userPassword']");
	public static final Target CONFIRM_PASSWORD = Target.the("Confirm Password")
			.locatedBy("//input[@id='form:rioSeccionCreateUser:userConfirmPassword']");
	public static final Target TERMS_AND_POLICIES = Target.the("Terms and Policies")
			.locatedBy("//div[@id='form:rioSeccionCreateUser:termsAndPolicies']");
	public static final Target BUTTON_CONFIRM = Target.the("Button Confirm")
			.locatedBy("//span[contains(text(),'Confirm')]/ancestor::button");
	public static final Target ACTIVE_CHECKBOX = Target.the("Active Checkbox")
			.locatedBy("//div[contains(@id,'form:rioSeccionCreateUser:termsAndPolicies')]");
	public static final Target BACK_TO_LOGIN = Target.the("Tittle Login").locatedBy(
			"//div[contains(@class,'Container100 Responsive100')]//a[@id='form:rioSeccionCreateUser:backToLogin']");
	public static final Target TITTLE_LOGIN = Target.the("Back to Login").locatedBy("//h1[contains(text(),'Login')]");
	public static final Target TERMS_AND_POLICIES_LINK = Target.the("Terms and policies Link")
			.locatedBy("//a[@id='form:rioSeccionCreateUser:termsAndPoliciesPopUp']");
	public static final Target TERMS_AND_POLICIES_TITTLE = Target.the("Terms and policies Tittle")
			.locatedBy("//span[@id='form:j_idt100_title']");
	public static final Target ACCOUNT_CREATED_SUCCESSFULLY = Target.the("Account created successfully")
			.locatedBy("//label[contains(@id,'form:userCreated')]");

}