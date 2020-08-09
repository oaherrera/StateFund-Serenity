package com.conexia.qa.statefund.questions;

import com.conexia.qa.statefund.user_interfaces.ForgotPasswordPage;
import com.conexia.qa.statefund.user_interfaces.LoginPage;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;

public class Return implements Question<Boolean> {

	private static String page;
	private static String link;

	private Return(boolean differencer, String parameter) {
		if (differencer) {
			link = parameter;
		} else {
			page = parameter;
		}
	}

	@Override
	public Boolean answeredBy(Actor actor) {
		Target pageElement = null, linkElement = null;
		Serenity.takeScreenshot();
		switch (page) {
		case "login":
			pageElement = LoginPage.LOGIN;
			break;
		default:
			break;
		}

		switch (link) {
		case "Back to Login":
			linkElement = ForgotPasswordPage.BACK_TO_LOGIN_LINK;
			break;
		default:
			break;
		}
		actor.attemptsTo(Click.on(linkElement));
		Serenity.takeScreenshot();
		return pageElement.resolveFor(actor).isDisplayed();
	}

	public static Return toPage(String page) {
		return new Return(false, page);
	}

	public Return trought(String link) {
		return new Return(true, link);
	}

}