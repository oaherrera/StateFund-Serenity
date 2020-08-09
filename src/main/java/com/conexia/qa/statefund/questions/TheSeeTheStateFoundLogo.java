package com.conexia.qa.statefund.questions;

import com.conexia.qa.statefund.user_interfaces.HomePage;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class TheSeeTheStateFoundLogo implements Question<Boolean> {

	@Override
	public Boolean answeredBy(Actor actor) {
		Serenity.takeScreenshot();
		return HomePage.LOGO_STATE_FOUND.resolveFor(actor).isPresent();
	}

	public static TheSeeTheStateFoundLogo onPortal() {
		return new TheSeeTheStateFoundLogo();
	}

}