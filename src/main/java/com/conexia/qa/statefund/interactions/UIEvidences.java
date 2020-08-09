package com.conexia.qa.statefund.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.thucydides.core.annotations.Step;

public class UIEvidences implements Interaction {

	private static String evidence;

	@Override
	@Step("#evidence")
	public <T extends Actor> void performAs(T actor) {
	}

	public static UIEvidences screenshot(String text) {
		evidence = "Text\n\n" + text;
		return Tasks.instrumented(UIEvidences.class, evidence);
	}

}