package com.conexia.qa.statefund.steps_definitions;

import static com.conexia.qa.statefund.user_interfaces.ClaimSearchPage.CLEAR_RESULTS;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;

import java.util.List;

import com.conexia.qa.statefund.interactions.AgreeTermsAndPolicies;
import com.conexia.qa.statefund.interactions.WaitLoading;
import com.conexia.qa.statefund.models.WorkerInformation;
import com.conexia.qa.statefund.questions.TheEnterDate;
import com.conexia.qa.statefund.questions.TheErrorMessageField;
import com.conexia.qa.statefund.questions.TheFieldsAreEmpty;
import com.conexia.qa.statefund.questions.TheFieldsAreMandatories;
import com.conexia.qa.statefund.questions.TheSearchGenerated;
import com.conexia.qa.statefund.questions.TheSelectDate;
import com.conexia.qa.statefund.tasks.AccessToClaimSearch;
import com.conexia.qa.statefund.tasks.ClaimSearch;
import com.conexia.qa.statefund.utils.DateFunctions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.actions.Click;

public class BR8UserInterfaceValidationSteps {

	@When("^Access to the Claim Search module$")
	public void accessToTheClaimSearchModule() {
		theActorInTheSpotlight().attemptsTo(AgreeTermsAndPolicies.afterLogin(), AccessToClaimSearch.menu());
	}

	@When("^Enter data in the fields on Claim Search$")
	public void enterDataInTheFieldsOnClaimSearch(List<WorkerInformation> dataWorker) {
		theActorInTheSpotlight().attemptsTo(AgreeTermsAndPolicies.afterLogin());
		WorkerInformation.saveWorkerInformationList(dataWorker.get(0));
		theActorInTheSpotlight().attemptsTo(ClaimSearch.by("Worker Information"));
	}

	@Then("^The portal is shows the symbol in mandatory fields$")
	public void thePortalIsShowsTheSymbolInMandatoryFields() {
		theActorInTheSpotlight().should(seeThat(TheFieldsAreMandatories.withAsterisk()));
	}

	@Then("^The portal is shows the error message (.*)$")
	public void thePortalIsShowsTheErrorsMessage(String message) {
		theActorInTheSpotlight().should(seeThat(TheErrorMessageField.displayed(message), equalTo(message)));
	}

	@Then("^Select the actual date in the field Date of Injury$")
	public void selectTheActualDateInTheFieldDateOfInjury() {
		theActorInTheSpotlight().should(seeThat(TheSelectDate.is(), equalTo(DateFunctions.actualDateWithFormat())));
	}

	@Then("^Enter the actual date in the field Date of Injury$")
	public void enterTheActualDateInTheFieldDateOfInjury() {
		theActorInTheSpotlight().should(seeThat(TheEnterDate.is(), equalTo(DateFunctions.actualDateWithFormat())));
	}

	@Then("^The fields remain empty after cleaning them$")
	public void theFieldsRemainEmptyAfterCleaningThem() {
		theActorInTheSpotlight().attemptsTo(Click.on(CLEAR_RESULTS), WaitLoading.page());
		theActorInTheSpotlight().should(seeThat(TheFieldsAreEmpty.through()));
	}

	@Then("^A record with the generated query is displayed$")
	public void aRecordWithTheGeneratedQueryIsDisplayed() {
		theActorInTheSpotlight().should(seeThat(TheSearchGenerated.is(),
				equalTo(WorkerInformation.readData(0).getWorkerFirstName().toUpperCase() + " - "
						+ WorkerInformation.readData(0).getWorkerLastName().toUpperCase() + " - "
						+ WorkerInformation.readData(0).getDateOfInjury())));
	}

	@Then("^The fields are empty$")
	public void theFieldsTheyAreEmpty() {
		theActorInTheSpotlight().should(seeThat(TheFieldsAreEmpty.through()));
	}

}