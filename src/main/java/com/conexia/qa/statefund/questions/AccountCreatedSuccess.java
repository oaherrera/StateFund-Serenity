package com.conexia.qa.statefund.questions;

import static com.conexia.qa.statefund.user_interfaces.SignUpPage.ACCOUNT_CREATED_SUCCESSFULLY;

import com.conexia.qa.statefund.interactions.WaitElement;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class AccountCreatedSuccess implements Question<Boolean> {

	@Override
	public Boolean answeredBy(Actor actor) {
		actor.attemptsTo(WaitElement.untilAppears(ACCOUNT_CREATED_SUCCESSFULLY));
		Serenity.takeScreenshot();
		return ACCOUNT_CREATED_SUCCESSFULLY.resolveFor(actor).isVisible();
	}

	public static AccountCreatedSuccess isShow() {
		return new AccountCreatedSuccess();
	}

}