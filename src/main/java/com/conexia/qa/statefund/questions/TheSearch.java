package com.conexia.qa.statefund.questions;

import java.util.List;

import com.conexia.qa.statefund.interactions.ChooseMultiple;
import com.conexia.qa.statefund.interactions.Swipe;
import com.conexia.qa.statefund.interactions.WaitLoading;
import com.conexia.qa.statefund.user_interfaces.CommonPage;
import com.conexia.qa.statefund.user_interfaces.TreatmentDetailsPage;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.targets.Target;

public class TheSearch implements Question<Boolean> {

	private String filter;
	private List<String> data;

	private TheSearch(String filter, List<String> data) {
		this.filter = filter;
		this.data = data;
	}

	@Override
	public Boolean answeredBy(Actor actor) {
		Target element = null;
		actor.attemptsTo(Scroll.to(CommonPage.NEXT), Click.on(CommonPage.NEXT), WaitLoading.page(),
				Scroll.to(TreatmentDetailsPage.TREATMENT_DETAILS), Swipe.vertical(-100),
				ChooseMultiple.options(data.get(1)).into(TreatmentDetailsPage.DIAGNOSIS_CODE_DESC,
						TreatmentDetailsPage.DIAGNOSIS_OPTION),
				WaitLoading.page());
		switch (filter) {
		case "code":
			element = TreatmentDetailsPage.DIAGNOSIS_CODE_TABLE.of(data.get(1));
			break;
		case "description":
			element = TreatmentDetailsPage.DIAGNOSIS_DESCRIPTION_TABLE.of(data.get(1));
			break;
		default:
			break;
		}
		return element.resolveFor(actor).getText().equalsIgnoreCase(data.get(1));
	}

	public static TheSearch is(String filter, List<String> data) {
		return new TheSearch(filter, data);
	}

}