package com.conexia.qa.statefund.tasks;

import static com.conexia.qa.statefund.user_interfaces.PrimaryPayerInformationPage.ADDRESS_ONE;
import static com.conexia.qa.statefund.user_interfaces.PrimaryPayerInformationPage.ADDRESS_TWO;
import static com.conexia.qa.statefund.user_interfaces.PrimaryPayerInformationPage.CITY;
import static com.conexia.qa.statefund.user_interfaces.PrimaryPayerInformationPage.INSURANCE_COMPANY_NAME;
import static com.conexia.qa.statefund.user_interfaces.PrimaryPayerInformationPage.PHONE_NUMBER;
import static com.conexia.qa.statefund.user_interfaces.PrimaryPayerInformationPage.STATE;
import static com.conexia.qa.statefund.user_interfaces.PrimaryPayerInformationPage.TITTLE;
import static com.conexia.qa.statefund.user_interfaces.PrimaryPayerInformationPage.ZIP_CODE;

import com.conexia.qa.statefund.interactions.Swipe;
import com.conexia.qa.statefund.interactions.Type;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.thucydides.core.annotations.Step;

public class FillPrimaryPayerInformation implements Task {

	private String insuranceCompanyName;
	private String addressOne;
	private String addressTwo;
	private String city;
	private String state;
	private String zipCode;
	private String phoneNumber;

	public FillPrimaryPayerInformation() {
		this.insuranceCompanyName = "Insurance Company Name";
		this.addressOne = "Address 1";
		this.addressTwo = "Address 1";
		this.city = "Home";
		this.state = "CA";
		this.zipCode = "66666";
		this.phoneNumber = "6666666666";
	}

	@Override
	@Step("{0} Fill the Primary Payer Information form")
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(Scroll.to(TITTLE), Swipe.vertical(-150),
				Enter.theValue(insuranceCompanyName).into(INSURANCE_COMPANY_NAME),
				Enter.theValue(addressOne).into(ADDRESS_ONE), Enter.theValue(addressTwo).into(ADDRESS_TWO));
		actor.attemptsTo(Enter.theValue(city).into(CITY), Enter.theValue(state).into(STATE),
				Enter.theValue(zipCode).into(ZIP_CODE), Type.theNumber(phoneNumber).into(PHONE_NUMBER));
		Serenity.takeScreenshot();
	}

	public static FillPrimaryPayerInformation form() {
		return Tasks.instrumented(FillPrimaryPayerInformation.class);
	}

}