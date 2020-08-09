package com.conexia.qa.statefund.questions;

import static com.conexia.qa.statefund.user_interfaces.CommonPage.SUMMARY_TITLE;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class TheSummary implements Question<Boolean> {

	@Override
	public Boolean answeredBy(Actor actor) {
		return SUMMARY_TITLE.resolveFor(actor).isVisible();
	}

	public static TheSummary isShow() {
		return new TheSummary();
	}

}