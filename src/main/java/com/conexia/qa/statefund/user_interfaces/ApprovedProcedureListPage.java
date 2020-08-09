package com.conexia.qa.statefund.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;

public class ApprovedProcedureListPage {

	private ApprovedProcedureListPage() {
	}

	public static final Target TITTLE = Target.the("Approved Procedure List")
			.locatedBy("//h1[.='Approved Procedure List']");
	public static final Target CHECKBOX_PROCEDURE = Target.the("Active Procedure").locatedBy(
			"//input[@type='checkbox']/ancestor-or-self::div/following-sibling::div/span[contains(@class,'blank')]");
	public static final Target BILLING_QUANTITY = Target.the("Billing Quantity")
			.locatedBy("//span[.='Billing Quantity']/following-sibling::span/input");
	public static final Target ADD_BILLING_QUANTITY = Target.the("Add Billing Quantity")
			.locatedBy("//a[contains(@class,'ui-spinner-up')]");
	public static final Target VIEW = Target.the("").locatedBy("");

}