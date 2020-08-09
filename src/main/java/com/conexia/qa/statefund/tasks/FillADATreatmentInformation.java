package com.conexia.qa.statefund.tasks;

import static com.conexia.qa.statefund.user_interfaces.CommonPage.NEXT;

import com.conexia.qa.statefund.interactions.WaitLoading;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.thucydides.core.annotations.Step;

public class FillADATreatmentInformation implements Task {

	@Override
	@Step("{0} Fill the Patient Insured Condition ADA form")
	public <T extends Actor> void performAs(T actor) {
		Serenity.takeScreenshot();
		actor.attemptsTo(FillAncillaryClaimTreatmentInformation.form(),
				FillTreatingDentistAndTreatmentLocationInformation.form(), Scroll.to(NEXT), Click.on(NEXT),
				WaitLoading.page());
	}

	public static FillADATreatmentInformation form() {
		return Tasks.instrumented(FillADATreatmentInformation.class);
	}

}