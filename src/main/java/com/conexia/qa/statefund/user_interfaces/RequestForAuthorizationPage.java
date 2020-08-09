package com.conexia.qa.statefund.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;

public class RequestForAuthorizationPage {

	private RequestForAuthorizationPage() {
	}

	public static final Target CLAIM_NUMBER = Target.the("Claim Number {0}")
			.locatedBy("//h1[contains(text(),'Request for Authorization - Claim Number: {0}')]");
	public static final Target CLAIM_NUMBER_UNDEFINED = Target.the("Claim Number")
			.locatedBy("//h1[contains(text(),'Request for Authorization - Claim Number: ')]");

}