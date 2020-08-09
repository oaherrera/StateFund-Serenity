package com.conexia.qa.statefund.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;

public class ClaimAdministratorInformationPage {

	private ClaimAdministratorInformationPage() {
	}

	public static final Target CLAIM_ADMINISTRATOR_INFORMATION = Target.the("Claim Administrator Information")
			.locatedBy("//h1[text()='Claim Administrator Information']");
	public static final Target COMPANY_NAME = Target.the("Company Name")
			.locatedBy("//input[contains(@id,'companyNameI')]");
	public static final Target ADDRESS = Target.the("Address")
			.locatedBy("//div[contains(@id,'addressI') and @role='combobox']");
	public static final Target ADDRESS_OPTIONS = Target.the("Address select")
			.locatedBy("//li[contains(@id,'addressI')]");
	public static final Target ADDRESS_LABEL = Target.the("Address label")
			.locatedBy("//*[contains(@id,'addressI_label')]");
	public static final Target CITY = Target.the("City").locatedBy("//input[contains(@id,'cityI')]");
	public static final Target TELEPHONE = Target.the("Telephone").locatedBy("//input[contains(@id,'phoneI')]");
	public static final Target EMAIL_ADDRESS = Target.the("Email Address")
			.locatedBy("//input[contains(@id,'emailAddressInputText')]");
	public static final Target CONTACT_NAME = Target.the("Contact Name")
			.locatedBy("//input[contains(@id,'contactNameI')]");
	public static final Target STATE = Target.the("State").locatedBy("//input[contains(@id,'stateI')]");
	public static final Target ZIP_CODE = Target.the("Zip Code").locatedBy("//input[contains(@id,'zipCodeI')]");
	public static final Target FAX_NUMBER = Target.the("Fax Number")
			.locatedBy("//input[contains(@id,'faxNumberInputText')]");

}