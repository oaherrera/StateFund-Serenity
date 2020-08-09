package com.conexia.qa.statefund.tasks;

import static com.conexia.qa.statefund.user_interfaces.CommonPage.SUBMIT;
import static com.conexia.qa.statefund.user_interfaces.Summary1500Page.I_ACCEPT_THE_ASSIGMENT;

import com.conexia.qa.statefund.interactions.WaitLoading;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.thucydides.core.annotations.Step;

public class SummaryCMS1500 implements Task {

	@Override
	@Step("{0} Complete the Summary of 1500 form")
	public <T extends Actor> void performAs(T actor) {
		Serenity.takeScreenshot();
		actor.attemptsTo(Scroll.to(I_ACCEPT_THE_ASSIGMENT));
		actor.attemptsTo(Click.on(I_ACCEPT_THE_ASSIGMENT));
		actor.attemptsTo(Click.on(SUBMIT), WaitLoading.page());
	}

	public static SummaryCMS1500 form() {
		return Tasks.instrumented(SummaryCMS1500.class);
	}

}