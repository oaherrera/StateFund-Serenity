package com.conexia.qa.statefund.questions;

import static com.conexia.qa.statefund.user_interfaces.CommonPage.RESULT_TABLE_NO_RECORD_FOUND;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class NoRecordsFound implements Question<Boolean> {

	@Override
	public Boolean answeredBy(Actor actor) {
		return RESULT_TABLE_NO_RECORD_FOUND.resolveFor(actor).isVisible();
	}

	public static NoRecordsFound yesShowMessage() {
		return new NoRecordsFound();
	}

}