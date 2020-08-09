package com.conexia.qa.statefund.questions;

import com.conexia.qa.statefund.user_interfaces.ForgotPasswordPage;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;

public class TheField implements Question<Boolean> {

	private String field;

	private TheField(String field) {
		this.field = field;
	}

	@Override
	public Boolean answeredBy(Actor actor) {
		Target element = null;
		switch (field) {
		case "Email":
			element = ForgotPasswordPage.EMAIL_ADDRESS;
			break;
		default:
			break;
		}
		Serenity.takeScreenshot();
		return element.resolveFor(actor).isDisplayed();
	}

	public static TheField isDisplayed(String field) {
		return new TheField(field);
	}

}