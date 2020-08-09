package com.conexia.qa.statefund.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;

public class PatientAndInsuredInformation1500Page {

	private PatientAndInsuredInformation1500Page() {
	}

	private static String init = "//h1[.='Patient and Insured Information']/ancestor-or-self::div[@class='seccion-header']/following-sibling::div//";

	public static final Target TITTLE = Target.the("Patient and Insured Information")
			.locatedBy("//h1[.='Patient and Insured Information']");
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
	public static final Target TELEPHONE = Target.the("Telephone")
			.locatedBy(init + "label[.='Telephone*']/following-sibling::input");
	public static final Target TELEPHONE_EXT = Target.the("Telephone Ext")
			.locatedBy(init + "label[.='Telephone Ext']/following-sibling::input");
	public static final Target PATIENT_ACCOUNT_NUMBER = Target.the("Patient's Account No.")
			.locatedBy(init + "label[.=\"Patient's Account No.*\"]/following-sibling::input");
	public static final Target RESERVED_FOR_NUCC_USE = Target.the("Reserved for NUCC Use")
			.locatedBy(init + "label[.='Reserved for NUCC Use']/following-sibling::input");
	public static final Target PATIENT_RELATIONSHIP_TO_INSURED = Target.the("Patient Relationship to Insured - {0}")
			.locatedBy(init + "label[.='Patient Relationship to Insured*']/following-sibling::*//label[.='{0}']");

}