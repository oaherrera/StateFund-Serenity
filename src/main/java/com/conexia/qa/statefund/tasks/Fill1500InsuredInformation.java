package com.conexia.qa.statefund.tasks;

import static com.conexia.qa.statefund.user_interfaces.InsuredInformation1500Page.ADDRESS;
import static com.conexia.qa.statefund.user_interfaces.InsuredInformation1500Page.ADDRESS_TWO;
import static com.conexia.qa.statefund.user_interfaces.InsuredInformation1500Page.CITY;
import static com.conexia.qa.statefund.user_interfaces.InsuredInformation1500Page.DATE_OF_BIRTH;
import static com.conexia.qa.statefund.user_interfaces.InsuredInformation1500Page.SEX;
import static com.conexia.qa.statefund.user_interfaces.InsuredInformation1500Page.STATE;
import static com.conexia.qa.statefund.user_interfaces.InsuredInformation1500Page.TELEPHONE;
import static com.conexia.qa.statefund.user_interfaces.InsuredInformation1500Page.TITTLE;
import static com.conexia.qa.statefund.user_interfaces.InsuredInformation1500Page.ZIP_CODE;

import com.conexia.qa.statefund.interactions.Type;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.thucydides.core.annotations.Step;

public class Fill1500InsuredInformation implements Task {

	private String dateOfBirth;
	private String sex;
	private String address;
	private String addressTwo;
	private String city;
	private String state;
	private String zipCode;
	private String telephone;

	public Fill1500InsuredInformation() {
		this.dateOfBirth = "04/26/1985";
		this.sex = "Female";
		this.address = "Address";
		this.addressTwo = "Address 2";
		this.city = "Panama";
		this.state = "CA";
		this.zipCode = "66666";
		this.telephone = "6666666666";
	}

	@Override
	@Step("{0} Fill the Insured Information 1500 form")
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(Scroll.to(TITTLE), Type.theNumber(dateOfBirth).into(DATE_OF_BIRTH), Click.on(SEX.of(sex)),
				Enter.theValue(address).into(ADDRESS), Enter.theValue(addressTwo).into(ADDRESS_TWO));
		actor.attemptsTo(Enter.theValue(city).into(CITY), Enter.theValue(state).into(STATE),
				Type.theNumber(zipCode).into(ZIP_CODE), Type.theNumber(telephone).into(TELEPHONE));
		Serenity.takeScreenshot();
	}

	public static Fill1500InsuredInformation form() {
		return Tasks.instrumented(Fill1500InsuredInformation.class);
	}

}