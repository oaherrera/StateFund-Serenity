package com.conexia.qa.statefund.steps_definitions;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

import java.util.List;

import com.conexia.qa.sql_developer.interactions.SearchClaimDB;
import com.conexia.qa.sql_developer.models.QueryResponse;
import com.conexia.qa.statefund.interactions.AgreeTermsAndPolicies;
import com.conexia.qa.statefund.models.WorkerInformation;
import com.conexia.qa.statefund.questions.TheErrorMessageField;
import com.conexia.qa.statefund.questions.TheInformationOfClaimSearch;
import com.conexia.qa.statefund.questions.TheResultOfClaimSearch;
import com.conexia.qa.statefund.tasks.ClaimSearch;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BR9ClaimSearchAndResultsSteps {

	@When("^Search an existing Claim$")
	public void searchAnExistingClaim(List<WorkerInformation> workerInformation) {
		WorkerInformation.saveWorkerInformationList(workerInformation.get(0));
		theActorInTheSpotlight().attemptsTo(AgreeTermsAndPolicies.afterLogin(),
				ClaimSearch.by(WorkerInformation.readData(0).getSearchBy()));
	}

	@Then("^Display the error message (.*) on claim search page$")
	public void displayTheErrorMessageOnClaimSearchPage(String message) {
		theActorInTheSpotlight().should(seeThat(TheErrorMessageField.displayed(message), equalTo(message)));
	}

	@Then("^Display the claim information$")
	public void displayTheClaimInformation() {
		theActorInTheSpotlight().attemptsTo(SearchClaimDB.by(WorkerInformation.readData(0).getSearchBy()));
		theActorInTheSpotlight()
				.should(seeThat(TheInformationOfClaimSearch.is(), equalTo(QueryResponse.getQueryResponse())));
	}

	@Then("^Display the label No Claim Found$")
	public void displayTheLabelNoClaimFound() {
		theActorInTheSpotlight().should(seeThat(TheResultOfClaimSearch.is(), containsString("No Claim Found")));
	}

}