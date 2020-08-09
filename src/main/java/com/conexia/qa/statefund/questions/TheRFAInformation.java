package com.conexia.qa.statefund.questions;

import com.conexia.qa.statefund.interactions.Swipe;
import com.conexia.qa.statefund.interactions.WaitLoading;
import com.conexia.qa.statefund.user_interfaces.TreatmentHistoryPage;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;

public class TheRFAInformation implements Question<Boolean> {

	@Override
	public Boolean answeredBy(Actor actor) {
		actor.attemptsTo(WaitLoading.page(), Scroll.to(TreatmentHistoryPage.TREATMENT_HISTORY), Swipe.vertical(-100));
		Serenity.takeScreenshot();
		actor.attemptsTo(Click.on(TreatmentHistoryPage.ROW_SPECIFICATION_RFA));
		Serenity.takeScreenshot();
		return TreatmentHistoryPage.CONTENT_RFA.resolveFor(actor).isVisible();
	}

	public static TheRFAInformation is() {
		return new TheRFAInformation();
	}

}