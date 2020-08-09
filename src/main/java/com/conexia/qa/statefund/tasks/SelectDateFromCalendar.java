package com.conexia.qa.statefund.tasks;

import com.conexia.qa.statefund.user_interfaces.ClaimSearchPage;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;

public class SelectDateFromCalendar implements Task {

	@Override
	@Step("{0} access to Claim Search")
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(Click.on(ClaimSearchPage.BUTTON_DATE_OF_INJURY));
		Serenity.takeScreenshot();
		actor.attemptsTo(Click.on(ClaimSearchPage.ACTUAL_DAY));
	}

	public static SelectDateFromCalendar actual() {
		return Tasks.instrumented(SelectDateFromCalendar.class);
	}

}