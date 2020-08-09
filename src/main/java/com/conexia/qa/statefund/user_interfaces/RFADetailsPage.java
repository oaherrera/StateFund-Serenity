package com.conexia.qa.statefund.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;

public class RFADetailsPage {

	private RFADetailsPage() {
	}

	public static final Target RFA_ID = Target.the("RFA ID # ").locatedBy("//h1[contains(.,'RFA ID #')]");
	public static final Target SUBMIT_EBILL = Target.the("Submit Ebill")
			.locatedBy("//span[.='Submit Ebill']/ancestor-or-self::button");
	public static final Target EBILL_TYPE = Target.the("Ebill Type {0}").locatedBy("//label[text()='{0}']");

}