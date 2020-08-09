package com.conexia.qa.statefund.tasks;

import com.conexia.qa.statefund.interactions.WaitLoading;
import com.conexia.qa.statefund.user_interfaces.ClaimSearchPage;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;

public class ClaimDetails implements Task {

	@Override
	@Step("{0} Claim Details")
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(Click.on(ClaimSearchPage.ACTION_VIEW), WaitLoading.page());
		Serenity.takeScreenshot();
	}

	public static ClaimDetails access() {
		return Tasks.instrumented(ClaimDetails.class);
	}

}