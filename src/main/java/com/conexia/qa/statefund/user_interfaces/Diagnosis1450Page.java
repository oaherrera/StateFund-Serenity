package com.conexia.qa.statefund.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;

public class Diagnosis1450Page {

	private Diagnosis1450Page() {
	}

	public static final Target TITTLE = Target.the("Diagnosis").locatedBy("//h1[.='Diagnosis']");
	public static final Target RESERVED_FOR_ASSIGMENT_BY_THE_NUBC = Target.the("Reserved for Assigment by the NUBC")
			.locatedBy("//input[contains(@id,'rsvrAssNubc1')]");

}