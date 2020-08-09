package com.conexia.qa.statefund.questions;

import static com.conexia.qa.statefund.user_interfaces.SignUpPage.TITTLE_LOGIN;

import com.conexia.qa.statefund.interactions.WaitElement;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ReturnLoginScreen implements Question<Boolean> {

	@Override
	public Boolean answeredBy(Actor actor) {
		actor.attemptsTo(WaitElement.untilAppears(TITTLE_LOGIN));
		Serenity.takeScreenshot();
		return TITTLE_LOGIN.resolveFor(actor).isVisible();
	}

	public static ReturnLoginScreen tittle() {
		return new ReturnLoginScreen();
	}

}