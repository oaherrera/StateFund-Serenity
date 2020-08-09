package com.conexia.qa.statefund.questions;

import com.conexia.qa.statefund.user_interfaces.ClaimAdministratorInformationPage;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.targets.Target;

public class TheUnableToEdit implements Question<Boolean> {

	private String field;

	public TheUnableToEdit(String field) {
		this.field = field;
	}

	@Override
	public Boolean answeredBy(Actor actor) {
		Target element = null;
		switch (field) {
		case "Company Name":
			element = ClaimAdministratorInformationPage.COMPANY_NAME;
			break;

		default:
			break;
		}
		actor.attemptsTo(Scroll.to(element));
		Serenity.takeScreenshot();
		return !element.resolveFor(actor).isEnabled();
	}

	public static TheUnableToEdit inTheField(String field) {
		return new TheUnableToEdit(field);
	}

}