package com.conexia.qa.statefund.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;

public class WorkerTableTitlesPage {

	private WorkerTableTitlesPage() {
	}

	public static final Target WORKER_FIRST_NAME = Target.the("Worker's First Name")
			.locatedBy("//*[@id=\"form:seccion:dataTable:firstName\"]");
	public static final Target WORKER_MIDDLE_NAME = Target.the("Worker's Middle Name")
			.locatedBy("//*[@id=\"form:seccion:dataTable:middleName\"]");
	public static final Target WORKER_LAST_NAME = Target.the("Worker's Last Name")
			.locatedBy("//*[@id=\"form:seccion:dataTable:lastName\"]");
	public static final Target DATE_OF_INJURY = Target.the("Date of Injury")
			.locatedBy("//*[@id=\"form:seccion:dataTable:DOI\"]");
	public static final Target CLAIM_NUMBER = Target.the("Claim Number")
			.locatedBy("//*[@id=\"form:seccion:dataTable:claimNumber\"]");
	public static final Target CLAIM_DESICION = Target.the("Claim Decision")
			.locatedBy("//*[@id=\"form:seccion:dataTable:claimDecision\"]");
	public static final Target ACTIONS = Target.the("Actions").locatedBy("//*[@id=\"form:seccion:dataTable:buttons\"]");

}