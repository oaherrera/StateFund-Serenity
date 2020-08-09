package com.conexia.qa.statefund.tasks;

import static com.conexia.qa.statefund.user_interfaces.HospitalizationInformationPage.ADD_OCCURRENCE_SPAN;
import static com.conexia.qa.statefund.user_interfaces.HospitalizationInformationPage.ADD_OCURRENCE;
import static com.conexia.qa.statefund.user_interfaces.HospitalizationInformationPage.DISCHARGE_HOUR;
import static com.conexia.qa.statefund.user_interfaces.HospitalizationInformationPage.OCCURRENCE_CODE;
import static com.conexia.qa.statefund.user_interfaces.HospitalizationInformationPage.OCCURRENCE_DATE;
import static com.conexia.qa.statefund.user_interfaces.HospitalizationInformationPage.OCCURRENCE_SPAN_CODE;
import static com.conexia.qa.statefund.user_interfaces.HospitalizationInformationPage.OCCURRENCE_SPAN_FROM_DATE;
import static com.conexia.qa.statefund.user_interfaces.HospitalizationInformationPage.OCCURRENCE_SPAN_THROUGH_DATE;
import static com.conexia.qa.statefund.user_interfaces.HospitalizationInformationPage.PATIENT_DISCHARGE_STATUS;
import static com.conexia.qa.statefund.user_interfaces.HospitalizationInformationPage.RESERVED_FOR_ASSIGMENT_BY_THE_NUBC;
import static com.conexia.qa.statefund.user_interfaces.HospitalizationInformationPage.TITTLE;

import com.conexia.qa.statefund.interactions.Sleep;
import com.conexia.qa.statefund.interactions.Type;
import com.conexia.qa.statefund.interactions.WaitLoading;
import com.conexia.qa.statefund.utils.DateFunctions;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.thucydides.core.annotations.Step;

public class FillHospitalizationInformation implements Task {

	private String dischargeHour;
	private String patientDischargeStatus;
	private String occurrenceCode;
	private String occurrenceDate;
	private String occurrenceSpanCode;
	private String occurrenceSpanFromDate;
	private String occurrenceSpanThorughDate;
	private String reservedForAssigmentTheNUBC;

	public FillHospitalizationInformation() {
		this.dischargeHour = "1213";
		this.patientDischargeStatus = "12";
		this.occurrenceCode = "22";
		this.occurrenceDate = DateFunctions.actualDate();
		this.occurrenceSpanCode = "AS";
		this.occurrenceSpanFromDate = DateFunctions.yesterdayDate();
		this.occurrenceSpanThorughDate = DateFunctions.aWeekLater();
		this.reservedForAssigmentTheNUBC = "asdf324t4";
	}

	@Override
	@Step("{0} Fill the Hospitalization Information form")
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(Scroll.to(TITTLE), Enter.theValue(dischargeHour).into(DISCHARGE_HOUR),
				Enter.theValue(patientDischargeStatus).into(PATIENT_DISCHARGE_STATUS));
		actor.attemptsTo(Enter.theValue(occurrenceCode).into(OCCURRENCE_CODE),
				Type.theNumber(occurrenceDate).into(OCCURRENCE_DATE), Click.on(ADD_OCURRENCE), WaitLoading.page());
		actor.attemptsTo(Enter.theValue(occurrenceSpanCode).into(OCCURRENCE_SPAN_CODE), Sleep.by(500),
				Type.theNumber(occurrenceSpanFromDate).into(OCCURRENCE_SPAN_FROM_DATE));
		actor.attemptsTo(Type.theNumber(occurrenceSpanThorughDate).into(OCCURRENCE_SPAN_THROUGH_DATE),
				Click.on(ADD_OCCURRENCE_SPAN),
				Enter.theValue(reservedForAssigmentTheNUBC).into(RESERVED_FOR_ASSIGMENT_BY_THE_NUBC));
		Serenity.takeScreenshot();
	}

	public static FillHospitalizationInformation form() {
		return Tasks.instrumented(FillHospitalizationInformation.class);
	}

}