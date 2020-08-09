package com.conexia.qa.statefund.tasks;

import com.conexia.qa.statefund.user_interfaces.CreateNewUserPage;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

public class AccessToCreateNewUser implements Task {

	@Override
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(Click.on(CreateNewUserPage.USER_MANAGEMENT), Click.on(CreateNewUserPage.CREATE_NEW_USER));
		Serenity.takeScreenshot();
	}

	public static AccessToCreateNewUser menu() {
		return Tasks.instrumented(AccessToCreateNewUser.class);
	}

}