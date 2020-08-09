package com.conexia.qa.statefund.steps_definitions;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;

import java.util.List;

import com.conexia.qa.statefund.interactions.WaitLoading;
import com.conexia.qa.statefund.models.UserAuthentication;
//import com.conexia.qa.statefund.questions.RedirectToForgotYourPassword;
//import com.conexia.qa.statefund.questions.RedirectToSignUp;
import com.conexia.qa.statefund.questions.ShowTermsAndPolicies;
import com.conexia.qa.statefund.questions.TheErrorMessage;
import com.conexia.qa.statefund.questions.TheErrorMessageAccessDenied;
import com.conexia.qa.statefund.tasks.AccessToLogin;
import com.conexia.qa.statefund.tasks.LogIn;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BR2LoginAndSecuritySteps {

	@When("^Login with the next credentials$")
	public void loginWithTheNextCredentials(List<UserAuthentication> userLogin) {
		int index = 0;
		UserAuthentication.saveUserAuthenticationList(userLogin.get(0));
		while (index < userLogin.size()) {
			theActorInTheSpotlight().attemptsTo(LogIn.withUser(UserAuthentication.readData(0).getUserName())
					.andPassword(UserAuthentication.readData(0).getPassword())
					.andAcceptTerms(UserAuthentication.readData(0).getAcceptTermsAndPolicies()), WaitLoading.page());
			index++;
		}
	}

	@Then("^Display the error message (.*) on login page$")
	public void displayTheErrorMessageOnLoginPage(String message) {
		theActorInTheSpotlight().should(seeThat(TheErrorMessage.displayed(), equalTo(message)));
	}

	@Then("^Display the span error message (.*) on login page$")
	public void displayTheSpanErrorMessageOnLoginPage(String message) {
		theActorInTheSpotlight().should(seeThat(TheErrorMessage.displayedSpanError(), equalTo(message)));
	}

	@Then("^Display the error access denied message (.*) on login page$")
	public void displayTheSpanErrorAccessDeniedMessageOnLoginPage(String message) {
		theActorInTheSpotlight().should(seeThat(TheErrorMessageAccessDenied.displayed(), equalTo(message)));
	}

	@When("^Open the link (.*) on login page$")
	public void openTheLinkOnLoginPage(String link) {
		theActorInTheSpotlight().attemptsTo(AccessToLogin.link(link));
	}

	@Then("^Display the window of Terms and Policies$")
	public void displayTheWindowOfTermsAndPolicies() {
		theActorInTheSpotlight().should(seeThat(ShowTermsAndPolicies.popUp()));
	}

	@Then("^Display the window of Forgot your password$")
	public void displayTheWindowOfForgotYourPassword() {
		//theActorInTheSpotlight().should(seeThat(RedirectToForgotYourPassword.option()));
	}

	@Then("^Display the window of Sign up$")
	public void displayTheWindowOfSignUp() {
		//theActorInTheSpotlight().should(seeThat(RedirectToSignUp.option()));
	}

}