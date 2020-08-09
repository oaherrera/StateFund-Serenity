package com.conexia.qa.statefund.questions;

import static net.serenitybdd.core.Serenity.takeScreenshot;

import com.conexia.qa.statefund.user_interfaces.HomePage;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class SeeMenu implements Question<Boolean> {

	private String nameMenu;

	private SeeMenu(String nameMenu) {
		this.nameMenu = nameMenu;
	}

	@Override
	public Boolean answeredBy(Actor actor) {
		takeScreenshot();
		return HomePage.MENU.of(nameMenu).resolveFor(actor).isVisible();
	}

	public static SeeMenu withName(String nameMenu) {
		return new SeeMenu(nameMenu);
	}

}