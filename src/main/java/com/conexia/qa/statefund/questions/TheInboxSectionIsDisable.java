package com.conexia.qa.statefund.questions;

import static com.conexia.qa.statefund.user_interfaces.MenuItemPage.USER_MANAGEMENT;

import com.conexia.qa.statefund.interactions.AgreeTermsAndPolicies;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class TheInboxSectionIsDisable implements Question<Boolean> {

	@Override
	public Boolean answeredBy(Actor actor) {
		actor.attemptsTo(AgreeTermsAndPolicies.afterLogin());
		Serenity.takeScreenshot();
		return !USER_MANAGEMENT.resolveFor(actor).isVisible();
	}

	public static TheInboxSectionIsDisable onPortal() {
		return new TheInboxSectionIsDisable();
	}

}