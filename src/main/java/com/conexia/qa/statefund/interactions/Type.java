package com.conexia.qa.statefund.interactions;

import org.openqa.selenium.Keys;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Hit;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.Step;

/*
 * Esribe letra a letra cada numero
 */
public class Type implements Interaction {

	private Target target;
	private String number;

	public Type(String number) {
		this.number = number;
	}

	@Override
	@Step("{0} enter the value #number into #target")
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(Click.on(target));
		for (int i = 0; i < number.length(); i++) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			switch (number.substring(i, i + 1)) {
			case "0":
				actor.attemptsTo(Hit.the(Keys.NUMPAD0).into(target));
				break;
			case "1":
				actor.attemptsTo(Hit.the(Keys.NUMPAD1).into(target));
				break;
			case "2":
				actor.attemptsTo(Hit.the(Keys.NUMPAD2).into(target));
				break;
			case "3":
				actor.attemptsTo(Hit.the(Keys.NUMPAD3).into(target));
				break;
			case "4":
				actor.attemptsTo(Hit.the(Keys.NUMPAD4).into(target));
				break;
			case "5":
				actor.attemptsTo(Hit.the(Keys.NUMPAD5).into(target));
				break;
			case "6":
				actor.attemptsTo(Hit.the(Keys.NUMPAD6).into(target));
				break;
			case "7":
				actor.attemptsTo(Hit.the(Keys.NUMPAD7).into(target));
				break;
			case "8":
				actor.attemptsTo(Hit.the(Keys.NUMPAD8).into(target));
				break;
			case "9":
				actor.attemptsTo(Hit.the(Keys.NUMPAD9).into(target));
				break;
			default:
				break;
			}
		}
		Serenity.takeScreenshot();
	}

	public static Type theNumber(String number) {
		return Tasks.instrumented(Type.class, number);
	}

	public Type into(Target target) {
		this.target = target;
		return this;
	}

}