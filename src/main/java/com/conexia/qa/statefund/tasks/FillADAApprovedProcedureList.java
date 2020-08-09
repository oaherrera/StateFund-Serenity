package com.conexia.qa.statefund.tasks;

import static com.conexia.qa.statefund.user_interfaces.ApprovedProcedureListPage.ADD_BILLING_QUANTITY;
import static com.conexia.qa.statefund.user_interfaces.ApprovedProcedureListPage.BILLING_QUANTITY;
import static com.conexia.qa.statefund.user_interfaces.ApprovedProcedureListPage.CHECKBOX_PROCEDURE;
import static com.conexia.qa.statefund.user_interfaces.ApprovedProcedureListPage.TITTLE;
import static com.conexia.qa.statefund.user_interfaces.CommonPage.NEXT;

import org.openqa.selenium.Keys;

import com.conexia.qa.statefund.interactions.Sleep;
import com.conexia.qa.statefund.interactions.WaitLoading;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Hit;
import net.serenitybdd.screenplay.actions.Scroll;
import net.thucydides.core.annotations.Step;

public class FillADAApprovedProcedureList implements Task {

	@Override
	@Step("{0} Fill the Approved Procedure List")
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(Scroll.to(TITTLE), Click.on(CHECKBOX_PROCEDURE));
		actor.attemptsTo(Sleep.by(1000), Click.on(ADD_BILLING_QUANTITY), Hit.the(Keys.TAB).into(BILLING_QUANTITY));
		Serenity.takeScreenshot();
		actor.attemptsTo(Click.on(NEXT), WaitLoading.page());
	}

	public static FillADAApprovedProcedureList form() {
		return Tasks.instrumented(FillADAApprovedProcedureList.class);
	}

}