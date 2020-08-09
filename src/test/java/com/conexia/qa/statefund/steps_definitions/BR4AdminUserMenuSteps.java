package com.conexia.qa.statefund.steps_definitions;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

import com.conexia.qa.statefund.questions.TheCreateNewUserSectionIsDisable;
import com.conexia.qa.statefund.questions.TheCreateNewUserSectionIsEnable;
import com.conexia.qa.statefund.questions.TheInboxSectionIsDisable;
import com.conexia.qa.statefund.questions.TheInboxSectionIsEnable;
import com.conexia.qa.statefund.questions.TheInboxUserSectionIsDisable;
import com.conexia.qa.statefund.questions.TheModuleUserManagementIsEnable;
import com.conexia.qa.statefund.questions.TheSearchUserSectionIsDisable;
import com.conexia.qa.statefund.questions.TheSearchUserSectionIsEnable;

import cucumber.api.java.en.Then;

public class BR4AdminUserMenuSteps {

	@Then("^the portal must show the User Management module$")
	public void thePortalMustShowUserManagementModule() {
		theActorInTheSpotlight().should(seeThat(TheModuleUserManagementIsEnable.onPortal()));
	}

	@Then("^the portal must not show the user management module$")
	public void thePortalMustNotShowTheUserManagementModule() {
		theActorInTheSpotlight().should(seeThat(TheInboxSectionIsDisable.onPortal()));
	}

	@Then("^the portal must show the inbox option in the management module$")
	public void thePortalMustShowTheInboxOptionInTheManagementModule() {
		theActorInTheSpotlight().should(seeThat(TheInboxSectionIsEnable.onPortal()));
	}

	@Then("^the portal must show create new users option in the management module$")
	public void thePortalMustShowCreateNewUsersOptionInTheManagementModule() {
		theActorInTheSpotlight().should(seeThat(TheCreateNewUserSectionIsEnable.onPortal()));
	}

	@Then("^the portal should show option search users in the module management$")
	public void thePortalShouldShowOptionSearchUsersInTheModuleManagement() {
		theActorInTheSpotlight().should(seeThat(TheSearchUserSectionIsEnable.onPortal()));
	}

	@Then("^the portal must not show the create user option in the management module$")
	public void thePortalMustNotShowTheCreateUserOption() {
		theActorInTheSpotlight().should(seeThat(TheCreateNewUserSectionIsDisable.onPortal()));
	}

	@Then("^the portal must not show the search user option in the management module$")
	public void thePortalMustNotShowTheSearchUserOption() {
		theActorInTheSpotlight().should(seeThat(TheSearchUserSectionIsDisable.onPortal()));
	}

	@Then("^the portal must not show the inbox user option in the management module$")
	public void thePortalMustNotShowTheinboxUserOption() {
		theActorInTheSpotlight().should(seeThat(TheInboxUserSectionIsDisable.onPortal()));
	}

}