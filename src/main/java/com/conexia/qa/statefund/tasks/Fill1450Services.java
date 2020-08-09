package com.conexia.qa.statefund.tasks;

import static com.conexia.qa.statefund.user_interfaces.Services1450Page.AMOUNT_PER_TREATMENT;
import static com.conexia.qa.statefund.user_interfaces.Services1450Page.ESTIMATED_AMOUNT_DUE;
import static com.conexia.qa.statefund.user_interfaces.Services1450Page.FROM_DATE;
import static com.conexia.qa.statefund.user_interfaces.Services1450Page.PRIOR_PAYMENTS;
import static com.conexia.qa.statefund.user_interfaces.Services1450Page.RESERVED_FOR_ASSIGMENT_BY_THE_NUBC;
import static com.conexia.qa.statefund.user_interfaces.Services1450Page.REVENUE_CODE;
import static com.conexia.qa.statefund.user_interfaces.Services1450Page.REVENUE_DESCRIPTION;
import static com.conexia.qa.statefund.user_interfaces.Services1450Page.SERVICE_DATE;
import static com.conexia.qa.statefund.user_interfaces.Services1450Page.TITTLE;
import static com.conexia.qa.statefund.user_interfaces.Services1450Page.TO_DATE;
import static com.conexia.qa.statefund.user_interfaces.Services1450Page.TREATMENT_AUTHORIZATION_CODE;

import com.conexia.qa.statefund.interactions.Type;
import com.conexia.qa.statefund.utils.DateFunctions;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.thucydides.core.annotations.Step;

public class Fill1450Services implements Task {

	private String fromDate;
	private String toDate;
	private String treatmentAuthorizationCode;
	private String reservedForAssigmentByTheNUBC;
	private String revenueCode;
	private String revenueDescription;
	private String serviceDate;
	private String amountPerTreatment;
	private String priorPayments;
	private String estimatedAmountDue;

	public Fill1450Services() {
		this.fromDate = DateFunctions.yesterdayDate();
		this.toDate = DateFunctions.aWeekLater();
		this.treatmentAuthorizationCode = "adw22e";
		this.reservedForAssigmentByTheNUBC = "ad33";
		this.revenueCode = "1";
		this.revenueDescription = "deee";
		this.serviceDate = "11/26/2016";
		this.amountPerTreatment = "12";
		this.priorPayments = "1";
		this.estimatedAmountDue = "11";
	}

	@Override
	@Step("{0} Fill the Services 1450 form")
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(Scroll.to(TITTLE), Type.theNumber(fromDate).into(FROM_DATE),
				Type.theNumber(toDate).into(TO_DATE),
				Enter.theValue(treatmentAuthorizationCode).into(TREATMENT_AUTHORIZATION_CODE),
				Enter.theValue(reservedForAssigmentByTheNUBC).into(RESERVED_FOR_ASSIGMENT_BY_THE_NUBC),
				Enter.theValue(revenueCode).into(REVENUE_CODE),
				Enter.theValue(revenueDescription).into(REVENUE_DESCRIPTION),
				Enter.theValue(serviceDate).into(SERVICE_DATE), Click.on(AMOUNT_PER_TREATMENT),
				Enter.theValue(amountPerTreatment).into(AMOUNT_PER_TREATMENT));
		actor.attemptsTo(Enter.theValue(priorPayments).into(PRIOR_PAYMENTS),
				Enter.theValue(estimatedAmountDue).into(ESTIMATED_AMOUNT_DUE));
		Serenity.takeScreenshot();
	}

	public static Fill1450Services form() {
		return Tasks.instrumented(Fill1450Services.class);
	}

}