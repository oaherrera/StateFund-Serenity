package com.conexia.qa.statefund.questions;

import com.conexia.qa.statefund.interactions.WaitElement;
import com.conexia.qa.statefund.interactions.WaitLoading;
import com.conexia.qa.statefund.user_interfaces.CommonPage;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class TheErrorMessageAlert implements Question<String> {

	private int result = 0;

	private TheErrorMessageAlert(int result) {
		this.result = result;
	}

	@Override
	public String answeredBy(Actor actor) {
		String message = null;
		actor.attemptsTo(WaitLoading.page(),
				WaitElement.untilBeEnabled(CommonPage.ERROR_MESSAGE_ALERT.of(String.valueOf(result))));
		message = Text.of(CommonPage.ERROR_MESSAGE_ALERT.of(String.valueOf(result))).viewedBy(actor).asString()
				.replace("\n", " ");
		Serenity.takeScreenshot();
		return message;
	}

	public static TheErrorMessageAlert displayed(int result) {
		return new TheErrorMessageAlert(result);
	}

}