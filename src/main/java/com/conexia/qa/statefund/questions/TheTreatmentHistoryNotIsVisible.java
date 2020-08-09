package com.conexia.qa.statefund.questions;

import com.conexia.qa.sql_developer.interactions.RestrictedClaimDB;
import com.conexia.qa.statefund.user_interfaces.ClaimDetailsPage;
import com.conexia.qa.statefund.user_interfaces.TreatmentHistoryPage;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.actions.Scroll;

public class TheTreatmentHistoryNotIsVisible implements Question<Boolean> {

	@Override
	public Boolean answeredBy(Actor actor) {
		boolean found = false;
		try {
			actor.attemptsTo(RestrictedClaimDB.query(), Scroll.to(ClaimDetailsPage.SUBMIT_RFA));
			Serenity.takeScreenshot();
			TreatmentHistoryPage.TREATMENT_HISTORY.resolveFor(actor).isDisplayed();
		} catch (Exception e) {
			found = true;
		}
		return found;
	}

	public static TheTreatmentHistoryNotIsVisible forARestrictedClaim() {
		return new TheTreatmentHistoryNotIsVisible();
	}

}