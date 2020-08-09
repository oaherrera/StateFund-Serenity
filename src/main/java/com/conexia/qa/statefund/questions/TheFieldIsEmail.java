package com.conexia.qa.statefund.questions;

import java.util.List;

import com.conexia.qa.statefund.interactions.EmailAddress;
import com.conexia.qa.statefund.user_interfaces.CommonPage;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class TheFieldIsEmail implements Question<Boolean> {

	private List<String> emailAddress;

	private TheFieldIsEmail(List<String> emailAddress) {
		this.emailAddress = emailAddress;
	}

	@Override
	public Boolean answeredBy(Actor actor) {
		boolean displayed = false;
		actor.attemptsTo(EmailAddress.isField(emailAddress, true));
		try {
			CommonPage.ERROR_MESSAGE.resolveFor(actor).isDisplayed();
		} catch (Exception e) {
			displayed = true;
		}
		return displayed;
	}

	public static TheFieldIsEmail inEmailAddress(List<String> emailAddress) {
		return new TheFieldIsEmail(emailAddress);
	}

}