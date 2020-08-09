package com.conexia.qa.statefund.questions;

import static com.conexia.qa.statefund.user_interfaces.MenuItemPage.INBOX;
import static com.conexia.qa.statefund.user_interfaces.MenuItemPage.USER_MANAGEMENT;

import com.conexia.qa.statefund.interactions.AgreeTermsAndPolicies;
import com.conexia.qa.statefund.user_interfaces.InboxPage;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.actions.Click;

public class TheInboxSectionIsEnable implements Question<Boolean> {

	@Override
	public Boolean answeredBy(Actor actor) {
		actor.attemptsTo(AgreeTermsAndPolicies.afterLogin(), Click.on(USER_MANAGEMENT), Click.on(INBOX));
		Serenity.takeScreenshot();
		return InboxPage.TITTLE.resolveFor(actor).isVisible();
	}

	public static TheInboxSectionIsEnable onPortal() {
		return new TheInboxSectionIsEnable();
	}

}