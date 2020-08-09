package com.conexia.qa.statefund.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;

public class OtherHealthPlanPage {

	private OtherHealthPlanPage() {
	}

	private static String init = "//h1[.='Other Health Plan']/ancestor-or-self::div[@class='seccion-header']/following-sibling::div//";

	public static final Target TITTLE = Target.the("Other Health Plan").locatedBy("//h1[.='Other Health Plan']");
	public static final Target IS_THERE_ANOTHER_HEALTH_BENEFIT_PLAN = Target
			.the("Is there another Health Benefit Plan? {0}")
			.locatedBy(init + "label[.='Is there another Health Benefit Plan?']/following-sibling::*//label[.='{0}']");
	public static final Target INSURED_FIRST_NAME = Target.the("Other Insured's First Name")
			.locatedBy(init + "label[.=\"Other Insured's First Name*\"]/following-sibling::input");
	public static final Target INSURED_MIDDLE_NAME = Target.the("Other Insured's Middle Name")
			.locatedBy(init + "label[.=\"Other Insured's  Middle Name*\"]/following-sibling::input");
	public static final Target INSURED_LAST_NAME = Target.the("Other Insured's Last Name")
			.locatedBy(init + "label[.=\"Other Insured's Last Name*\"]/following-sibling::input");
	public static final Target INSURE_POLICY_OR_GROUP_NUMBER = Target.the("Other Insured's Policy or Group Number")
			.locatedBy(init + "label[.=\"Other Insured's Policy or Group Number*\"]/following-sibling::input");
	public static final Target INSURANCE_PLAN_NUMBER_OR_PROGRAM_NAME = Target.the("Insurance Plan Name or Program Name")
			.locatedBy(init + "label[.='Insurance Plan Name or Program Name*']/following-sibling::input");
	public static final Target RESERVED_FOR_NUCC_USE_ONE = Target.the("Reserved for NUCC Use 1")
			.locatedBy(init + "label[.='Reserved for NUCC Use 1']/following-sibling::input");
	public static final Target RESERVED_FOR_NUCC_USE_TWO = Target.the("Reserved for NUCC Use 2")
			.locatedBy(init + "label[.='Reserved for NUCC Use 2']/following-sibling::input");

}