package com.conexia.qa.statefund.tasks;

import com.conexia.qa.statefund.interactions.WaitLoading;
import com.conexia.qa.statefund.user_interfaces.ClaimDetailsPage;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;

public class DeleteRecord implements Task {

	@Override
	@Step("{0} click in the icon Delete")
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(Click.on(ClaimDetailsPage.ACTIONS_DELETE));
		Serenity.takeScreenshot();
		actor.attemptsTo(Click.on(ClaimDetailsPage.OPTION_YES_DELETE), WaitLoading.page());
		Serenity.takeScreenshot();
	}

	public static DeleteRecord iconDelete() {
		return Tasks.instrumented(DeleteRecord.class);
	}

}