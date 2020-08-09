package com.conexia.qa.statefund.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;

public class PayerInformationPage {

	private PayerInformationPage() {
	}

	public static final Target TITTLE = Target.the("Payer Information").locatedBy("//h1[.='Payer Information']");
	public static final Target PAYER_NAME = Target.the("Payer Name").locatedBy("//input[contains(@id,'payerName1')]");

}