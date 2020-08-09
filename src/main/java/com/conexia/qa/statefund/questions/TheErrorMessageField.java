package com.conexia.qa.statefund.questions;

import com.conexia.qa.statefund.interactions.WaitElement;
import com.conexia.qa.statefund.user_interfaces.CommonPage;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.targets.Target;

public class TheErrorMessageField implements Question<String> {

	private String message;

	private TheErrorMessageField(String message) {
		this.message = message;
	}

	@Override
	public String answeredBy(Actor actor) {
		Target element = null;
		switch (message) {
		case "This field is required":
			element = CommonPage.ERROR_MESSAGE;
			break;
		case "The email is invalid, Please enter a valid email address":
			element = CommonPage.ERROR_MESSAGE;
			break;
		case "Quantity is required.":
			element = CommonPage.ERROR_MESSAGES;
			break;
		default:
			break;
		}
		actor.attemptsTo(WaitElement.untilBeEnabled(element));
		Serenity.takeScreenshot();
		return Text.of(element).viewedBy(actor).asString();
	}

	public static TheErrorMessageField displayed(String message) {
		return new TheErrorMessageField(message);
	}

}