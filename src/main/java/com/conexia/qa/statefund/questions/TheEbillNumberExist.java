package com.conexia.qa.statefund.questions;

import static com.conexia.qa.statefund.user_interfaces.EbillHistoryPage.EBILL_ID;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class TheEbillNumberExist implements Question<Boolean> {

	@Override
	public Boolean answeredBy(Actor actor) {
		Serenity.takeScreenshot();
		return EBILL_ID.of(actor.gaveAsThe("ebillNumber").toString()).resolveFor(actor).isVisible();
	}

	public static TheEbillNumberExist onHistory() {
		return new TheEbillNumberExist();
	}

}