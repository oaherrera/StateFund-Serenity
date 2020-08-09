package com.conexia.qa.statefund.tasks;

import static com.conexia.qa.statefund.user_interfaces.AddOperatingSurgeryPage.ADD_OPERATING;
import static com.conexia.qa.statefund.user_interfaces.AddOperatingSurgeryPage.OPERATING_FIRST_NAME;
import static com.conexia.qa.statefund.user_interfaces.AddOperatingSurgeryPage.OPERATING_LAST_NAME;
import static com.conexia.qa.statefund.user_interfaces.AddOperatingSurgeryPage.OPERATING_NPI;
import static com.conexia.qa.statefund.user_interfaces.AddOperatingSurgeryPage.OPERATING_QUALIFIER;
import static com.conexia.qa.statefund.user_interfaces.AddOperatingSurgeryPage.OPERATING_SAVE;

import com.conexia.qa.statefund.interactions.Sleep;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;

public class AddOperatingSurgery implements Task {

	private String operatingProviderNPI;
	private String operatingProviderQualifier;
	private String operatingProviderFirstName;
	private String operatingProviderLastName;

	public AddOperatingSurgery() {
		this.operatingProviderNPI = "ope3wr3";
		this.operatingProviderQualifier = "BB";
		this.operatingProviderFirstName = "Pepe";
		this.operatingProviderLastName = "Carnitas";
	}

	@Override
	@Step("{0} Add Operating Surgery Information form")
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(Click.on(ADD_OPERATING), Sleep.by(1000));
		actor.attemptsTo(Enter.theValue(operatingProviderNPI).into(OPERATING_NPI),
				Enter.theValue(operatingProviderQualifier).into(OPERATING_QUALIFIER),
				Enter.theValue(operatingProviderFirstName).into(OPERATING_FIRST_NAME),
				Enter.theValue(operatingProviderLastName).into(OPERATING_LAST_NAME));
		Serenity.takeScreenshot();
		actor.attemptsTo(Click.on(OPERATING_SAVE));
	}

	public static AddOperatingSurgery information() {
		return Tasks.instrumented(AddOperatingSurgery.class);
	}

}