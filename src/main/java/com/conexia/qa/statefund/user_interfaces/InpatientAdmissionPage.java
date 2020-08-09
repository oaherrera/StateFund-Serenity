package com.conexia.qa.statefund.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;

public class InpatientAdmissionPage {

	private InpatientAdmissionPage() {
	}

	private static String init = "//h1[.='Inpatient Admission']/ancestor-or-self::div[@class='seccion-header']/following-sibling::div//";

	public static final Target TITTLE = Target.the("Inpatient Admission").locatedBy("//h1[.='Inpatient Admission']");
	public static final Target ADMISSION_OF_CARE_DATE = Target.the("Admission/Start of Care Date")
			.locatedBy(init + "label[.='Admission/Start of Care Date*']/following-sibling::span/input");
	public static final Target ADMISSION_HOUR = Target.the("Admission Hour")
			.locatedBy(init + "label[.='Admission Hour']/following-sibling::span/input");
	public static final Target ADMITING_DIAGNOSIS_CODE = Target.the("Admitting Diagnosis Code")
			.locatedBy(init + "label[.='Admitting Diagnosis Code*']/following-sibling::span/input[1]");
	public static final Target OPTION_ADMITING_DIAGNOSIS_CODE = Target.the("").locatedBy(
			"//label[.='Admitting Diagnosis Code*']/following::span[contains(@id,'autocompleteDiagnosis_panel')]/ul/li[1]");

	public static final Target ACCIDENT_STATE = Target.the("Accident State")
			.locatedBy(init + "label[.='Accident State']/following-sibling::*//select");
	public static final Target PRIORITY_TYPE_OF_VISIT = Target.the("Priority Type of Visit")
			.locatedBy(init + "label[.='Priority Type of Visit*']/following-sibling::input");
	public static final Target POINT_OF_ORIGIN = Target.the("Point of Origin for Admission or Visit")
			.locatedBy(init + "label[.='Point of Origin for Admission or Visit*']/following-sibling::input");
	public static final Target PROSPECTIVE_PAYMENT_SYSTEM_CODE = Target.the("Prospective Payment System Code")
			.locatedBy(init
					+ "label[.='Prospective Payment System Code']/ancestor-or-self::div/following-sibling::input[1]");
	public static final Target RESERVED_FOR_ASSIGMENT_ONE = Target.the("Reserved for Assigment by the NUBC").locatedBy(
			init + "label[.='Reserved for Assigment by the NUBC']/ancestor-or-self::div/following-sibling::input[@id='form:seccion:rsvrAssNubc']");
	public static final Target REASON = Target.the("Reason")
			.locatedBy(init + "label[.='Reason']/ancestor-or-self::div/following-sibling::div/div/input");
	public static final Target ADD_REASON = Target.the("Add Reason")
			.locatedBy("//span[.='Add']/ancestor-or-self::button[contains(@id,'Reason')]");
	public static final Target CODE = Target.the("Code")
			.locatedBy(init + "label[.='Code']/ancestor-or-self::div/following-sibling::div/div/input");
	public static final Target ADD_CODE = Target.the("Add Code")
			.locatedBy("//span[.='Add']/ancestor-or-self::button[contains(@id,'Cause')]");
	public static final Target RESERVED_FOR_ASSIGMENT_TWO = Target.the("Reserved for Assigment by the NUBC").locatedBy(
			init + "label[.='Reserved for Assigment by the NUBC']/ancestor-or-self::div/following-sibling::input[@id='form:seccion:rsvrAssNubc1']");

}