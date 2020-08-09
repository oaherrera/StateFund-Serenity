package com.conexia.qa.statefund.questions;

import com.conexia.qa.statefund.tasks.SelectDateFromCalendar;
import com.conexia.qa.statefund.user_interfaces.ClaimSearchPage;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class TheSelectDate implements Question<String> {

	@Override
	public String answeredBy(Actor actor) {
		actor.attemptsTo(SelectDateFromCalendar.actual());
		Serenity.takeScreenshot();
		return ClaimSearchPage.DATE_OF_INJURY.resolveFor(actor).getValue();
	}

	public static TheSelectDate is() {
		return new TheSelectDate();
	}

}