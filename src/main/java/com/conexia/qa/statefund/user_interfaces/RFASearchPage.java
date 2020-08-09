package com.conexia.qa.statefund.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;

public class RFASearchPage {

	private RFASearchPage() {
	}

	public static final Target WORKER_INFORMATION = Target.the("Search by Worker's Information")
			.locatedBy("//a[text()=\"Worker's Information\"]/ancestor-or-self::li");
	public static final Target FIRST_NAME = Target.the("First Name")
			.locatedBy("//label[text()='First Name*']//ancestor-or-self::div[1]/following-sibling::div/input");
	public static final Target LAST_NAME = Target.the("Last Name")
			.locatedBy("//label[text()='Last Name*']//ancestor-or-self::div[1]/following-sibling::div/input");
	public static final Target DATE_OF_INJURY = Target.the("Date of Injury")
			.locatedBy("//label[text()='Date of Injury*']//ancestor-or-self::div[1]/following-sibling::div//input");
	public static final Target RFA = Target.the("Search by RFA").locatedBy("//a[text()='RFA']");
	public static final Target RFA_ID = Target.the("RFA ID")
			.locatedBy("//label[text()='RFA ID']//ancestor-or-self::div[1]/following-sibling::div/input");
	public static final Target CLAIM_NUMBER = Target.the("Claim Number")
			.locatedBy("//label[text()='Claim Number']//ancestor-or-self::div[1]/following-sibling::div/input");
	public static final Target VIEW = Target.the("Action View")
			.locatedBy("//span[text()='View']/ancestor-or-self::button");

}