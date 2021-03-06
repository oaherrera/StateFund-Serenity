package com.conexia.qa.statefund.tasks;

import static com.conexia.qa.statefund.user_interfaces.CommonPage.NEXT;

import com.conexia.qa.statefund.interactions.WaitLoading;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;

public class FillADAProviderInformation implements Task {

	@Override
	@Step("{0} Fill the Provider Information ADA form")
	public <T extends Actor> void performAs(T actor) {
		Serenity.takeScreenshot();
		actor.attemptsTo(FillTypeOfTransaction.form(), FillBillingDentistOrDentalEntity.form(), Click.on(NEXT),
				WaitLoading.page());
	}

	public static FillADAProviderInformation form() {
		return Tasks.instrumented(FillADAProviderInformation.class);
	}

}