package com.conexia.qa.statefund.questions;

import com.conexia.qa.statefund.user_interfaces.ClaimSearchPage;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class TheClaimSearch implements Question<String> {

	@Override
	public String answeredBy(Actor actor) {
		Serenity.takeScreenshot();
		return Text.of(ClaimSearchPage.NO_RESULTS_LABEL).viewedBy(actor).asString().replace("\nSubmit a Non-Claim RFA",
				"");
	}

	public static TheClaimSearch theRecordWasNotFound() {
		return new TheClaimSearch();
	}

}