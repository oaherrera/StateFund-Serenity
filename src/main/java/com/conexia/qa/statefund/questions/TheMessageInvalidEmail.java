package com.conexia.qa.statefund.questions;

import static com.conexia.qa.statefund.user_interfaces.SearchUserPage.MESSAGE_EMAIL_INVALID;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class TheMessageInvalidEmail implements Question<Boolean> {

	@Override
	public Boolean answeredBy(Actor actor) {
		Serenity.takeScreenshot();
		return MESSAGE_EMAIL_INVALID.resolveFor(actor).isVisible();
	}

	public static TheMessageInvalidEmail onPortal() {
		return new TheMessageInvalidEmail();
	}

}