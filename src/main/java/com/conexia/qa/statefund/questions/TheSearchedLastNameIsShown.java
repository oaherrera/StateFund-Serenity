package com.conexia.qa.statefund.questions;

import com.conexia.qa.statefund.user_interfaces.SearchUserPage;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class TheSearchedLastNameIsShown implements Question<Boolean> {

	@Override
	public Boolean answeredBy(Actor actor) {
		Serenity.takeScreenshot();
		return SearchUserPage.LAST_NAME.resolveFor(actor).isPresent();
	}

	public static TheSearchedLastNameIsShown onPortal() {
		return new TheSearchedLastNameIsShown();
	}

}