package com.conexia.qa.statefund.questions;

import com.conexia.qa.statefund.user_interfaces.SearchUserPage;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class TheSearchedMiddleInitialIsShown implements Question<Boolean> {

	@Override
	public Boolean answeredBy(Actor actor) {
		Serenity.takeScreenshot();
		return SearchUserPage.MIDDLE_INITIAL_RESULT.resolveFor(actor).isPresent();
	}

	public static TheSearchedMiddleInitialIsShown onPortal() {
		return new TheSearchedMiddleInitialIsShown();
	}

}