package com.conexia.qa.statefund.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;

public class Summary1450Page {

	private Summary1450Page() {
	}

	public static final Target I_ACCEPT_THE_RELEASE = Target.the("I accept the relese")
			.locatedBy("//div[contains(@id,'checkboxId')]//span");
	public static final Target I_ACCEPT_THE_ASSIGMENT = Target.the("I accept the assigment")
			.locatedBy("//div[contains(@id,'checkboxId2')]//span");

}