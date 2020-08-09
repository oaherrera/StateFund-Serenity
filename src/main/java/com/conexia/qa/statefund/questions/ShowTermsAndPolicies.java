package com.conexia.qa.statefund.questions;

import com.conexia.qa.statefund.interactions.WaitElement;
import com.conexia.qa.statefund.user_interfaces.ForgotPasswordPage;
import com.conexia.qa.statefund.user_interfaces.LoginPage;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;

public class ShowTermsAndPolicies implements Question<Boolean> {

	private boolean forgotPassword;

	private ShowTermsAndPolicies() {
	}

	private ShowTermsAndPolicies(boolean forgotPassword) {
		this.forgotPassword = forgotPassword;
	}

	@Override
	public Boolean answeredBy(Actor actor) {
		Target element = null;
		if (forgotPassword) {
			element = ForgotPasswordPage.POP_UP_TERMS_AND_POLICIES;
		} else {
			element = LoginPage.POP_UP_TERMS_AND_POLICIES;
		}
		actor.attemptsTo(WaitElement.untilAppears(element));
		Serenity.takeScreenshot();
		return element.resolveFor(actor).isVisible();
	}

	public static ShowTermsAndPolicies popUp() {
		return new ShowTermsAndPolicies();
	}

	public static ShowTermsAndPolicies popUpForgotPassword() {
		return new ShowTermsAndPolicies(true);
	}

}