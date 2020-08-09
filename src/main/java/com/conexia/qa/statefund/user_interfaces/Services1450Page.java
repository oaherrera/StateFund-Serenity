package com.conexia.qa.statefund.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;

public class Services1450Page {

	private Services1450Page() {
	}

	public static final Target TITTLE = Target.the("Services").locatedBy("//h1[.='Services']");
	public static final Target FROM_DATE = Target.the("From Date").locatedBy("//input[contains(@id,'fromDate_input')]");
	public static final Target TO_DATE = Target.the("To Date").locatedBy("//input[contains(@id,'toDate_input')]");
	public static final Target TREATMENT_AUTHORIZATION_CODE = Target.the("Treatment Authorization Code")
			.locatedBy("//input[contains(@id,'treatmentCode')]");
	public static final Target RESERVED_FOR_ASSIGMENT_BY_THE_NUBC = Target.the("Reserved for Assigment by the NUBC")
			.locatedBy("//input[contains(@id,'rsvrAssNubc2')]");
	public static final Target REVENUE_CODE = Target.the("Revenue Code")
			.locatedBy("//input[contains(@id,'revenueCode')]");
	public static final Target REVENUE_DESCRIPTION = Target.the("Revenue Description")
			.locatedBy("//input[contains(@id,'revenueDescription')]");
	public static final Target SERVICE_DATE = Target.the("Service Date")
			.locatedBy("//input[contains(@id,'serviceDateC_input')]");
	public static final Target AMOUNT_PER_TREATMENT = Target.the("Amount per Treatment")
			.locatedBy("//input[contains(@id,'amountPerTreatInput')]");
	public static final Target PRIOR_PAYMENTS = Target.the("Prior Payments")
			.locatedBy("//input[contains(@id,'prior')]");
	public static final Target ESTIMATED_AMOUNT_DUE = Target.the("Estimated Amount Due")
			.locatedBy("//input[contains(@id,'estimated')]");

}