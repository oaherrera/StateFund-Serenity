package com.conexia.qa.statefund.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;

public class AncillaryClaimTreatmentInformationPage {

	private AncillaryClaimTreatmentInformationPage() {
	}

	public static final Target TITTLE = Target.the("Ancillary Claim/Treatment Information")
			.locatedBy("//h1[.='Ancillary Claim/Treatment Information']");
	public static final Target PLACE_OF_TREATMENT = Target.the("Place of Treatment is {0}")
			.locatedBy("//label[.='Place of Treatment*']/following-sibling::div//label[.=\"{0}\"]");
	public static final Target RADIOGRAPH = Target.the("Radiograph(s)")
			.locatedBy("//input[contains(@id,'radiographInput')]");
	public static final Target ORAL_IMAGES = Target.the("Oral Images")
			.locatedBy("//input[contains(@id,'oralImagesInput')]");
	public static final Target MODEL = Target.the("Model(s)").locatedBy("//input[contains(@id,'modelsInput')]");
	public static final Target IS_TREATMENT_FOR_ORTHODONTICS = Target.the("Is Treatment for Orthodontics? {0}")
			.locatedBy("//label[.='Is Treatment for Orthodontics?*']/following-sibling::div//label[.='{0}']");
	public static final Target DATE_APPLIANCE_PLACED = Target.the("Date Appliance Placed")
			.locatedBy("//input[contains(@id,'dateAppliancePlacedCalendar_input')]");
	public static final Target MONTHS_OF_TREATMENT_REMAINING = Target.the("Months of Treatment Remaining")
			.locatedBy("//input[contains(@id,'monthsRemainingInput')]");
	public static final Target REPLACEMENT_OF_PROTHESIS = Target.the("Replacement of Prothesis? {0}")
			.locatedBy("//label[.='Replacement of Prosthesis?']/following-sibling::div//label[.='{0}']");
	public static final Target DATE_PRIOR_REPLACEMENT = Target.the("Date Prior Replacement")
			.locatedBy("//input[contains(@id,'datePriorReplacementCalendar_input')]");
	public static final Target TREATMENT_RESULTING_FROM = Target.the("Treatment Resulting From {0}")
			.locatedBy("//label[.='Treatment Resulting From*']/following-sibling::div//label[.='{0}']");
	public static final Target AUTO_ACCIDENT_STATE = Target.the("Auto Accident State")
			.locatedBy("//select[contains(@id,'accident_input')]");

}