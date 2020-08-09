package com.conexia.qa.statefund.questions;

import org.junit.Assert;
import org.openqa.selenium.interactions.Actions;

import com.conexia.qa.statefund.drivers.OwnWebDriver;
import com.conexia.qa.statefund.interactions.Swipe;
import com.conexia.qa.statefund.interactions.WaitLoading;
import com.conexia.qa.statefund.models.URTreatmentType;
import com.conexia.qa.statefund.user_interfaces.TreatmentDetailsPage;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.targets.Target;

public class TheSelect implements Question<Boolean> {

	private String dependentField, independentField, value;

	private TheSelect(String dependentField) {
		this.dependentField = dependentField;
	}

	@Override
	public Boolean answeredBy(Actor actor) {
		Actions action = new Actions(OwnWebDriver.getDriver());
		Target dependentElement = null, independentElement = null, dependentElementOptions = null,
				independentElementOptions = null;
		int quantitySwipe = 0, takeScreenshot = 9, intervalTakeScreenshot = 5;
		boolean found = false;
		switch (dependentField) {
		case "UR Treatment Type":
			dependentElement = TreatmentDetailsPage.UR_TREATMENT_TYPE;
			independentElement = TreatmentDetailsPage.PROCEDURE_TYPE;
			dependentElementOptions = TreatmentDetailsPage.UR_TREATMENT_TYPE_OPTIONS;
			independentElementOptions = TreatmentDetailsPage.PROCEDURE_TYPE_OPTIONS;
			quantitySwipe = -100;
			break;

		default:
			break;
		}
		actor.attemptsTo(Scroll.to(independentElement), Swipe.vertical(quantitySwipe), Click.on(independentElement));
		for (int i = 0; i < independentElementOptions.resolveAllFor(actor).size(); i++) {
			action.moveToElement(independentElementOptions.resolveAllFor(actor).get(i)).build().perform();
			if (independentElementOptions.resolveAllFor(actor).get(i).getText().equalsIgnoreCase(value)) {
				actor.attemptsTo(Click.on(independentElementOptions.resolveAllFor(actor).get(i)), WaitLoading.page());
				Serenity.takeScreenshot();
				break;
			}
		}
		actor.attemptsTo(Scroll.to(dependentElement), Swipe.vertical(quantitySwipe), Click.on(dependentElement));
		Serenity.takeScreenshot();
		for (int i = 0; i < dependentElementOptions.resolveAllFor(actor).size(); i++) {
			action.moveToElement(dependentElementOptions.resolveAllFor(actor).get(i)).build().perform();
			if (i > 0) {
				for (int j = 0; j < URTreatmentType.URTreatmentTypeData.size(); j++) {
					if (dependentElementOptions.resolveAllFor(actor).get(i).getText()
							.equals(URTreatmentType.readData(j))) {
						found = true;
						break;
					}
				}
				Assert.assertTrue(found);
				if (i % takeScreenshot == 0) {
					takeScreenshot = takeScreenshot + intervalTakeScreenshot;
					Serenity.takeScreenshot();
				}
			}
		}
		return found;
	}

	public static TheSelect dependent(String dependentField) {
		return new TheSelect(dependentField);
	}

	public TheSelect from(String independentField, String value) {
		this.independentField = independentField;
		this.value = value;
		return this;
	}

}