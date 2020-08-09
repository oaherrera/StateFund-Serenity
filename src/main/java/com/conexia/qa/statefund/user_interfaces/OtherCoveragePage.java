package com.conexia.qa.statefund.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;

public class OtherCoveragePage {

	private OtherCoveragePage() {
	}

	public static final Target TITTLE = Target.the("Other Coverage").locatedBy("//h1[.='Other Coverage']");
	public static final Target OTHER_DENTAL_OR_MEDICAL_COVERAGE = Target.the("Other Dental or Medical Coverage? {0}")
			.locatedBy("//label[.='{0}']");
	public static final Target SUFFIX = Target.the("Suffix")
			.locatedBy("//select[contains(@id,'selectOthersuffix_input')]");
	public static final Target POLICYHOLDER_SUBSCRIBER_FIRST_NAME = Target.the("Policyholder/Subscriber's First Name")
			.locatedBy("//input[contains(@id,'policyFirst')]");
	public static final Target POLICYHOLDER_SUBSCRIBER_MIDDLE_NAME = Target.the("Policyholder/Subscriber's Middle Name")
			.locatedBy("//input[contains(@id,'policyMiddle')]");
	public static final Target POLICYHOLDER_SUBSCRIBER_LAST_NAME = Target.the("Policyholder/Subscriber's Last Name")
			.locatedBy("//input[contains(@id,'policyLast')]");
	public static final Target DATE_OF_BIRTH = Target.the("Date of Birth")
			.locatedBy("//input[contains(@id,'dateofBirthOtherCalendar_input')]");
	public static final Target GENDER = Target.the("Gender").locatedBy(
			"//h1[.='Other Coverage']/ancestor-or-self::div[@class='seccion-header']/following-sibling::div//label[.='{0}']");
	public static final Target POLICYHOLDER_SUBSCRIBER_ID = Target.the("Policyholder/Subscriber ID (SSN or ID#)")
			.locatedBy("//input[contains(@id,'policyID')]");
	public static final Target PLAN_GROUP_NAME = Target.the("Plan/Group Name")
			.locatedBy("//input[contains(@id,'policyGroupName')]");
	public static final Target RELATIONSHIP_TO_POLICYHOLDER_SUBSCRIBER = Target
			.the("{0} Relationship To Policyholder/Subscriber").locatedBy(
					"//h1[.='Other Coverage']/ancestor-or-self::div[@class='seccion-header']/following-sibling::div//label[.='{0}']");
	public static final Target OTHER_INSURANCE_COMPANY_NAME = Target.the("Other Insurance Company Name")
			.locatedBy("//input[contains(@id,'payerOtherInsuranceCompanyName')]");
	public static final Target ADDRESS_ONE = Target.the("Address 1")
			.locatedBy("//input[contains(@id,'payerOtherAddress1')]");
	public static final Target CITY = Target.the("City").locatedBy("//input[contains(@id,'cityOther')]");
	public static final Target STATE = Target.the("State").locatedBy("//input[contains(@id,'stateOther')]");
	public static final Target ZIP_CODE = Target.the("Zip Code").locatedBy("//input[contains(@id,'zipCodeOther')]");

}