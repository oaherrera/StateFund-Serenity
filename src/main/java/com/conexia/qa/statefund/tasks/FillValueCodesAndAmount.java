package com.conexia.qa.statefund.tasks;

import static com.conexia.qa.statefund.user_interfaces.ValueCodesAndAmountPage.ADD;
import static com.conexia.qa.statefund.user_interfaces.ValueCodesAndAmountPage.AMOUNT;
import static com.conexia.qa.statefund.user_interfaces.ValueCodesAndAmountPage.CODE;
import static com.conexia.qa.statefund.user_interfaces.ValueCodesAndAmountPage.TITTLE;

import com.conexia.qa.statefund.interactions.Sleep;
import com.conexia.qa.statefund.interactions.Swipe;
import com.conexia.qa.statefund.interactions.WaitLoading;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.thucydides.core.annotations.Step;

public class FillValueCodesAndAmount implements Task {

	private String code;
	private String amount;

	public FillValueCodesAndAmount() {
		this.code = "12";
		this.amount = "21";
	}

	@Override
	@Step("{0} Fill the Value Codes And Amount form")
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(Scroll.to(TITTLE), Swipe.vertical(-200), Enter.theValue(code).into(CODE),
				Enter.theValue(amount).into(AMOUNT), Sleep.by(500));
		actor.attemptsTo(Sleep.by(1000), Click.on(ADD), WaitLoading.page());
		Serenity.takeScreenshot();
	}

	public static FillValueCodesAndAmount form() {
		return Tasks.instrumented(FillValueCodesAndAmount.class);
	}

}