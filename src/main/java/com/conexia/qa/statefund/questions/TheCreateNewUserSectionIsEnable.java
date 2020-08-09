package com.conexia.qa.statefund.questions;

import static com.conexia.qa.statefund.user_interfaces.MenuItemPage.CREATE_NEW_USER;
import static com.conexia.qa.statefund.user_interfaces.MenuItemPage.USER_MANAGEMENT;

import com.conexia.qa.statefund.interactions.AgreeTermsAndPolicies;
import com.conexia.qa.statefund.user_interfaces.CreateNewUserPage;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.actions.Click;

public class TheCreateNewUserSectionIsEnable implements Question<Boolean> {

	@Override
	public Boolean answeredBy(Actor actor) {
		actor.attemptsTo(AgreeTermsAndPolicies.afterLogin(), Click.on(USER_MANAGEMENT), Click.on(CREATE_NEW_USER));
		Serenity.takeScreenshot();
		return CreateNewUserPage.TITTLE.resolveFor(actor).isVisible();
	}

	public static TheCreateNewUserSectionIsEnable onPortal() {
		return new TheCreateNewUserSectionIsEnable();
	}

}