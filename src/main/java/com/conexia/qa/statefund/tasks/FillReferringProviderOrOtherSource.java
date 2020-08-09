package com.conexia.qa.statefund.tasks;

import static com.conexia.qa.statefund.user_interfaces.ReferringProviderOrOtherSourcePage.FIRST_NAME;
import static com.conexia.qa.statefund.user_interfaces.ReferringProviderOrOtherSourcePage.LAST_NAME;
import static com.conexia.qa.statefund.user_interfaces.ReferringProviderOrOtherSourcePage.LICENSE;
import static com.conexia.qa.statefund.user_interfaces.ReferringProviderOrOtherSourcePage.MIDDLE_NAME;
import static com.conexia.qa.statefund.user_interfaces.ReferringProviderOrOtherSourcePage.NPI_NUMBER;
import static com.conexia.qa.statefund.user_interfaces.ReferringProviderOrOtherSourcePage.QUAL_ID;
import static com.conexia.qa.statefund.user_interfaces.ReferringProviderOrOtherSourcePage.TITTLE;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.thucydides.core.annotations.Step;

public class FillReferringProviderOrOtherSource implements Task {

	private String firstName;
	private String middleName;
	private String lastName;
	private String qualID;
	private String license;
	private String npiNumber;

	public FillReferringProviderOrOtherSource() {
		this.firstName = "Provider Name";
		this.middleName = "P";
		this.lastName = "Carnitas";
		this.qualID = "Q1";
		this.license = "123456";
		this.npiNumber = "1234567980";
	}

	@Override
	@Step("{0} Fill the Referring Provider Or Other Source form")
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(Scroll.to(TITTLE), Enter.theValue(firstName).into(FIRST_NAME),
				Enter.theValue(middleName).into(MIDDLE_NAME), Enter.theValue(lastName).into(LAST_NAME),
				Enter.theValue(qualID).into(QUAL_ID), Enter.theValue(license).into(LICENSE),
				Enter.theValue(npiNumber).into(NPI_NUMBER));
		Serenity.takeScreenshot();
	}

	public static FillReferringProviderOrOtherSource form() {
		return Tasks.instrumented(FillReferringProviderOrOtherSource.class);
	}

}