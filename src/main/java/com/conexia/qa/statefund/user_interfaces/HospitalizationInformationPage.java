package com.conexia.qa.statefund.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;

public class HospitalizationInformationPage {

	private HospitalizationInformationPage() {
	}

	private static String init = "//h1[.='Hospitalization Information']/ancestor-or-self::div[@class='seccion-header']/following-sibling::div//";

	public static final Target TITTLE = Target.the("Outside LAB").locatedBy("//h1[.='Hospitalization Information']");
	public static final Target DISCHARGE_HOUR = Target.the("Discharge Hour").locatedBy(init
			+ "label[.='Discharge Hour']/ancestor-or-self::div/following-sibling::div/following-sibling::div/div/span/input[contains(@id,'dischargeHour')]");
	public static final Target PATIENT_DISCHARGE_STATUS = Target.the("Patient Discharge Status").locatedBy(init
			+ "label[.='Patient Discharge Status']/ancestor-or-self::div/following-sibling::div/following-sibling::div/div//input[contains(@id,'patientStatus')]");
	public static final Target OCCURRENCE_CODE = Target.the("Occurrence Code")
			.locatedBy("//input[contains(@id,'codeMand')]");
	public static final Target OCCURRENCE_DATE = Target.the("Occurrence Date")
			.locatedBy("//input[contains(@id,'dateHospi')]");
	public static final Target ADD_OCURRENCE = Target.the("Add Occurrence")
			.locatedBy("//button[contains(@id,'ocurrenceButton')]");
	public static final Target OCCURRENCE_SPAN_CODE = Target.the("Occurrence Span Code")
			.locatedBy("//input[contains(@id,'codeOccurrence')]");
	public static final Target OCCURRENCE_SPAN_FROM_DATE = Target.the("Occurrence Span From Date")
			.locatedBy("//input[contains(@id,'fromDateOcurr')]");
	public static final Target OCCURRENCE_SPAN_THROUGH_DATE = Target.the("Occurrence Span Through Date")
			.locatedBy("//input[contains(@id,'throughDateOcurr')]");
	public static final Target ADD_OCCURRENCE_SPAN = Target.the("Add Occurrence Span")
			.locatedBy("//button[contains(@id,'spanOcurrences')]");
	public static final Target RESERVED_FOR_ASSIGMENT_BY_THE_NUBC = Target.the("Reserved for Assigment by the NUBC")
			.locatedBy("//input[contains(@id,'rsvrAssNubc2')]");

}