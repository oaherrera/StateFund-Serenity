package com.conexia.qa.statefund.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;

public class Summary1500Page {

	private Summary1500Page() {
	}

	public static final Target I_ACCEPT_THE_ASSIGMENT = Target.the("I accept the assigment")
			.locatedBy("//div[contains(@id,'checkboxId')]//span");

}