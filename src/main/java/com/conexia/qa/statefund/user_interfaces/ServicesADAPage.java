package com.conexia.qa.statefund.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;

public class ServicesADAPage {

	private ServicesADAPage() {
	}

	public static final Target TITTLE = Target.the("Services").locatedBy("//h1[.='Services']");
	public static final Target PROCEDURE_DATE = Target.the("Procedure Date")
			.locatedBy("//input[contains(@id,'serviceDate_input')]");
	public static final Target AMOUNT_PER_TREATMENT = Target.the("Amount per Treatment")
			.locatedBy("//input[contains(@id,'chargesRow')]");
	public static final Target OTHER_FEE = Target.the("Other fee(s)").locatedBy("//input[contains(@id,'otherFees')]");

}