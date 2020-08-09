package com.conexia.qa.statefund.steps_definitions;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

import java.util.List;

import com.conexia.qa.sql_developer.interactions.GetDataUserDB;
import com.conexia.qa.sql_developer.models.User;
import com.conexia.qa.sql_developer.questions.CountProviderForUser;
import com.conexia.qa.sql_developer.questions.TheUserAsignedUniqueProvider;
import com.conexia.qa.statefund.interactions.CancelAndConfirmation;
import com.conexia.qa.statefund.interactions.ClickOn;
import com.conexia.qa.statefund.interactions.Sleep;
import com.conexia.qa.statefund.interactions.Swipe;
import com.conexia.qa.statefund.interactions.WaitLoading;
import com.conexia.qa.statefund.models.CreateNewUser;
import com.conexia.qa.statefund.questions.SeeDisplaysAlertRequiredFields;
import com.conexia.qa.statefund.questions.ShowCreateUser;
import com.conexia.qa.statefund.questions.ShowFormEdit;
import com.conexia.qa.statefund.questions.ShowTheMessageInNewUser;
import com.conexia.qa.statefund.questions.TheFieldsAreDisable;
import com.conexia.qa.statefund.questions.TheMessageInvalidEmail;
import com.conexia.qa.statefund.questions.ThePortalDisplays;
import com.conexia.qa.statefund.questions.TheSearchedEmailIsShown;
import com.conexia.qa.statefund.questions.TheSearchedFirstNameIsShown;
import com.conexia.qa.statefund.questions.TheSearchedLastNameIsShown;
import com.conexia.qa.statefund.questions.TheSearchedMiddleInitialIsShown;
import com.conexia.qa.statefund.questions.TheSearchedUserIsShown;
import com.conexia.qa.statefund.tasks.ClearMandatoryFields;
import com.conexia.qa.statefund.tasks.EditUser;
import com.conexia.qa.statefund.tasks.FillInformationNewUser;
import com.conexia.qa.statefund.tasks.FillUserField;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BR5PortalAdminScreenUserMngmtSteps {

	@When("^looking for the user (.*)$")
	public void lookingForTheUser(String user) {
		theActorInTheSpotlight().attemptsTo(FillUserField.withUser(user));
	}

	@Then("^the portal must show the module the result of the user search$")
	public void thePortalMustShowTheModuleTheResultOfTheUserSearch() {
		theActorInTheSpotlight().should(seeThat(TheSearchedUserIsShown.onPortal()));
	}

	@When("^looking for the mail (.*)$")
	public void lookingForTheMail(String mail) {
		theActorInTheSpotlight().attemptsTo(FillUserField.withMail(mail));
	}

	@Then("^the portal must show the module the result of the email search$")
	public void thePortalMustShowTheModuleTheResultOfTheEmailSearch() {
		theActorInTheSpotlight().should(seeThat(TheSearchedEmailIsShown.onPortal()));
	}

	@When("^looking for the FirstName (.*)$")
	public void LookingForTheFirstName(String FirstName) {
		theActorInTheSpotlight().attemptsTo(FillUserField.withFirstName(FirstName));
	}

	@Then("^The portal must show one or more search matches\\.$")
	public void thePortalMustShowOneOrMoreSearchMatches() {
		theActorInTheSpotlight().should(seeThat(TheSearchedFirstNameIsShown.onPortal()));
	}

	@When("^looking for the middleInitial (.*)$")
	public void LookingForThemiddleInitial(String middleInitial) {
		theActorInTheSpotlight().attemptsTo(FillUserField.withMiddleInitial(middleInitial));
	}

	@Then("^The portal must show search matches\\.$")
	public void thePortalMustShowSearchMatches() {
		theActorInTheSpotlight().should(seeThat(TheSearchedMiddleInitialIsShown.onPortal()));
	}

	@When("^looking for the lastName (.*)$")
	public void LookingForTheLastName(String lastName) {
		theActorInTheSpotlight().attemptsTo(FillUserField.withLastName(lastName));
	}

	@Then("^The portal must show search matches related to the last name\\.$")
	public void thePortalMustShowSearchMatchesRelatedToTheLastName() {
		theActorInTheSpotlight().should(seeThat(TheSearchedLastNameIsShown.onPortal()));
	}

	@Then("The Portal displays the Modify user screen")
	public void thePortalDisplaysTheModifyUserScreen() {
		theActorInTheSpotlight().should(seeThat(ShowFormEdit.forUser()));
	}

	@And("^Edit user with Start Date (.+) and End Date (.+)$")
	public void editUserWithStartDateAndEndDate(String startDate, String endDate) {
		theActorInTheSpotlight().attemptsTo(EditUser.withFiels(startDate, endDate));
		theActorInTheSpotlight().attemptsTo(ClickOn.buttonSave());
	}

	@And("^Edit user access Level (.+)$")
	public void editUserAccessLevel(String accessLeven) {
		theActorInTheSpotlight().attemptsTo(EditUser.accessLevel(accessLeven));
		theActorInTheSpotlight().attemptsTo(ClickOn.buttonSave());
	}

	@And("^Edit user the workplaces (.+)$")
	public void editUsertheworkplaces(String workplaces) {
		theActorInTheSpotlight().attemptsTo(EditUser.workplace(workplaces));
		theActorInTheSpotlight().attemptsTo(ClickOn.buttonSave());
	}

	@And("^Edit user the Physicians related to a User with Physician (.+)$")
	public void editUserThePhysiciansRelatedToAUser(String physician) {
		theActorInTheSpotlight().attemptsTo(EditUser.physician(physician));
		theActorInTheSpotlight().attemptsTo(ClickOn.buttonSave());
	}

	@And("^Edit user the Active mark$")
	public void editUserTheActiveMark() {
		theActorInTheSpotlight().attemptsTo(EditUser.activeMark());
		theActorInTheSpotlight().attemptsTo(ClickOn.buttonSave());
	}

	@And("^Cancel Edit user$")
	public void cancelEditUser() {
		theActorInTheSpotlight().attemptsTo(CancelAndConfirmation.withoutSaving(true));
	}

	// 6
	@Then("^The Portal displays a confirmation message: (.+)$")
	public void thePortalMustDisplayTheInformationalMessage(String message) {
		// TODO: REPORTAR ESTE DEFECTO NO MUESTRA MENSAJE
	}

	@Then("^The portal must display the informational message The User email is invalid\\. Please enter a valid email addres$")
	public void thePortalMustDisplayTheInformationalMessageTheUserEmailIsInvalidPleaseEnterAValidEmailAddres() {
		theActorInTheSpotlight().should(seeThat(TheMessageInvalidEmail.onPortal()));
	}

	@When("^looking for the fields First Name, Middle initial or Last Name$")
	public void lookingForTheFieldsFirstNameMiddleInitialOrLastName(List<CreateNewUser> informationUserData) {
		CreateNewUser.saveCreateNewUserList(informationUserData.get(0));
		theActorInTheSpotlight()
				.attemptsTo(FillUserField.withFirstNameMiddleInitialLastName(CreateNewUser.readData(0).getFirstName(),
						CreateNewUser.readData(0).getMiddleInitial(), CreateNewUser.readData(0).getLastName()));
	}

	@Then("^The fields: First Name, Last Name, User Name, Email, Telephone and Mobile are disable$")
	public void theFieldsAreDisable() {
		theActorInTheSpotlight().should(seeThat(TheFieldsAreDisable.inFormEditUser()));
	}

	@Then("^The fields: Acces Level, Workplace, Physcian, Active and Dates are disable$")
	public void TheFieldsOtherIsDisable() {
		theActorInTheSpotlight().should(seeThat(TheFieldsAreDisable.inFormEditUserAdmin()));
	}

	@And("Clear mandatory fields in edit form")
	public void cleanMandatoryFields() {
		theActorInTheSpotlight().attemptsTo(ClearMandatoryFields.inEditUser());
		theActorInTheSpotlight().attemptsTo(EditUser.accessLevel("Select"));
		theActorInTheSpotlight().attemptsTo(ClickOn.buttonSave());
		theActorInTheSpotlight().attemptsTo(Sleep.by(1000));
	}

	@Then("The portal displays an alert message: (.+) at edit user")
	public void displaysAlertMessageRequiredFieldIsEmptyEdit(String message) {
		theActorInTheSpotlight().should(seeThat(SeeDisplaysAlertRequiredFields.inEditUser(message)));
	}

	@Then("The portal displays an alert message: (.+), at new user")
	public void displaysAlertMessageRequiredFieldIsEmptyNew(String message) {
		theActorInTheSpotlight().should(seeThat(SeeDisplaysAlertRequiredFields.inNewUser(message)));
	}

	@When("^Admin User fills all the form the information$")
	public void adminUserFillsAllTheFormTheInformation(List<CreateNewUser> createNewUser) {
		CreateNewUser.saveCreateNewUserList(createNewUser.get(0));
		theActorInTheSpotlight().attemptsTo(FillInformationNewUser.fields());
		theActorInTheSpotlight().attemptsTo(ClickOn.buttonSave(), WaitLoading.page());
	}

	@When("^Admin User fills all the form the information and Cancel process$")
	public void adminUserFillsAllTheFormTheInformationAndCancel(List<CreateNewUser> createNewUser) {
		CreateNewUser.saveCreateNewUserList(createNewUser.get(0));
		theActorInTheSpotlight().attemptsTo(FillInformationNewUser.fields());
		theActorInTheSpotlight().attemptsTo(ClickOn.buttonCancel(), WaitLoading.page(), ClickOn.buttonConfirmateYes());
	}

	@When("^Selects the Save button to confirm the transaction$")
	public void selectsTheSaveButton() {
		theActorInTheSpotlight().attemptsTo(Swipe.vertical(500));
		theActorInTheSpotlight().attemptsTo(ClickOn.buttonSave(), WaitLoading.page());
	}

	@Then("^The Portal displays the message: (.+)$")
	public void thePortalDisplaysTheMessage(String message) {
		theActorInTheSpotlight().should(seeThat(ThePortalDisplays.theMessages(message)));
		theActorInTheSpotlight().attemptsTo(ClickOn.buttonAccept());
	}

	@Then("^The Portal highligths (.+) field with the message:(.+)$")
	public void thePortalHighligthsStartDateFieldWithTheMessage(String field, String message) {
		theActorInTheSpotlight().should(seeThat(ShowTheMessageInNewUser.forField(message, field)));
	}

	@Then("The Portal must redirect to the Create User Page")
	public void thePortalMustRedirectToTheCreateUserPage() {
		theActorInTheSpotlight().should(seeThat(ShowCreateUser.inThePortal()));
	}

	@Then("^Displays the Portal users (.+) founded with the same assigned provider IDs$")
	public void displaysThePortalUsersFoundedWithTheSameAssignedProviderIDs(String userName) {
		theActorInTheSpotlight().attemptsTo(GetDataUserDB.forFilterUsername(userName));
		theActorInTheSpotlight().attemptsTo(CountProviderForUser.inDataBase(User.getId()));
		theActorInTheSpotlight().should(seeThat(TheUserAsignedUniqueProvider.inDataBase()));
	}

}