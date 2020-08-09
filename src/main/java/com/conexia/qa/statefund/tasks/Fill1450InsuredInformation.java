package com.conexia.qa.statefund.tasks;

import static com.conexia.qa.statefund.user_interfaces.InsuredInformation1450Page.DOES_THE_INSURED_HAVE_SOCIAL_SECURITY_NUMBER;
import static com.conexia.qa.statefund.user_interfaces.InsuredInformation1450Page.INSURED_GROUP_NAME;
import static com.conexia.qa.statefund.user_interfaces.InsuredInformation1450Page.TITTLE;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.thucydides.core.annotations.Step;

public class Fill1450InsuredInformation implements Task {

	private String doesTheInsuredHaveSocialSecurityNumber;
	private String insuredGroupName;

	public Fill1450InsuredInformation() {
		this.doesTheInsuredHaveSocialSecurityNumber = "Yes";
		this.insuredGroupName = "Group Name 123";
	}

	@Override
	@Step("{0} Fill the Insured's Information 1450 form")
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(Scroll.to(TITTLE),
				Click.on(DOES_THE_INSURED_HAVE_SOCIAL_SECURITY_NUMBER.of(doesTheInsuredHaveSocialSecurityNumber)));
		actor.attemptsTo(Enter.theValue(insuredGroupName).into(INSURED_GROUP_NAME));
		Serenity.takeScreenshot();
	}

	public static Fill1450InsuredInformation form() {
		return Tasks.instrumented(Fill1450InsuredInformation.class);
	}

}