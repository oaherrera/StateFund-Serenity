package com.conexia.qa.statefund.questions;

import java.util.List;

import com.conexia.qa.statefund.interactions.Sleep;
import com.conexia.qa.statefund.interactions.Swipe;
import com.conexia.qa.statefund.user_interfaces.CommonPage;
import com.conexia.qa.statefund.user_interfaces.TreatmentDetailsPage;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.targets.Target;

public class TheInvalidSearch implements Question<String> {

	private List<String> data;
	private String filter;

	private TheInvalidSearch(String filter, List<String> data) {
		this.filter = filter;
		this.data = data;
	}

	@Override
	public String answeredBy(Actor actor) {
		Target element = null, title = null;
		String parts[] = filter.split(" ");
		switch (parts[0]) {
		case "diagnosis":
			title = TreatmentDetailsPage.TREATMENT_DETAILS;
			element = TreatmentDetailsPage.DIAGNOSIS_CODE_DESC;
			break;
		case "procedure":
			title = TreatmentDetailsPage.TREATMENT_DETAILS;
			element = TreatmentDetailsPage.PROCEDURE_CODE_DESC;
			break;
		default:
			break;
		}
		actor.attemptsTo(Scroll.to(title), Swipe.vertical(-100), Enter.theValue(data.get(1)).into(element),
				Sleep.by(1500));
		Serenity.takeScreenshot();
		return CommonPage.NO_MATCHES_FOUND.resolveFor(actor).getText();
	}

	public static TheInvalidSearch is(String filter, List<String> data) {
		return new TheInvalidSearch(filter, data);
	}

}