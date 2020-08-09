package com.conexia.qa.statefund.tasks;

import static com.conexia.qa.statefund.user_interfaces.LoginPage.CHECK_TERMS_AND_POLICIES;
import static com.conexia.qa.statefund.user_interfaces.LoginPage.LOGIN;
import static com.conexia.qa.statefund.user_interfaces.LoginPage.PASSWORD;
import static com.conexia.qa.statefund.user_interfaces.LoginPage.USER_NAME;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;

public class SingIn implements Task {

	private String user;
	private String password;

	public SingIn(String user) {
		this.user = user;
	}

	@Override
	@Step("{0} Sing in State Fund")
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(Enter.theValue(user).into(USER_NAME), Enter.theValue(password).into(PASSWORD),
				Click.on(CHECK_TERMS_AND_POLICIES));
		Serenity.takeScreenshot();
		actor.attemptsTo(Click.on(LOGIN));
	}

	public static SingIn withTheUser(String user) {
		return Tasks.instrumented(SingIn.class, user);
	}

	public SingIn andPassword(String password) {
		this.password = password;
		return this;
	}

}