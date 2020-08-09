package com.conexia.qa.statefund.tasks;

import static com.conexia.qa.statefund.user_interfaces.SavedDraftForClaimPage.EDIT_BY_ID;
import static com.conexia.qa.statefund.user_interfaces.SavedDraftForClaimPage.ROW_SELECTED;
import static net.serenitybdd.core.Serenity.takeScreenshot;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

/**
 * @author ChristianCamiloSchottlaender
 */
public class EditDraft implements Task {

	private String numberRow;
	private int intRow;

	public EditDraft(String numberRow) {
		this.numberRow = numberRow;
		intRow = Integer.parseInt(this.numberRow) + 1;
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		takeScreenshot();
		String idDraft = ROW_SELECTED.of("" + intRow).resolveFor(actor).getAttribute("data-rk");
		actor.attemptsTo(Click.on(EDIT_BY_ID.of(idDraft + "")));
		takeScreenshot();
	}

	public static EditDraft ofRow(String numberRow) {
		return Tasks.instrumented(EditDraft.class, numberRow);
	}

}