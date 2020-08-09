package com.conexia.qa.statefund.questions;

import static com.conexia.qa.statefund.user_interfaces.DocumentAttachmentPage.MESSAGE_RECORD_NOT_FOUND;

import com.conexia.qa.statefund.interactions.WaitElement;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ItWasDeleted implements Question<Boolean> {

	@Override
	public Boolean answeredBy(Actor actor) {
		actor.attemptsTo(WaitElement.untilAppears(MESSAGE_RECORD_NOT_FOUND));
		Serenity.takeScreenshot();
		return MESSAGE_RECORD_NOT_FOUND.resolveFor(actor).isVisible();
	}

	public static ItWasDeleted theAttachment() {
		return new ItWasDeleted();
	}

}