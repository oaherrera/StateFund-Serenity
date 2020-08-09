package com.conexia.qa.statefund.questions;

import static com.conexia.qa.statefund.user_interfaces.CommonPage.SUBMIT;
import static com.conexia.qa.statefund.user_interfaces.ForgotPasswordPage.BACK_TO_LOGIN_BUTTON;
import static com.conexia.qa.statefund.user_interfaces.ForgotPasswordPage.CHECK_TERMS_AND_POLICIES;
import static com.conexia.qa.statefund.user_interfaces.ForgotPasswordPage.EMAIL_ADDRESS;
import static com.conexia.qa.statefund.user_interfaces.ForgotPasswordPage.MESSAGE_OF_REQUEST;

import java.util.List;

import com.conexia.qa.statefund.interactions.WaitLoading;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

public class PasswordRecovery implements Question<Boolean> {

	private List<String> email;

	private PasswordRecovery(List<String> email) {
		this.email = email;
	}

	@Override
	public Boolean answeredBy(Actor actor) {
		actor.attemptsTo(Enter.theValue(email.get(1)).into(EMAIL_ADDRESS), Click.on(CHECK_TERMS_AND_POLICIES));
		Serenity.takeScreenshot();
		actor.attemptsTo(Click.on(SUBMIT), WaitLoading.page());
		Serenity.takeScreenshot();
		return MESSAGE_OF_REQUEST.resolveFor(actor).isDisplayed()
				&& BACK_TO_LOGIN_BUTTON.resolveFor(actor).isDisplayed();
	}

	public static PasswordRecovery request(List<String> email) {
		return new PasswordRecovery(email);
	}

}