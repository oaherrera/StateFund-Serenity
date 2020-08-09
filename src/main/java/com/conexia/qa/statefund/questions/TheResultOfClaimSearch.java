package com.conexia.qa.statefund.questions;

import static com.conexia.qa.statefund.user_interfaces.ClaimSearchPage.NO_RESULTS_LABEL;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class TheResultOfClaimSearch implements Question<String> {

	@Override
	public String answeredBy(Actor actor) {
		Serenity.takeScreenshot();
		return Text.of(NO_RESULTS_LABEL).viewedBy(actor).asString();
	}

	public static TheResultOfClaimSearch is() {
		return new TheResultOfClaimSearch();
	}

}