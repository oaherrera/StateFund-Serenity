package com.conexia.qa.statefund.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;

public class ValueCodesAndAmountPage {

	private ValueCodesAndAmountPage() {
	}

	public static final Target TITTLE = Target.the("Value Codes and Amount")
			.locatedBy("//h1[.='Value Codes and Amount']");
	public static final Target CODE = Target.the("Code")
			.locatedBy("//input[contains(@id,'seccionCodesAndAmount:code')]");
	public static final Target AMOUNT = Target.the("Amount")
			.locatedBy("//input[contains(@id,'seccionCodesAndAmount:amount')]");
	public static final Target ADD = Target.the("Add").locatedBy("//span[.='Add']/ancestor-or-self::button");

}