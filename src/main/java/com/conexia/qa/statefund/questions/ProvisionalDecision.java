package com.conexia.qa.statefund.questions;

import com.conexia.qa.statefund.models.PDFInformation;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ProvisionalDecision implements Question<String> {

	@Override
	public String answeredBy(Actor actor) {
		PDFInformation pdfInformation = new PDFInformation();
		return pdfInformation.getProvisionalDecision();
	}

	public static ProvisionalDecision is() {
		return new ProvisionalDecision();
	}

}