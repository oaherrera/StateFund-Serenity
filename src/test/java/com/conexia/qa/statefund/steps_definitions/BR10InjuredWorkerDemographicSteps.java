package com.conexia.qa.statefund.steps_definitions;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;

import com.conexia.qa.sql_developer.interactions.DetailsClaimDB;
import com.conexia.qa.sql_developer.models.ClaimDetail;
import com.conexia.qa.statefund.questions.TheDetailsOfClaim;
import com.conexia.qa.statefund.questions.TheErrorMessageAlert;
import com.conexia.qa.statefund.tasks.ClaimDetails;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class BR10InjuredWorkerDemographicSteps {

	@And("^Access to Claim Details$")
	public void accessToClaimDetails() {
		theActorInTheSpotlight().attemptsTo(ClaimDetails.access());
	}

	@Then("^Verify the demograpchic information of the claim searched$")
	public void verifyTheDemographicInformationOfTheClaimSearched() {
		theActorInTheSpotlight().attemptsTo(DetailsClaimDB.query());
		theActorInTheSpotlight().should(seeThat(TheDetailsOfClaim.is(),
				equalTo(ClaimDetail.getWorkerFirstName() + " " + ClaimDetail.getWorkerLastName() + " - "
						+ ClaimDetail.getWorkerDateOfInjury() + " - " + ClaimDetail.getEmployerName())));
	}

	@Then("^The portal is shows alert with the error message (.*) = (.*)$")
	public void theErrorMessageIsDisplayedOnTheScreen(int result, String message) {
		theActorInTheSpotlight().should(seeThat(TheErrorMessageAlert.displayed(result), equalTo(message)));
	}

}