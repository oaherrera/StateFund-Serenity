package com.conexia.qa.statefund.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;

public class SummaryADAPage {

	private SummaryADAPage() {
	}

	public static final Target SUBSCRIBER_SIGNATURE = Target.the("Subscriber Signature")
			.locatedBy("//input[contains(@id,'patientSignature')]");
	public static final Target SUBSCRIBER_DATE = Target.the("Subscriber Date")
			.locatedBy("//input[contains(@id,'dateSignature_input')]");
	public static final Target TREATING_DENTIST_SIGNATURE = Target.the("Treating Dentist Signature")
			.locatedBy("//input[contains(@id,'treatingDentisSignature')]");
	public static final Target TREATING_DATE = Target.the("Treating Date")
			.locatedBy("//input[contains(@id,'dateSignatureTreating_input')]");

}