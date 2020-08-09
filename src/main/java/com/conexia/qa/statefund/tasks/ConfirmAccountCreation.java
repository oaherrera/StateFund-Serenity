package com.conexia.qa.statefund.tasks;

import static com.conexia.qa.statefund.user_interfaces.SignUpPage.BUTTON_CONFIRM;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

public class ConfirmAccountCreation implements Task {

	@Override
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(Click.on(BUTTON_CONFIRM));
		Serenity.takeScreenshot();
	}

	public static ConfirmAccountCreation whitButton() {
		return Tasks.instrumented(ConfirmAccountCreation.class);
	}

}