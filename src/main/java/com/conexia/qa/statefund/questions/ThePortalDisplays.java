package com.conexia.qa.statefund.questions;

import static net.serenitybdd.core.Serenity.takeScreenshot;

import com.conexia.qa.statefund.user_interfaces.CreateNewUserPage;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ThePortalDisplays implements Question<Boolean> {

	private String message;

	public ThePortalDisplays(String message) {
		this.message = message.trim();
	}

	@Override
	public Boolean answeredBy(Actor actor) {
		takeScreenshot();
		return CreateNewUserPage.MESSAGE_USER_CREATED.of(message).resolveFor(actor).isVisible();
	}

	public static ThePortalDisplays theMessages(String message) {
		return new ThePortalDisplays(message);
	}

}