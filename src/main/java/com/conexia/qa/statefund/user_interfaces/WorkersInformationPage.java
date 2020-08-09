package com.conexia.qa.statefund.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;

public class WorkersInformationPage {

	private WorkersInformationPage() {
	}

	public static final Target WORKER_FIRST_NAME = Target.the("Worker's First Name")
			.locatedBy("//input[contains(@id,'firstName')]");
	public static final Target WORKER_MIDDLE_NAME = Target.the("Worker's Middle Name")
			.locatedBy("//input[contains(@id,'middleName')]");
	public static final Target WORKER_LAST_NAME = Target.the("Worker's Last Name")
			.locatedBy("//input[contains(@id,'lastName')]");
	public static final Target DATE_OF_BIRTH = Target.the("Date of Birth")
			.locatedBy("//input[contains(@id,'dateOfBirth')]");
	public static final Target DATE_OF_INJURY = Target.the("Date of Injury")
			.locatedBy("//input[contains(@id,'dateOfInjur')]");
	public static final Target RFA_TYPE_LABEL = Target.the("{0}").locatedBy("//label[text()='RFA Type:*']");
	public static final Target RFA_TYPE_OPTION = Target.the("{0}").locatedBy("//label[text()='{0}']");
	public static final Target RFA_TYPE_OPTION_NEW_REQUEST = Target.the("New Request")
			.locatedBy("//label[text()='New Request']//preceding::div[1]");
	public static final Target RFA_TYPE_OPTION_RESUBMISSION = Target.the("Resubmission")
			.locatedBy("//label[text()='Resubmission']//preceding::div[1]");
	public static final Target RFA_TYPE_OPTION_EXPEDITED = Target.the("Expedited")
			.locatedBy("//label[text()='Expedited']//preceding::div[1]");
	public static final Target RFA_TYPE_OPTION_WRITTEN_CONFIRMATION_OR_PRIOR_ORAL_REQUEST = Target
			.the("Written Confirmation or Prior Oral Request")
			.locatedBy("//label[text()='Written Confirmation or Prior Oral Request']//preceding::div[1]");

}