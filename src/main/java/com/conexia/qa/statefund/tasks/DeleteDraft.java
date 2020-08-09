package com.conexia.qa.statefund.tasks;

import static com.conexia.qa.statefund.user_interfaces.SavedDraftForClaimPage.DELETE_BY_ID;
import static com.conexia.qa.statefund.user_interfaces.SavedDraftForClaimPage.DELETE_MASSIVE;
import static com.conexia.qa.statefund.user_interfaces.SavedDraftForClaimPage.NO_CONFIRM;
import static com.conexia.qa.statefund.user_interfaces.SavedDraftForClaimPage.NO_CONFIRM_MASSIVE;
import static com.conexia.qa.statefund.user_interfaces.SavedDraftForClaimPage.ROW_SELECTED;
import static com.conexia.qa.statefund.user_interfaces.SavedDraftForClaimPage.YES_CONFIRM;
import static com.conexia.qa.statefund.user_interfaces.SavedDraftForClaimPage.YES_CONFIRM_MASSIVE;
import static net.serenitybdd.core.Serenity.takeScreenshot;

import com.conexia.qa.sql_developer.interactions.SearchDraftSavedDB;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

/**
 * @author ChristianCamiloSchottlaender
 */
public class DeleteDraft implements Task {

	private String numberRow;
	private int intRow;
	private boolean cancelDelete;

	public DeleteDraft(String numberRow, boolean cancelDelete) {
		this.numberRow = numberRow;
		this.cancelDelete = cancelDelete;
		if (!numberRow.equals("allSelected")) {
			this.intRow = (Integer.parseInt(this.numberRow) + 1);
		}
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		if (numberRow.equals("allSelected")) {
			actor.attemptsTo(Click.on(DELETE_MASSIVE));
			takeScreenshot();
			if (cancelDelete) {
				actor.attemptsTo(Click.on(NO_CONFIRM_MASSIVE));
			} else {
				actor.attemptsTo(Click.on(YES_CONFIRM_MASSIVE));
			}
			takeScreenshot();
		} else {
			String idDraft = ROW_SELECTED.of("" + intRow).resolveFor(actor).getAttribute("data-rk");
			actor.attemptsTo(SearchDraftSavedDB.byId(idDraft));
			actor.attemptsTo(Click.on(DELETE_BY_ID.of(idDraft)));
			takeScreenshot();
			if (cancelDelete) {
				actor.attemptsTo(Click.on(NO_CONFIRM));
			} else {
				actor.attemptsTo(Click.on(YES_CONFIRM));
			}
			takeScreenshot();
			actor.attemptsTo(SearchDraftSavedDB.byId(idDraft));
		}
	}

	public static DeleteDraft ofRow(String numberRow) {
		return Tasks.instrumented(DeleteDraft.class, numberRow, false);
	}

	public static DeleteDraft ofRowAndCancelDelete(String numberRow) {
		return Tasks.instrumented(DeleteDraft.class, numberRow, true);
	}

	public static DeleteDraft allSelected() {
		return Tasks.instrumented(DeleteDraft.class, "allSelected", false);
	}

	public static DeleteDraft allSelectedAndCancel() {
		return Tasks.instrumented(DeleteDraft.class, "allSelected", true);
	}

}