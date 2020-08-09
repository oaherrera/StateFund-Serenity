package com.conexia.qa.statefund.questions;

import static com.conexia.qa.statefund.user_interfaces.CreateNewUserPage.USER_MANAGEMENT;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class TheAdministratorUserIsShow implements Question<Boolean> {

	@Override
	public Boolean answeredBy(Actor actor) {
		Serenity.takeScreenshot();
		return USER_MANAGEMENT.resolveFor(actor).isVisible();
	}

	public static TheAdministratorUserIsShow onTheMenu() {
		return new TheAdministratorUserIsShow();
	}

}