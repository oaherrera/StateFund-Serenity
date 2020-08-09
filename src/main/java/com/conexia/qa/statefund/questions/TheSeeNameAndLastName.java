package com.conexia.qa.statefund.questions;

import com.conexia.qa.statefund.user_interfaces.HomePage;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class TheSeeNameAndLastName implements Question<Boolean> {

	@Override
	public Boolean answeredBy(Actor actor) {
		Serenity.takeScreenshot();
		return HomePage.NAME_And_LAST_NAME.resolveFor(actor).isPresent();
	}

	public static TheSeeNameAndLastName onPortal() {
		return new TheSeeNameAndLastName();
	}

}