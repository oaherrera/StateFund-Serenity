package com.conexia.qa.statefund.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;

public class BillingProviderInformation1450Page {

	private BillingProviderInformation1450Page() {
	}

	public static final Target TITTLE = Target.the("Billing Provider Information")
			.locatedBy("//h1[.='Billing Provider Information']");
	public static final Target TYPE_OF_BILL = Target.the("Type of Bill")
			.locatedBy("//input[contains(@id,'typeOfBill')]");
	public static final Target BILLING_PROVIDER_NAME = Target.the("Billing Provider Name")
			.locatedBy("//input[contains(@id,'billingProviderName1')]");
	public static final Target ADDRESS_ONE = Target.the("Address 1")
			.locatedBy("//input[contains(@id,'billingAdress1')]");
	public static final Target ADDRESS_TWO = Target.the("Address 2")
			.locatedBy("//input[contains(@id,'billingAdress2')]");
	public static final Target CITY = Target.the("City").locatedBy("//input[contains(@id,'cityBilling1')]");
	public static final Target STATE = Target.the("State").locatedBy("//input[contains(@id,'stateBilling1')]");
	public static final Target ZIP_CODE = Target.the("Zip Code").locatedBy("//input[contains(@id,'zipCodeBilling1')]");
	public static final Target TELEPHONE = Target.the("Telephone")
			.locatedBy("//input[contains(@id,'telephoneBilling1')]");
	public static final Target TELEPHONE_EXT = Target.the("Telephone Ext")
			.locatedBy("//input[contains(@id,'telephoneExt1')]");
	public static final Target FAX_NUMBER = Target.the("Fax Number").locatedBy("//input[contains(@id,'faxNumber1')]");
	public static final Target FEDERAL_TAX_NUMBER = Target.the("Federal Tax Number")
			.locatedBy("//input[contains(@id,'FederalTaxNumber1')]");
	public static final Target NATIONAL_PROVIDER_IDENTIFIER = Target.the("National Provider Identifier")
			.locatedBy("//input[contains(@id,'nationalProviderIdentifier1')]");
	public static final Target OTHER_BILLING_PROVODER_ID = Target.the("Other Billing Provider ID")
			.locatedBy("//input[contains(@id,'otherBillingProviderId1')]");
	public static final Target QUALIFIER = Target.the("Qualifier").locatedBy("//input[contains(@id,'qual1')]");
	public static final Target CODE = Target.the("Code").locatedBy("//input[contains(@id,'code1')]");
	public static final Target VALUE = Target.the("Value").locatedBy("//input[contains(@id,'value1')]");
	public static final Target ADD = Target.the("Add").locatedBy("//span[.='Add']/ancestor-or-self::button");
	public static final Target BILLING_PROVIDER_DIFERENT_FROM_PAY = Target
			.the("Billing Provider different from Pay-To Provider {0}").locatedBy("//label[.='{0}']");

}