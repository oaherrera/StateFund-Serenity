package com.conexia.qa.statefund.questions;

import static com.conexia.qa.statefund.user_interfaces.ClaimSearchPage.RESULT_CLAIM_DECISION;
import static com.conexia.qa.statefund.user_interfaces.ClaimSearchPage.RESULT_CLAIM_NUMBER;
import static com.conexia.qa.statefund.user_interfaces.ClaimSearchPage.RESULT_DATE_OF_INJURY;
import static com.conexia.qa.statefund.user_interfaces.ClaimSearchPage.RESULT_FIRST_NAME;
import static com.conexia.qa.statefund.user_interfaces.ClaimSearchPage.RESULT_LAST_NAME;
import static com.conexia.qa.statefund.user_interfaces.ClaimSearchPage.RESULT_MIDDLE_NAME;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class TheInformationOfClaimSearch implements Question<String> {

	private String firstName;
	private String middleName;
	private String lastName;
	private String dateOfInjury;
	private String claimNumber;
	private String claimDecision;

	@Override
	public String answeredBy(Actor actor) {
		Serenity.takeScreenshot();
		firstName = Text.of(RESULT_FIRST_NAME).viewedBy(actor).asString();
		if (RESULT_MIDDLE_NAME.resolveFor(actor).getAttribute("text") == null) {
			middleName = "";
		} else {
			middleName = RESULT_MIDDLE_NAME.resolveFor(actor).getAttribute("text");
		}
		lastName = Text.of(RESULT_LAST_NAME).viewedBy(actor).asString();
		dateOfInjury = Text.of(RESULT_DATE_OF_INJURY).viewedBy(actor).asString();
		claimNumber = Text.of(RESULT_CLAIM_NUMBER).viewedBy(actor).asString();
		claimDecision = Text.of(RESULT_CLAIM_DECISION).viewedBy(actor).asString();
		return firstName + " - " + middleName + " - " + lastName + " - " + dateOfInjury + " - " + claimNumber + " - "
				+ claimDecision;
	}

	public static TheInformationOfClaimSearch is() {
		return new TheInformationOfClaimSearch();
	}

}