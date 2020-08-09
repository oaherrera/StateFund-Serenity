package com.conexia.qa.statefund.questions;

import com.conexia.qa.statefund.interactions.UIEvidences;
import com.conexia.qa.statefund.user_interfaces.WorkersInformationPage;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ContextualHelpText implements Question<Boolean> {

	private String rfaOption;

	private ContextualHelpText(String rfaOption) {
		this.rfaOption = rfaOption;
	}

	@Override
	public Boolean answeredBy(Actor actor) {
		Serenity.takeScreenshot();
		actor.attemptsTo(UIEvidences.screenshot(
				WorkersInformationPage.RFA_TYPE_OPTION.of(rfaOption).resolveFor(actor).getAttribute("title")));
		return !WorkersInformationPage.RFA_TYPE_OPTION.of(rfaOption).resolveFor(actor).getAttribute("title").isEmpty();
	}

	public static ContextualHelpText isDisplayed(String rfaOption) {
		return new ContextualHelpText(rfaOption);
	}

}