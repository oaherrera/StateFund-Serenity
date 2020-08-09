package com.conexia.qa.statefund.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;

public class TreatingDentistAndTreatmentLocationInformationPage {

	private TreatingDentistAndTreatmentLocationInformationPage() {
	}

	public static final Target TITTLE = Target.the("Treating Dentist and Treatment Location Information")
			.locatedBy("//h1[.='Treating Dentist and Treatment Location Information']");
	public static final Target NPI_NUMER = Target.the("NPI #").locatedBy("//input[contains(@id,'NPIInput')]");
	public static final Target LICENSE_NUMBER = Target.the("License number")
			.locatedBy("//input[contains(@id,'licenseNumberInput')]");
	public static final Target ADDRESS_ONE = Target.the("Address 1")
			.locatedBy("//input[contains(@id,'address1Input')]");
	public static final Target ADDRESS_TWO = Target.the("Address 2")
			.locatedBy("//input[contains(@id,'address2Input')]");
	public static final Target CITY = Target.the("City").locatedBy("//input[contains(@id,'cityInput')]");
	public static final Target STATE = Target.the("State").locatedBy("//input[contains(@id,'stateInput')]");
	public static final Target ZIP_CODE = Target.the("Zip Code").locatedBy("//input[contains(@id,'zipInput')]");
	public static final Target PROVIDER_SPECIALTY_CODE = Target.the("Provider Specialty Code")
			.locatedBy("//input[contains(@id,'providerSpecialtyInput')]");
	public static final Target PHONE_NUMBER = Target.the("Phone number")
			.locatedBy("//input[contains(@id,'phoneNumberInput')]");
	public static final Target ADDITIONAL_PROVIDER_ID = Target.the("Additional provider ID")
			.locatedBy("//input[contains(@id,'additionalProviderInput')]");

}