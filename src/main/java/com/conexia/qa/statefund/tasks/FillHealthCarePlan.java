package com.conexia.qa.statefund.tasks;

import static com.conexia.qa.statefund.user_interfaces.HealthCarePlanPage.DOES_THE_PATIENT_HAVE_AN_IDENTIFIER;
import static com.conexia.qa.statefund.user_interfaces.HealthCarePlanPage.HEALTH_PLAN_ID;
import static com.conexia.qa.statefund.user_interfaces.HealthCarePlanPage.MEDICAL_HEALTH_RECORD;
import static com.conexia.qa.statefund.user_interfaces.HealthCarePlanPage.TITTLE;

import com.conexia.qa.statefund.interactions.Swipe;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.thucydides.core.annotations.Step;

public class FillHealthCarePlan implements Task {

	private String healthPlanID;;
	private String doesThePatientHaveIdentifier;
	private String medicalHealthRecord;

	public FillHealthCarePlan() {
		this.healthPlanID = "Plan123456";
		this.doesThePatientHaveIdentifier = "Yes";
		this.medicalHealthRecord = "Record 12345";
	}

	@Override
	@Step("{0} Fill the Health Care Plan form")
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(Scroll.to(TITTLE), Enter.theValue(healthPlanID).into(HEALTH_PLAN_ID), Swipe.vertical(-150),
				Click.on(DOES_THE_PATIENT_HAVE_AN_IDENTIFIER.of(doesThePatientHaveIdentifier)),
				Enter.theValue(medicalHealthRecord).into(MEDICAL_HEALTH_RECORD));
		Serenity.takeScreenshot();
	}

	public static FillHealthCarePlan form() {
		return Tasks.instrumented(FillHealthCarePlan.class);
	}

}