package com.conexia.qa.statefund.tasks;

import static com.conexia.qa.statefund.user_interfaces.SignUpPage.BACK_TO_LOGIN;

import com.conexia.qa.statefund.interactions.Sleep;
import com.conexia.qa.statefund.user_interfaces.SignUpPage;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.thucydides.core.annotations.Step;

public class ReturnToLogin implements Task {

	@Override
	@Step("{0} Click Button Back to Login ")
	public <T extends Actor> void performAs(T actor) {
		Serenity.takeScreenshot();
		actor.attemptsTo(Scroll.to(BACK_TO_LOGIN), Sleep.by(2000));
		Serenity.takeScreenshot();
		actor.attemptsTo(Click.on(SignUpPage.BACK_TO_LOGIN));
		Serenity.takeScreenshot();
	}

	public static ReturnToLogin whitButton() {
		return Tasks.instrumented(ReturnToLogin.class);
	}

}