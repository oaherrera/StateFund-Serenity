package com.conexia.qa.statefund.questions;

import com.conexia.qa.statefund.user_interfaces.ClaimSearchPage;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class TheFieldsAreEmpty implements Question<Boolean> {

	@Override
	public Boolean answeredBy(Actor actor) {
		Serenity.takeScreenshot();
		return ClaimSearchPage.FIRST_NAME.resolveFor(actor).getValue().isEmpty()
				&& ClaimSearchPage.LAST_NAME.resolveFor(actor).getValue().isEmpty()
				&& ClaimSearchPage.DATE_OF_INJURY.resolveFor(actor).getValue().isEmpty();
	}

	public static TheFieldsAreEmpty through() {
		return new TheFieldsAreEmpty();
	}

}