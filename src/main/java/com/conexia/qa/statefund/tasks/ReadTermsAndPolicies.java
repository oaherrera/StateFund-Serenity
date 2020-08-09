package com.conexia.qa.statefund.tasks;

import com.conexia.qa.statefund.interactions.Sleep;
import com.conexia.qa.statefund.user_interfaces.SignUpPage;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;

public class ReadTermsAndPolicies implements Task {

	@Override
	@Step("{0} Read Terms And Policies")
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(Click.on(SignUpPage.TERMS_AND_POLICIES_LINK));
		Serenity.takeScreenshot();
		actor.attemptsTo(Sleep.by(2000));
	}

	public static ReadTermsAndPolicies inTheLink() {
		return Tasks.instrumented(ReadTermsAndPolicies.class);
	}

}