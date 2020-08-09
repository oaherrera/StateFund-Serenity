package com.conexia.qa.statefund.tasks;

import static com.conexia.qa.statefund.user_interfaces.PatientAndInsuredInformationADAPage.ADDRESS_ONE;
import static com.conexia.qa.statefund.user_interfaces.PatientAndInsuredInformationADAPage.ADDRESS_TWO;
import static com.conexia.qa.statefund.user_interfaces.PatientAndInsuredInformationADAPage.CITY;
import static com.conexia.qa.statefund.user_interfaces.PatientAndInsuredInformationADAPage.RELATIONSHIP_TO_POLICYHOLDER;
import static com.conexia.qa.statefund.user_interfaces.PatientAndInsuredInformationADAPage.SEX;
import static com.conexia.qa.statefund.user_interfaces.PatientAndInsuredInformationADAPage.STATE;
import static com.conexia.qa.statefund.user_interfaces.PatientAndInsuredInformationADAPage.STUDENT_STATUS;
import static com.conexia.qa.statefund.user_interfaces.PatientAndInsuredInformationADAPage.TELEPHONE;
import static com.conexia.qa.statefund.user_interfaces.PatientAndInsuredInformationADAPage.TITTLE;
import static com.conexia.qa.statefund.user_interfaces.PatientAndInsuredInformationADAPage.ZIP_CODE;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.thucydides.core.annotations.Step;

public class FillADAPatientAndInsuredInformation implements Task {

	private String sex;
	private String addressOne;
	private String addressTwo;
	private String city;
	private String state;
	private String zipCode;
	private String telephone;
	private String realationshipToPolicyholder;
	private String studentStatus;

	public FillADAPatientAndInsuredInformation() {
		this.sex = "Male";
		this.addressOne = "Address 1";
		this.addressTwo = "Address 2";
		this.city = "New York";
		this.state = "CA";
		this.zipCode = "66666";
		this.telephone = "6666666666";
		this.realationshipToPolicyholder = "Other";
		this.studentStatus = "FTS";
	}

	@Override
	@Step("{0} Fill the Patient And Insured Information ADA form")
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(Scroll.to(TITTLE), Click.on(SEX.of(sex)), Enter.theValue(addressOne).into(ADDRESS_ONE),
				Enter.theValue(addressTwo).into(ADDRESS_TWO), Enter.theValue(city).into(CITY),
				Enter.theValue(state).into(STATE), Enter.theValue(zipCode).into(ZIP_CODE),
				Enter.theValue(telephone).into(TELEPHONE));
		actor.attemptsTo(Click.on(RELATIONSHIP_TO_POLICYHOLDER.of(realationshipToPolicyholder)),
				Click.on(STUDENT_STATUS.of(studentStatus)));
		Serenity.takeScreenshot();
	}

	public static FillADAPatientAndInsuredInformation form() {
		return Tasks.instrumented(FillADAPatientAndInsuredInformation.class);
	}

}