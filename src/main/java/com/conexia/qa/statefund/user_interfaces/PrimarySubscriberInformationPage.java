package com.conexia.qa.statefund.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;

public class PrimarySubscriberInformationPage {

	private PrimarySubscriberInformationPage() {
	}

	public static final Target TITTLE = Target.the("Primary Subscriber Information")
			.locatedBy("//h1[.='Primary Subscriber Information']");
	public static final Target PRIMARY_SUBSCRIBER_NAME = Target.the("Primary Subscriber Name")
			.locatedBy("//input[contains(@id,'subscriberName')]");
	public static final Target ADDRESS_ONE = Target.the("Address 1")
			.locatedBy("//input[contains(@id,'subscriberAddress1')]");
	public static final Target ADDRESS_TWO = Target.the("Address 2")
			.locatedBy("//input[contains(@id,'subscriberAddress2')]");
	public static final Target CITY = Target.the("City").locatedBy("//input[contains(@id,'subscriberCity')]");
	public static final Target STATE = Target.the("State")
			.locatedBy("//input[contains(@id,'seccionPrimarySubscriberInformation:statePatient')]");
	public static final Target ZIP_CODE = Target.the("Zip Code")
			.locatedBy("//input[contains(@id,'seccionPrimarySubscriberInformation:zipCodePatient')]");
	public static final Target TELEPHONE = Target.the("Telephone")
			.locatedBy("//input[contains(@id,'seccionPrimarySubscriberInformation:telephonePatient')]");
	public static final Target DATE_OF_BIRTH = Target.the("Date of Birth")
			.locatedBy("//input[contains(@id,'subscriberDateOfBirthCalendar_input')]");
	public static final Target GENDER = Target.the("{0} Gender")
			.locatedBy("//table[contains(@id,'genderSubscriberSelect')]//label[.='{0}']");
	public static final Target POLICYHOLDER = Target.the("Policyholder/Subscriber ID (SSN or ID#)")
			.locatedBy("//input[contains(@id,'ssnOrId')]");
	public static final Target PLAN_GROUP_NUMBER = Target.the("Plan/Group Number")
			.locatedBy("//input[contains(@id,'planGroupNumber')]");

}