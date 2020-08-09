package com.conexia.qa.statefund.tasks;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.thucydides.core.annotations.Step;

public class FillADAProcedureSelection implements Task {

	@Override
	@Step("{0} Fill the Procedure Selection ADA form")
	public <T extends Actor> void performAs(T actor) {
		Serenity.takeScreenshot();
		actor.attemptsTo(FillADAApprovedProcedureList.form());
	}

	public static FillADAProcedureSelection form() {
		return Tasks.instrumented(FillADAProcedureSelection.class);
	}

}