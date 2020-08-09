package com.conexia.qa.statefund.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;

public class BillingDentistOrDentalEntityPage {

	private BillingDentistOrDentalEntityPage() {
	}

	public static final Target TITTLE = Target.the("Billing Dentist or Dental Entity")
			.locatedBy("//h1[.='Billing Dentist or Dental Entity']");
	public static final Target DENTIST_NAME = Target.the("Dentist Name")
			.locatedBy("//input[contains(@id,'dentistName')]");
	public static final Target ADDRESS_ONE = Target.the("Address 1")
			.locatedBy("//input[contains(@id,'payerAddress1')]");
	public static final Target ADDRESS_TWO = Target.the("Address 2")
			.locatedBy("//input[contains(@id,'payerAddress2')]");
	public static final Target CITY = Target.the("City").locatedBy("//input[contains(@id,'payerCity')]");
	public static final Target STATE = Target.the("State").locatedBy("//input[contains(@id,'payerState')]");
	public static final Target ZIP_CODE = Target.the("Zip Code").locatedBy("//input[contains(@id,'payerZipCode')]");
	public static final Target NPI = Target.the("NPI").locatedBy("//input[contains(@id,'npiInputDentist')]");
	public static final Target LICENSE_NUMBER = Target.the("License Number")
			.locatedBy("//input[contains(@id,'licenseNumber')]");
	public static final Target SSN_OR_TIN = Target.the("SSN or TIN").locatedBy("//input[contains(@id,'ssnOrTin')]");
	public static final Target PHONE_NUMBER = Target.the("Phone Number")
			.locatedBy("//input[contains(@id,'phoneNumber')]");
	public static final Target ADDITIONAL_PROVIDER_ID = Target.the("Additional Provider ID")
			.locatedBy("//input[contains(@id,'additionalProviderID')]");

}