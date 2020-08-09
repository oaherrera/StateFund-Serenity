package com.conexia.qa.statefund.tasks;

import static com.conexia.qa.statefund.user_interfaces.Diagnosis1450Page.RESERVED_FOR_ASSIGMENT_BY_THE_NUBC;
import static com.conexia.qa.statefund.user_interfaces.Diagnosis1450Page.TITTLE;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.thucydides.core.annotations.Step;

public class Fill1450Diagnosis implements Task {

	private String reservedForAssigmentByTheNUBC;

	public Fill1450Diagnosis() {
		this.reservedForAssigmentByTheNUBC = "test1234";
	}

	@Override
	@Step("{0} Fill the Diagnosis 1450 form")
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(Scroll.to(TITTLE),
				Enter.theValue(reservedForAssigmentByTheNUBC).into(RESERVED_FOR_ASSIGMENT_BY_THE_NUBC));
		Serenity.takeScreenshot();
	}

	public static Fill1450Diagnosis form() {
		return Tasks.instrumented(Fill1450Diagnosis.class);
	}

}