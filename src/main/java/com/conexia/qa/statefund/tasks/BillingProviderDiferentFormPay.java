package com.conexia.qa.statefund.tasks;

import static com.conexia.qa.statefund.user_interfaces.BillingProviderDiferentFormPayPage.PAY_TO_ADDRESS_ONE;
import static com.conexia.qa.statefund.user_interfaces.BillingProviderDiferentFormPayPage.PAY_TO_ADDRESS_TWO;
import static com.conexia.qa.statefund.user_interfaces.BillingProviderDiferentFormPayPage.PAY_TO_CITY;
import static com.conexia.qa.statefund.user_interfaces.BillingProviderDiferentFormPayPage.PAY_TO_ID;
import static com.conexia.qa.statefund.user_interfaces.BillingProviderDiferentFormPayPage.PAY_TO_NAME;
import static com.conexia.qa.statefund.user_interfaces.BillingProviderDiferentFormPayPage.PAY_TO_STATE;
import static com.conexia.qa.statefund.user_interfaces.BillingProviderDiferentFormPayPage.PAY_TO_ZIP_CODE;
import static com.conexia.qa.statefund.user_interfaces.BillingProviderDiferentFormPayPage.PAY_TO_ZIP_CODE_TWO;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;

public class BillingProviderDiferentFormPay implements Task {

	private String payToName;
	private String payToAddressOne;
	private String payToAddressTwo;
	private String payToCity;
	private String payToState;
	private String payToZipCode;
	private String payToZipCodeTwo;
	private String payToID;

	public BillingProviderDiferentFormPay() {
		this.payToName = "payer Name";
		this.payToAddressOne = "Address 1";
		this.payToAddressTwo = "Address 2";
		this.payToCity = "Home";
		this.payToState = "CA";
		this.payToZipCode = "65465";
		this.payToZipCodeTwo = "2342";
		this.payToID = "PayID123456";
	}

	@Override
	@Step("{0} Fill the Billing Provider Diferent Form Pay-To Provider")
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(Enter.theValue(payToName).into(PAY_TO_NAME),
				Enter.theValue(payToAddressOne).into(PAY_TO_ADDRESS_ONE),
				Enter.theValue(payToAddressTwo).into(PAY_TO_ADDRESS_TWO));
		actor.attemptsTo(Enter.theValue(payToCity).into(PAY_TO_CITY), Enter.theValue(payToState).into(PAY_TO_STATE),
				Enter.theValue(payToZipCode).into(PAY_TO_ZIP_CODE));
		actor.attemptsTo(Enter.theValue(payToZipCodeTwo).into(PAY_TO_ZIP_CODE_TWO),
				Enter.theValue(payToID).into(PAY_TO_ID));
		Serenity.takeScreenshot();
	}

	public static BillingProviderDiferentFormPay form() {
		return Tasks.instrumented(BillingProviderDiferentFormPay.class);
	}

}