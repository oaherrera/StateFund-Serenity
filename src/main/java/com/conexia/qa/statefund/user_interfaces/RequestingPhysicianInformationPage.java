package com.conexia.qa.statefund.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;

public class RequestingPhysicianInformationPage {

	private RequestingPhysicianInformationPage() {
	}

	public static final Target REQUESTING_PHYSICIAN_INFORMATION = Target.the("Requesting Physician Information")
			.locatedBy("//h1[text()='Requesting Physician Information']");
	public static final Target PHYSICIAN_NAME = Target.the("Physician Name")
			.locatedBy("//select[contains(@id,'physician')]");
	public static final Target CONTACT_NAME = Target.the("Contact name")
			.locatedBy("//input[contains(@id,'practiceNameI')]");
	public static final Target CITY = Target.the("City").locatedBy("//input[contains(@id,'city')]");
	public static final Target ZIP_CODE = Target.the("Zip Code").locatedBy("//input[contains(@id,'zipCode')]");
	public static final Target SPECIALITY = Target.the("Speciality").locatedBy("//select[contains(@id,'specialityI')]");
	public static final Target EMAIL_ADDRESS = Target.the("Email Address")
			.locatedBy("//input[contains(@id,'emailAddressI')]");
	public static final Target PRACTICE_NAME = Target.the("Practice name")
			.locatedBy("//input[contains(@id,'practiceNameI')]");
	public static final Target ADDRESS = Target.the("Address").locatedBy("//input[contains(@id,'address')]");
	public static final Target STATE = Target.the("State").locatedBy("//input[contains(@id,'state')]");
	public static final Target TELEPHONE = Target.the("Telephone").locatedBy("//input[contains(@id,'phone')]");
	public static final Target FAX_NUMBER = Target.the("Fax Number").locatedBy("//input[contains(@id,'FaxNumber')]");
	public static final Target NPI_NUMBER = Target.the("NPI Number")
			.locatedBy("//input[contains(@id,'NPINumberI_input')]");

}