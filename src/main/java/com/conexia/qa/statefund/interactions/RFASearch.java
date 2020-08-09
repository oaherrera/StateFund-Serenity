package com.conexia.qa.statefund.interactions;

import static com.conexia.qa.statefund.user_interfaces.CommonPage.SEARCH;
import static com.conexia.qa.statefund.user_interfaces.MenuItemPage.EBILL;
import static com.conexia.qa.statefund.user_interfaces.MenuItemPage.RFA_SEARCH;
import static com.conexia.qa.statefund.user_interfaces.RFASearchPage.CLAIM_NUMBER;
import static com.conexia.qa.statefund.user_interfaces.RFASearchPage.DATE_OF_INJURY;
import static com.conexia.qa.statefund.user_interfaces.RFASearchPage.FIRST_NAME;
import static com.conexia.qa.statefund.user_interfaces.RFASearchPage.LAST_NAME;
import static com.conexia.qa.statefund.user_interfaces.RFASearchPage.RFA;
import static com.conexia.qa.statefund.user_interfaces.RFASearchPage.RFA_ID;
import static com.conexia.qa.statefund.user_interfaces.RFASearchPage.VIEW;
import static com.conexia.qa.statefund.user_interfaces.RFASearchPage.WORKER_INFORMATION;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;

public class RFASearch implements Interaction {

	private String firstName;
	private String lastName;
	private String dateOfInjury;
	private String rfaID;
	private String claimNumber;
	private String searchBy;

	public RFASearch(String searchBy, String firstName, String lastName, String dateOfInjury) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfInjury = dateOfInjury;
		this.searchBy = searchBy;
	}

	public RFASearch(String searchBy, String identifier) {
		this.rfaID = identifier;
		this.claimNumber = identifier;
		this.searchBy = searchBy;
	}

	@Override
	@Step("{0} RFA Search by #searchBy")
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(Click.on(EBILL), Click.on(RFA_SEARCH));
		if (searchBy.equals("RFA")) {
			actor.attemptsTo(Click.on(RFA));
			if (rfaID != null) {
				actor.attemptsTo(Enter.theValue(rfaID).into(RFA_ID));
			} else if (claimNumber != null) {
				actor.attemptsTo(Enter.theValue(claimNumber).into(CLAIM_NUMBER));
			}
		} else {
			actor.attemptsTo(Click.on(WORKER_INFORMATION), Enter.theValue(firstName).into(FIRST_NAME),
					Enter.theValue(lastName).into(LAST_NAME), Type.theNumber(dateOfInjury).into(DATE_OF_INJURY));
		}
		actor.attemptsTo(Click.on(SEARCH), WaitLoading.page());
		Serenity.takeScreenshot();
		actor.attemptsTo(Click.on(VIEW));
	}

	public static RFASearch byWorkerInformation(String firstName, String lastName, String dateOfInjury) {
		return Tasks.instrumented(RFASearch.class, "Worker Information", firstName, lastName, dateOfInjury);
	}

	public static RFASearch byRFAid(String rfaID) {
		return Tasks.instrumented(RFASearch.class, "RFA", rfaID);
	}

	public static RFASearch byClaimNumber(String claimNumber) {
		return Tasks.instrumented(RFASearch.class, "RFA", claimNumber);
	}

}