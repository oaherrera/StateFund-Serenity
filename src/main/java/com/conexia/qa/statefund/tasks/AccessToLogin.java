package com.conexia.qa.statefund.tasks;

import static com.conexia.qa.statefund.user_interfaces.ForgotPasswordPage.LINK_TERMS_AND_POLICIES;
import static com.conexia.qa.statefund.user_interfaces.LoginPage.FORGOT_YOUR_PASSWORD;
import static com.conexia.qa.statefund.user_interfaces.LoginPage.SIGN_UP;
import static com.conexia.qa.statefund.user_interfaces.LoginPage.TERMS_AND_POLICIES;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;

public class AccessToLogin implements Task {

	private String link;

	public AccessToLogin(String link) {
		this.link = link;
	}

	@Override
	@Step("{0} Clicks on #link")
	public <T extends Actor> void performAs(T actor) {
		Serenity.takeScreenshot();
		switch (link) {
		case "Accept Terms and Policies":
			actor.attemptsTo(Click.on(TERMS_AND_POLICIES));
			break;
		case "Terms and Policies":
			actor.attemptsTo(Click.on(LINK_TERMS_AND_POLICIES));
			break;
		case "Forgot your password":
			actor.attemptsTo(Click.on(FORGOT_YOUR_PASSWORD));
			break;
		case "Sign up":
			actor.attemptsTo(Click.on(SIGN_UP));
			break;
		default:
			break;
		}
	}

	public static AccessToLogin link(String link) {
		return Tasks.instrumented(AccessToLogin.class, link);
	}

}