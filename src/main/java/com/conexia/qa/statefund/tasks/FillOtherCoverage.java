package com.conexia.qa.statefund.tasks;

import static com.conexia.qa.statefund.user_interfaces.OtherCoveragePage.ADDRESS_ONE;
import static com.conexia.qa.statefund.user_interfaces.OtherCoveragePage.CITY;
import static com.conexia.qa.statefund.user_interfaces.OtherCoveragePage.DATE_OF_BIRTH;
import static com.conexia.qa.statefund.user_interfaces.OtherCoveragePage.OTHER_DENTAL_OR_MEDICAL_COVERAGE;
import static com.conexia.qa.statefund.user_interfaces.OtherCoveragePage.OTHER_INSURANCE_COMPANY_NAME;
import static com.conexia.qa.statefund.user_interfaces.OtherCoveragePage.PLAN_GROUP_NAME;
import static com.conexia.qa.statefund.user_interfaces.OtherCoveragePage.POLICYHOLDER_SUBSCRIBER_FIRST_NAME;
import static com.conexia.qa.statefund.user_interfaces.OtherCoveragePage.POLICYHOLDER_SUBSCRIBER_ID;
import static com.conexia.qa.statefund.user_interfaces.OtherCoveragePage.POLICYHOLDER_SUBSCRIBER_LAST_NAME;
import static com.conexia.qa.statefund.user_interfaces.OtherCoveragePage.POLICYHOLDER_SUBSCRIBER_MIDDLE_NAME;
import static com.conexia.qa.statefund.user_interfaces.OtherCoveragePage.RELATIONSHIP_TO_POLICYHOLDER_SUBSCRIBER;
import static com.conexia.qa.statefund.user_interfaces.OtherCoveragePage.STATE;
import static com.conexia.qa.statefund.user_interfaces.OtherCoveragePage.SUFFIX;
import static com.conexia.qa.statefund.user_interfaces.OtherCoveragePage.TITTLE;
import static com.conexia.qa.statefund.user_interfaces.OtherCoveragePage.ZIP_CODE;

import com.conexia.qa.statefund.interactions.Swipe;
import com.conexia.qa.statefund.interactions.Type;
import com.conexia.qa.statefund.user_interfaces.OtherCoveragePage;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.thucydides.core.annotations.Step;

public class FillOtherCoverage implements Task {

	private String otherDentalOrMedicalCoverage;
	private String suffix;
	private String policyholderSubscriberFirstName;
	private String policyholderSubscriberMiddleName;
	private String policyholderSubscriberLastName;
	private String dateOfBirth;
	private String gender;
	private String policyholderSubscriberID;
	private String planGroupName;
	private String relationshipToPolicyholderSubscriber;
	private String otherInsuranceCompanyName;
	private String addressOne;
	private String city;
	private String state;
	private String zipCode;

	public FillOtherCoverage() {
		this.otherDentalOrMedicalCoverage = "Yes";
		this.suffix = "Sr.";
		this.policyholderSubscriberFirstName = "SusFName";
		this.policyholderSubscriberMiddleName = "M";
		this.policyholderSubscriberLastName = "SusLName";
		this.dateOfBirth = "07071991";
		this.gender = "Female";
		this.policyholderSubscriberID = "135138513";
		this.planGroupName = "GroupName";
		this.relationshipToPolicyholderSubscriber = "Self";
		this.otherInsuranceCompanyName = "Conexia";
		this.addressOne = "Address 1";
		this.city = "tangamandapio";
		this.state = "CA";
		this.zipCode = "12345";
	}

	@Override
	@Step("{0} Fill the Other Coverage form")
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(Scroll.to(TITTLE),
				Click.on(OTHER_DENTAL_OR_MEDICAL_COVERAGE.of(otherDentalOrMedicalCoverage)));
		if (otherDentalOrMedicalCoverage.equals("Yes")) {
			actor.attemptsTo(SelectFromOptions.byVisibleText(suffix).from(SUFFIX),
					Enter.theValue(policyholderSubscriberFirstName).into(POLICYHOLDER_SUBSCRIBER_FIRST_NAME),
					Enter.theValue(policyholderSubscriberMiddleName).into(POLICYHOLDER_SUBSCRIBER_MIDDLE_NAME),
					Enter.theValue(policyholderSubscriberLastName).into(POLICYHOLDER_SUBSCRIBER_LAST_NAME));
			actor.attemptsTo(Swipe.vertical(200), Type.theNumber(dateOfBirth).into(DATE_OF_BIRTH),
					Click.on(OtherCoveragePage.GENDER.of(gender)),
					Enter.theValue(policyholderSubscriberID).into(POLICYHOLDER_SUBSCRIBER_ID),
					Enter.theValue(planGroupName).into(PLAN_GROUP_NAME),
					Click.on(RELATIONSHIP_TO_POLICYHOLDER_SUBSCRIBER.of(relationshipToPolicyholderSubscriber)));
			actor.attemptsTo(Enter.theValue(otherInsuranceCompanyName).into(OTHER_INSURANCE_COMPANY_NAME),
					Enter.theValue(addressOne).into(ADDRESS_ONE), Enter.theValue(city).into(CITY));
			actor.attemptsTo(Enter.theValue(state).into(STATE), Type.theNumber(zipCode).into(ZIP_CODE));
		}
		Serenity.takeScreenshot();
	}

	public static FillOtherCoverage form() {
		return Tasks.instrumented(FillOtherCoverage.class);
	}

}