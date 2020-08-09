package com.conexia.qa.statefund.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;

public class Services1500Page {

	private Services1500Page() {
	}

	private static String init = "//h1[.='Services']/ancestor-or-self::div[@class='seccion-header']/following-sibling::div//";

	public static final Target TITTLE = Target.the("Services").locatedBy("//h1[.='Services']");
	public static final Target PRIOR_AUTHORIZARION_NUMBER = Target.the("Prior authorization number")
			.locatedBy(init + "label[.='Prior authorization number']/following-sibling::input");
	public static final Target PLACE_OF_SERVICE = Target.the("Place of Service")
			.locatedBy(init + "span[.='Place of Service*']/following-sibling::div//input");
	public static final Target AMMOUNT_PER_TREATMENT = Target.the("Amount per Treatment")
			.locatedBy(init + "span[.='Amount per Treatment*']/following-sibling::div//input");
	public static final Target AMOUNT_PAID = Target.the("Amount Paid $")
			.locatedBy(init + "input[contains(@id,'amountPaid')]");

}