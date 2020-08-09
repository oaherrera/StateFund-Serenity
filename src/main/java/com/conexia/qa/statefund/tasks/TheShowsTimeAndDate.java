package com.conexia.qa.statefund.tasks;

import com.conexia.qa.statefund.user_interfaces.HomePage;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class TheShowsTimeAndDate implements Question<Boolean> {

	@Override
	public Boolean answeredBy(Actor actor) {
		Serenity.takeScreenshot();
		return HomePage.CLOCK.resolveFor(actor).isPresent();
	}

	public static TheShowsTimeAndDate onPortal() {
		return new TheShowsTimeAndDate();
	}

}