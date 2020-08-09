package com.conexia.qa.statefund.tasks;

import static com.conexia.qa.statefund.user_interfaces.ServicesADAPage.AMOUNT_PER_TREATMENT;
import static com.conexia.qa.statefund.user_interfaces.ServicesADAPage.OTHER_FEE;
import static com.conexia.qa.statefund.user_interfaces.ServicesADAPage.PROCEDURE_DATE;
import static com.conexia.qa.statefund.user_interfaces.ServicesADAPage.TITTLE;

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

public class FillADAServices implements Task {

	private String procedureDate;
	private String amountPerTreatment;
	private String otherFee;

	public FillADAServices() {
		this.procedureDate = DateFunctions.actualDate();
		this.amountPerTreatment = "1";
		this.otherFee = "1";
	}

	@Override
	@Step("{0} Fill the Services form")
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(Scroll.to(TITTLE), Type.theNumber(procedureDate).into(PROCEDURE_DATE),
				Click.on(AMOUNT_PER_TREATMENT), Enter.theValue(amountPerTreatment).into(AMOUNT_PER_TREATMENT),
				Enter.theValue(otherFee).into(OTHER_FEE));
		Serenity.takeScreenshot();
	}

	public static FillADAServices form() {
		return Tasks.instrumented(FillADAServices.class);
	}

}