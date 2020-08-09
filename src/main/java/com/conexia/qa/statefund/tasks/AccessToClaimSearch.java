package com.conexia.qa.statefund.tasks;

import com.conexia.qa.statefund.user_interfaces.MenuItemPage;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;

public class AccessToClaimSearch implements Task {

	@Override
	@Step("{0} access to Claim Search")
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(Click.on(MenuItemPage.CLAIM), Click.on(MenuItemPage.CLAIM_SEARCH));
		Serenity.takeScreenshot();
	}

	public static AccessToClaimSearch menu() {
		return Tasks.instrumented(AccessToClaimSearch.class);
	}

}