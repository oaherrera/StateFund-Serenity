package com.conexia.qa.statefund.tasks;

import static com.conexia.qa.statefund.user_interfaces.BillingProviderInformation1450Page.ADD;
import static com.conexia.qa.statefund.user_interfaces.BillingProviderInformation1450Page.ADDRESS_ONE;
import static com.conexia.qa.statefund.user_interfaces.BillingProviderInformation1450Page.ADDRESS_TWO;
import static com.conexia.qa.statefund.user_interfaces.BillingProviderInformation1450Page.BILLING_PROVIDER_DIFERENT_FROM_PAY;
import static com.conexia.qa.statefund.user_interfaces.BillingProviderInformation1450Page.BILLING_PROVIDER_NAME;
import static com.conexia.qa.statefund.user_interfaces.BillingProviderInformation1450Page.CITY;
import static com.conexia.qa.statefund.user_interfaces.BillingProviderInformation1450Page.CODE;
import static com.conexia.qa.statefund.user_interfaces.BillingProviderInformation1450Page.FAX_NUMBER;
import static com.conexia.qa.statefund.user_interfaces.BillingProviderInformation1450Page.FEDERAL_TAX_NUMBER;
import static com.conexia.qa.statefund.user_interfaces.BillingProviderInformation1450Page.NATIONAL_PROVIDER_IDENTIFIER;
import static com.conexia.qa.statefund.user_interfaces.BillingProviderInformation1450Page.OTHER_BILLING_PROVODER_ID;
import static com.conexia.qa.statefund.user_interfaces.BillingProviderInformation1450Page.QUALIFIER;
import static com.conexia.qa.statefund.user_interfaces.BillingProviderInformation1450Page.STATE;
import static com.conexia.qa.statefund.user_interfaces.BillingProviderInformation1450Page.TELEPHONE;
import static com.conexia.qa.statefund.user_interfaces.BillingProviderInformation1450Page.TELEPHONE_EXT;
import static com.conexia.qa.statefund.user_interfaces.BillingProviderInformation1450Page.TITTLE;
import static com.conexia.qa.statefund.user_interfaces.BillingProviderInformation1450Page.TYPE_OF_BILL;
import static com.conexia.qa.statefund.user_interfaces.BillingProviderInformation1450Page.VALUE;
import static com.conexia.qa.statefund.user_interfaces.BillingProviderInformation1450Page.ZIP_CODE;

import com.conexia.qa.statefund.interactions.Swipe;
import com.conexia.qa.statefund.interactions.WaitLoading;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.thucydides.core.annotations.Step;

public class Fill1450BillingProviderInformation implements Task {

	private String typeOfBill;
	private String billingProviderName;
	private String addressOne;
	private String addressTwo;
	private String city;
	private String state;
	private String zipCode;
	private String telephone;
	private String telephoneExt;
	private String faxNumber;
	private String federalTaxNumber;
	private String nationalProviderIdentifier;
	private String otherBillingProviderID;
	private String qualifier;
	private String code;
	private String value;
	private String billingProviderDifferentFromPay;

	public Fill1450BillingProviderInformation() {
		this.typeOfBill = "2342";
		this.billingProviderName = "provider one";
		this.addressOne = "Address 1";
		this.addressTwo = "Address 2";
		this.city = "Sprintfied";
		this.state = "CA";
		this.zipCode = "66666";
		this.telephone = "6666666666";
		this.telephoneExt = "345345345";
		this.faxNumber = "43434353453453453453";
		this.federalTaxNumber = "453453456";
		this.nationalProviderIdentifier = "Provider12";
		this.otherBillingProviderID = "584813584543543";
		this.qualifier = "12";
		this.code = "21";
		this.value = "33";
		this.billingProviderDifferentFromPay = "Yes";
	}

	@Override
	@Step("{0} Fill the Billing Provider Information 1450 form")
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(Scroll.to(TITTLE), Enter.theValue(typeOfBill).into(TYPE_OF_BILL));
		actor.attemptsTo(Enter.theValue(billingProviderName).into(BILLING_PROVIDER_NAME),
				Enter.theValue(addressOne).into(ADDRESS_ONE), Enter.theValue(addressTwo).into(ADDRESS_TWO));
		actor.attemptsTo(Enter.theValue(city).into(CITY), Enter.theValue(state).into(STATE),
				Enter.theValue(zipCode).into(ZIP_CODE));
		actor.attemptsTo(Enter.theValue(telephone).into(TELEPHONE), Enter.theValue(telephoneExt).into(TELEPHONE_EXT),
				Enter.theValue(faxNumber).into(FAX_NUMBER));
		actor.attemptsTo(Enter.theValue(federalTaxNumber).into(FEDERAL_TAX_NUMBER),
				Enter.theValue(nationalProviderIdentifier).into(NATIONAL_PROVIDER_IDENTIFIER),
				Enter.theValue(otherBillingProviderID).into(OTHER_BILLING_PROVODER_ID));
		actor.attemptsTo(Swipe.vertical(100), Enter.theValue(qualifier).into(QUALIFIER),
				Enter.theValue(code).into(CODE), Enter.theValue(value).into(VALUE), Click.on(ADD), WaitLoading.page());
		actor.attemptsTo(Swipe.vertical(300),
				Click.on(BILLING_PROVIDER_DIFERENT_FROM_PAY.of(billingProviderDifferentFromPay)));
		Serenity.takeScreenshot();
		if (billingProviderDifferentFromPay.equals("Yes")) {
			actor.attemptsTo(BillingProviderDiferentFormPay.form());
		}
	}

	public static Fill1450BillingProviderInformation form() {
		return Tasks.instrumented(Fill1450BillingProviderInformation.class);
	}

}