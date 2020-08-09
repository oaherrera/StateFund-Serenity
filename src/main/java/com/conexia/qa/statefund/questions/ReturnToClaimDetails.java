package com.conexia.qa.statefund.questions;

import static com.conexia.qa.statefund.user_interfaces.ClaimSearchPage.TITTLE_CLAIM_DETAILS;

import com.conexia.qa.statefund.interactions.WaitElement;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ReturnToClaimDetails implements Question<Boolean> {

	@Override
	public Boolean answeredBy(Actor actor) {
		actor.attemptsTo(WaitElement.untilAppears(TITTLE_CLAIM_DETAILS));
		Serenity.takeScreenshot();
		return TITTLE_CLAIM_DETAILS.resolveFor(actor).isVisible();
	}

	public static ReturnToClaimDetails tittle() {
		return new ReturnToClaimDetails();
	}

}