package com.conexia.qa.statefund.tasks;

import static com.conexia.qa.statefund.user_interfaces.DiagnosisADAPage.REMARKS;
import static com.conexia.qa.statefund.user_interfaces.DiagnosisADAPage.TITTLE;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.thucydides.core.annotations.Step;

public class FillADADiagnosis implements Task {

	private String remarks;

	public FillADADiagnosis() {
		this.remarks = "test 1234";
	}

	@Override
	@Step("{0} Fill the Diagnosis ADA form")
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(Scroll.to(TITTLE), Enter.theValue(remarks).into(REMARKS));
		Serenity.takeScreenshot();
	}

	public static FillADADiagnosis form() {
		return Tasks.instrumented(FillADADiagnosis.class);
	}

}