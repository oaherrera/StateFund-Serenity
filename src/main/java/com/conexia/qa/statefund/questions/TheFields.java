package com.conexia.qa.statefund.questions;

import java.util.List;

import org.junit.Assert;

import com.conexia.qa.statefund.interactions.WaitLoading;
import com.conexia.qa.statefund.user_interfaces.ClaimAdministratorInformationPage;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.targets.Target;

public class TheFields implements Question<Boolean> {

	private String field;
	private String fields;
	private List<String> value;

	private TheFields(String fields) {
		this.fields = fields;
	}

	@Override
	public Boolean answeredBy(Actor actor) {
		Target element = null, selectElement = null;
		switch (field) {
		case "Address":
			element = ClaimAdministratorInformationPage.ADDRESS;
			selectElement = ClaimAdministratorInformationPage.ADDRESS_OPTIONS;
			break;
		default:
			break;
		}
		actor.attemptsTo(Scroll.to(element), Click.on(element),
				SelectFromOptions.byVisibleText(value.get(1)).from(selectElement), WaitLoading.page());
		String afields[] = fields.replace(" ", "").split(",");
		for (int i = 0; i < afields.length; i++) {
			Target elementCompleted = null;
			switch (afields[i]) {
			case "City":
				elementCompleted = ClaimAdministratorInformationPage.CITY;
				break;
			case "State":
				elementCompleted = ClaimAdministratorInformationPage.STATE;
				break;
			case "ZipCode":
				elementCompleted = ClaimAdministratorInformationPage.ZIP_CODE;
				break;
			default:
				break;
			}
			Assert.assertTrue(!elementCompleted.resolveFor(actor).getValue().isEmpty());
		}
		Serenity.takeScreenshot();
		return true;
	}

	public static TheFields areAutoPopulated(String fields) {
		return new TheFields(fields);
	}

	public TheFields troughtField(String field, List<String> value) {
		this.field = field;
		this.value = value;
		return this;
	}

}