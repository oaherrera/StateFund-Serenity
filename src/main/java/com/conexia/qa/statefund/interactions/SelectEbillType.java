package com.conexia.qa.statefund.interactions;

import static com.conexia.qa.statefund.user_interfaces.CommonPage.NEXT;
import static com.conexia.qa.statefund.user_interfaces.RFADetailsPage.EBILL_TYPE;
import static com.conexia.qa.statefund.user_interfaces.RFADetailsPage.SUBMIT_EBILL;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.thucydides.core.annotations.Step;

public class SelectEbillType implements Interaction {

	private String typeOfEbill;

	public SelectEbillType(String typeOfEbill) {
		this.typeOfEbill = typeOfEbill;
	}

	@Override
	@Step("{0} Select a Ebill Type #typeOfEbill")
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(Scroll.to(SUBMIT_EBILL), Click.on(SUBMIT_EBILL), Click.on(EBILL_TYPE.of(typeOfEbill)));
		Serenity.takeScreenshot();
		actor.attemptsTo(Click.on(NEXT), WaitLoading.page());
	}

	public static SelectEbillType cms1500() {
		return Tasks.instrumented(SelectEbillType.class, "CMS 1500");
	}

	public static SelectEbillType cms1450() {
		return Tasks.instrumented(SelectEbillType.class, "CMS 1450");
	}

	public static SelectEbillType ada2006() {
		return Tasks.instrumented(SelectEbillType.class, "ADA 2006");
	}

}