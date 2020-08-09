package com.conexia.qa.statefund.questions;

import com.conexia.qa.statefund.user_interfaces.WorkerTableTitlesPage;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class DataTableIsShow implements Question<Boolean> {

	@Override
	public Boolean answeredBy(Actor actor) {
		Serenity.takeScreenshot();
		return WorkerTableTitlesPage.WORKER_FIRST_NAME.resolveFor(actor).isPresent();
	}

	public static DataTableIsShow onPortal() {
		return new DataTableIsShow();
	}

}