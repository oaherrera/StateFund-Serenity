package com.conexia.qa.statefund.questions;

import static com.conexia.qa.statefund.user_interfaces.ClaimSearchPage.RESULT_DATE_OF_INJURY;
import static com.conexia.qa.statefund.user_interfaces.ClaimSearchPage.RESULT_FIRST_NAME;
import static com.conexia.qa.statefund.user_interfaces.ClaimSearchPage.RESULT_LAST_NAME;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class TheSearchGenerated implements Question<String> {

	private String firstName;
	private String lastName;
	private String dateOfInjury;

	@Override
	public String answeredBy(Actor actor) {
		Serenity.takeScreenshot();
		firstName = Text.of(RESULT_FIRST_NAME).viewedBy(actor).asString();
		lastName = Text.of(RESULT_LAST_NAME).viewedBy(actor).asString();
		dateOfInjury = Text.of(RESULT_DATE_OF_INJURY).viewedBy(actor).asString().replace("/", "");

		return firstName + " - " + lastName + " - " + dateOfInjury;
	}

	public static TheSearchGenerated is() {
		return new TheSearchGenerated();
	}

}