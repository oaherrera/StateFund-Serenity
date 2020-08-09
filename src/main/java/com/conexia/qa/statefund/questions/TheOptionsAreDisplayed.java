package com.conexia.qa.statefund.questions;

import com.conexia.qa.statefund.interactions.Swipe;
import com.conexia.qa.statefund.models.WorkerInformation;
import com.conexia.qa.statefund.user_interfaces.RequestForAuthorizationPage;
import com.conexia.qa.statefund.user_interfaces.WorkersInformationPage;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.actions.Scroll;

public class TheOptionsAreDisplayed implements Question<Boolean> {

	@Override
	public Boolean answeredBy(Actor actor) {
		actor.attemptsTo(
				Scroll.to(RequestForAuthorizationPage.CLAIM_NUMBER.of(WorkerInformation.readData(0).getClaimNumber())),
				Swipe.vertical(-200));
		if (WorkersInformationPage.RFA_TYPE_LABEL.resolveFor(actor).isDisplayed()) {
			actor.attemptsTo(Scroll.to(WorkersInformationPage.RFA_TYPE_LABEL), Swipe.vertical(-100));
			Serenity.takeScreenshot();
		}
		return WorkersInformationPage.RFA_TYPE_OPTION_NEW_REQUEST.resolveFor(actor).isDisplayed()
				&& WorkersInformationPage.RFA_TYPE_OPTION_RESUBMISSION.resolveFor(actor).isDisplayed()
				&& WorkersInformationPage.RFA_TYPE_OPTION_EXPEDITED.resolveFor(actor).isDisplayed()
				&& WorkersInformationPage.RFA_TYPE_OPTION_WRITTEN_CONFIRMATION_OR_PRIOR_ORAL_REQUEST.resolveFor(actor)
						.isDisplayed();
	}

	public static TheOptionsAreDisplayed fromFieldRFAType() {
		return new TheOptionsAreDisplayed();
	}

}