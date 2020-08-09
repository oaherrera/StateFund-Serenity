package com.conexia.qa.statefund.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;

public class MissingTeethInformationPage {

	private MissingTeethInformationPage() {
	}

	public static final Target TITTLE = Target.the("Missing Teeth Information")
			.locatedBy("//h1[.='Missing Teeth Information']");
	public static final Target IS_THE_PATIENT_MISSING_ANY_TEETH = Target.the("Is the patient missing any teeth? {0}")
			.locatedBy("//label[.='Is the patient missing any teeth?']/following-sibling::table//label[.='{0}']");
	public static final Target TEETH_NUMBER = Target.the("Teeth #{0}")
			.locatedBy("//div[contains(@id,'missingTeethSeccion')]//span[.='{0}']");
	public static final Target PRIMARY_TEETH = Target.the("Primary Teeth").locatedBy("//span[.='Primary Teeth']");
	public static final Target PRIMARY_TEETH_ID = Target.the("Primary Teeth {0}")
			.locatedBy("//div[contains(@id,'missingTeethSeccion')]//span[.='{0}']");

}