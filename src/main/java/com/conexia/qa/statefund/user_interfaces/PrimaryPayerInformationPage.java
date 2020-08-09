package com.conexia.qa.statefund.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;

public class PrimaryPayerInformationPage {

	private PrimaryPayerInformationPage() {
	}

	public static final Target TITTLE = Target.the("Primary Payer Information")
			.locatedBy("//h1[.='Primary Payer Information']");
	public static final Target INSURANCE_COMPANY_NAME = Target.the("Insurance Company Name")
			.locatedBy("//input[contains(@id,'payerInsuranceCompanyName')]");
	public static final Target ADDRESS_ONE = Target.the("Address 1")
			.locatedBy("//input[contains(@id,'payerAddress1')]");
	public static final Target ADDRESS_TWO = Target.the("Address 2")
			.locatedBy("//input[contains(@id,'payerAddress2')]");
	public static final Target CITY = Target.the("City").locatedBy("//input[contains(@id,'payerCity')]");
	public static final Target STATE = Target.the("State").locatedBy("//input[contains(@id,'payerState')]");
	public static final Target ZIP_CODE = Target.the("Zip Code").locatedBy("//input[contains(@id,'payerZipCode')]");
	public static final Target PHONE_NUMBER = Target.the("Phone Number")
			.locatedBy("//input[contains(@id,'payerPhoneNumber')]");

}