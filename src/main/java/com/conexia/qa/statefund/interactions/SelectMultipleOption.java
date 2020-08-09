package com.conexia.qa.statefund.interactions;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.Step;

public class SelectMultipleOption implements Interaction {

	private Target optionTarget;
	private Target allOptions;
	private Target close;
	private Target target;
	private String text;

	public SelectMultipleOption(String text) {
		this.text = text;
	}

	@Override
	@Step("{0} Select the option with text #text")
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(Click.on(target));
		if (text.toLowerCase().contains("all")) {
			actor.attemptsTo(Click.on(allOptions));
		} else {
			actor.attemptsTo(Click.on(optionTarget));
		}
		actor.attemptsTo(Click.on(close));
		Serenity.takeScreenshot();
	}

	public static SelectMultipleOption text(String text) {
		return Tasks.instrumented(SelectMultipleOption.class, text);
	}

	public SelectMultipleOption into(Target allOptions, Target optionTarget, Target target) {
		this.allOptions = allOptions;
		this.optionTarget = optionTarget;
		this.target = target;
		return this;
	}

	public SelectMultipleOption andClose(Target close) {
		this.close = close;
		return this;
	}

}