package com.conexia.qa.statefund.questions;

import static com.conexia.qa.statefund.user_interfaces.MenuItemPage.SEARCH_USER;
import static com.conexia.qa.statefund.user_interfaces.MenuItemPage.USER_MANAGEMENT;

import com.conexia.qa.statefund.interactions.AgreeTermsAndPolicies;
import com.conexia.qa.statefund.user_interfaces.SearchUserPage;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.actions.Click;

public class TheSearchUserSectionIsEnable implements Question<Boolean> {

	@Override
	public Boolean answeredBy(Actor actor) {
		actor.attemptsTo(AgreeTermsAndPolicies.afterLogin(), Click.on(USER_MANAGEMENT), Click.on(SEARCH_USER));
		Serenity.takeScreenshot();
		return SearchUserPage.TITTLE.resolveFor(actor).isVisible();
	}

	public static TheSearchUserSectionIsEnable onPortal() {
		return new TheSearchUserSectionIsEnable();
	}

}