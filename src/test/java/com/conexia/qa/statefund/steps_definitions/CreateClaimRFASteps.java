package com.conexia.qa.statefund.steps_definitions;

import static com.conexia.qa.statefund.user_interfaces.ClaimSearchPage.SUBMIT_A_NON_CLAIM_RFA;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;

import java.util.List;

import com.conexia.qa.sql_developer.interactions.DecisionsQueryDB;
import com.conexia.qa.sql_developer.interactions.JsonOutDB;
import com.conexia.qa.sql_developer.models.QueryResponse;
import com.conexia.qa.sql_developer.questions.JsonOutThePeriodFequencyAndQuantity;
import com.conexia.qa.sql_developer.questions.JsonOutTheProcedureTypeAndProcedureCode;
import com.conexia.qa.statefund.interactions.AcceptNotification;
import com.conexia.qa.statefund.interactions.AgreeTermsAndPolicies;
import com.conexia.qa.statefund.interactions.PDFReader;
import com.conexia.qa.statefund.interactions.RFAType;
import com.conexia.qa.statefund.models.DocumentAttachment;
import com.conexia.qa.statefund.models.PDFInformation;
import com.conexia.qa.statefund.models.PhysicianInformation;
import com.conexia.qa.statefund.models.TreatmentDetails;
import com.conexia.qa.statefund.models.WorkerInformation;
import com.conexia.qa.statefund.questions.ProvisionalDecision;
import com.conexia.qa.statefund.questions.ProvisionalSourceOfDecision;
import com.conexia.qa.statefund.questions.ThePeriodFequencyAndQuantity;
import com.conexia.qa.statefund.tasks.ClaimSearch;
import com.conexia.qa.statefund.tasks.DownloadNonClaim;
import com.conexia.qa.statefund.tasks.FillPhysicianInformation;
import com.conexia.qa.statefund.tasks.FillTheClaimAdministrator;
import com.conexia.qa.statefund.tasks.FillTheTreatmentDetails;
import com.conexia.qa.statefund.tasks.FillWorkerInformation;
import com.conexia.qa.statefund.tasks.SelectDocumentAttachment;
import com.conexia.qa.statefund.tasks.ViewClaimDetail;
import com.conexia.qa.statefund.utils.FilePath;
import com.conexia.qa.statefund.utils.Folder;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CreateClaimRFASteps {

	@When("^Search a claim by worker information section$")
	public void searchAClaimByWorkerInformationSection(List<WorkerInformation> workerInformation) {
		WorkerInformation.saveWorkerInformationList(workerInformation.get(0));
		theActorInTheSpotlight().attemptsTo(AgreeTermsAndPolicies.afterLogin(), ClaimSearch.by("Worker Information"),
				AgreeTermsAndPolicies.ofTransaction());
	}

	@When("^Submit a New Claim RFA with a worker information$")
	public void submitANewClaimRFAWithAWorkerInformation(List<WorkerInformation> workerInformation) {
		WorkerInformation.saveWorkerInformationList(workerInformation.get(0));
		theActorInTheSpotlight().attemptsTo(AgreeTermsAndPolicies.afterLogin(),
				ClaimSearch.by(WorkerInformation.readData(0).getSearchBy()),
				ViewClaimDetail.number(WorkerInformation.readData(0).getClaimNumber()),
				RFAType.option(WorkerInformation.readData(0).getRfaType()));
	}

	@When("^Submit a Non-Claim RFA with a worker information$")
	public void submitANonClaimRFAWithAWorkerInformation(List<WorkerInformation> workerInformation) {
		WorkerInformation.saveWorkerInformationList(workerInformation.get(0));
		theActorInTheSpotlight().attemptsTo(AgreeTermsAndPolicies.afterLogin(), ClaimSearch.by("Worker Information"),
				AcceptNotification.popUp(SUBMIT_A_NON_CLAIM_RFA), AgreeTermsAndPolicies.afterLogin(),
				FillWorkerInformation.withTheWorker(WorkerInformation.readData(0).getWorkerFirstName())
						.andRFATypeIs(WorkerInformation.readData(0).getRfaType()));
	}

	@When("^Fill the Requesting Physician Information$")
	public void fillTheRequestingPhysicianInformation(List<PhysicianInformation> physicianInformation) {
		PhysicianInformation.savePhysicianInformationList(physicianInformation.get(0));
		theActorInTheSpotlight()
				.attemptsTo(FillPhysicianInformation.mandatory(PhysicianInformation.readData(0).getPhysicianName()));
	}

	@When("^Fill the Claim Administrator Information$")
	public void fillTheClaimAdministratorInformation() {
		theActorInTheSpotlight().attemptsTo(FillTheClaimAdministrator.information());
	}

	@When("^Fill the Treatment Details$")
	public void filTheTreatmentDetails(List<TreatmentDetails> treatmentDetails) {
		TreatmentDetails.saveTreatmentDetailsList(treatmentDetails.get(0));
		theActorInTheSpotlight().attemptsTo(FillTheTreatmentDetails.fields());
	}

	@When("^Fill the Document Attachment$")
	public void fillTheDocumentAttachment(List<DocumentAttachment> documentAttachment) {
		DocumentAttachment.saveDocumentAttachmentList(documentAttachment.get(0));
		theActorInTheSpotlight()
				.attemptsTo(SelectDocumentAttachment.type(DocumentAttachment.readData(0).getDocumentType()));
	}

	@Then("^The Non-Claim RFA proccess is correctly registred$")
	public void theNonClaimRFAProccessIsCorrectlyRegistred() {
		theActorInTheSpotlight().attemptsTo(DownloadNonClaim.rfa());
		theActorCalled(FilePath.getHostName());
		Folder folder = new Folder();
		PDFInformation pdfInformation = new PDFInformation();

		theActorInTheSpotlight().attemptsTo(PDFReader.contentOf(folder.getFilePath(FilePath.downloadPath())));
		theActorInTheSpotlight().attemptsTo(JsonOutDB.ofClaimId(pdfInformation.getTemporaryRFAID()));
		theActorInTheSpotlight().attemptsTo(DecisionsQueryDB.ofClaimId(pdfInformation.getTemporaryRFAID()));
		theActorInTheSpotlight()
				.should(seeThat(ProvisionalDecision.is(), equalTo(QueryResponse.getProvisionalDecision())));
		theActorInTheSpotlight().should(
				seeThat(ProvisionalSourceOfDecision.is(), equalTo(QueryResponse.getProvisionalSourceOfDecision())));
		theActorInTheSpotlight().should(seeThat(JsonOutTheProcedureTypeAndProcedureCode.are(),
				equalTo(TreatmentDetails.readData(0).getProcedureType() + " - " + pdfInformation.getProcedureCode())));
		theActorInTheSpotlight().should(seeThat(ThePeriodFequencyAndQuantity.are(),
				equalTo(TreatmentDetails.readData(0).getPeriod() + " - " + TreatmentDetails.readData(0).getFrecuency()
						+ " - " + TreatmentDetails.readData(0).getQuantity())));
		theActorInTheSpotlight().should(seeThat(JsonOutThePeriodFequencyAndQuantity.are(),
				equalTo(TreatmentDetails.readData(0).getPeriod() + " - " + TreatmentDetails.readData(0).getFrecuency()
						+ " - " + TreatmentDetails.readData(0).getQuantity())));
	}

	@Then("^The New Claim RFA proccess is correctly registred$")
	public void theNewClaimRFAProccessIsCorrectlyRegistred() {
		// waitloading
		theActorCalled(FilePath.getHostName());
//		Folder folder = new Folder();
//		PDFInformation pdfInformation = new PDFInformation();
	}

}