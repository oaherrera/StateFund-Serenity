package com.conexia.qa.statefund.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;

public class ForgotPasswordPage {

	private ForgotPasswordPage() {
	}

	public static final Target TITLE_FORGOT_PASSWORD = Target.the("Forgot Password")
			.locatedBy("//h1[.='Forgot Password']");
	public static final Target EMAIL_ADDRESS = Target.the("Email address")
			.locatedBy("//*[@id='form:seccionRio:email']");
	public static final Target MESSAGE_OF_REQUEST = Target.the("Message of request")
			.locatedBy("//label[contains(@id,'form:seccionRioEmailSent')]");
	public static final Target BACK_TO_LOGIN_BUTTON = Target.the("Back to Login button")
			.locatedBy("//*[@id='form:seccionRioEmailSent:backToLoginButton']");
	public static final Target BACK_TO_LOGIN_LINK = Target.the("Back to Login link")
			.locatedBy("//*[@id='form:seccionRio:backToLoginLink']");
	public static final Target CHECK_TERMS_AND_POLICIES = Target.the("I Accept Terms and Policies")
			.locatedBy("//input[@type='checkbox']/ancestor::div[1]/following-sibling::div");
	public static final Target LINK_TERMS_AND_POLICIES = Target.the("Terms and policies Link")
			.locatedBy("//a[.=' Terms and Policies']");
	public static final Target POP_UP_TERMS_AND_POLICIES = Target.the("Terms and Policies popup")
			.locatedBy("//div[@role='dialog' and @aria-hidden='false' and @style!='display: none;']");

}