package com.conexia.qa.statefund.steps_definitions;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;

import com.conexia.qa.sql_developer.interactions.RequestedBodyPartsDB;
import com.conexia.qa.sql_developer.interactions.SpecificationDetailsClaimDB;
import com.conexia.qa.sql_developer.models.ClaimDetail;
import com.conexia.qa.sql_developer.models.RequestedBodyParts;
import com.conexia.qa.statefund.interactions.ThePopUp;
import com.conexia.qa.statefund.questions.TheAttachmentDocument;
import com.conexia.qa.statefund.questions.TheButton;
import com.conexia.qa.statefund.questions.TheClaimInformation;
import com.conexia.qa.statefund.questions.TheInformationPopUp;
import com.conexia.qa.statefund.questions.TheRFAButton;
import com.conexia.qa.statefund.questions.TheRFAInformation;
import com.conexia.qa.statefund.questions.TheTreatmentHistoryIsDisplayed;
import com.conexia.qa.statefund.questions.TheTreatmentHistoryNotIsVisible;
import com.conexia.qa.statefund.tasks.SpecificationClaimDetails;

import cucumber.api.java.en.Then;

public class BR12ClaimDetailsSteps {

	@Then("^Verify the specification of the claim searched$")
	public void verifyTheSpecificationOfTheClaimSearched() {
		theActorInTheSpotlight().attemptsTo(SpecificationDetailsClaimDB.query());
		if (ClaimDetail.getWorkerMiddleName() == null) {
			theActorInTheSpotlight().should(seeThat(TheClaimInformation.is(),
					equalTo(ClaimDetail.getClaimNumber() + " - " + ClaimDetail.getWorkerFirstName() + " "
							+ ClaimDetail.getWorkerLastName() + " - " + ClaimDetail.getWorkerDateOfBirth() + " - "
							+ ClaimDetail.getWorkerDateOfInjury() + " - " + ClaimDetail.getEmployerName())));// + " - "
																												// +
																												// ClaimDetail.getRfaID())));
		} else {
			theActorInTheSpotlight().should(seeThat(TheClaimInformation.is(),
					equalTo(ClaimDetail.getClaimNumber() + " - " + ClaimDetail.getWorkerFirstName() + " "
							+ ClaimDetail.getWorkerMiddleName() + " " + ClaimDetail.getWorkerLastName() + " - "
							+ ClaimDetail.getWorkerDateOfBirth() + " - " + ClaimDetail.getWorkerDateOfInjury() + " - "
							+ ClaimDetail.getEmployerName())));// + " - " + ClaimDetail.getRfaID())));
		}
		theActorInTheSpotlight().attemptsTo(SpecificationClaimDetails.view());
	}

	@Then("^Verify the (.*) button is displayed$")
	public void verifyTheButton(String button) {
		theActorInTheSpotlight().should(seeThat(TheButton.isDisplayed(button)));
	}

	@Then("^Verify the information from (.*) pop-up$")
	public void verifyTheInformationFromPopUp(String popUp) {
		if (popUp.equalsIgnoreCase("Requested Body Parts")) {
			theActorInTheSpotlight().attemptsTo(RequestedBodyPartsDB.query());
			theActorInTheSpotlight().should(seeThat(TheInformationPopUp.is(popUp),
					equalTo(RequestedBodyParts.getDescription() + " " + RequestedBodyParts.getDecision())));
		} else if (popUp.equalsIgnoreCase("Related Claim")) {
			theActorInTheSpotlight().should(seeThat(TheInformationPopUp.is(popUp), equalTo(null)));
		}
	}

	@Then("^Verify the pagination from Related Claim pop-up$")
	public void verifyThePaginationFromRelatedClaimPopUp() {
		theActorInTheSpotlight().attemptsTo(ThePopUp.hasThreeRelatedClaimsPerPage());
	}

	@Then("^The RFA button is disable and the Claim Type is (.*)$")
	public void theRFAButtonIsDisableAndTheClaimTypeIs(String claimType) {
		theActorInTheSpotlight().should(seeThat(TheRFAButton.isDisabled(claimType)));
	}

	@Then("^The RFA button is enable, the Claim Type is (.*) and Claim Decision is (.*)$")
	public void theRFAButtonIsEnableTheClaimTypeIsAndClaimDecisionIs(String claimType, String claimDecision) {
		theActorInTheSpotlight().should(seeThat(TheRFAButton.isEnabled(claimType, claimDecision)));
	}

	@Then("^The RFA button is disable, the Claim Type is (.*) and Claim Decision is (.*)$")
	public void theRFAButtonIsDisableTheClaimTypeIsAndClaimDecisionIs(String claimType, String claimDecision) {
		theActorInTheSpotlight().should(seeThat(TheRFAButton.isDisabled(claimType, claimDecision)));
	}

	@Then("^The Treatment History no is visible for a Restricted Claim$")
	public void theTreatmentHistoryNoIsVisibleForARestrictedClaim() {
		theActorInTheSpotlight().should(seeThat(TheTreatmentHistoryNotIsVisible.forARestrictedClaim()));
	}

	@Then("^The Treatment History is displayed for the RFAs displayed$")
	public void theTreatmentHistoryIsDisplayedForTheRFAsDisplayed() {
		theActorInTheSpotlight().should(seeThat(TheTreatmentHistoryIsDisplayed.forARFA()));
	}

	@Then("^Verify the specification of the RFA selected$")
	public void verifyTheSpecificationOfTheRFASelected() {
		theActorInTheSpotlight().should(seeThat(TheRFAInformation.is()));
	}

	@Then("^Access a document from Attachments Document pop-up$")
	public void accessADocumentFromAttachmentsDocumentPopUp() {
		theActorInTheSpotlight().should(seeThat(TheAttachmentDocument.is()));
	}

}