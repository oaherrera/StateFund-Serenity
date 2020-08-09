package com.conexia.qa.statefund.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;

public class BillingProviderInformation1500Page {

	private BillingProviderInformation1500Page() {
	}

	private static String init = "//h1[.='Billing Provider Information']/ancestor-or-self::div[@class='seccion-header']/following-sibling::div//";
	public static final Target TITTLE = Target.the("Billing Provider Information")
			.locatedBy("//h1[.='Billing Provider Information']");
	public static final Target FIRST_NAME = Target.the("Provider's First Name")
			.locatedBy(init + "label[.=\"Provider's First Name *\"]/ancestor-or-self::div/div/input");
	public static final Target MIDDLE_NAME = Target.the("Provider's Middle Name")
			.locatedBy(init + "label[.=\"Provider's Middle Name *\"]/ancestor-or-self::div/div/input");
	public static final Target LAST_NAME = Target.the("Provider's Last Name")
			.locatedBy(init + "label[.=\"Provider's Last Name *\"]/ancestor-or-self::div/div/input");
	public static final Target ADDRESS_ONE = Target.the("Billing Address 1")
			.locatedBy(init + "label[contains(@id,'billingAdress1')]/ancestor-or-self::div/div/input");
	public static final Target ADDRESS_TWO = Target.the("Billing Address 2")
			.locatedBy(init + "label[.='Billing Address 2 *']/ancestor-or-self::div/div/input");
	public static final Target CITY = Target.the("City")
			.locatedBy(init + "label[.='City *']/ancestor-or-self::div/div/input");
	public static final Target STATE = Target.the("State")
			.locatedBy(init + "label[.='State *']/ancestor-or-self::div/div/input");
	public static final Target ZIP_CODE = Target.the("Zip Code")
			.locatedBy(init + "label[.='Zip Code *']/ancestor-or-self::div/div/input");
	public static final Target ZIP_CODE_EXT = Target.the("Zip Code Ext")
			.locatedBy(init + "label[.='Zip Code Ext.']/ancestor-or-self::div/div/input");
	public static final Target TELEPHONE = Target.the("Telephone")
			.locatedBy(init + "label[.='Telephone*']/ancestor-or-self::div/div/input");
	public static final Target TELEPHONE_EXT = Target.the("Telephone Ext")
			.locatedBy(init + "label[.='Telephone Ext.']/ancestor-or-self::div/div/input");
	public static final Target SIGNATURE_OF_PHYSICIAN_OR_SUPPLIER = Target.the("Signature of Physician or Supplier")
			.locatedBy(init + "label[.='Signature of Physician or Supplier *']/ancestor-or-self::div/div/input");
	public static final Target NPI_NUMBER = Target.the("NPI #")
			.locatedBy(init + "label[.='NPI #']/ancestor-or-self::div/div/input");
	public static final Target OTHER_ID_NUMBER = Target.the("Other ID #")
			.locatedBy(init + "label[.='Other ID #']/ancestor-or-self::div/div/input");
	public static final Target DEGREE = Target.the("Degree")
			.locatedBy(init + "label[.='Degree *']/ancestor-or-self::div/div/input");
	public static final Target DATE = Target.the("Date")
			.locatedBy(init + "label[.='Date *']/following-sibling::*//input");
	public static final Target FEDERAL_TAX_ID = Target.the("Federal Tax ID {0}")
			.locatedBy(init + "label[.='Federal Tax ID *']/following-sibling::*//label[.='{0}']");
	public static final Target PROVIDER_FED_TAX_ID = Target.the("Provider’s Fed. Tax ID")
			.locatedBy(init + "label[.=\"Provider’s Fed. Tax ID *\"]/following-sibling::*/input");

}