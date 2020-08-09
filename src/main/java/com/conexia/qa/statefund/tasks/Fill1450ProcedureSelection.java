package com.conexia.qa.statefund.tasks;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.thucydides.core.annotations.Step;

public class Fill1450ProcedureSelection implements Task {

	@Override
	@Step("{0} Fill the Procedure Selection 1450 form")
	public <T extends Actor> void performAs(T actor) {
		Serenity.takeScreenshot();
		actor.attemptsTo(FillApprovedProcedureList.form());
	}

	public static Fill1450ProcedureSelection form() {
		return Tasks.instrumented(Fill1450ProcedureSelection.class);
	}

}