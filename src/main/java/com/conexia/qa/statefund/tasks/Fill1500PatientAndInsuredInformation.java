package com.conexia.qa.statefund.tasks;

import static com.conexia.qa.statefund.user_interfaces.PatientAndInsuredInformation1500Page.ADDRESS_ONE;
import static com.conexia.qa.statefund.user_interfaces.PatientAndInsuredInformation1500Page.ADDRESS_TWO;
import static com.conexia.qa.statefund.user_interfaces.PatientAndInsuredInformation1500Page.CITY;
import static com.conexia.qa.statefund.user_interfaces.PatientAndInsuredInformation1500Page.PATIENT_ACCOUNT_NUMBER;
import static com.conexia.qa.statefund.user_interfaces.PatientAndInsuredInformation1500Page.RESERVED_FOR_NUCC_USE;
import static com.conexia.qa.statefund.user_interfaces.PatientAndInsuredInformation1500Page.SEX;
import static com.conexia.qa.statefund.user_interfaces.PatientAndInsuredInformation1500Page.STATE;
import static com.conexia.qa.statefund.user_interfaces.PatientAndInsuredInformation1500Page.TELEPHONE;
import static com.conexia.qa.statefund.user_interfaces.PatientAndInsuredInformation1500Page.TELEPHONE_EXT;
import static com.conexia.qa.statefund.user_interfaces.PatientAndInsuredInformation1500Page.TITTLE;
import static com.conexia.qa.statefund.user_interfaces.PatientAndInsuredInformation1500Page.ZIP_CODE;

import com.conexia.qa.statefund.interactions.Type;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.thucydides.core.annotations.Step;

public class Fill1500PatientAndInsuredInformation implements Task {

	private String sex;
	private String addressOne;
	private String addressTwo;
	private String city;
	private String state;
	private String zipCode;
	private String telephone;
	private String telephoneExt;
	private String patientAccountNumber;
	private String reservedForNUCCUse;
	@SuppressWarnings("unused")
	private String patientRelationshipToInsured;

	public Fill1500PatientAndInsuredInformation() {
		this.sex = "Male";
		this.addressOne = "Address 1";
		this.addressTwo = "Address 2";
		this.city = "New York";
		this.state = "CA";
		this.zipCode = "66666";
		this.telephone = "6666666666";
		this.telephoneExt = "999999999";
		this.patientAccountNumber = "patientNumber123456";
		this.reservedForNUCCUse = "Reserved for 123456";
		this.patientRelationshipToInsured = "Ohter";
	}

	@Override
	@Step("{0} Fill the Patient And Insured Information 1500 form")
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(Scroll.to(TITTLE), Click.on(SEX.of(sex)), Enter.theValue(addressOne).into(ADDRESS_ONE),
				Enter.theValue(addressTwo).into(ADDRESS_TWO));
		actor.attemptsTo(Enter.theValue(city).into(CITY), Enter.theValue(state).into(STATE),
				Type.theNumber(zipCode).into(ZIP_CODE));
		actor.attemptsTo(Type.theNumber(telephone).into(TELEPHONE), Enter.theValue(telephoneExt).into(TELEPHONE_EXT),
				Enter.theValue(patientAccountNumber).into(PATIENT_ACCOUNT_NUMBER),
				Enter.theValue(reservedForNUCCUse).into(RESERVED_FOR_NUCC_USE));
//		ator.attemptsTo(Click.on(PATIENT_RELATIONSHIP_TO_INSURED.of(patientRelationshipToInsured)));
		Serenity.takeScreenshot();
	}

	public static Fill1500PatientAndInsuredInformation form() {
		return Tasks.instrumented(Fill1500PatientAndInsuredInformation.class);
	}

}