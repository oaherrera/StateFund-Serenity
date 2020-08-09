package com.conexia.qa.statefund.questions;

import com.conexia.qa.statefund.user_interfaces.ClaimDetailsPage;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class TheDetailsOfClaim implements Question<String> {

	private String name;
	private String dateOfInjury;
	private String employerName;

	@Override
	public String answeredBy(Actor actor) {
		name = Text.of(ClaimDetailsPage.INJURED_WORKER_NAME).viewedBy(actor).asString();
		dateOfInjury = Text.of(ClaimDetailsPage.DATE_OF_INJURY).viewedBy(actor).asString();
		employerName = Text.of(ClaimDetailsPage.EMPLOYER_NAME).viewedBy(actor).asString();
		Serenity.takeScreenshot();
		return name + " - " + dateOfInjury + " - " + employerName;
	}

	public static TheDetailsOfClaim is() {
		return new TheDetailsOfClaim();
	}

}