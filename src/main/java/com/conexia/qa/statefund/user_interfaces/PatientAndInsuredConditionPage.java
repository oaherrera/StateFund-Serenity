package com.conexia.qa.statefund.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;

public class PatientAndInsuredConditionPage {

	private PatientAndInsuredConditionPage() {
	}

	private static String init = "//h1[.=\"Patient and Insured's Condition\"]/ancestor-or-self::div[@class='seccion-header']/following-sibling::div//";

	public static final Target TITTLE = Target.the("Insured's Information")
			.locatedBy("//h1[.=\"Patient and Insured's Condition\"]");
	public static final Target EMPLOYEMENT = Target.the("Employment? {0}")
			.locatedBy(init + "label[.='Employment? *']/following-sibling::*//label[.='{0}']");
	public static final Target AUTO_ACCIDENT = Target.the("Auto accident? {0}")
			.locatedBy(init + "label[.='Auto accident?']/following-sibling::*//label[.='{0}']");
	public static final Target PLACE = Target.the("Place")
			.locatedBy(init + "label[.='Place *']/following-sibling::input");
	public static final Target OTHER_ACCIDENT = Target.the("Other accident? {0}")
			.locatedBy(init + "label[.='Other accident?']/following-sibling::*//label[.='{0}']");

}