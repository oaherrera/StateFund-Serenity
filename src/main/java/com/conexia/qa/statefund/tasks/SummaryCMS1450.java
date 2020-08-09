package com.conexia.qa.statefund.tasks;

import static com.conexia.qa.statefund.user_interfaces.CommonPage.SUBMIT;
import static com.conexia.qa.statefund.user_interfaces.Summary1450Page.I_ACCEPT_THE_RELEASE;

import com.conexia.qa.statefund.interactions.WaitLoading;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.thucydides.core.annotations.Step;

public class SummaryCMS1450 implements Task {

	@Override
	@Step("{0} Complete the Summary of 1450 form")
	public <T extends Actor> void performAs(T actor) {
		Serenity.takeScreenshot();
		actor.attemptsTo(Scroll.to(I_ACCEPT_THE_RELEASE));
		actor.attemptsTo(Click.on(I_ACCEPT_THE_RELEASE));
//		actor.attemptsTo(Click.on(I_ACCEPT_THE_ASSIGMENT));
		actor.attemptsTo(Click.on(SUBMIT), WaitLoading.page());
	}

	public static SummaryCMS1450 form() {
		return Tasks.instrumented(SummaryCMS1450.class);
	}

}