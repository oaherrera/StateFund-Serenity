package com.conexia.qa.statefund.tasks;

import static com.conexia.qa.statefund.user_interfaces.BillingDentistOrDentalEntityPage.ADDITIONAL_PROVIDER_ID;
import static com.conexia.qa.statefund.user_interfaces.BillingDentistOrDentalEntityPage.ADDRESS_ONE;
import static com.conexia.qa.statefund.user_interfaces.BillingDentistOrDentalEntityPage.ADDRESS_TWO;
import static com.conexia.qa.statefund.user_interfaces.BillingDentistOrDentalEntityPage.CITY;
import static com.conexia.qa.statefund.user_interfaces.BillingDentistOrDentalEntityPage.DENTIST_NAME;
import static com.conexia.qa.statefund.user_interfaces.BillingDentistOrDentalEntityPage.LICENSE_NUMBER;
import static com.conexia.qa.statefund.user_interfaces.BillingDentistOrDentalEntityPage.NPI;
import static com.conexia.qa.statefund.user_interfaces.BillingDentistOrDentalEntityPage.PHONE_NUMBER;
import static com.conexia.qa.statefund.user_interfaces.BillingDentistOrDentalEntityPage.SSN_OR_TIN;
import static com.conexia.qa.statefund.user_interfaces.BillingDentistOrDentalEntityPage.STATE;
import static com.conexia.qa.statefund.user_interfaces.BillingDentistOrDentalEntityPage.TITTLE;
import static com.conexia.qa.statefund.user_interfaces.BillingDentistOrDentalEntityPage.ZIP_CODE;

import com.conexia.qa.statefund.interactions.Swipe;
import com.conexia.qa.statefund.interactions.Type;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.thucydides.core.annotations.Step;

public class FillBillingDentistOrDentalEntity implements Task {

	private String dentistName;
	private String addressOne;
	private String addressTwo;
	private String city;
	private String state;
	private String zipCode;
	private String npi;
	private String licenseNumber;
	private String ssnORtin;
	private String phonenumber;
	private String additionalProviderID;

	public FillBillingDentistOrDentalEntity() {
		this.dentistName = "Dentist Name";
		this.addressOne = "Address 1";
		this.addressTwo = "Address 2";
		this.city = "city";
		this.state = "CA";
		this.zipCode = "66666";
		this.npi = "4534534537";
		this.licenseNumber = "53435";
		this.ssnORtin = "111111111";
		this.phonenumber = "6666666666";
		this.additionalProviderID = "3464658790";
	}

	@Override
	@Step("{0} Fill the Billing Dentist or Dental Entity form")
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(Scroll.to(TITTLE), Swipe.vertical(-150), Enter.theValue(dentistName).into(DENTIST_NAME),
				Enter.theValue(addressOne).into(ADDRESS_ONE));
		actor.attemptsTo(Enter.theValue(addressTwo).into(ADDRESS_TWO), Enter.theValue(city).into(CITY),
				Enter.theValue(state).into(STATE), Enter.theValue(zipCode).into(ZIP_CODE),
				Enter.theValue(npi).into(NPI), Enter.theValue(licenseNumber).into(LICENSE_NUMBER),
				Enter.theValue(ssnORtin).into(SSN_OR_TIN));
		actor.attemptsTo(Swipe.vertical(150), Type.theNumber(phonenumber).into(PHONE_NUMBER),
				Enter.theValue(additionalProviderID).into(ADDITIONAL_PROVIDER_ID));
		Serenity.takeScreenshot();
	}

	public static FillBillingDentistOrDentalEntity form() {
		return Tasks.instrumented(FillBillingDentistOrDentalEntity.class);
	}

}