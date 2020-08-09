package com.conexia.qa.statefund.steps_definitions;

import static com.conexia.qa.statefund.user_interfaces.TreatmentHistoryPage.EXPAND_ROW;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;

import java.util.List;

import com.conexia.qa.statefund.interactions.AgreeTermsAndPolicies;
import com.conexia.qa.statefund.interactions.ClickOn;
import com.conexia.qa.statefund.interactions.RFAType;
import com.conexia.qa.statefund.interactions.Sleep;
import com.conexia.qa.statefund.interactions.Swipe;
import com.conexia.qa.statefund.models.CreateNewUser;
import com.conexia.qa.statefund.models.DocumentAttachment;
import com.conexia.qa.statefund.models.PhysicianInformation;
import com.conexia.qa.statefund.models.WorkerInformation;
import com.conexia.qa.statefund.questions.DataTableIsShow;
import com.conexia.qa.statefund.questions.ReturnToClaimDetails;
import com.conexia.qa.statefund.questions.TheAdministratorUserIsShow;
import com.conexia.qa.statefund.questions.TheClaimSearch;
import com.conexia.qa.statefund.tasks.AccessToCreateNewUser;
import com.conexia.qa.statefund.tasks.ClaimDetails;
import com.conexia.qa.statefund.tasks.ClaimSearch;
import com.conexia.qa.statefund.tasks.DeleteRecord;
import com.conexia.qa.statefund.tasks.EditRecord;
import com.conexia.qa.statefund.tasks.EnterBySendRFA;
import com.conexia.qa.statefund.tasks.EnterSavedDrafts;
import com.conexia.qa.statefund.tasks.FillInformationNewUser;
import com.conexia.qa.statefund.tasks.FillPhysicianInformation;
import com.conexia.qa.statefund.tasks.SaveAsDraft;
import com.conexia.qa.statefund.tasks.ViewFiles;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.actions.Click;

public class BR6UserAssociationAndAccessSteps {

	@Then("^The portal is shows a message (.*)$")
	public void thePortalIsShowsAMessage(String param) {
		theActorInTheSpotlight().should(seeThat(TheClaimSearch.theRecordWasNotFound(), equalTo(param)));
	}

	@When("^Access to create new user module$")
	public void accessToCreateNewUserModule() {
		theActorInTheSpotlight().attemptsTo(AgreeTermsAndPolicies.afterLogin(), AccessToCreateNewUser.menu());
	}

	@When("^The Admin User fills all the form whitout the information in Physicians field$")
	public void theAdminUserFillsAllTheFormWhitoutTheInformationInPhysiciansField(List<CreateNewUser> createNewUser) {
		CreateNewUser.saveCreateNewUserList(createNewUser.get(0));
		theActorInTheSpotlight().attemptsTo(FillInformationNewUser.fields());
		theActorInTheSpotlight().attemptsTo(ClickOn.buttonSave());
	}

	@Then("^The portal displays the demographics information$")
	public void ThePortalDisplaysTheDemographicsInformation() {
		theActorInTheSpotlight().attemptsTo(ClaimDetails.access());
	}

	@When("^Enter data in the fields on worker information$")
	public void EnterDataInTheFieldsOnWorkerInformation(List<WorkerInformation> dataWorker) {
		WorkerInformation.saveWorkerInformationList(dataWorker.get(0));
		theActorInTheSpotlight().attemptsTo(AgreeTermsAndPolicies.afterLogin(), ClaimSearch.by("Worker Information"));
	}

	@Then("^The portal displays the results$")
	public void thePortalDisplaysTheResults() {
		theActorInTheSpotlight().should(seeThat(DataTableIsShow.onPortal()));
	}

	@Then("^The portal displays the information of the selected RFA$")
	public void thePortalDisplaysTheInformationOfTheSelectedRFA() {
		theActorInTheSpotlight().attemptsTo(Swipe.vertical(500), Sleep.by(3000));
		Serenity.takeScreenshot();
		theActorInTheSpotlight().attemptsTo(Click.on(EXPAND_ROW), Sleep.by(3000));
		Serenity.takeScreenshot();
	}

	@Then("^Access to the the options from User Management$")
	public void accessToTheTheOptionsFromUserManagement() {
		theActorInTheSpotlight().attemptsTo(AgreeTermsAndPolicies.afterLogin());
		theActorInTheSpotlight().should(seeThat(TheAdministratorUserIsShow.onTheMenu()));
	}

	@Then("^can see all the attachments$")
	public void canSeeAllTheAttachments() {
		theActorInTheSpotlight().attemptsTo(ViewFiles.associated());
	}

	@When("^Entry to send RFA$")
	public void entryToSendRFA() {
		theActorInTheSpotlight().attemptsTo(EnterBySendRFA.onButton());
	}

	@When("^Fill the Requesting Physician Information with RFA type$")
	public void fillTheRequestingPhysicianInformationWithRFAType(List<PhysicianInformation> physicianInformation) {
		PhysicianInformation.savePhysicianInformationList(physicianInformation.get(0));
		theActorInTheSpotlight().attemptsTo(RFAType.option(PhysicianInformation.readData(0).getRfaType()),
				FillPhysicianInformation.mandatory(PhysicianInformation.readData(0).getPhysicianName()));
	}

	@When("^Enter saved drafts$")
	public void EnterSavedDrafts() {
		theActorInTheSpotlight().attemptsTo(EnterSavedDrafts.button());
	}

	@Then("^Can edit a record$")
	public void canEditARecord() {
		theActorInTheSpotlight().attemptsTo(EditRecord.icon());
	}

	@Then("^Can delete a record$")
	public void candeleteARecord() {
		theActorInTheSpotlight().attemptsTo(DeleteRecord.iconDelete());
	}

	@When("^Fill the Document Attachment and save as draft$")
	public void fillTheDocumentAttachmentAndSaveAsDraft(List<DocumentAttachment> documentAttachment) {
		DocumentAttachment.saveDocumentAttachmentList(documentAttachment.get(0));
		theActorInTheSpotlight().attemptsTo(SaveAsDraft.type(DocumentAttachment.readData(0).getDocumentType()));
	}

	@Then("^The portal redirects to the Claim Details$")
	public void thePortalRedirectsToTheClaimDetails() {
		theActorInTheSpotlight().should(seeThat(ReturnToClaimDetails.tittle()));
	}

}