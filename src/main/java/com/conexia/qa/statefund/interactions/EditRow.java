package com.conexia.qa.statefund.interactions;

import static com.conexia.qa.statefund.user_interfaces.CommonPage.EDIT_ROW;
import static net.serenitybdd.core.Serenity.takeScreenshot;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

/**
 * @author ChristianSchottlaender
 **/
public class EditRow implements Task {

	private String numberRow;

	public EditRow(String numberRow) {
		this.numberRow = numberRow;
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(Click.on(EDIT_ROW.of(numberRow)));
		takeScreenshot();
	}

	public static EditRow number(String numberRow) {
		return Tasks.instrumented(EditRow.class, numberRow);
	}

}