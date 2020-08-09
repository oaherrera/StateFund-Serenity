package com.conexia.qa.statefund.questions;

import static com.conexia.qa.statefund.user_interfaces.LoginPage.ERROR_MESSAGE;

import com.conexia.qa.statefund.interactions.WaitElement;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.targets.Target;

public class TheErrorMessage implements Question<String> {

	private boolean isSpan;

	private TheErrorMessage(boolean isSpan) {
		this.isSpan = isSpan;
	}

	@Override
	public String answeredBy(Actor actor) {
		Target element = null;
		if (!isSpan) {
			actor.attemptsTo(WaitElement.untilBeEnabled(ERROR_MESSAGE.of("p")));
			element = ERROR_MESSAGE.of("p");
		} else {
			actor.attemptsTo(WaitElement.untilBeEnabled(ERROR_MESSAGE.of("span")));
			element = ERROR_MESSAGE.of("span");
		}
		Serenity.takeScreenshot();
		return Text.of(element).viewedBy(actor).asString();
	}

	public static TheErrorMessage displayed() {
		return new TheErrorMessage(false);
	}

	public static TheErrorMessage displayedSpanError() {
		return new TheErrorMessage(true);
	}

}