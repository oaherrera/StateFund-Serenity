package com.conexia.qa.statefund.tasks;

import static com.conexia.qa.statefund.user_interfaces.Services1500Page.AMMOUNT_PER_TREATMENT;
import static com.conexia.qa.statefund.user_interfaces.Services1500Page.AMOUNT_PAID;
import static com.conexia.qa.statefund.user_interfaces.Services1500Page.PLACE_OF_SERVICE;
import static com.conexia.qa.statefund.user_interfaces.Services1500Page.PRIOR_AUTHORIZARION_NUMBER;
import static com.conexia.qa.statefund.user_interfaces.Services1500Page.TITTLE;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.thucydides.core.annotations.Step;

public class Fill1500Services implements Task {

	private String priorAuthorizationNumber;
	private String placeOfService;
	private String amountPerTreatment;
	private String amountPaid;

	public Fill1500Services() {
		this.priorAuthorizationNumber = "Authorization 123456";
		this.placeOfService = "12";
		this.amountPerTreatment = "1";
		this.amountPaid = "1";
	}

	@Override
	@Step("{0} Fill the Services 1500 form")
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(Scroll.to(TITTLE), Enter.theValue(priorAuthorizationNumber).into(PRIOR_AUTHORIZARION_NUMBER),
				Enter.theValue(placeOfService).into(PLACE_OF_SERVICE),
				Enter.theValue(amountPerTreatment).into(AMMOUNT_PER_TREATMENT),
				Enter.theValue(amountPaid).into(AMOUNT_PAID));
		Serenity.takeScreenshot();
	}

	public static Fill1500Services form() {
		return Tasks.instrumented(Fill1500Services.class);
	}

}