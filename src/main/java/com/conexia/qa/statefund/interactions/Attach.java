package com.conexia.qa.statefund.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.Step;

/*
 * 
 * Enviar path a a etiqueta UpLoad
 * 
 */

public class Attach implements Interaction {

	private String file;
	private Target target;

	public Attach(String file) {
		this.file = file;
	}

	@Override
	@Step("{0} enters #file into #target")
	public <T extends Actor> void performAs(T actor) {
		target.resolveFor(actor).sendKeys(file);
	}

	public static Attach file(String file) {
		return Tasks.instrumented(Attach.class, file);
	}

	public Attach into(Target target) {
		this.target = target;
		return this;
	}

}