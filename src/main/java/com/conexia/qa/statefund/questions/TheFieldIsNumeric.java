package com.conexia.qa.statefund.questions;

import java.util.List;

import com.conexia.qa.statefund.interactions.Type;
import com.conexia.qa.statefund.user_interfaces.ClaimAdministratorInformationPage;
import com.conexia.qa.statefund.user_interfaces.CommonPage;
import com.conexia.qa.statefund.user_interfaces.RequestingPhysicianInformationPage;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.targets.Target;

public class TheFieldIsNumeric implements Question<Boolean> {

	private String value;
	private String field;

	private TheFieldIsNumeric(String field, String value) {
		this.field = field;
		this.value = value;
	}

	@Override
	public Boolean answeredBy(Actor actor) {
		Target element = null;
		switch (field) {
		case "NPI Number":
			element = RequestingPhysicianInformationPage.NPI_NUMBER;
			break;
		case "Telephone":
			element = ClaimAdministratorInformationPage.TELEPHONE;
			break;
		case "Fax Number":
			element = ClaimAdministratorInformationPage.FAX_NUMBER;
			break;
		default:
			break;
		}
		actor.attemptsTo(Scroll.to(CommonPage.NEXT), Type.theNumber(value).into(element));
		String comparate = "";
		for (int i = 0; i < value.length(); i++) {
			try {
				comparate = comparate + String.valueOf(Integer.parseInt(String.valueOf(value.charAt(i))));
			} catch (Exception e) {
			}
		}
		Serenity.takeScreenshot();
		String temp = "";
		try {
			Integer.parseInt(element.resolveFor(actor).getValue());
			temp = element.resolveFor(actor).getValue();
		} catch (Exception e) {
			temp = element.resolveFor(actor).getValue().replace("(", "").replace(")", "").replace("-", "");
		}
		return temp.equals(comparate);
	}

	public static TheFieldIsNumeric in(String field, List<String> value) {
		return new TheFieldIsNumeric(field, value.get(1));
	}

}