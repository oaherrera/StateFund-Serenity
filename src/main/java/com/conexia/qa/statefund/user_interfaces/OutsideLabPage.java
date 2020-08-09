package com.conexia.qa.statefund.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;

public class OutsideLabPage {

	private OutsideLabPage() {
	}

	private static String init = "//h1[.='Outside LAB']/ancestor-or-self::div[@class='seccion-header']/following-sibling::div//";

	public static final Target TITTLE = Target.the("Outside LAB").locatedBy("//h1[.='Outside LAB']");
	public static final Target OUTSIDE_LAB = Target.the("Outside LAB? {0}")
			.locatedBy(init + "label[.='Outside LAB?']/following-sibling::*//label[.='{0}']");
	public static final Target CHARGES = Target.the("$ Charges")
			.locatedBy(init + "label[.='$ Charges']/following-sibling::input");

}