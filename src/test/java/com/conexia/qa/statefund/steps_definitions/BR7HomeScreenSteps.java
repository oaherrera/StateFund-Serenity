package com.conexia.qa.statefund.steps_definitions;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

import com.conexia.qa.statefund.interactions.AgreeTermsAndPolicies;
import com.conexia.qa.statefund.questions.FirstView;
import com.conexia.qa.statefund.questions.IconNotification;
import com.conexia.qa.statefund.questions.LogOut;
import com.conexia.qa.statefund.questions.SeeMenu;
import com.conexia.qa.statefund.questions.ShowAllNotification;
import com.conexia.qa.statefund.questions.TheHomeScreen;
import com.conexia.qa.statefund.questions.TheSeeNameAndLastName;
import com.conexia.qa.statefund.questions.TheSeeTheMenuOnTheLeft;
import com.conexia.qa.statefund.questions.TheSeeTheStateFoundLogo;
import com.conexia.qa.statefund.tasks.GoToAllNotificationUser;
import com.conexia.qa.statefund.tasks.SelectPhysician;
import com.conexia.qa.statefund.tasks.SelectWorkplace;
import com.conexia.qa.statefund.tasks.TheShowsTimeAndDate;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class BR7HomeScreenSteps {

	@Then("^The portal should display the home screen$")
	public void thePortalShouldDisplayTheHomeScreen() {
		theActorInTheSpotlight().should(seeThat(TheHomeScreen.onPortal()));
	}

	@Then("^The portal should show the header session$")
	public void thePortalShouldShowTheHeaderSession() {
		theActorInTheSpotlight().should(seeThat(TheSeeTheMenuOnTheLeft.onPortal()));
	}

	@Then("^The portal must show the state logo$")
	public void thePortalMustShowTheStateLogo() {
		theActorInTheSpotlight().should(seeThat(TheSeeTheStateFoundLogo.onPortal()));
	}

	@Then("^The portal must show the first and last name$")
	public void thePortalMustShowTheFirstAndLastName() {
		theActorInTheSpotlight().should(seeThat(TheSeeNameAndLastName.onPortal()));
	}

	@Then("^The portal must show job names$")
	public void thePortalMustShowJobNames() {
		theActorInTheSpotlight().attemptsTo(AgreeTermsAndPolicies.afterLogin(), SelectWorkplace.by());
	}

	@Then("^The portal shows the doctors (.+) assigned in the drop-down menu$")
	public void thePortalShowsTheDoctorsAssignedInTheDropDownMenu(String physician) {
		theActorInTheSpotlight().attemptsTo(AgreeTermsAndPolicies.afterLogin(), SelectPhysician.by(physician));
	}

	@Then("^The user can select the doctor (.*)$")
	public void theUserCanSelectTheDoctor(String physician) {
		theActorInTheSpotlight().attemptsTo(AgreeTermsAndPolicies.afterLogin(), SelectPhysician.by(physician));
	}

	@Then("^The portal shows the time and date in the header$")
	public void thePortalShowsTheTimeAndDateInTheHeader() {
		theActorInTheSpotlight().should(seeThat(TheShowsTimeAndDate.onPortal()));
	}

	@Then("^The portal shows the visual alert$")
	public void thePortalShowsTheVisualAlert() {
		theActorInTheSpotlight().attemptsTo(AgreeTermsAndPolicies.afterLogin());
		theActorInTheSpotlight().should(seeThat(IconNotification.inHeaderSection()));
	}

	@Then("^The Portal displays a Password Expiration notification$")
	public void thePortalDisplaysAPasswordExpirationNotification() {
		throw new PendingException();
	}

	@And("^Go to notifications for user (.+)$")
	public void goToNotificationForUser(String userName) {
		theActorInTheSpotlight().attemptsTo(AgreeTermsAndPolicies.afterLogin());
		theActorInTheSpotlight().attemptsTo(GoToAllNotificationUser.forUser());
	}

	@Then("^The Portal displays the message Description Notification:(.+)$")
	public void thePortalDisplaysThemessageDescriptionNotification(String messageNotification) {
		theActorInTheSpotlight().should(seeThat(ShowAllNotification.ofMessage(messageNotification)));
	}

	@Then("^The portal shows the close assignment button$")
	public void thePortalShowsTheCloseAssignmentButton() {
		theActorInTheSpotlight().attemptsTo(AgreeTermsAndPolicies.afterLogin());
		theActorInTheSpotlight().should(seeThat(LogOut.inSession()));
	}

	@Then("^The Portal displays the modules (.+)$")
	public void thePortalShowsTheAccessModes(String modul) {
		theActorInTheSpotlight().attemptsTo(AgreeTermsAndPolicies.afterLogin());
		String[] modules = modul.split(",");
		int index = 0;
		while (index < modules.length) {
			theActorInTheSpotlight().should(seeThat(SeeMenu.withName(modules[index])));
			index++;
		}
	}

	@Then("^The Portal displays the Home screen module$")
	public void thePortalDisplaysTheHomeScreenModule() {
		theActorInTheSpotlight().attemptsTo(AgreeTermsAndPolicies.afterLogin());
		theActorInTheSpotlight().should(seeThat(FirstView.homePage()));
	}

	@Then("^The Portal displays the image in the Carrousel News Slider$")
	public void thePortalShowsTheSlider() {
		theActorInTheSpotlight().attemptsTo(AgreeTermsAndPolicies.afterLogin());
		theActorInTheSpotlight().should(seeThat(FirstView.carruselImage()));
	}

	@Then("The Portal displays the message for Copyright")
	public void thePortalDisplaysTheMessageForCopyright() {
		theActorInTheSpotlight().attemptsTo(AgreeTermsAndPolicies.afterLogin());
		theActorInTheSpotlight().should(seeThat(FirstView.copyRight()));
	}

}