package com.conexia.qa.statefund.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;

public class ServiceFacilityInformationPage {

	private ServiceFacilityInformationPage() {
	}

	private static String init = "//h1[.='Service Facility Information']/ancestor-or-self::div[@class='seccion-header']/following-sibling::div//";

	public static final Target TITTLE = Target.the("Service Facility Information")
			.locatedBy("//h1[.='Service Facility Information']");
	public static final Target FACILITY_NAME = Target.the("Facility Name")
			.locatedBy(init + "label[.='Facility Name *']/ancestor-or-self::div/following-sibling::div/input");
	public static final Target ADDRESS_ONE = Target.the("Address 1")
			.locatedBy(init + "label[.='Address 1 *']/ancestor-or-self::div/following-sibling::div/input");
	public static final Target ADDRESS_TWO = Target.the("Address 2")
			.locatedBy(init + "label[.='Address 2 ']/ancestor-or-self::div/following-sibling::div/input");
	public static final Target CITY = Target.the("City")
			.locatedBy(init + "label[.='City *']/ancestor-or-self::div/following-sibling::div/input");
	public static final Target STATE = Target.the("State")
			.locatedBy(init + "label[.='State *']/ancestor-or-self::div/following-sibling::div/input");
	public static final Target ZIP_CODE = Target.the("Zip Code")
			.locatedBy(init + "label[.='Zip Code *']/ancestor-or-self::div/following-sibling::div/input");
	public static final Target ZIP_CODE_EXT = Target.the("Zip Code Ext")
			.locatedBy(init + "label[.='Zip Code Ext.']/ancestor-or-self::div/following-sibling::div/input");
	public static final Target NPI_NUMBER = Target.the("NPI #")
			.locatedBy(init + "label[.='NPI #']/ancestor-or-self::div/following-sibling::div/input");
	public static final Target OTHER_ID_NUMBER = Target.the("Other ID #")
			.locatedBy(init + "label[.='Other ID #']/ancestor-or-self::div/following-sibling::div/input");

}