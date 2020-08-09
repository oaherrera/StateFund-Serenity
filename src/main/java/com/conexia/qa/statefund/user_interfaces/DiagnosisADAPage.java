package com.conexia.qa.statefund.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;

public class DiagnosisADAPage {

	private DiagnosisADAPage() {
	}

	public static final Target TITTLE = Target.the("Diagnosis").locatedBy("//h1[.='Diagnosis']");
	public static final Target REMARKS = Target.the("Remarks").locatedBy("//textarea[contains(@id,'remarksI')]");

}