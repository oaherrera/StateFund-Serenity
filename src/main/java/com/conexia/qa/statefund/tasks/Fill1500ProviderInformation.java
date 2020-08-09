package com.conexia.qa.statefund.tasks;

import static com.conexia.qa.statefund.user_interfaces.CommonPage.NEXT;

import com.conexia.qa.statefund.interactions.WaitLoading;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;

public class Fill1500ProviderInformation implements Task {

	@Override
	@Step("{0} Fill the Provider Information 1500 form")
	public <T extends Actor> void performAs(T actor) {
		Serenity.takeScreenshot();
		actor.attemptsTo(FillServiceFacilityInformation.form(), Fill1500BillingProviderInformation.form(),
				FillReferringProviderOrOtherSource.form(), FillOutsideLab.form(), FillAdditionalClaimInformation.form(),
				Click.on(NEXT), WaitLoading.page());
	}

	public static Fill1500ProviderInformation form() {
		return Tasks.instrumented(Fill1500ProviderInformation.class);
	}

}