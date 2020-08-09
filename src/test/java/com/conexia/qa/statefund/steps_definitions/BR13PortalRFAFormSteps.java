package com.conexia.qa.statefund.steps_definitions;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;

import java.util.List;

import com.conexia.qa.sql_developer.interactions.LegalFlagDescriptionDB;
import com.conexia.qa.sql_developer.interactions.ProcedureTypeDB;
import com.conexia.qa.sql_developer.interactions.ProcedureTypeURTreatmentTypeDB;
import com.conexia.qa.statefund.interactions.EmailAddress;
import com.conexia.qa.statefund.models.LegalFlag;
import com.conexia.qa.statefund.models.PhysicianInformation;
import com.conexia.qa.statefund.models.ProcedureType;
import com.conexia.qa.statefund.models.TreatmentDetails;
import com.conexia.qa.statefund.models.WorkerInformation;
import com.conexia.qa.statefund.questions.ContextualHelpText;
import com.conexia.qa.statefund.questions.SelectOnlyOneOption;
import com.conexia.qa.statefund.questions.TheCalendar;
import com.conexia.qa.statefund.questions.TheErrorMessageField;
import com.conexia.qa.statefund.questions.TheFieldIsEmail;
import com.conexia.qa.statefund.questions.TheFieldIsNumeric;
import com.conexia.qa.statefund.questions.TheFields;
import com.conexia.qa.statefund.questions.TheFieldsAreDisplayed;
import com.conexia.qa.statefund.questions.TheInvalidSearch;
import com.conexia.qa.statefund.questions.TheLegalFlagDescription;
import com.conexia.qa.statefund.questions.TheOption;
import com.conexia.qa.statefund.questions.TheOptionsAreDisplayed;
import com.conexia.qa.statefund.questions.ThePartiallyMatchedResults;
import com.conexia.qa.statefund.questions.TheSearch;
import com.conexia.qa.statefund.questions.TheSelect;
import com.conexia.qa.statefund.questions.TheUnableToEdit;
import com.conexia.qa.statefund.questions.TheValueDisplayed;

import cucumber.api.java.en.Then;

public class BR13PortalRFAFormSteps {

	@Then("^Verify the fields displayed the portal RFA form$")
	public void verifyTheFieldsDisplayedThePortalRFAForm(List<PhysicianInformation> physicianInformation) {
		PhysicianInformation.savePhysicianInformationList(physicianInformation.get(0));
		TreatmentDetails.saveTreatmentDetailsList(physicianInformation.get(0));
		theActorInTheSpotlight().should(seeThat(TheFieldsAreDisplayed.fromPortalRFAForm()));
	}

	@Then("^Verify the displayed options from field RFA type$")
	public void verifyTheDisplayedOptionsFromFieldRFAType() {
		theActorInTheSpotlight().should(seeThat(TheOptionsAreDisplayed.fromFieldRFAType()));
	}

	@Then("^Verify that is able to select only one value in the field RFA type$")
	public void verifyThatIsAbleToSelectOnlyOneValueInTheFieldRFAType() {
		theActorInTheSpotlight().should(seeThat(SelectOnlyOneOption.inTheFieldRFAType()));
	}

	@Then("^Verify that is able to change the RFA type option$")
	public void VerifyThatIsAbleToChangeTheRFATypeOption() {
		theActorInTheSpotlight().should(seeThat(SelectOnlyOneOption.inTheFieldRFAType()));
		theActorInTheSpotlight().should(seeThat(SelectOnlyOneOption.inTheFieldRFAType()));
	}

	@Then("^Verify a contextual help text is a displayed when the user hovers over the (.*) RFA type option$")
	public void verifyAContextualHelpTextIsADisplayedWhenTheUserHoversOverTheRFATypeOption(String rfaOption) {
		theActorInTheSpotlight().should(seeThat(ContextualHelpText.isDisplayed(rfaOption)));
	}

	@Then("^Verify the legal flag description is sent back to State Fund in the comments section of the portal RFA form$")
	public void verifyTheLegalFlagDescriptionIsSentBackToStateFundInTheCommentsSectionOfThePortalRFAForm(
			List<LegalFlag> legalFlag) {
		LegalFlag.saveLegalFlagList(legalFlag.get(0));
		theActorInTheSpotlight().attemptsTo(LegalFlagDescriptionDB.query());
		theActorInTheSpotlight().should(seeThat(TheLegalFlagDescription.submitted(),
				equalTo(WorkerInformation.readData(0).getClaimNumber() + " - " + LegalFlag.readData(0).getComment()
						+ " - " + LegalFlag.readData(0).getSubmittedDate())));
	}

	@Then("^Verify is able to enter a numeric value in the (.*) field$")
	public void verifyIsAbleToEnterANumericValueInTheField(String field, List<String> value) {
		theActorInTheSpotlight().should(seeThat(TheFieldIsNumeric.in(field, value)));
	}

	@Then("^Verify is able to enter the Requesting Physicians Email Address$")
	public void verifyIsAbleToEnterTheRequestingPhysiciansEmailAddress(List<String> emailAddress) {
		theActorInTheSpotlight().should(seeThat(TheFieldIsEmail.inEmailAddress(emailAddress)));
	}

	@Then("^Display the error message (.*) on Requesting Physician Information section$")
	public void displayTheErrorMessageOnClaimSearchPage(String message, List<String> emailAddress) {
		theActorInTheSpotlight().attemptsTo(EmailAddress.isField(emailAddress, false));
		theActorInTheSpotlight().should(seeThat(TheErrorMessageField.displayed(message), equalTo(message)));
	}

	@Then("^Verify the value displayed is (.*) in the (.*) field$")
	public void verifyTheValueDisplayedIsInTheField(String value, String field) {
		theActorInTheSpotlight().should(seeThat(TheValueDisplayed.is(value).from(field)));
	}

	@Then("^Verify is unable to edit the (.*) field$")
	public void verifyIsUnableToEditTheField(String field) {
		theActorInTheSpotlight().should(seeThat(TheUnableToEdit.inTheField(field)));
	}

	@Then("^Verify the (.*) displayed from (.*) field$")
	public void verifyTheDisplayedFromField(String option, String field) {
		theActorInTheSpotlight().should(seeThat(TheOption.isDisplayed(option).from(field)));
	}

	@Then("^Verify the (.*) displayed from (.*) field to (.*)$")
	public void verifyTheDisplayedFromFieldTo(String option, String field, String section,
			List<TreatmentDetails> treatmentDetails) {
		theActorInTheSpotlight()
				.should(seeThat(TheOption.isDisplayed(option).from(field).withDataTreatmentDetails(treatmentDetails)));
	}

	@Then("^Verify the select an value any from (.*) field, and the (.*) fields must be auto-populated$")
	public void verifyTheSelectAnValueAnyFromFieldAndTheFieldsMustBeAutoPopulated(String field, String fields,
			List<String> value) {
		theActorInTheSpotlight().should(seeThat(TheFields.areAutoPopulated(fields).troughtField(field, value)));
	}

	@Then("^Verify is able to search for a Diagnosis by entering the diagnosis (.*)$")
	public void verifyIsAbleToSearchForADiagnosisByEnteringTheDiagnosis(String filter, List<String> data) {
		theActorInTheSpotlight().should(seeThat(TheSearch.is(filter, data)));
	}

	@Then("^Verify when the (.*) entered is invalid with the message (.*)$")
	public void verifyWhenTheDiagnosisEnteredIsInvalidWithTheMessage(String filter, String message, List<String> data) {
		theActorInTheSpotlight().should(seeThat(TheInvalidSearch.is(filter, data), equalTo(message)));
	}

	@Then("^Verify displays up to (.*) partially matched results in the (.*) field$")
	public void verifyDisplaysUpToPartiallyMatchedResultsInTheField(int quantity, String field, List<String> data) {
		theActorInTheSpotlight().should(seeThat(ThePartiallyMatchedResults.displays(data, quantity).from(field)));
	}

	@Then("^Verify a calendar table is displayed when the (.*) field is selected$")
	public void verifyACalendarTableIsDisplayedWhenTheFieldIsSelected(String field,
			List<TreatmentDetails> treatmentDetails) {
		theActorInTheSpotlight()
				.should(seeThat(TheCalendar.isDisplayed(field).withDataTreatmentDetails(treatmentDetails)));
	}

	@Then("^Verify is displaying (.*) based on the (.*): (.*)$")
	public void verifyIsDisplayingBasedOnThe(String dependentField, String value, String independentField) {
		ProcedureType.setDescription(value);
		theActorInTheSpotlight().attemptsTo(ProcedureTypeDB.query(), ProcedureTypeURTreatmentTypeDB.query());
		theActorInTheSpotlight().should(seeThat(TheSelect.dependent(dependentField).from(independentField, value)));
	}

}