package com.conexia.qa.statefund.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;

public class InsuredInformation1500Page {

	private InsuredInformation1500Page() {
	}

	private static String init = "//h1[.=\"Insured's Information\"]/ancestor-or-self::div[@class='seccion-header']/following-sibling::div//";

	public static final Target TITTLE = Target.the("Insured's Information")
			.locatedBy("//h1[.=\"Insured's Information\"]");
	public static final Target DATE_OF_BIRTH = Target.the("Date of Birth")
			.locatedBy(init + "label[.='Date of Birth']/following-sibling::span/input");
	public static final Target SEX = Target.the("{0} Sex")
			.locatedBy(init + "label[.='Sex']/following-sibling::div//label[.='{0}']");
	public static final Target ADDRESS = Target.the("Address")
			.locatedBy(init + "label[.='Address']/following-sibling::input");
	public static final Target ADDRESS_TWO = Target.the("Address 2")
			.locatedBy(init + "label[.='Address 2']/following-sibling::input");
	public static final Target CITY = Target.the("City").locatedBy(init + "label[.='City']/following-sibling::input");
	public static final Target STATE = Target.the("State")
			.locatedBy(init + "label[.='State']/following-sibling::input");
	public static final Target ZIP_CODE = Target.the("Zip Code")
			.locatedBy(init + "label[.='Zip Code']/following-sibling::input");
	public static final Target TELEPHONE = Target.the("Telephone")
			.locatedBy(init + "label[.='Telephone']/following-sibling::input");

}