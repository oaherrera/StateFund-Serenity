package com.conexia.qa.statefund.tasks;

import static com.conexia.qa.statefund.user_interfaces.CommonPage.NEXT;
import static com.conexia.qa.statefund.user_interfaces.RequestingPhysicianInformationPage.ADDRESS;
import static com.conexia.qa.statefund.user_interfaces.RequestingPhysicianInformationPage.CITY;
import static com.conexia.qa.statefund.user_interfaces.RequestingPhysicianInformationPage.FAX_NUMBER;
import static com.conexia.qa.statefund.user_interfaces.RequestingPhysicianInformationPage.PHYSICIAN_NAME;
import static com.conexia.qa.statefund.user_interfaces.RequestingPhysicianInformationPage.STATE;
import static com.conexia.qa.statefund.user_interfaces.RequestingPhysicianInformationPage.TELEPHONE;
import static com.conexia.qa.statefund.user_interfaces.RequestingPhysicianInformationPage.ZIP_CODE;

import com.conexia.qa.statefund.interactions.Type;
import com.conexia.qa.statefund.interactions.WaitLoading;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.thucydides.core.annotations.Step;

public class FillPhysicianInformation implements Task {

	private String physicianName;

	public FillPhysicianInformation(String physicianName) {
		this.physicianName = physicianName;
	}

	@Override
	@Step("{0} Requesting the Physician Information")
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(SelectFromOptions.byVisibleText(physicianName + " ").from(PHYSICIAN_NAME), WaitLoading.page(),
				Scroll.to(PHYSICIAN_NAME), WaitLoading.page());
		if (CITY.resolveFor(actor).getAttribute("value").equals("")) {
			actor.attemptsTo(Enter.theValue("City Of Automation Test").into(CITY));
		}
		if (ZIP_CODE.resolveFor(actor).getAttribute("value").equals("")) {
			actor.attemptsTo(Enter.theValue("12345").into(ZIP_CODE));
		}
		if (ADDRESS.resolveFor(actor).getAttribute("value").equals("")) {
			actor.attemptsTo(Enter.theValue("Address Of Automation Test").into(ADDRESS));
		}
		if (STATE.resolveFor(actor).getAttribute("value").equals("")) {
			actor.attemptsTo(Enter.theValue("CA").into(STATE));
		}
		if (TELEPHONE.resolveFor(actor).getAttribute("value").equals("")) {
			actor.attemptsTo(Click.on(TELEPHONE), Type.theNumber("3105809988").into(TELEPHONE));
		}
		if (FAX_NUMBER.resolveFor(actor).getAttribute("value").equals("")) {
			actor.attemptsTo(Click.on(FAX_NUMBER), Type.theNumber("9257486259").into(FAX_NUMBER));
		}
		Serenity.takeScreenshot();
		actor.attemptsTo(Scroll.to(NEXT), Click.on(NEXT), WaitLoading.page());
	}

	public static FillPhysicianInformation mandatory(String physicianName) {
		return Tasks.instrumented(FillPhysicianInformation.class, physicianName);
	}

}