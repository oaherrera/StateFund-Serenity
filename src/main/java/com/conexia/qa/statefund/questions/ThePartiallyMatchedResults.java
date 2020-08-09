package com.conexia.qa.statefund.questions;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.conexia.qa.statefund.drivers.OwnWebDriver;
import com.conexia.qa.statefund.interactions.Sleep;
import com.conexia.qa.statefund.interactions.Swipe;
import com.conexia.qa.statefund.user_interfaces.TreatmentDetailsPage;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.targets.Target;

public class ThePartiallyMatchedResults implements Question<Boolean> {

	private List<String> data;
	private int quantity;
	private String field;

	private ThePartiallyMatchedResults(List<String> data, int quantity) {
		this.data = data;
		this.quantity = quantity;
	}

	@Override
	public Boolean answeredBy(Actor actor) {
		Target element = null, results = null;
		switch (field) {
		case "Procedure Search":
			element = TreatmentDetailsPage.PROCEDURE_CODE_DESC;
			results = TreatmentDetailsPage.PROCEDURE_CODE_DESC_OPTIONS;
			break;
		default:
			break;
		}
		actor.attemptsTo(Scroll.to(element), Swipe.vertical(-100), Enter.keyValues(data.get(1)).into(element),
				Sleep.by(500));
		Actions accion = new Actions(OwnWebDriver.getDriver());
		for (int i = 0; i < results.resolveAllFor(actor).size(); i++) {
			WebElement elemento = results.resolveAllFor(actor).get(i);
			accion.moveToElement(elemento).build().perform();
			if (i % 6 == 0) {
				Serenity.takeScreenshot();
			}
		}
		return results.resolveAllFor(actor).size() == quantity;
	}

	public static ThePartiallyMatchedResults displays(List<String> data, int quantity) {
		return new ThePartiallyMatchedResults(data, quantity);
	}

	public ThePartiallyMatchedResults from(String field) {
		this.field = field;
		return this;
	}

}