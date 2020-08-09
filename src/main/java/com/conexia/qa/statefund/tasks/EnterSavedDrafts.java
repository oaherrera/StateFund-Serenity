package com.conexia.qa.statefund.tasks;

import com.conexia.qa.statefund.interactions.Sleep;
import com.conexia.qa.statefund.interactions.Swipe;
import com.conexia.qa.statefund.interactions.WaitLoading;
import com.conexia.qa.statefund.user_interfaces.ClaimSearchPage;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;

public class EnterSavedDrafts implements Task {

	@Override
	@Step("{0} Saved Drafts")
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(Swipe.vertical(200), Sleep.by(1000));
		Serenity.takeScreenshot();
		actor.attemptsTo(Click.on(ClaimSearchPage.SAVED_DRAFTS), WaitLoading.page());
		Serenity.takeScreenshot();
	}

	public static EnterSavedDrafts button() {
		return Tasks.instrumented(EnterSavedDrafts.class);
	}

}