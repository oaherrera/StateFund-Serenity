package com.conexia.qa.statefund.interactions;

import static com.conexia.qa.statefund.user_interfaces.SavedDraftForClaimPage.ORDER_BY_SAVED_DATE;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

/**
 * @author ChristianCamiloSchottlaender
 */
public class OrderResults implements Interaction {

	public String resultsOf;

	public OrderResults(String resultsOf) {
		this.resultsOf = resultsOf;
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		switch (resultsOf) {
		case "SavedDraft":
			ORDER_BY_SAVED_DATE.resolveFor(actor).getAttribute("aria-label");
			actor.attemptsTo(Click.on(ORDER_BY_SAVED_DATE));
			break;
		}
	}

	public static OrderResults ofSavedDraftBy() {
		return Tasks.instrumented(OrderResults.class, "SavedDraft");
	}

}