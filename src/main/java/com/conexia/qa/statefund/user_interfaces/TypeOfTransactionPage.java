package com.conexia.qa.statefund.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;

public class TypeOfTransactionPage {

	private TypeOfTransactionPage() {
	}

	public static final Target TITTLE = Target.the("Type of Transaction").locatedBy("//h1[.='Type of Transaction']");
	public static final Target TYPE = Target.the("Type {0}")
			.locatedBy("//div[contains(@id,'outPanel1')]//label[.='{0}']");

}