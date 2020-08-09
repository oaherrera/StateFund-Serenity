package com.conexia.qa.statefund.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;

public class ClaimSearchPage {

	private ClaimSearchPage() {
	}

	public static final Target WORKER_INFORMATION = Target.the("Search by Worker's Information")
			.locatedBy("//a[text()=\"Worker's Information\"]/ancestor-or-self::li");
	public static final Target FIRST_NAME = Target.the("First Name")
			.locatedBy("//label[text()='First Name*']//ancestor-or-self::div[1]/following-sibling::div/input");
	public static final Target LAST_NAME = Target.the("Last Name")
			.locatedBy("//label[text()='Last Name*']//ancestor-or-self::div[1]/following-sibling::div/input");
	public static final Target DATE_OF_INJURY = Target.the("Date of Injury")
			.locatedBy("//label[text()='Date of Injury']//ancestor-or-self::div[1]/following-sibling::div//input");
	public static final Target BUTTON_DATE_OF_INJURY = Target.the("Date of Injury")
			.locatedBy("//*[@id='form:seccion:tabs:workerDateofInjury']/button");
	public static final Target ACTUAL_DAY = Target.the("Actual day")
			.locatedBy("//td[@class=' ui-datepicker-days-cell-over  ui-datepicker-today']");
	public static final Target CLAIM = Target.the("Search by Claim").locatedBy("//a[text()='Claim']");
	public static final Target CLAIM_NUMBER = Target.the("Claim Number")
			.locatedBy("//label[text()='Claim Number*']//ancestor-or-self::div[1]/following-sibling::div/input");
	public static final Target SUBMIT_A_NON_CLAIM_RFA = Target.the("Submit a Non-Claim RFA")
			.locatedBy("//span[text()='Submit a Non-Claim RFA']/ancestor-or-self::a");

	public static final Target ACTION_VIEW = Target.the("View")
			.locatedBy("//span[text()='Actions']/following-sibling::button");
	public static final Target CLAIM_NUMBER_LABEL = Target.the("Claim Number")
			.locatedBy("//h1[text()='Claim Details - Claim Number: {0}']");
	public static final Target SUBMIT_RFA = Target.the("View")
			.locatedBy("//span[text()='Submit RFA']/ancestor-or-self::button");

	public static final Target NO_RESULTS_LABEL = Target.the("No Results")
			.locatedBy("//td/span[.='Date of injury']/following-sibling::div");

	public static final Target RESULT_FIRST_NAME = Target.the("First Name")
			.locatedBy("//td/span[.='First Name']/following-sibling::span");
	public static final Target RESULT_MIDDLE_NAME = Target.the("Middle Name")
			.locatedBy("//td/span[.='Middle Name']/following-sibling::span");
	public static final Target RESULT_LAST_NAME = Target.the("Last Name")
			.locatedBy("//td/span[.='Last Name']/following-sibling::span");
	public static final Target RESULT_DATE_OF_INJURY = Target.the("Date of injury")
			.locatedBy("//td/span[.='Date of injury']/following-sibling::span");
	public static final Target RESULT_CLAIM_NUMBER = Target.the("Claim Number")
			.locatedBy("//td/span[.='Claim Number']/following-sibling::span");
	public static final Target RESULT_CLAIM_DECISION = Target.the("Claim Decision")
			.locatedBy("//td/span[.='Claim Decision']/following-sibling::span");
	public static final Target FIRST_NAME_LABEL = Target.the("First Name").locatedBy("//label[text()='First Name*']");
	public static final Target LAST_NAME_LABEL = Target.the("Last Name").locatedBy("//label[text()='Last Name*']");

	public static final Target CLEAR_RESULTS = Target.the("Clear Results")
			.locatedBy("//*[text()='Clear Results']/ancestor::button");

	public static final Target SAVED_DRAFTS = Target.the("Saved Drafts")
			.locatedBy("//button[contains(@id,'seccion:')]//span[contains(text(),'Saved Drafts')]");
	public static final Target TITTLE_CLAIM_DETAILS = Target.the("Tittle Claim Details")
			.locatedBy("//h1[contains(text(),'Claim Details - Claim Number:')]");

}