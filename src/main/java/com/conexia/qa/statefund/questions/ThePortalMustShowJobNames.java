package com.conexia.qa.statefund.questions;

import com.conexia.qa.statefund.tasks.SelectWorkplace;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ThePortalMustShowJobNames implements Question<Boolean> {

	public String TheportalmustshowjobNames(Actor actor) {
		Serenity.takeScreenshot();
		return SelectWorkplace.class.toString();
	}

	public static ThePortalMustShowJobNames onPortal() {
		return new ThePortalMustShowJobNames();
	}

	@Override
	public Boolean answeredBy(Actor actor) {
		// TODO Auto-generated method stub
		return null;
	}

}