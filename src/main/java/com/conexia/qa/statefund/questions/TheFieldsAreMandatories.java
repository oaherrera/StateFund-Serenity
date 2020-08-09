package com.conexia.qa.statefund.questions;

import static com.conexia.qa.statefund.user_interfaces.ClaimSearchPage.FIRST_NAME_LABEL;

import com.conexia.qa.statefund.user_interfaces.ClaimSearchPage;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class TheFieldsAreMandatories implements Question<Boolean> {

	@Override
	public Boolean answeredBy(Actor actor) {
		Serenity.takeScreenshot();
		return FIRST_NAME_LABEL.resolveFor(actor).isVisible()
				&& ClaimSearchPage.LAST_NAME_LABEL.resolveFor(actor).isVisible();
	}

	public static TheFieldsAreMandatories withAsterisk() {
		return new TheFieldsAreMandatories();
	}

}