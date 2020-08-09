package com.conexia.qa.statefund.tasks;

import static com.conexia.qa.statefund.user_interfaces.SavedDraftForClaimPage.CHECK_OF_ROW;
import static net.serenitybdd.core.Serenity.takeScreenshot;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

/**
 * @author ChristianCamiloSchottlaender
 */
public class SelectDraft implements Task {

	String numberRow;
	int intRow;

	public SelectDraft(String numberRow) {
		this.numberRow = numberRow;
		this.intRow = (Integer.parseInt(this.numberRow) + 1);
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(Click.on(CHECK_OF_ROW.of("" + intRow)));
		takeScreenshot();
	}

	public static SelectDraft ofRow(String numberRow) {
		return Tasks.instrumented(SelectDraft.class, numberRow);
	}

}