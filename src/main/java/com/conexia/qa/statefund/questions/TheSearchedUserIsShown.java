package com.conexia.qa.statefund.questions;

import com.conexia.qa.statefund.user_interfaces.SearchUserPage;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class TheSearchedUserIsShown implements Question<Boolean> {

	@Override
	public Boolean answeredBy(Actor actor) {
		Serenity.takeScreenshot();
		return SearchUserPage.USER_RESULT.resolveFor(actor).isPresent();
	}

	public static TheSearchedUserIsShown onPortal() {
		return new TheSearchedUserIsShown();
	}

}