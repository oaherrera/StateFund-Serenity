package com.conexia.qa.statefund.tasks;

import static com.conexia.qa.statefund.user_interfaces.PatientAndInsuredConditionPage.AUTO_ACCIDENT;
import static com.conexia.qa.statefund.user_interfaces.PatientAndInsuredConditionPage.EMPLOYEMENT;
import static com.conexia.qa.statefund.user_interfaces.PatientAndInsuredConditionPage.OTHER_ACCIDENT;
import static com.conexia.qa.statefund.user_interfaces.PatientAndInsuredConditionPage.PLACE;
import static com.conexia.qa.statefund.user_interfaces.PatientAndInsuredConditionPage.TITTLE;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.thucydides.core.annotations.Step;

public class FillPatientAndInsuredCondition implements Task {

	private String employment;
	private String autoAccident;
	private String place;
	private String otherAccident;

	public FillPatientAndInsuredCondition() {
		this.employment = "Yes";
		this.autoAccident = "Yes";
		this.place = "ca";
		this.otherAccident = "Yes";
	}

	@Override
	@Step("{0} Fill the Patient And Insured Condition")
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(Scroll.to(TITTLE), Click.on(EMPLOYEMENT.of(employment)),
				Click.on(AUTO_ACCIDENT.of(autoAccident)), Click.on(OTHER_ACCIDENT.of(otherAccident)));
		if (autoAccident.equals("Yes")) {
			actor.attemptsTo(Enter.theValue(place).into(PLACE));
		}
		Serenity.takeScreenshot();
	}

	public static FillPatientAndInsuredCondition form() {
		return Tasks.instrumented(FillPatientAndInsuredCondition.class);
	}

}