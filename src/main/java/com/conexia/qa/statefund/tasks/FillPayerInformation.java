package com.conexia.qa.statefund.tasks;

import static com.conexia.qa.statefund.user_interfaces.PayerInformationPage.PAYER_NAME;
import static com.conexia.qa.statefund.user_interfaces.PayerInformationPage.TITTLE;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.thucydides.core.annotations.Step;

public class FillPayerInformation implements Task {

	private String payerName;

	public FillPayerInformation() {
		this.payerName = "Paco Rocha";
	}

	@Override
	@Step("{0} Fill the Payer Information form")
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(Scroll.to(TITTLE), Enter.theValue(payerName).into(PAYER_NAME));
		Serenity.takeScreenshot();
	}

	public static FillPayerInformation form() {
		return Tasks.instrumented(FillPayerInformation.class);
	}

}