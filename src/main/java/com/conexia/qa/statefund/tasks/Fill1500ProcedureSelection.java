package com.conexia.qa.statefund.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.thucydides.core.annotations.Step;

public class Fill1500ProcedureSelection implements Task {

	@Override
	@Step("{0} Fill the Procedure Selection 1500 form")
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(FillApprovedProcedureList.form());
	}

	public static Fill1500ProcedureSelection form() {
		return Tasks.instrumented(Fill1500ProcedureSelection.class);
	}

}