package com.conexia.qa.statefund.tasks;

import static com.conexia.qa.statefund.user_interfaces.AddOtherSurgeryPage.ADD_OTHER;
import static com.conexia.qa.statefund.user_interfaces.AddOtherSurgeryPage.PROVIDER_ONE_FIRST_NAME;
import static com.conexia.qa.statefund.user_interfaces.AddOtherSurgeryPage.PROVIDER_ONE_LAST_NAME;
import static com.conexia.qa.statefund.user_interfaces.AddOtherSurgeryPage.PROVIDER_ONE_NPI;
import static com.conexia.qa.statefund.user_interfaces.AddOtherSurgeryPage.PROVIDER_ONE_QUALIFIER;
import static com.conexia.qa.statefund.user_interfaces.AddOtherSurgeryPage.PROVIDER_SAVE;
import static com.conexia.qa.statefund.user_interfaces.AddOtherSurgeryPage.PROVIDER_TWO_FIRST_NAME;
import static com.conexia.qa.statefund.user_interfaces.AddOtherSurgeryPage.PROVIDER_TWO_LAST_NAME;
import static com.conexia.qa.statefund.user_interfaces.AddOtherSurgeryPage.PROVIDER_TWO_NPI;
import static com.conexia.qa.statefund.user_interfaces.AddOtherSurgeryPage.PROVIDER_TWO_QUALIFIER;

import com.conexia.qa.statefund.interactions.Sleep;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;

public class AddOtherSurgery implements Task {

	private String providerOneNPI;
	private String providerOneQualifier;
	private String providerOneFirstName;
	private String providerOneLastName;
	private String providerTwoNPI;
	private String providerTwoQualifier;
	private String providerTwoFirstName;
	private String providerTwoLastName;

	public AddOtherSurgery() {
		this.providerOneNPI = "pro1npi";
		this.providerOneQualifier = "CC";
		this.providerOneFirstName = "Pepe";
		this.providerOneLastName = "Carnitas";
		this.providerTwoNPI = "pro2npi";
		this.providerTwoQualifier = "DD";
		this.providerTwoFirstName = "Pepe";
		this.providerTwoLastName = "Carnitas";
	}

	@Override
	@Step("{0} Add Other Surgery Information form")
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(Click.on(ADD_OTHER), Sleep.by(1000));
		actor.attemptsTo(Enter.theValue(providerOneNPI).into(PROVIDER_ONE_NPI),
				Enter.theValue(providerOneQualifier).into(PROVIDER_ONE_QUALIFIER),
				Enter.theValue(providerOneFirstName).into(PROVIDER_ONE_FIRST_NAME),
				Enter.theValue(providerOneLastName).into(PROVIDER_ONE_LAST_NAME),
				Enter.theValue(providerTwoNPI).into(PROVIDER_TWO_NPI),
				Enter.theValue(providerTwoQualifier).into(PROVIDER_TWO_QUALIFIER),
				Enter.theValue(providerTwoFirstName).into(PROVIDER_TWO_FIRST_NAME),
				Enter.theValue(providerTwoLastName).into(PROVIDER_TWO_LAST_NAME));
		Serenity.takeScreenshot();
		actor.attemptsTo(Click.on(PROVIDER_SAVE));
	}

	public static AddOtherSurgery information() {
		return Tasks.instrumented(AddOtherSurgery.class);
	}

}