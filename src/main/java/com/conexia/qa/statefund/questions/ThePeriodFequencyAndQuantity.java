package com.conexia.qa.statefund.questions;

import com.conexia.qa.statefund.models.PDFInformation;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ThePeriodFequencyAndQuantity implements Question<String> {

	@Override
	public String answeredBy(Actor actor) {
		PDFInformation information = new PDFInformation();
		return information.getPeriod() + " - " + information.getFrequency() + " - " + information.getQuantity();
	}

	public static ThePeriodFequencyAndQuantity are() {
		return new ThePeriodFequencyAndQuantity();
	}

}