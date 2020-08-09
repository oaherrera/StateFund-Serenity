package com.conexia.qa.statefund.tasks;

import static com.conexia.qa.statefund.user_interfaces.ServiceFacilityInformationPage.ADDRESS_ONE;
import static com.conexia.qa.statefund.user_interfaces.ServiceFacilityInformationPage.ADDRESS_TWO;
import static com.conexia.qa.statefund.user_interfaces.ServiceFacilityInformationPage.CITY;
import static com.conexia.qa.statefund.user_interfaces.ServiceFacilityInformationPage.FACILITY_NAME;
import static com.conexia.qa.statefund.user_interfaces.ServiceFacilityInformationPage.NPI_NUMBER;
import static com.conexia.qa.statefund.user_interfaces.ServiceFacilityInformationPage.OTHER_ID_NUMBER;
import static com.conexia.qa.statefund.user_interfaces.ServiceFacilityInformationPage.STATE;
import static com.conexia.qa.statefund.user_interfaces.ServiceFacilityInformationPage.TITTLE;
import static com.conexia.qa.statefund.user_interfaces.ServiceFacilityInformationPage.ZIP_CODE;
import static com.conexia.qa.statefund.user_interfaces.ServiceFacilityInformationPage.ZIP_CODE_EXT;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.thucydides.core.annotations.Step;

public class FillServiceFacilityInformation implements Task {

	private String facilityName;
	private String addressOne;
	private String addressTwo;
	private String city;
	private String state;
	private String zipCode;
	private String zipCodeExt;
	private String npiNumber;
	private String otherIDNumber;

	public FillServiceFacilityInformation() {
		this.facilityName = "Facility Name";
		this.addressOne = "Address 1";
		this.addressTwo = "Address 2";
		this.city = "Nueva new York";
		this.state = "CA";
		this.zipCode = "666666";
		this.zipCodeExt = "4444";
		this.npiNumber = "3423423423";
		this.otherIDNumber = "32234234";
	}

	@Override
	@Step("{0} Fill the Service Facility Information form")
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(Scroll.to(TITTLE), Enter.theValue(facilityName).into(FACILITY_NAME),
				Enter.theValue(addressOne).into(ADDRESS_ONE), Enter.theValue(addressTwo).into(ADDRESS_TWO),
				Enter.theValue(city).into(CITY), Enter.theValue(state).into(STATE),
				Enter.theValue(zipCode).into(ZIP_CODE), Enter.theValue(zipCodeExt).into(ZIP_CODE_EXT),
				Enter.theValue(npiNumber).into(NPI_NUMBER), Enter.theValue(otherIDNumber).into(OTHER_ID_NUMBER));
		Serenity.takeScreenshot();
	}

	public static FillServiceFacilityInformation form() {
		return Tasks.instrumented(FillServiceFacilityInformation.class);
	}

}