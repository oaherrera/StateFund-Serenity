package com.conexia.qa.statefund.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;

public class SurgeryInformationPage {

	private SurgeryInformationPage() {
	}

	public static final Target TITTLE = Target.the("Surgery Information").locatedBy("//h1[.='Surgery Information']");
	public static final Target WAS_A_SURGERY_PERFORMED = Target.the("Was a surgery performed? {0}").locatedBy(
			"//h1[.='Surgery Information']/ancestor-or-self::div[@class='seccion-header']/following-sibling::div//label[.='{0}']");
	public static final Target CODE = Target.the("Code").locatedBy("//input[contains(@id,'codeOther')]");
	public static final Target DATE = Target.the("Date").locatedBy("//input[contains(@id,'dateOther')]");
	public static final Target TYPE = Target.the("Principal").locatedBy("//span[.='Principal']");
	public static final Target ADD = Target.the("Add")
			.locatedBy("//span[.='Add']/ancestor-or-self::button[contains(@id,'surgeryButton')]");

}