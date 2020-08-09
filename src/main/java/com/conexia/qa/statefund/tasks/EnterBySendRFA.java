package com.conexia.qa.statefund.tasks;

import static com.conexia.qa.statefund.user_interfaces.ClaimSearchPage.SUBMIT_RFA;

import com.conexia.qa.statefund.interactions.WaitLoading;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.thucydides.core.annotations.Step;

public class EnterBySendRFA implements Task {

	@Override
	@Step("{0} Click Button RFA")
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(Scroll.to(SUBMIT_RFA), Click.on(SUBMIT_RFA), WaitLoading.page());
		Serenity.takeScreenshot();
	}

	public static EnterBySendRFA onButton() {
		return Tasks.instrumented(EnterBySendRFA.class);
	}

}