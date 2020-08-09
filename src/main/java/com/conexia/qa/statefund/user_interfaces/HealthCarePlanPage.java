package com.conexia.qa.statefund.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;

public class HealthCarePlanPage {

	private HealthCarePlanPage() {
	}

	private static String init = "//h1[.='Health Care Plan']/ancestor-or-self::div[@class='seccion-header']/following-sibling::div//";

	public static final Target TITTLE = Target.the("Health Care Plan").locatedBy("//h1[.='Health Care Plan']");
	public static final Target HEALTH_PLAN_ID = Target.the("Health Plan ID")
			.locatedBy(init + "label[.='Health Plan ID*']/following-sibling::input");
	public static final Target DOES_THE_PATIENT_HAVE_AN_IDENTIFIER = Target
			.the("Does the patient have an Patient Identifier or Social Security Number? {0}").locatedBy(init
					+ "label[.='Does the patient have an Patient Identifier or Social Security Number?*']/following-sibling::*//label[.='{0}']");
	public static final Target MEDICAL_HEALTH_RECORD = Target.the("Medical Health Record")
			.locatedBy(init + "label[.='Medical Health Record']/following-sibling::input");

}