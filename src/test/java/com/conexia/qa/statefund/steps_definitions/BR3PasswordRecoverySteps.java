package com.conexia.qa.statefund.steps_definitions;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

import java.util.List;

import com.conexia.qa.sql_developer.interactions.PasswordEncryptedDB;
import com.conexia.qa.statefund.models.UserAuthentication;
import com.conexia.qa.statefund.questions.PasswordRecovery;
import com.conexia.qa.statefund.questions.Return;
import com.conexia.qa.statefund.questions.ShowTermsAndPolicies;
import com.conexia.qa.statefund.questions.TheField;
import com.conexia.qa.statefund.questions.ThePassword;

import cucumber.api.java.en.Then;

public class BR3PasswordRecoverySteps {

	@Then("^Verify the (.*) field displayed$")
	public void verifyTheFieldDisplayed(String field) {
		theActorInTheSpotlight().should(seeThat(TheField.isDisplayed(field)));
	}

	@Then("^Submit a password recovery request$")
	public void submitAPasswordRecoveryRequest(List<String> email) {
		theActorInTheSpotlight().should(seeThat(PasswordRecovery.request(email)));
	}

	@Then("^Display the window of Terms and Policies in the Forgot password$")
	public void displayTheWindowOfTermsAndPoliciesInTheForgotPassword() {
		theActorInTheSpotlight().should(seeThat(ShowTermsAndPolicies.popUpForgotPassword()));
	}

	@Then("^Return to (.*) page trought the link (.*)$")
	public void returnToPageTroughtTheLink(String page, String link) {
		theActorInTheSpotlight().should(seeThat(Return.toPage(page).trought(link)));
	}

	@Then("^Verify the password encrypted saved in the database$")
	public void verifyThePasswordEncryptedSavedInTheDatabase(List<UserAuthentication> userAuthentication) {
		String password = "";
		UserAuthentication.saveUserAuthenticationList(userAuthentication.get(0));
		password = UserAuthentication.readData(0).getPassword();
		theActorInTheSpotlight().attemptsTo(PasswordEncryptedDB.query());
		theActorInTheSpotlight().should(seeThat(ThePassword.isEncrypted(password)));
	}

}