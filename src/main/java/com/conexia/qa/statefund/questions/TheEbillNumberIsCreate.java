package com.conexia.qa.statefund.questions;

import static com.conexia.qa.statefund.user_interfaces.CommonPage.EBILL_NUMBER;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class TheEbillNumberIsCreate implements Question<Boolean> {

	@Override
	public Boolean answeredBy(Actor actor) {
		Serenity.takeScreenshot();
		return EBILL_NUMBER.resolveFor(actor).isVisible();
	}

	public static TheEbillNumberIsCreate correctly() {
		return new TheEbillNumberIsCreate();
	}

}