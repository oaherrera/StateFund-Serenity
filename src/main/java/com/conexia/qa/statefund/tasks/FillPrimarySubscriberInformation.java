package com.conexia.qa.statefund.tasks;

import static com.conexia.qa.statefund.user_interfaces.PrimarySubscriberInformationPage.ADDRESS_ONE;
import static com.conexia.qa.statefund.user_interfaces.PrimarySubscriberInformationPage.ADDRESS_TWO;
import static com.conexia.qa.statefund.user_interfaces.PrimarySubscriberInformationPage.CITY;
import static com.conexia.qa.statefund.user_interfaces.PrimarySubscriberInformationPage.DATE_OF_BIRTH;
import static com.conexia.qa.statefund.user_interfaces.PrimarySubscriberInformationPage.GENDER;
import static com.conexia.qa.statefund.user_interfaces.PrimarySubscriberInformationPage.PLAN_GROUP_NUMBER;
import static com.conexia.qa.statefund.user_interfaces.PrimarySubscriberInformationPage.POLICYHOLDER;
import static com.conexia.qa.statefund.user_interfaces.PrimarySubscriberInformationPage.PRIMARY_SUBSCRIBER_NAME;
import static com.conexia.qa.statefund.user_interfaces.PrimarySubscriberInformationPage.STATE;
import static com.conexia.qa.statefund.user_interfaces.PrimarySubscriberInformationPage.TELEPHONE;
import static com.conexia.qa.statefund.user_interfaces.PrimarySubscriberInformationPage.TITTLE;
import static com.conexia.qa.statefund.user_interfaces.PrimarySubscriberInformationPage.ZIP_CODE;

import com.conexia.qa.statefund.interactions.Type;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.thucydides.core.annotations.Step;

public class FillPrimarySubscriberInformation implements Task {

	private String primarySubscriberName;
	private String addressOne;
	private String addressTwo;
	private String city;
	private String state;
	private String zipCode;
	private String telephone;
	private String dateOfBirth;
	private String gender;
	private String policyholderSubscriberID;
	private String planGroupNumber;

	public FillPrimarySubscriberInformation() {
		this.primarySubscriberName = "Pace";
		this.addressOne = "P. O. Box 3171";
		this.addressTwo = "P. O. Box 8458";
		this.city = "Suisun City";
		this.state = "CA";
		this.zipCode = "66666";
		this.telephone = "6666666666";
		this.dateOfBirth = "07301991";
		this.gender = "Female";
		this.policyholderSubscriberID = "231234242";
		this.planGroupNumber = "plan 12";
	}

	@Override
	@Step("{0} Fill the Primary Subscriber Information form")
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(Scroll.to(TITTLE));
		if (PRIMARY_SUBSCRIBER_NAME.resolveFor(actor).getAttribute("value").equals("")) {
			actor.attemptsTo(Enter.theValue(primarySubscriberName).into(PRIMARY_SUBSCRIBER_NAME));
		}
		if (ADDRESS_ONE.resolveFor(actor).getAttribute("value").equals("")) {
			actor.attemptsTo(Enter.theValue(addressOne).into(ADDRESS_ONE));
		}
		if (ADDRESS_TWO.resolveFor(actor).getAttribute("value").equals("")) {
			actor.attemptsTo(Enter.theValue(addressTwo).into(ADDRESS_TWO));
		}
		if (CITY.resolveFor(actor).getAttribute("value").equals("")) {
			actor.attemptsTo(Enter.theValue(city).into(CITY));
		}
		if (STATE.resolveFor(actor).getAttribute("value").equals("")) {
			actor.attemptsTo(Enter.theValue(state).into(STATE));
		}
		if (ZIP_CODE.resolveFor(actor).getAttribute("value").equals("")) {
			actor.attemptsTo(Type.theNumber(zipCode).into(ZIP_CODE));
		}
		if (TELEPHONE.resolveFor(actor).getAttribute("value").equals("")) {
			actor.attemptsTo(Type.theNumber(telephone).into(TELEPHONE));
		}
		if (DATE_OF_BIRTH.resolveFor(actor).getAttribute("value").equals("")) {
			actor.attemptsTo(Type.theNumber(dateOfBirth).into(DATE_OF_BIRTH));
		}
		actor.attemptsTo(Click.on(GENDER.of(gender)));
		if (POLICYHOLDER.resolveFor(actor).getAttribute("value").equals("")) {
			actor.attemptsTo(Enter.theValue(policyholderSubscriberID).into(POLICYHOLDER));
		}
		if (PLAN_GROUP_NUMBER.resolveFor(actor).getAttribute("value").equals("")) {
			actor.attemptsTo(Enter.theValue(planGroupNumber).into(PLAN_GROUP_NUMBER));
		}
		Serenity.takeScreenshot();
	}

	public static FillPrimarySubscriberInformation form() {
		return Tasks.instrumented(FillPrimarySubscriberInformation.class);
	}

}