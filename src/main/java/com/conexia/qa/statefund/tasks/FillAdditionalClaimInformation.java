package com.conexia.qa.statefund.tasks;

import static com.conexia.qa.statefund.user_interfaces.AdditionalClaimInformationPage.ADDITIONAL_CLAIM_INFORMATION;
import static com.conexia.qa.statefund.user_interfaces.AdditionalClaimInformationPage.TITTLE;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.thucydides.core.annotations.Step;

public class FillAdditionalClaimInformation implements Task {

	private String additionalClaimInformation;

	public FillAdditionalClaimInformation() {
		this.additionalClaimInformation = "additionalClaimInformation";
	}

	@Override
	@Step("{0} Fill the Additional Claim Information form")
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(Scroll.to(TITTLE),
				Enter.theValue(additionalClaimInformation).into(ADDITIONAL_CLAIM_INFORMATION));
		Serenity.takeScreenshot();
	}

	public static FillAdditionalClaimInformation form() {
		return Tasks.instrumented(FillAdditionalClaimInformation.class);
	}

}