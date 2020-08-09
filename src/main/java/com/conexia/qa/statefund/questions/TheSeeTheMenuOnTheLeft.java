package com.conexia.qa.statefund.questions;

import com.conexia.qa.statefund.user_interfaces.HomePage;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class TheSeeTheMenuOnTheLeft implements Question<Boolean> {

	@Override
	public Boolean answeredBy(Actor actor) {
		Serenity.takeScreenshot();
		return HomePage.MENU_LEFT.resolveFor(actor).isPresent();
	}

	public static TheHomeScreen onPortal() {
		return new TheHomeScreen();
	}

}