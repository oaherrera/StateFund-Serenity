package com.conexia.qa.statefund.tasks;

import static com.conexia.qa.statefund.user_interfaces.CommonPage.ACCEPT;
import static com.conexia.qa.statefund.user_interfaces.CommonPage.EBILL_NUMBER;
import static com.conexia.qa.statefund.user_interfaces.MenuItemPage.HISTORY;

import com.conexia.qa.statefund.interactions.WaitLoading;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;

public class GoToRFAHistory implements Task {

	private String ebillNumber;

	@Override
	@Step("{0} Go to RFA History")
	public <T extends Actor> void performAs(T actor) {
		ebillNumber = EBILL_NUMBER.resolveFor(actor).getText().split(":")[1].replace(" ", "");
		actor.remember("ebillNumber", ebillNumber);
		actor.attemptsTo(Click.on(ACCEPT), WaitLoading.page(), Click.on(HISTORY));
		Serenity.takeScreenshot();
	}

	public static GoToRFAHistory fromEbill() {
		return Tasks.instrumented(GoToRFAHistory.class);
	}

}