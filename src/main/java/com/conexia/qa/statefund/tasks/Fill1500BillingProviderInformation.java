package com.conexia.qa.statefund.tasks;

import static com.conexia.qa.statefund.user_interfaces.BillingProviderInformation1500Page.ADDRESS_ONE;
import static com.conexia.qa.statefund.user_interfaces.BillingProviderInformation1500Page.ADDRESS_TWO;
import static com.conexia.qa.statefund.user_interfaces.BillingProviderInformation1500Page.CITY;
import static com.conexia.qa.statefund.user_interfaces.BillingProviderInformation1500Page.DATE;
import static com.conexia.qa.statefund.user_interfaces.BillingProviderInformation1500Page.DEGREE;
import static com.conexia.qa.statefund.user_interfaces.BillingProviderInformation1500Page.FEDERAL_TAX_ID;
import static com.conexia.qa.statefund.user_interfaces.BillingProviderInformation1500Page.FIRST_NAME;
import static com.conexia.qa.statefund.user_interfaces.BillingProviderInformation1500Page.LAST_NAME;
import static com.conexia.qa.statefund.user_interfaces.BillingProviderInformation1500Page.MIDDLE_NAME;
import static com.conexia.qa.statefund.user_interfaces.BillingProviderInformation1500Page.NPI_NUMBER;
import static com.conexia.qa.statefund.user_interfaces.BillingProviderInformation1500Page.OTHER_ID_NUMBER;
import static com.conexia.qa.statefund.user_interfaces.BillingProviderInformation1500Page.PROVIDER_FED_TAX_ID;
import static com.conexia.qa.statefund.user_interfaces.BillingProviderInformation1500Page.SIGNATURE_OF_PHYSICIAN_OR_SUPPLIER;
import static com.conexia.qa.statefund.user_interfaces.BillingProviderInformation1500Page.STATE;
import static com.conexia.qa.statefund.user_interfaces.BillingProviderInformation1500Page.TELEPHONE;
import static com.conexia.qa.statefund.user_interfaces.BillingProviderInformation1500Page.TELEPHONE_EXT;
import static com.conexia.qa.statefund.user_interfaces.BillingProviderInformation1500Page.TITTLE;
import static com.conexia.qa.statefund.user_interfaces.BillingProviderInformation1500Page.ZIP_CODE;
import static com.conexia.qa.statefund.user_interfaces.BillingProviderInformation1500Page.ZIP_CODE_EXT;

import com.conexia.qa.statefund.interactions.Type;
import com.conexia.qa.statefund.utils.DateFunctions;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.thucydides.core.annotations.Step;

public class Fill1500BillingProviderInformation implements Task {

	private String firstName;
	private String middleName;
	private String lastName;
	private String addressOne;
	private String addressTwo;
	private String city;
	private String state;
	private String zipCode;
	private String zipCodeExt;
	private String telephone;
	private String telephoneExt;
	private String signatureOfPhysicianOrSupplier;
	private String npiNumber;
	private String otherIDNumber;
	private String degree;
	private String date;
	private String federalTaxID;
	private String providerFedTaxID;

	public Fill1500BillingProviderInformation() {
		this.firstName = "Provider name";
		this.middleName = "p";
		this.lastName = "carnitas";
		this.addressOne = "Address 1";
		this.addressTwo = "Address 1";
		this.city = "Chicago";
		this.state = "CA";
		this.zipCode = "66666";
		this.zipCodeExt = "3423";
		this.telephone = "6666666666";
		this.telephoneExt = "234234234";
		this.signatureOfPhysicianOrSupplier = "Physician Name";
		this.npiNumber = "2342345478";
		this.otherIDNumber = "98765468136";
		this.degree = "dg";
		this.date = DateFunctions.actualDate();
		this.federalTaxID = "EIN";
		this.providerFedTaxID = "786861611";
	}

	@Override
	@Step("{0} Fill the Billing Provider Information 1500 form")
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(Scroll.to(TITTLE), Enter.theValue(firstName).into(FIRST_NAME),
				Enter.theValue(middleName).into(MIDDLE_NAME), Enter.theValue(lastName).into(LAST_NAME),
				Enter.theValue(addressOne).into(ADDRESS_ONE), Enter.theValue(addressTwo).into(ADDRESS_TWO),
				Enter.theValue(city).into(CITY), Enter.theValue(state).into(STATE),
				Enter.theValue(zipCode).into(ZIP_CODE), Enter.theValue(zipCodeExt).into(ZIP_CODE_EXT),
				Enter.theValue(telephone).into(TELEPHONE), Enter.theValue(telephoneExt).into(TELEPHONE_EXT),
				Enter.theValue(signatureOfPhysicianOrSupplier).into(SIGNATURE_OF_PHYSICIAN_OR_SUPPLIER),
				Enter.theValue(npiNumber).into(NPI_NUMBER), Enter.theValue(otherIDNumber).into(OTHER_ID_NUMBER),
				Enter.theValue(degree).into(DEGREE), Type.theNumber(date).into(DATE),
				Click.on(FEDERAL_TAX_ID.of(federalTaxID)), Enter.theValue(providerFedTaxID).into(PROVIDER_FED_TAX_ID));
		Serenity.takeScreenshot();
	}

	public static Fill1500BillingProviderInformation form() {
		return Tasks.instrumented(Fill1500BillingProviderInformation.class);
	}

}