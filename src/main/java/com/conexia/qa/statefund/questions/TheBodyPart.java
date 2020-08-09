package com.conexia.qa.statefund.questions;

import com.conexia.qa.statefund.models.TreatmentDetails;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class TheBodyPart implements Question<String> {

	@Override
	public String answeredBy(Actor actor) {
		return TreatmentDetails.readData(0).getRelatedBodyPart();
	}

	public static TheBodyPart is() {
		return new TheBodyPart();
	}

}