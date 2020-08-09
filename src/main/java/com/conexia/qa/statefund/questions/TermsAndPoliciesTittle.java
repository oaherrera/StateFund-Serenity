package com.conexia.qa.statefund.questions;

import static com.conexia.qa.statefund.user_interfaces.SignUpPage.TERMS_AND_POLICIES_TITTLE;

import com.conexia.qa.statefund.interactions.WaitElement;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class TermsAndPoliciesTittle implements Question<Boolean> {

	@Override
	public Boolean answeredBy(Actor actor) {
		actor.attemptsTo(WaitElement.untilAppears(TERMS_AND_POLICIES_TITTLE));
		Serenity.takeScreenshot();
		return TERMS_AND_POLICIES_TITTLE.resolveFor(actor).isVisible();
	}

	public static TermsAndPoliciesTittle isShow() {
		return new TermsAndPoliciesTittle();
	}

}