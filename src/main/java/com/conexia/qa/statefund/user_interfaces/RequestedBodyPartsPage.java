package com.conexia.qa.statefund.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;

public class RequestedBodyPartsPage {

	private RequestedBodyPartsPage() {
	}

	public static final Target REQUESTED_BODY_PARTS = Target.the("Requested Body Parts")
			.locatedBy("//*[@id='requestedBodyPartsDialog_content']//tr/td[1]");
	public static final Target DECISION = Target.the("Decision")
			.locatedBy("//*[@id='requestedBodyPartsDialog_content']//tr/td[2]");

}