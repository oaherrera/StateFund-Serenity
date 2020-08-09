package com.conexia.qa.statefund.interactions;

import static com.conexia.qa.statefund.user_interfaces.MenuItemPage.AGREE_TERMS_AND_POLICIES;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

/*
*
*Aceptar Terminos y Condiciones despues del Login
*
*/

public class AgreeTermsAndPolicies implements Interaction {

	@Override
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(WaitUntil.the(AGREE_TERMS_AND_POLICIES, isVisible()));
		Serenity.takeScreenshot();
		actor.attemptsTo(Click.on(AGREE_TERMS_AND_POLICIES));
	}

	public static AgreeTermsAndPolicies afterLogin() {
		return Tasks.instrumented(AgreeTermsAndPolicies.class);
	}

	public static AgreeTermsAndPolicies ofTransaction() {
		return Tasks.instrumented(AgreeTermsAndPolicies.class);
	}

}