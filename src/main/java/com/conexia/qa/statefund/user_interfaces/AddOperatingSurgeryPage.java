package com.conexia.qa.statefund.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;

public class AddOperatingSurgeryPage {

	private AddOperatingSurgeryPage() {
	}

	public static final Target ADD_OPERATING = Target.the("Add Operating")
			.locatedBy("//span[.='Add Operating']/ancestor-or-self::button");
	public static final Target OPERATING_NPI = Target.the("NPI").locatedBy("//input[contains(@id,'npiOpe')]");
	public static final Target OPERATING_QUALIFIER = Target.the("Qualifier")
			.locatedBy("//input[contains(@id,'qualifierOpe')]");
	public static final Target OPERATING_FIRST_NAME = Target.the("First Name")
			.locatedBy("//input[contains(@id,'firstNameOpe')]");
	public static final Target OPERATING_LAST_NAME = Target.the("Last Name")
			.locatedBy("//input[contains(@id,'lastNameOpe')]");
	public static final Target OPERATING_SAVE = Target.the("Save")
			.locatedBy("//div[contains(@id,'dlgOperating')]//span[.='Save']/ancestor-or-self::button");

}