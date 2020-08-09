package com.conexia.qa.statefund.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;

public class InboxPage {

	private InboxPage() {
	}

	public static final Target TITTLE = Target.the("Permission Requests")
			.locatedBy("//h1[text()='Permission Requests']");

}