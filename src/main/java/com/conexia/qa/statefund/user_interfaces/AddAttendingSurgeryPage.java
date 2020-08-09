package com.conexia.qa.statefund.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;

public class AddAttendingSurgeryPage {

	private AddAttendingSurgeryPage() {
	}

	public static final Target ADD_ATTENDING = Target.the("Add Attending")
			.locatedBy("//span[.='Add Attending']/ancestor-or-self::button");
	public static final Target ATTENDING_NPI = Target.the("NPI").locatedBy("//input[contains(@id,'npiAtt')]");
	public static final Target ATTENDING_QUALIFIER = Target.the("Qualifier")
			.locatedBy("//input[contains(@id,'qualifierAtt')]");
	public static final Target ATTENDING_FIRST_NAME = Target.the("First Name")
			.locatedBy("//input[contains(@id,'firstNameAtt')]");
	public static final Target ATTENDING_LAST_NAME = Target.the("Last Name")
			.locatedBy("//input[contains(@id,'lastNameAtt')]");
	public static final Target ATTENDING_SAVE = Target.the("Save")
			.locatedBy("//div[contains(@id,'dlgAttending')]//span[.='Save']/ancestor-or-self::button");

}