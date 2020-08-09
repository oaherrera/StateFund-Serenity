package com.conexia.qa.statefund.questions;

import com.conexia.qa.statefund.user_interfaces.ClaimAdministratorInformationPage;
import com.conexia.qa.statefund.user_interfaces.CommonPage;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.targets.Target;

public class TheValueDisplayed implements Question<Boolean> {

	private String value, field;

	private TheValueDisplayed(String value) {
		this.value = value;
	}

	@Override
	public Boolean answeredBy(Actor actor) {
		Target element = null;
		actor.attemptsTo(Scroll.to(CommonPage.NEXT));
		Serenity.takeScreenshot();
		switch (field) {
		case "Company Name":
			element = ClaimAdministratorInformationPage.COMPANY_NAME;
			break;
		default:
			break;
		}
		return element.resolveFor(actor).getValue().equalsIgnoreCase(value);
	}

	public static TheValueDisplayed is(String value) {
		return new TheValueDisplayed(value);
	}

	public TheValueDisplayed from(String field) {
		this.field = field;
		return this;
	}

}