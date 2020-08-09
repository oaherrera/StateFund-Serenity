package com.conexia.qa.statefund.questions;

import static net.serenitybdd.core.Serenity.takeScreenshot;

import com.conexia.qa.statefund.user_interfaces.EditUserPage;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

/**
 * @author ChristianSchottlaender
 **/
public class ShowFormEdit implements Question<Boolean> {

	@Override
	public Boolean answeredBy(Actor actor) {
		takeScreenshot();
		return EditUserPage.TITLE.resolveFor(actor).isVisible();
	}

	public static ShowFormEdit forUser() {
		return new ShowFormEdit();
	}

}