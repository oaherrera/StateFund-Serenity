package com.conexia.qa.statefund.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;

public class PatientAndInsuredInformation1450Page {

	private PatientAndInsuredInformation1450Page() {
	}

	private static String init = "//h1[.=\"Patient Insured's Information\"]/ancestor-or-self::div[@class='seccion-header']/following-sibling::div//";

	public static final Target TITTLE = Target.the("Patient and Insured Information")
			.locatedBy("//h1[.=\"Patient Insured's Information\"]");
	public static final Target SEX = Target.the("{0} Sex").locatedBy(init + "label[.='{0}']");
	public static final Target ADDRESS_ONE = Target.the("Address 1")
			.locatedBy(init + "label[.='Address 1*']/following-sibling::input");
	public static final Target ADDRESS_TWO = Target.the("Address 2")
			.locatedBy(init + "label[.='Address 2']/following-sibling::input");
	public static final Target CITY = Target.the("City").locatedBy(init + "label[.='City*']/following-sibling::input");
	public static final Target STATE = Target.the("State")
			.locatedBy(init + "label[.='State*']/following-sibling::input");
	public static final Target ZIP_CODE = Target.the("Zip Code")
			.locatedBy(init + "label[.='Zip Code*']/following-sibling::input");

	public static final Target PATIENT_CONTROL_NUMBER = Target.the("Patient Control Number*")
			.locatedBy(init + "label[.='Patient Control Number*']/following-sibling::input");
	public static final Target RESERVED_FOR_ASSIGNMENT = Target.the("Reserved for Assignment")
			.locatedBy(init + "label[.='Reserved for Assignment']/following-sibling::input");
	public static final Target REMARKS = Target.the("Remarks")
			.locatedBy(init + "label[.='Remarks']/following-sibling::textarea");

}