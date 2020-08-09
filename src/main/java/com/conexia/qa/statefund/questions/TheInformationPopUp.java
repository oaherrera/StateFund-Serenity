package com.conexia.qa.statefund.questions;

import com.conexia.qa.statefund.interactions.Swipe;
import com.conexia.qa.statefund.interactions.WaitLoading;
import com.conexia.qa.statefund.user_interfaces.ClaimDetailsPage;
import com.conexia.qa.statefund.user_interfaces.RequestedBodyPartsPage;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.targets.Target;

public class TheInformationPopUp implements Question<String> {

	private String popUp;
	private String requestBodyPartsDescription;
	private String requestBodyPartsDecision;

	private TheInformationPopUp(String popUp) {
		this.popUp = popUp;
	}

	@Override
	public String answeredBy(Actor actor) {
		String informationPopUp = null;
		Target element = null;
		switch (popUp) {
		case "Requested Body Parts":
			element = ClaimDetailsPage.REQUESTED_BODY_PARTS;
			actor.attemptsTo(Scroll.to(element), Swipe.vertical(-100));
			Serenity.takeScreenshot();
			actor.attemptsTo(Click.on(element), WaitLoading.page());
			requestBodyPartsDescription = Text.of(RequestedBodyPartsPage.REQUESTED_BODY_PARTS).viewedBy(actor)
					.asString();
			requestBodyPartsDecision = Text.of(RequestedBodyPartsPage.DECISION).viewedBy(actor).asString();
			informationPopUp = requestBodyPartsDescription + " " + requestBodyPartsDecision;
			break;
		case "Related Claim":
			element = ClaimDetailsPage.RELATED_CLAIMS;
			actor.attemptsTo(Scroll.to(element), Swipe.vertical(-100));
			Serenity.takeScreenshot();
			actor.attemptsTo(Click.on(element), WaitLoading.page());
			break;
		default:
			break;
		}
		Serenity.takeScreenshot();
		return informationPopUp;
	}

	public static TheInformationPopUp is(String popUp) {
		return new TheInformationPopUp(popUp);
	}

}