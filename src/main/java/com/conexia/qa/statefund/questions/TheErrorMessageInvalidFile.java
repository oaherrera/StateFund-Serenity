package com.conexia.qa.statefund.questions;

import static com.conexia.qa.statefund.user_interfaces.DocumentAttachmentPage.MESSAGE_INVALID_FILE;

import com.conexia.qa.statefund.interactions.WaitElement;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class TheErrorMessageInvalidFile implements Question<String> {

	@Override
	public String answeredBy(Actor actor) {
		actor.attemptsTo(WaitElement.untilBeEnabled(MESSAGE_INVALID_FILE));
		Serenity.takeScreenshot();
		return Text.of(MESSAGE_INVALID_FILE).viewedBy(actor).asString();
	}

	public static TheErrorMessageInvalidFile displayed() {
		return new TheErrorMessageInvalidFile();
	}

}