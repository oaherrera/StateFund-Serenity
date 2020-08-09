package com.conexia.qa.statefund.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;

public class InsuredInformation1450Page {

	private InsuredInformation1450Page() {
	}

	private static String init = "//h1[.=\"Insured's Information\"]/ancestor-or-self::div[@class='seccion-header']/following-sibling::div//";

	public static final Target TITTLE = Target.the("Insured's Information")
			.locatedBy("//h1[.=\"Insured's Information\"]");
	public static final Target PATIENT_RELATIONSHIP_TO_INSURED = Target.the("Patient's relationship to Insured is {0}")
			.locatedBy(init
					+ "label[.=\"Patient's relationship to Insured *\"]/ancestor-or-self::div/following-sibling::*//label[.='{0}']");
	public static final Target DOES_THE_INSURED_HAVE_SOCIAL_SECURITY_NUMBER = Target
			.the("Does the insured have an Insured's Unique ID or Social Security Number? {0}").locatedBy(init
					+ "label[.=\"Does the insured have an Insured's Unique ID or Social Security Number?*\"]/following-sibling::*//label[.='{0}']");
	public static final Target INSURED_GROUP_NAME = Target.the("Insured's Group Name")
			.locatedBy(init + "label[.=\"Insured's Group Name\"]/following-sibling::input");

}