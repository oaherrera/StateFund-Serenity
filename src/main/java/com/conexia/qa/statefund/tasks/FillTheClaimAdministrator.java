package com.conexia.qa.statefund.tasks;

import static com.conexia.qa.statefund.user_interfaces.CommonPage.NEXT;

import com.conexia.qa.statefund.interactions.WaitLoading;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;

public class FillTheClaimAdministrator implements Task {

	@Override
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(Scroll.to(NEXT));
		Serenity.takeScreenshot();
		actor.attemptsTo(Click.on(NEXT), WaitLoading.page());
	}

	public static FillTheClaimAdministrator information() {
		return Tasks.instrumented(FillTheClaimAdministrator.class);
	}

}