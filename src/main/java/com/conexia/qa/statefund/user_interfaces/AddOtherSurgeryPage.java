package com.conexia.qa.statefund.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;

public class AddOtherSurgeryPage {

	private AddOtherSurgeryPage() {
	}

	public static final Target ADD_OTHER = Target.the("Add Other")
			.locatedBy("//span[.='Add Other']/ancestor-or-self::button");
	public static final Target PROVIDER_ONE_NPI = Target.the("Provider 1 NPI").locatedBy(
			"(//div[@id='form:dlgOther']//label[.='NPI'])[1]/ancestor-or-self::div/following-sibling::div/input");
	public static final Target PROVIDER_ONE_QUALIFIER = Target.the("Provider 1 Qualifier").locatedBy(
			"(//div[@id='form:dlgOther']//label[.='Qualifier'])[1]/ancestor-or-self::div/following-sibling::div/input");
	public static final Target PROVIDER_ONE_FIRST_NAME = Target.the("Provider 1 First Name").locatedBy(
			"(//div[@id='form:dlgOther']//label[.='First Name'])[1]/ancestor-or-self::div/following-sibling::div/input");
	public static final Target PROVIDER_ONE_LAST_NAME = Target.the("Provider 1 Last Name").locatedBy(
			"(//div[@id='form:dlgOther']//label[.='Last Name'])[1]/ancestor-or-self::div/following-sibling::div/input");
	public static final Target PROVIDER_TWO_NPI = Target.the("Provider 2 NPI").locatedBy(
			"(//div[@id='form:dlgOther']//label[.='NPI'])[2]/ancestor-or-self::div/following-sibling::div/input");
	public static final Target PROVIDER_TWO_QUALIFIER = Target.the("Provider 2 Qualifier").locatedBy(
			"(//div[@id='form:dlgOther']//label[.='Qualifier'])[2]/ancestor-or-self::div/following-sibling::div/input");
	public static final Target PROVIDER_TWO_FIRST_NAME = Target.the("Provider 2 First Name").locatedBy(
			"(//div[@id='form:dlgOther']//label[.='First Name'])[2]/ancestor-or-self::div/following-sibling::div/input");
	public static final Target PROVIDER_TWO_LAST_NAME = Target.the("Provider 2 Last Name").locatedBy(
			"(//div[@id='form:dlgOther']//label[.='Last Name'])[2]/ancestor-or-self::div/following-sibling::div/input");
	public static final Target PROVIDER_SAVE = Target.the("Save")
			.locatedBy("//div[contains(@id,'dlgOther')]//span[.='Save']/ancestor-or-self::button");

}