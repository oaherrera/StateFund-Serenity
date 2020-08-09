package com.conexia.qa.statefund.steps_definitions;

import static com.conexia.qa.statefund.models.FieldsSavedDraft.readData;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

import java.util.List;

import com.conexia.qa.statefund.interactions.OrderResults;
import com.conexia.qa.statefund.interactions.RFACancel;
import com.conexia.qa.statefund.interactions.RFAType;
import com.conexia.qa.statefund.models.FieldsSavedDraft;
import com.conexia.qa.statefund.questions.DraftIsDelete;
import com.conexia.qa.statefund.questions.FormAfterEditDraft;
import com.conexia.qa.statefund.questions.InSavedDraftIsDisplayed;
import com.conexia.qa.statefund.questions.NoRecordsFound;
import com.conexia.qa.statefund.tasks.DeleteDraft;
import com.conexia.qa.statefund.tasks.EditDraft;
import com.conexia.qa.statefund.tasks.SelectDraft;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import net.serenitybdd.screenplay.GivenWhenThen;

/**
 * @author ChristianCamiloSchottlaender
 */
public class BR14SavedDraftSteps {

	@And("^Click on the checkbox in row number (.+) of a saved draft$")
	public void clicksInTheCheckboxNextSavedDraft(String rowSelect) {
		theActorInTheSpotlight().attemptsTo(SelectDraft.ofRow(rowSelect));
	}

	@And("^Click on Delete in row number (.+)$")
	public void clickOnDeleteInRowNumber(String rowSelect) {
		theActorInTheSpotlight().attemptsTo(DeleteDraft.ofRow(rowSelect));
	}

	@And("Click on Delete in row number (.+) and Cancel$")
	public void clickOnDeleteInRowNumberAndCencel(String rowSelect) {
		theActorInTheSpotlight().attemptsTo(DeleteDraft.ofRowAndCancelDelete(rowSelect));
	}

	@And("^Click on Delete Drafts$")
	public void clickOnDeleteDrafts() {
		theActorInTheSpotlight().attemptsTo(DeleteDraft.allSelected());
	}

	@And("^Click on Delete Drafts and Cancel$")
	public void clickOnDeleteDraftsAndCancel() {
		theActorInTheSpotlight().attemptsTo(DeleteDraft.allSelectedAndCancel());
	}

	@And("^Click on Edit in row number (.+)$")
	public void clickOnEditInRowNumber(String rowSelect) {
		theActorInTheSpotlight().attemptsTo(EditDraft.ofRow(rowSelect));
		theActorInTheSpotlight().attemptsTo(RFAType.option("New Request"));
	}

	@And("^Click on Cancel edit Rfa$")
	public void clickOnCancelEditRFa() {
		theActorInTheSpotlight().attemptsTo(RFACancel.toProcess());
	}

	@And("^Click on order Saved Date$")
	public void clickOnOrderSavedDate() {
		theActorInTheSpotlight().attemptsTo(OrderResults.ofSavedDraftBy());
	}

	@Then("^Display the drafts in order and fields created by user$")
	public void displayTheDraftsFields(List<FieldsSavedDraft> fieldsSavedDraftData) {
		FieldsSavedDraft.savefieldsSavedDraftList(fieldsSavedDraftData.get(0));
		System.out.println("" + readData(0).getOrderBy());
		theActorInTheSpotlight()
				.should(GivenWhenThen.seeThat(InSavedDraftIsDisplayed.fields(readData(0).getClaimNumber(),
						readData(0).getCreateBy(), readData(0).getClaimNumberField(),
						readData(0).getInjuredWorkerField(), readData(0).getDateOfInjuryField(),
						readData(0).getSavedDateField(), readData(0).getOrderBy())));
		FieldsSavedDraft.emptyfieldsSavedDraftList();
	}

	@Then("^Draft is delete$")
	public void draftIsDelete() {
		theActorInTheSpotlight().should(seeThat(DraftIsDelete.inDataBase()));
	}

	@Then("^See the Rfa form edit for Claim number (.+)$")
	public void seeTheRfaFormEdit(String claimNumber) {
		theActorInTheSpotlight().should(GivenWhenThen.seeThat(FormAfterEditDraft.seeToRfaOfClaim(claimNumber)));
	}

	@Then("Display the message No records found.")
	public void displayTheMessageNoRecordsFound() {
		theActorInTheSpotlight().should(seeThat(NoRecordsFound.yesShowMessage()));
	}

}