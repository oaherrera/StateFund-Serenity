package com.conexia.qa.statefund.interactions;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.Step;

public class SelectList implements Interaction {

	private Target inputTarget;
	private Target firtsOptionTarget;
	private String text;

	public SelectList(String text) {
		this.text = text;
	}

	@Override
	@Step("{0} Select the option with text #text")
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(Enter.theValue(text).into(inputTarget));
		Serenity.takeScreenshot();
		actor.attemptsTo(Click.on(firtsOptionTarget));
	}

	public static SelectList text(String text) {
		return Tasks.instrumented(SelectList.class, text);
	}

	public SelectList into(Target inputTarget, Target firtsOptionTarget) {
		this.inputTarget = inputTarget;
		this.firtsOptionTarget = firtsOptionTarget;
		return this;
	}

}