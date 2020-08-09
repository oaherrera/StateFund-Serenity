package com.conexia.qa.statefund.interactions;

import static com.conexia.qa.statefund.user_interfaces.WorkersInformationPage.RFA_TYPE_OPTION;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;

public class RFAType implements Interaction {

	private String rfaType;

	public RFAType(String rfaType) {
		this.rfaType = rfaType;
	}

	@Override
	@Step("{0} select RFA Type: #rfaType ")
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(Click.on(RFA_TYPE_OPTION.of(rfaType)));
		Serenity.takeScreenshot();
	}

	public static RFAType option(String rfaType) {
		return Tasks.instrumented(RFAType.class, rfaType);
	}

}