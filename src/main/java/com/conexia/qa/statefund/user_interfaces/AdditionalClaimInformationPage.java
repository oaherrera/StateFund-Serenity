package com.conexia.qa.statefund.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;

public class AdditionalClaimInformationPage {

	private AdditionalClaimInformationPage() {
	}

	private static String init = "//h1[.='Additional Claim Information']/ancestor-or-self::div[@class='seccion-header']/following-sibling::div//";
	public static final Target TITTLE = Target.the("Additional Claim Information")
			.locatedBy("//h1[.='Additional Claim Information']");
	public static final Target ADDITIONAL_CLAIM_INFORMATION = Target.the("Additional Claim Information").locatedBy(
			init + "label[.='Additional Claim Information']/ancestor-or-self::div/following-sibling::div/input");

}