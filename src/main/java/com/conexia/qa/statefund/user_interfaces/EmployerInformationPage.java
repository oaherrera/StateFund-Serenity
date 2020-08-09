package com.conexia.qa.statefund.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;

public class EmployerInformationPage {

	private EmployerInformationPage() {
	}

	public static final Target EMPLOYER_NAME = Target.the("Employer Name")
			.locatedBy("//input[contains(@id,'employername')]");

}