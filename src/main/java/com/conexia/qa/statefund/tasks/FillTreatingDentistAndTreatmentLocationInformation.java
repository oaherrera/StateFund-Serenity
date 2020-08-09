package com.conexia.qa.statefund.tasks;

import static com.conexia.qa.statefund.user_interfaces.TreatingDentistAndTreatmentLocationInformationPage.ADDITIONAL_PROVIDER_ID;
import static com.conexia.qa.statefund.user_interfaces.TreatingDentistAndTreatmentLocationInformationPage.ADDRESS_ONE;
import static com.conexia.qa.statefund.user_interfaces.TreatingDentistAndTreatmentLocationInformationPage.ADDRESS_TWO;
import static com.conexia.qa.statefund.user_interfaces.TreatingDentistAndTreatmentLocationInformationPage.CITY;
import static com.conexia.qa.statefund.user_interfaces.TreatingDentistAndTreatmentLocationInformationPage.LICENSE_NUMBER;
import static com.conexia.qa.statefund.user_interfaces.TreatingDentistAndTreatmentLocationInformationPage.NPI_NUMER;
import static com.conexia.qa.statefund.user_interfaces.TreatingDentistAndTreatmentLocationInformationPage.PHONE_NUMBER;
import static com.conexia.qa.statefund.user_interfaces.TreatingDentistAndTreatmentLocationInformationPage.PROVIDER_SPECIALTY_CODE;
import static com.conexia.qa.statefund.user_interfaces.TreatingDentistAndTreatmentLocationInformationPage.STATE;
import static com.conexia.qa.statefund.user_interfaces.TreatingDentistAndTreatmentLocationInformationPage.TITTLE;
import static com.conexia.qa.statefund.user_interfaces.TreatingDentistAndTreatmentLocationInformationPage.ZIP_CODE;

import com.conexia.qa.statefund.interactions.Swipe;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.thucydides.core.annotations.Step;

public class FillTreatingDentistAndTreatmentLocationInformation implements Task {

	private String npiNumber;
	private String licenseNumber;
	private String addressOne;
	private String addressTwo;
	private String city;
	private String state;
	private String zipCode;
	private String providerSpecialtyCode;
	private String phoneNumber;
	private String additionalProviderID;

	public FillTreatingDentistAndTreatmentLocationInformation() {
		this.npiNumber = "1111111111";
		this.licenseNumber = "";
		this.addressOne = "Address 1";
		this.addressTwo = "Address 2";
		this.city = "city";
		this.state = "CA";
		this.zipCode = "66666";
		this.providerSpecialtyCode = "ProviderSp";
		this.phoneNumber = "6666666666";
		this.additionalProviderID = "123456";
	}

	@Override
	@Step("{0} Fill the Treating Dentist And Treatment Location Information form")
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(Scroll.to(TITTLE), Swipe.vertical(-150), Enter.theValue(npiNumber).into(NPI_NUMER));
		actor.attemptsTo(Enter.theValue(licenseNumber).into(LICENSE_NUMBER),
				Enter.theValue(addressOne).into(ADDRESS_ONE), Enter.theValue(addressTwo).into(ADDRESS_TWO));
		actor.attemptsTo(Enter.theValue(city).into(CITY), Enter.theValue(state).into(STATE),
				Enter.theValue(zipCode).into(ZIP_CODE));
		actor.attemptsTo(Enter.theValue(providerSpecialtyCode).into(PROVIDER_SPECIALTY_CODE),
				Enter.theValue(phoneNumber).into(PHONE_NUMBER),
				Enter.theValue(additionalProviderID).into(ADDITIONAL_PROVIDER_ID));
		Serenity.takeScreenshot();
	}

	public static FillTreatingDentistAndTreatmentLocationInformation form() {
		return Tasks.instrumented(FillTreatingDentistAndTreatmentLocationInformation.class);
	}

}