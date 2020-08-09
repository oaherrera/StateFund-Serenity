package com.conexia.qa.statefund.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;

public class BillingProviderDiferentFormPayPage {

	private BillingProviderDiferentFormPayPage() {
	}

	public static final Target PAY_TO_NAME = Target.the("Pay-To Name").locatedBy("//input[contains(@id,'payToName1')]");
	public static final Target PAY_TO_ADDRESS_ONE = Target.the("Pay-To Address 1")
			.locatedBy("//input[contains(@id,'payToAddress1')]");
	public static final Target PAY_TO_ADDRESS_TWO = Target.the("Pay-To Address 2")
			.locatedBy("//input[contains(@id,'payToAddress2')]");
	public static final Target PAY_TO_CITY = Target.the("Pay-To City").locatedBy("//input[contains(@id,'payToCity1')]");
	public static final Target PAY_TO_STATE = Target.the("Pay-To State")
			.locatedBy("//input[contains(@id,'payToState1')]");
	public static final Target PAY_TO_ZIP_CODE = Target.the("Pay-To Zip Code")
			.locatedBy("//input[contains(@id,'payToZipCode1')]");
	public static final Target PAY_TO_ZIP_CODE_TWO = Target.the("Pay-To Zip Code 2")
			.locatedBy("//input[contains(@id,'payToZipCode2')]");
	public static final Target PAY_TO_ID = Target.the("Pay-To Id").locatedBy("//input[contains(@id,'payToID')]");

}