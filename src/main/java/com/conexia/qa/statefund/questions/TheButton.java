package com.conexia.qa.statefund.questions;

import com.conexia.qa.statefund.interactions.Swipe;
import com.conexia.qa.statefund.user_interfaces.ClaimDetailsPage;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.targets.Target;

public class TheButton implements Question<Boolean> {

	private String button;

	private TheButton(String button) {
		this.button = button;
	}

	@Override
	public Boolean answeredBy(Actor actor) {
		Target element = null;
		switch (button) {
		case "Requested Body Parts":
			element = ClaimDetailsPage.REQUESTED_BODY_PARTS;
			break;
		case "Related Claim":
			element = ClaimDetailsPage.RELATED_CLAIMS;
			break;
		case "RFA":
			element = ClaimDetailsPage.SUBMIT_RFA;
			break;
		case "Saved Draft":
			element = ClaimDetailsPage.SAVED_DRAFTS;
			break;
		default:
			break;
		}
		actor.attemptsTo(Scroll.to(element), Swipe.vertical(-100));
		Serenity.takeScreenshot();
		return element.resolveFor(actor).isVisible();
	}

	public static TheButton isDisplayed(String button) {
		return new TheButton(button);
	}

}