package com.conexia.qa.statefund.questions;

import static com.conexia.qa.statefund.user_interfaces.ClaimDetailsPage.REQUEST_FOR_AUTORIZATION_CLAIM_NUMBER;
import static net.serenitybdd.core.Serenity.takeScreenshot;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

/**
 * @author ChristianCamiloSchottlaender
 */
public class FormAfterEditDraft implements Question<Boolean> {

	private String claimNumber;

	public FormAfterEditDraft(String claimNumber) {
		this.claimNumber = claimNumber;
	}

	@Override
	public Boolean answeredBy(Actor actor) {
		takeScreenshot();
		return REQUEST_FOR_AUTORIZATION_CLAIM_NUMBER.of(claimNumber).resolveFor(actor).isVisible();
	}

	public static FormAfterEditDraft seeToRfaOfClaim(String claimNumber) {
		return new FormAfterEditDraft(claimNumber);
	}

}