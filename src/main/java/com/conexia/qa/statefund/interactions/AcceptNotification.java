package com.conexia.qa.statefund.interactions;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

/*
*
*Espera a que el Pop UP sea visible y le da click
*
*/

public class AcceptNotification implements Interaction {

	private Target target;

	public AcceptNotification(Target target) {
		this.target = target;
	}

	@Override
	@Step("{0} clicks on #target")
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(WaitUntil.the(target, isVisible()));
		Serenity.takeScreenshot();
		actor.attemptsTo(Click.on(target));
	}

	public static AcceptNotification popUp(Target target) {
		return Tasks.instrumented(AcceptNotification.class, target);
	}

}