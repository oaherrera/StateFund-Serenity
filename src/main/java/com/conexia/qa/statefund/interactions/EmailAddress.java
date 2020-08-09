package com.conexia.qa.statefund.interactions;

import static com.conexia.qa.statefund.user_interfaces.RequestingPhysicianInformationPage.FAX_NUMBER;
import static com.conexia.qa.statefund.user_interfaces.RequestingPhysicianInformationPage.PHYSICIAN_NAME;

import java.util.List;

import com.conexia.qa.statefund.user_interfaces.CommonPage;
import com.conexia.qa.statefund.user_interfaces.RequestingPhysicianInformationPage;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.thucydides.core.annotations.Step;

public class EmailAddress implements Interaction {

	private List<String> emailAddress;
	private boolean returnDecision;

	public EmailAddress(List<String> emailAddress, boolean returnDecision) {
		this.emailAddress = emailAddress;
		this.returnDecision = returnDecision;
	}

	@Override
	@Step("{0} Email Address")
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(RFAType.option(emailAddress.get(4)),
				SelectFromOptions.byVisibleText(emailAddress.get(5) + " ").from(PHYSICIAN_NAME),
				Scroll.to(CommonPage.NEXT), Sleep.by(1500), Type.theNumber(emailAddress.get(6)).into(FAX_NUMBER),
				Enter.theValue(emailAddress.get(7)).into(RequestingPhysicianInformationPage.EMAIL_ADDRESS));
		Serenity.takeScreenshot();
		actor.attemptsTo(Click.on(CommonPage.NEXT), WaitLoading.page());
		if (returnDecision) {
			actor.attemptsTo(Scroll.to(CommonPage.BACK), Click.on(CommonPage.BACK), WaitLoading.page(),
					Scroll.to(CommonPage.BACK));
		}
		Serenity.takeScreenshot();
	}

	public static EmailAddress isField(List<String> emailAddress, boolean returnDecision) {
		return Tasks.instrumented(EmailAddress.class, emailAddress, returnDecision);
	}

}