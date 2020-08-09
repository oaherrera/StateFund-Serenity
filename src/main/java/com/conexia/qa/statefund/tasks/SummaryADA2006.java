package com.conexia.qa.statefund.tasks;

import static com.conexia.qa.statefund.user_interfaces.CommonPage.SUBMIT;
import static com.conexia.qa.statefund.user_interfaces.SummaryADAPage.SUBSCRIBER_DATE;
import static com.conexia.qa.statefund.user_interfaces.SummaryADAPage.SUBSCRIBER_SIGNATURE;
import static com.conexia.qa.statefund.user_interfaces.SummaryADAPage.TREATING_DATE;
import static com.conexia.qa.statefund.user_interfaces.SummaryADAPage.TREATING_DENTIST_SIGNATURE;

import com.conexia.qa.statefund.interactions.Type;
import com.conexia.qa.statefund.interactions.WaitLoading;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.thucydides.core.annotations.Step;

public class SummaryADA2006 implements Task {

	private String subscriberSignature;
	private String dateSubscriber;
	private String treatingDentistSignature;
	private String dateTreating;

	public SummaryADA2006() {
		this.subscriberSignature = "Subscriber Signature";
		this.dateSubscriber = "11/14/2019";
		this.treatingDentistSignature = "Treating Dentist Signature";
		this.dateTreating = "11/14/2019";
	}

	@Override
	@Step("{0} Complete the Summary of ADA form")
	public <T extends Actor> void performAs(T actor) {
		Serenity.takeScreenshot();
		actor.attemptsTo(Scroll.to(SUBMIT), Enter.theValue(subscriberSignature).into(SUBSCRIBER_SIGNATURE),
				Type.theNumber(dateSubscriber).into(SUBSCRIBER_DATE),
				Enter.theValue(treatingDentistSignature).into(TREATING_DENTIST_SIGNATURE),
				Type.theNumber(dateTreating).into(TREATING_DATE), Click.on(TREATING_DENTIST_SIGNATURE),
				Click.on(SUBMIT), WaitLoading.page());
	}

	public static SummaryADA2006 form() {
		return Tasks.instrumented(SummaryADA2006.class);
	}

}