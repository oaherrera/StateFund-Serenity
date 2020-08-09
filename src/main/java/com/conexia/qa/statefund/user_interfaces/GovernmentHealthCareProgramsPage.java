package com.conexia.qa.statefund.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;

public class GovernmentHealthCareProgramsPage {

	private GovernmentHealthCareProgramsPage() {
	}

	private static String init = "//h1[.='Government Health Care Programs']/ancestor-or-self::div[@class='seccion-header']/following-sibling::div//";

	public static final Target TITTLE = Target.the("Government Health Care Programs")
			.locatedBy("//h1[.='Government Health Care Programs']");
	public static final Target INSURED_PLAN_NAME_OR_PROGRAM_NAME = Target.the("Insurance Plan Name or Program Name")
			.locatedBy(init + "label[.='Insurance Plan Name or Program Name']/following-sibling::input");
	public static final Target DOES_THE_PATIENT_HAVE_AN_INSURED_ID_NUMBER_OR_SOCIAL_SECURITY_NUMBER = Target
			.the("Does the patient have an insured's ID Number or social Security Number? {0}").locatedBy(init
					+ "label[.=\"Does the patient have an insured's ID Number or social Security Number?*\"]/following-sibling::*//label[.='{0}']");
	public static final Target INSURED_POLICY_GROUP_OR_FECA_NUMBER = Target.the("Insured's Policy Group or FECA Number")
			.locatedBy(init + "label[.=\"Insured's Policy Group or FECA Number*\"]/following-sibling::input");
	public static final Target INSURED_ID_NUMBER = Target.the("Insured's ID Number")
			.locatedBy(init + "label[.=\"Insured's ID Number*\"]/ancestor-or-self::div/div/input");

}