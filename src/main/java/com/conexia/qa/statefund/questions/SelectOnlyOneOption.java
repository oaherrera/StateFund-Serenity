package com.conexia.qa.statefund.questions;

import java.util.Random;

import org.junit.Assert;

import com.conexia.qa.statefund.user_interfaces.WorkersInformationPage;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.actions.Click;

public class SelectOnlyOneOption implements Question<Boolean> {

	@Override
	public Boolean answeredBy(Actor actor) {
		int option = 0;
		Random randomNumber = new Random();
		option = randomNumber.nextInt(4);
		switch (option) {
		case 0:
			actor.attemptsTo(Click.on(WorkersInformationPage.RFA_TYPE_OPTION.of("New Request")));
			Assert.assertFalse(WorkersInformationPage.RFA_TYPE_OPTION_RESUBMISSION.resolveFor(actor)
					.getAttribute("class").contains("ui-state-active"));
			Assert.assertFalse(WorkersInformationPage.RFA_TYPE_OPTION_EXPEDITED.resolveFor(actor).getAttribute("class")
					.contains("ui-state-active"));
			Assert.assertFalse(WorkersInformationPage.RFA_TYPE_OPTION_WRITTEN_CONFIRMATION_OR_PRIOR_ORAL_REQUEST
					.resolveFor(actor).getAttribute("class").contains("ui-state-active"));
			Assert.assertTrue(WorkersInformationPage.RFA_TYPE_OPTION_NEW_REQUEST.resolveFor(actor).getAttribute("class")
					.contains("ui-state-active"));
			break;
		case 1:
			actor.attemptsTo(Click.on(WorkersInformationPage.RFA_TYPE_OPTION.of("Resubmission")));
			Assert.assertFalse(WorkersInformationPage.RFA_TYPE_OPTION_NEW_REQUEST.resolveFor(actor)
					.getAttribute("class").contains("ui-state-active"));
			Assert.assertFalse(WorkersInformationPage.RFA_TYPE_OPTION_EXPEDITED.resolveFor(actor).getAttribute("class")
					.contains("ui-state-active"));
			Assert.assertFalse(WorkersInformationPage.RFA_TYPE_OPTION_WRITTEN_CONFIRMATION_OR_PRIOR_ORAL_REQUEST
					.resolveFor(actor).getAttribute("class").contains("ui-state-active"));
			Assert.assertTrue(WorkersInformationPage.RFA_TYPE_OPTION_RESUBMISSION.resolveFor(actor)
					.getAttribute("class").contains("ui-state-active"));
			break;
		case 2:
			actor.attemptsTo(Click.on(WorkersInformationPage.RFA_TYPE_OPTION.of("Expedited")));
			Assert.assertFalse(WorkersInformationPage.RFA_TYPE_OPTION_NEW_REQUEST.resolveFor(actor)
					.getAttribute("class").contains("ui-state-active"));
			Assert.assertFalse(WorkersInformationPage.RFA_TYPE_OPTION_RESUBMISSION.resolveFor(actor)
					.getAttribute("class").contains("ui-state-active"));
			Assert.assertFalse(WorkersInformationPage.RFA_TYPE_OPTION_WRITTEN_CONFIRMATION_OR_PRIOR_ORAL_REQUEST
					.resolveFor(actor).getAttribute("class").contains("ui-state-active"));
			Assert.assertTrue(WorkersInformationPage.RFA_TYPE_OPTION_EXPEDITED.resolveFor(actor).getAttribute("class")
					.contains("ui-state-active"));
			break;
		case 3:
			actor.attemptsTo(
					Click.on(WorkersInformationPage.RFA_TYPE_OPTION.of("Written Confirmation or Prior Oral Request")));
			Assert.assertFalse(WorkersInformationPage.RFA_TYPE_OPTION_NEW_REQUEST.resolveFor(actor)
					.getAttribute("class").contains("ui-state-active"));
			Assert.assertFalse(WorkersInformationPage.RFA_TYPE_OPTION_RESUBMISSION.resolveFor(actor)
					.getAttribute("class").contains("ui-state-active"));
			Assert.assertFalse(WorkersInformationPage.RFA_TYPE_OPTION_EXPEDITED.resolveFor(actor).getAttribute("class")
					.contains("ui-state-active"));
			Assert.assertTrue(WorkersInformationPage.RFA_TYPE_OPTION_WRITTEN_CONFIRMATION_OR_PRIOR_ORAL_REQUEST
					.resolveFor(actor).getAttribute("class").contains("ui-state-active"));
			break;
		default:
			break;
		}
		Serenity.takeScreenshot();
		return true;
	}

	public static SelectOnlyOneOption inTheFieldRFAType() {
		return new SelectOnlyOneOption();
	}

}