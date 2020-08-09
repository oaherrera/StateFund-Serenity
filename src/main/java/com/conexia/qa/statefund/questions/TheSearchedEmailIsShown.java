package com.conexia.qa.statefund.questions;

import com.conexia.qa.statefund.user_interfaces.SearchUserPage;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class TheSearchedEmailIsShown implements Question<Boolean> {

	@Override
	public Boolean answeredBy(Actor actor) {
		Serenity.takeScreenshot();
		return SearchUserPage.EMAIL_RESULT.resolveFor(actor).isPresent();
	}

	public static TheSearchedEmailIsShown onPortal() {
		return new TheSearchedEmailIsShown();
	}

}