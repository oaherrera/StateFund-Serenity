package com.conexia.qa.statefund.tasks;

import static com.conexia.qa.statefund.user_interfaces.AddAttendingSurgeryPage.ADD_ATTENDING;
import static com.conexia.qa.statefund.user_interfaces.AddAttendingSurgeryPage.ATTENDING_FIRST_NAME;
import static com.conexia.qa.statefund.user_interfaces.AddAttendingSurgeryPage.ATTENDING_LAST_NAME;
import static com.conexia.qa.statefund.user_interfaces.AddAttendingSurgeryPage.ATTENDING_NPI;
import static com.conexia.qa.statefund.user_interfaces.AddAttendingSurgeryPage.ATTENDING_QUALIFIER;
import static com.conexia.qa.statefund.user_interfaces.AddAttendingSurgeryPage.ATTENDING_SAVE;

import com.conexia.qa.statefund.interactions.Sleep;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;

public class AddAttendingSurgery implements Task {

	private String attendingProviderNPI;
	private String attendingProviderQualifier;
	private String attendingProviderFirstName;
	private String attendingProviderLastName;

	public AddAttendingSurgery() {
		this.attendingProviderNPI = "att3wr3";
		this.attendingProviderQualifier = "AA";
		this.attendingProviderFirstName = "Pepe";
		this.attendingProviderLastName = "Carnitas";
	}

	@Override
	@Step("{0} Add Attending Surgery Information form")
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(Click.on(ADD_ATTENDING), Sleep.by(1000));
		actor.attemptsTo(Enter.theValue(attendingProviderNPI).into(ATTENDING_NPI),
				Enter.theValue(attendingProviderQualifier).into(ATTENDING_QUALIFIER),
				Enter.theValue(attendingProviderFirstName).into(ATTENDING_FIRST_NAME),
				Enter.theValue(attendingProviderLastName).into(ATTENDING_LAST_NAME));
		Serenity.takeScreenshot();
		actor.attemptsTo(Click.on(ATTENDING_SAVE));
	}

	public static AddAttendingSurgery information() {
		return Tasks.instrumented(AddAttendingSurgery.class);
	}

}