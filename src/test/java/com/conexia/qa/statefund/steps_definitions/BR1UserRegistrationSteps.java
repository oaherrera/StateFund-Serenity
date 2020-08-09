package com.conexia.qa.statefund.steps_definitions;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

import java.util.List;

import com.conexia.qa.statefund.models.CreateNewAccount;
import com.conexia.qa.statefund.questions.AccountCreatedSuccess;
import com.conexia.qa.statefund.questions.ReturnLoginScreen;
import com.conexia.qa.statefund.questions.SendMail;
import com.conexia.qa.statefund.questions.TermsAndPoliciesTittle;
import com.conexia.qa.statefund.tasks.ConfirmAccountCreation;
import com.conexia.qa.statefund.tasks.FillInformationNewAccount;
import com.conexia.qa.statefund.tasks.FillInformationNewAccountWithEmail;
import com.conexia.qa.statefund.tasks.ReadTermsAndPolicies;
import com.conexia.qa.statefund.tasks.ReturnToLogin;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BR1UserRegistrationSteps {

	@When("^Confirm without filling out the form$")
	public void onfirmWithoutFillingOutTheForm() {
		theActorInTheSpotlight().attemptsTo(ConfirmAccountCreation.whitButton());
	}

	@When("^diligence the form with existing user$")
	public void diligenceTheFormWithExistingUser(List<CreateNewAccount> createNewAccount) {
		int index = 0;
		CreateNewAccount.emptyCreateNewAccountList();
		while (index < createNewAccount.size()) {
			CreateNewAccount.saveInformationNewAccount(createNewAccount.get(index));
			theActorInTheSpotlight().attemptsTo(FillInformationNewAccount.fields(index));
			index++;
		}
	}

	@When("^diligence the form with existing user and check email$")
	public void diligenceTheFormWithExistingUserAndCheckEmail(List<CreateNewAccount> createNewAccount) {
		int index = 0;
		CreateNewAccount.emptyCreateNewAccountList();
		while (index < createNewAccount.size()) {
			CreateNewAccount.saveInformationNewAccount(createNewAccount.get(index));
			theActorInTheSpotlight().attemptsTo(FillInformationNewAccountWithEmail.fields(index));
			index++;
		}
	}

	@Then("^The user can return to login$")
	public void theUserCanReturnToLogin() {
		theActorInTheSpotlight().attemptsTo(ReturnToLogin.whitButton());
		theActorInTheSpotlight().should(seeThat(ReturnLoginScreen.tittle()));
	}

	@Then("^Display the window of Sign up and Verify the Portal displays the “Terms and Policies” text in a pop-up screen when The Portal User selects the Terms and Policies link.$")
	public void termsAndPolicies() {
		theActorInTheSpotlight().attemptsTo(ReadTermsAndPolicies.inTheLink());
		theActorInTheSpotlight().should(seeThat(TermsAndPoliciesTittle.isShow()));
	}

	@When("^Account message created successfully is displayed$")
	public void accountMessageCreatedSuccessfullyIsDisplayed() {
		theActorInTheSpotlight().should(seeThat(AccountCreatedSuccess.isShow()));

	}
	
	@Then("^mail delivery is validated$")
	public void mailDeliveryIsValidated() {
		theActorInTheSpotlight().should(seeThat(SendMail.isShow()));
	}

}