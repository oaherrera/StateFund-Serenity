package com.conexia.qa.statefund.tasks;

import static com.conexia.qa.statefund.user_interfaces.TypeOfTransactionPage.TYPE;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;

public class FillTypeOfTransaction implements Task {

	@Override
	@Step("{0} Select the Type Of Transaction form")
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(Click.on(TYPE.of("Statement of Actual Services")),
				Click.on(TYPE.of("Request for Predetermination/Preauthorization")),
				Click.on(TYPE.of("EPSDT/Title X|X")));
		Serenity.takeScreenshot();
	}

	public static FillTypeOfTransaction form() {
		return Tasks.instrumented(FillTypeOfTransaction.class);
	}

}