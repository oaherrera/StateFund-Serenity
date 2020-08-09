package com.conexia.qa.statefund.questions;

import com.conexia.qa.statefund.interactions.Type;
import com.conexia.qa.statefund.user_interfaces.ClaimSearchPage;
import com.conexia.qa.statefund.utils.DateFunctions;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class TheEnterDate implements Question<String> {

	@Override
	public String answeredBy(Actor actor) {
		actor.attemptsTo(Type.theNumber(DateFunctions.actualDate()).into(ClaimSearchPage.DATE_OF_INJURY));
		Serenity.takeScreenshot();
		return ClaimSearchPage.DATE_OF_INJURY.resolveFor(actor).getValue();
	}

	public static TheEnterDate is() {
		return new TheEnterDate();
	}

}