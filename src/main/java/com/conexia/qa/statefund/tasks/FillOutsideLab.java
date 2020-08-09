package com.conexia.qa.statefund.tasks;

import static com.conexia.qa.statefund.user_interfaces.OutsideLabPage.CHARGES;
import static com.conexia.qa.statefund.user_interfaces.OutsideLabPage.OUTSIDE_LAB;
import static com.conexia.qa.statefund.user_interfaces.OutsideLabPage.TITTLE;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.thucydides.core.annotations.Step;

public class FillOutsideLab implements Task {

	private String outsideLab;
	private String charges;

	public FillOutsideLab() {
		this.outsideLab = "Yes";
		this.charges = "1234";
	}

	@Override
	@Step("{0} Fill the Outside LAB form")
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(Scroll.to(TITTLE), Click.on(OUTSIDE_LAB.of(outsideLab)));
		if (outsideLab.equals("Yes")) {
			actor.attemptsTo(Enter.theValue(charges).into(CHARGES));
		}
		Serenity.takeScreenshot();
	}

	public static FillOutsideLab form() {
		return Tasks.instrumented(FillOutsideLab.class);
	}

}