package com.conexia.qa.statefund.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;

public class ClaimDetailsPage {

	private ClaimDetailsPage() {
	}

	public static final Target CLAIM_NUMBER = Target.the("Claim Number {0}")
			.locatedBy("//h1[contains(text(),'Claim Details - Claim Number: {0}')]");
	public static final Target INJURED_WORKER_NAME = Target.the("Injured Worker's Name")
			.locatedBy("//div[contains(text(),'Injured Worker')]/child::label");
	public static final Target DATE_OF_BIRTH = Target.the("Date of Birth")
			.locatedBy("//div[contains(text(),'Date of Birth:')]/child::label");
	public static final Target DATE_OF_INJURY = Target.the("Date of Injury")
			.locatedBy("//div[contains(text(),'Date of Injury:')]/child::label");
	public static final Target EMPLOYER_NAME = Target.the("Employer Name")
			.locatedBy("//div[contains(text(),'Employer Name:')]/child::label");
	public static final Target CLAIM_NUMBER_UNDEFINED = Target.the("Claim Number")
			.locatedBy("//h1[contains(text(),'Claim Details - Claim Number')]");

	public static final Target CLAIM_DETAILS = Target.the("Claim Details").locatedBy("//h1[text()='Claim Details']");
	public static final Target REQUESTED_BODY_PARTS = Target.the("Requested Body Parts")
			.locatedBy("//button[normalize-space(.)='Requested Body Parts']");
	public static final Target RELATED_CLAIMS = Target.the("Related Claims")
			.locatedBy("//button[normalize-space(.)='Related Claims']");
	public static final Target SAVED_DRAFTS = Target.the("Saved Drafts")
			.locatedBy("//button[normalize-space(.)='Saved Drafts']");

	public static final Target SUBMIT_RFA = Target.the("Submit RFA")
			.locatedBy("//button[normalize-space(.)='Submit RFA']");

	public static final Target ACTIONS_EDIT = Target.the("Actions Icon")
			.locatedBy("(//span[contains(text(),'Edit')]//ancestor::button)[1]");
	public static final Target ACTIONS_DELETE = Target.the("Actions Delete")
			.locatedBy("(//span[contains(text(),'Delete')]//ancestor::button)[1]");
	public static final Target OPTION_YES_DELETE = Target.the("Option yes Delete")
			.locatedBy("//button[contains(@id,'confirmationButton')]");

	public static final Target REQUEST_FOR_AUTORIZATION_CLAIM_NUMBER = Target
			.the("Request for Authorization - Claim Number: {0}")
			.locatedBy("//h1[.='Request for Authorization - Claim Number: {0}']");

}