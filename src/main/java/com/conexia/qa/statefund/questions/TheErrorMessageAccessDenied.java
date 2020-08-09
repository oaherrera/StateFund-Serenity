package com.conexia.qa.statefund.questions;

import com.conexia.qa.statefund.interactions.WaitElement;
import com.conexia.qa.statefund.user_interfaces.LoginPage;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class TheErrorMessageAccessDenied implements Question<String> {

	@Override
	public String answeredBy(Actor actor) {
		actor.attemptsTo(WaitElement.untilAppears(LoginPage.ERROR_MESSAGE_ACCESS_DENIED));
		Serenity.takeScreenshot();
		return Text.of(LoginPage.ERROR_MESSAGE_ACCESS_DENIED).viewedBy(actor).asString();
	}

	public static TheErrorMessageAccessDenied displayed() {
		return new TheErrorMessageAccessDenied();
	}

}