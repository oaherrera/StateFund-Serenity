package com.conexia.qa.statefund.questions;

import static com.conexia.qa.statefund.user_interfaces.HomePage.BELL_NOTIFICATION;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.actions.Click;

public class IconNotification implements Question<Boolean> {

	@Override
	public Boolean answeredBy(Actor actor) {
		actor.attemptsTo(Click.on(BELL_NOTIFICATION));
		return BELL_NOTIFICATION.resolveFor(actor).isVisible();
	}

	public static IconNotification inHeaderSection() {
		return new IconNotification();
	}

}