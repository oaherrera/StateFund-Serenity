package com.conexia.qa.statefund.questions;

import com.conexia.qa.statefund.interactions.WaitLoading;
import com.conexia.qa.statefund.user_interfaces.TreatmentHistoryPage;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.actions.Scroll;

public class TheTreatmentHistoryIsDisplayed implements Question<Boolean> {

	@Override
	public Boolean answeredBy(Actor actor) {
		actor.attemptsTo(WaitLoading.page(), Scroll.to(TreatmentHistoryPage.TREATMENT_HISTORY));
		Serenity.takeScreenshot();
		return TreatmentHistoryPage.RFA_ID_UNDEFINED.resolveFor(actor).isDisplayed();
	}

	public static TheTreatmentHistoryIsDisplayed forARFA() {
		return new TheTreatmentHistoryIsDisplayed();
	}

}