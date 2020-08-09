package com.conexia.qa.statefund.interactions;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.Step;

/*
 * 
 * Selecciona Multiples opciones de la lista
 * Ingresando un dato clave y selecciona la primera opcion
 * usar separador ; en caso de requerir varios
 * 
 */
public class ChooseMultiple implements Interaction {

	private String options;
	private String[] option;
	private Target inputTarget;
	private Target optionTarget;

	public ChooseMultiple(String options) {
		this.options = options;
	}

	@Override
	@Step("{0} Choose the options of #inputTarget")
	public <T extends Actor> void performAs(T actor) {
		option = options.split(";");
		for (int i = 0; i < option.length; i++) {
			actor.attemptsTo(Enter.theValue(option[i]).into(inputTarget));
			actor.attemptsTo(Click.on(optionTarget.of(option[i])), WaitLoading.page());
		}
		Serenity.takeScreenshot();
	}

	public static ChooseMultiple options(String options) {
		return Tasks.instrumented(ChooseMultiple.class, options);
	}

	public ChooseMultiple into(Target inputTarget, Target optionTarget) {
		this.inputTarget = inputTarget;
		this.optionTarget = optionTarget;
		return this;
	}

}