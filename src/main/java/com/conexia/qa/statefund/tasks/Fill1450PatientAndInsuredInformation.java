package com.conexia.qa.statefund.tasks;

import static com.conexia.qa.statefund.user_interfaces.PatientAndInsuredInformation1450Page.ADDRESS_ONE;
import static com.conexia.qa.statefund.user_interfaces.PatientAndInsuredInformation1450Page.ADDRESS_TWO;
import static com.conexia.qa.statefund.user_interfaces.PatientAndInsuredInformation1450Page.CITY;
import static com.conexia.qa.statefund.user_interfaces.PatientAndInsuredInformation1450Page.PATIENT_CONTROL_NUMBER;
import static com.conexia.qa.statefund.user_interfaces.PatientAndInsuredInformation1450Page.REMARKS;
import static com.conexia.qa.statefund.user_interfaces.PatientAndInsuredInformation1450Page.RESERVED_FOR_ASSIGNMENT;
import static com.conexia.qa.statefund.user_interfaces.PatientAndInsuredInformation1450Page.SEX;
import static com.conexia.qa.statefund.user_interfaces.PatientAndInsuredInformation1450Page.STATE;
import static com.conexia.qa.statefund.user_interfaces.PatientAndInsuredInformation1450Page.TITTLE;
import static com.conexia.qa.statefund.user_interfaces.PatientAndInsuredInformation1450Page.ZIP_CODE;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.thucydides.core.annotations.Step;

public class Fill1450PatientAndInsuredInformation implements Task {

	private String sex;
	private String addressOne;
	private String addressTwo;
	private String city;
	private String state;
	private String zipCode;
	private String patientControlNumber;
	private String reservedForAssignment;
	private String remarks;

	public Fill1450PatientAndInsuredInformation() {
		this.sex = "Male";
		this.addressOne = "Address 1";
		this.addressTwo = "Address 2";
		this.city = "New York";
		this.state = "CA";
		this.zipCode = "66666";
		this.patientControlNumber = "123456789012363456846435";
		this.reservedForAssignment = "Assignment to pepito";
		this.remarks = "Automation Test";
	}

	@Override
	@Step("{0} Fill the Patient And Insured Information 1450 form")
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(Scroll.to(TITTLE), Click.on(SEX.of(sex)), Enter.theValue(addressOne).into(ADDRESS_ONE),
				Enter.theValue(addressTwo).into(ADDRESS_TWO), Enter.theValue(city).into(CITY),
				Enter.theValue(state).into(STATE), Enter.theValue(zipCode).into(ZIP_CODE),
				Enter.theValue(patientControlNumber).into(PATIENT_CONTROL_NUMBER),
				Enter.theValue(reservedForAssignment).into(RESERVED_FOR_ASSIGNMENT),
				Enter.theValue(remarks).into(REMARKS));
		Serenity.takeScreenshot();
	}

	public static Fill1450PatientAndInsuredInformation form() {
		return Tasks.instrumented(Fill1450PatientAndInsuredInformation.class);
	}

}