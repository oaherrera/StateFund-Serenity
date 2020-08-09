package com.conexia.qa.statefund.questions;

import static com.conexia.qa.statefund.user_interfaces.SearchUserPage.TITTLE;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ShowCreateUser implements Question<Boolean> {

	@Override
	public Boolean answeredBy(Actor actor) {
		return TITTLE.resolveFor(actor).isVisible();
	}

	public static ShowCreateUser inThePortal() {
		return new ShowCreateUser();
	}

}