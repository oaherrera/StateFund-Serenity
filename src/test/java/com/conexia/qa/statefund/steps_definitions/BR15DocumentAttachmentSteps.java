package com.conexia.qa.statefund.steps_definitions;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;

import java.util.List;

import com.conexia.qa.statefund.models.DocumentAttachment;
import com.conexia.qa.statefund.questions.ItWasDeleted;
import com.conexia.qa.statefund.questions.TheErrorMessageInvalidFile;
import com.conexia.qa.statefund.questions.TheErrorMessageInvalidFileSize;
import com.conexia.qa.statefund.questions.TheSummary;
import com.conexia.qa.statefund.tasks.Download;
import com.conexia.qa.statefund.tasks.SelectDocumentAttachmentBiggerThan32MB;
import com.conexia.qa.statefund.tasks.SelectDocumentAttachmentForRemove;
import com.conexia.qa.statefund.tasks.SelectDocumentAttachmentWord;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BR15DocumentAttachmentSteps {

	@Then("^the portal shows the summary screen$")
	public void thePortalShowsTheSummaryScreen() {
		theActorInTheSpotlight().should(seeThat(TheSummary.isShow()));
	}

	@When("^Fill the Document Attachment and remove$")
	public void fillTheDocumentAttachmentAndRemove(List<DocumentAttachment> documentAttachment) {
		DocumentAttachment.saveDocumentAttachmentList(documentAttachment.get(0));
		theActorInTheSpotlight()
				.attemptsTo(SelectDocumentAttachmentForRemove.type(DocumentAttachment.readData(0).getDocumentType()));
	}

	@Then("^shows that the record was deleted$")
	public void showsThatTheRecordWasDeleted() {
		theActorInTheSpotlight().should(seeThat(ItWasDeleted.theAttachment()));
	}

	@Then("^can see all the attachments and view document to download$")
	public void canSeeAllTheAttachmentsAndViewDocumentToDownload() {
		theActorInTheSpotlight().attemptsTo(Download.file());
	}

	@When("^Fill the Document Attachment other than pdf$")
	public void FillTheDocumentAttachmentOtherThanPdf(List<DocumentAttachment> documentAttachment) {
		DocumentAttachment.saveDocumentAttachmentList(documentAttachment.get(0));
		theActorInTheSpotlight()
				.attemptsTo(SelectDocumentAttachmentWord.type(DocumentAttachment.readData(0).getDocumentType()));
	}

	@Then("^Error message (.*) is displayed$")
	public void errorMessageIsDisplayed(String message) {
		theActorInTheSpotlight().should(seeThat(TheErrorMessageInvalidFile.displayed(), equalTo(message)));
	}

	@When("^Fill the Document Attachment bigger than 32MB$")
	public void fillTheDocumentAttachmentBiggerThan32MB(List<DocumentAttachment> documentAttachment) {
		DocumentAttachment.saveDocumentAttachmentList(documentAttachment.get(0));
		theActorInTheSpotlight().attemptsTo(
				SelectDocumentAttachmentBiggerThan32MB.type(DocumentAttachment.readData(0).getDocumentType()));
	}

	@Then("^Error message (.*) is show$")
	public void errorMessageInvalidFileSizeIsShow(String message) {
		theActorInTheSpotlight().should(seeThat(TheErrorMessageInvalidFileSize.displayed(), equalTo(message)));
	}

}