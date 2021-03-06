package com.conexia.qa.statefund.questions;

import static com.conexia.qa.statefund.user_interfaces.MenuItemPage.CREATE_NEW_USER;
import static com.conexia.qa.statefund.user_interfaces.MenuItemPage.USER_MANAGEMENT;

import com.conexia.qa.statefund.interactions.AgreeTermsAndPolicies;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

/**
 * @author ChristianSchottlaender
 **/
public class TheCreateNewUserSectionIsDisable implements Question<Boolean> {

	@Override
	public Boolean answeredBy(Actor actor) {
		actor.attemptsTo(AgreeTermsAndPolicies.afterLogin());
		Serenity.takeScreenshot();
		if (CREATE_NEW_USER.resolveFor(actor).isVisible() || USER_MANAGEMENT.resolveFor(actor).isVisible()) {
			return false;
		} else {
			return true;
		}
	}

	public static TheCreateNewUserSectionIsDisable onPortal() {
		return new TheCreateNewUserSectionIsDisable();
	}

}