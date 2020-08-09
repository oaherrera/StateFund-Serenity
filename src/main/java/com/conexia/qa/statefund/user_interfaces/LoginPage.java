package com.conexia.qa.statefund.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;

public class LoginPage {

	private LoginPage() {
	}

	public static final Target USER_NAME = Target.the("Username").locatedBy("//input[@accesskey='u']");
	public static final Target PASSWORD = Target.the("Password").locatedBy("//input[@accesskey='p']");
	public static final Target CHECK_TERMS_AND_POLICIES = Target.the("I Accept Terms and Policies")
			.locatedBy("//input[@type='checkbox']/following-sibling::label");
	public static final Target LOGIN = Target.the("Login").locatedBy("//button[text()='Login']");
	public static final Target ERROR_MESSAGE = Target.the("Error Message").locatedBy("//div[@class='error']/{0}");
	public static final Target TERMS_AND_POLICIES = Target.the("Terms and Policies")
			.locatedBy("//a[.='Terms and Policies']");
	public static final Target FORGOT_YOUR_PASSWORD = Target.the("Forgot your password?")
			.locatedBy("//a/span[.='Forgot your password?']");
	public static final Target SIGN_UP = Target.the("Sign up").locatedBy("//a[.='Sign up']");

	public static final Target POP_UP_TERMS_AND_POLICIES = Target.the("Terms and Policies")
			.locatedBy("//div[@id='modalTermsAndConditions' and @style!='display: none;']");
	public static final Target ERROR_MESSAGE_ACCESS_DENIED = Target.the("Error Message Access Denied")
			.locatedBy("//div[@class='alert alert-danger']/p");

}