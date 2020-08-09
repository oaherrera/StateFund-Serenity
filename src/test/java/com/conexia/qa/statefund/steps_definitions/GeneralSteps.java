package com.conexia.qa.statefund.steps_definitions;

import static net.serenitybdd.screenplay.actors.OnStage.setTheStage;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

import java.util.List;

import com.conexia.qa.statefund.drivers.ChromeWebDriver;
import com.conexia.qa.statefund.drivers.OwnWebDriver;
import com.conexia.qa.statefund.interactions.EditRow;
import com.conexia.qa.statefund.models.ClaimAdministratorInformation;
import com.conexia.qa.statefund.models.CreateNewAccount;
import com.conexia.qa.statefund.models.CreateNewUser;
import com.conexia.qa.statefund.models.DocumentAttachment;
import com.conexia.qa.statefund.models.FieldsSavedDraft;
import com.conexia.qa.statefund.models.LegalFlag;
import com.conexia.qa.statefund.models.PhysicianInformation;
import com.conexia.qa.statefund.models.Selenium;
import com.conexia.qa.statefund.models.TreatmentDetails;
import com.conexia.qa.statefund.models.URTreatmentType;
import com.conexia.qa.statefund.models.UserAuthentication;
import com.conexia.qa.statefund.models.WorkerInformation;
import com.conexia.qa.statefund.tasks.SingIn;
import com.conexia.qa.statefund.utils.FilePath;
import com.conexia.qa.statefund.utils.Folder;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.Cast;

public class GeneralSteps {

	@Before
	public void before() {
		Folder folder = new Folder();
		folder.deleteDirectory(FilePath.downloadPath());
		UserAuthentication.emptyUserAuthenticationList();
		WorkerInformation.emptyWorkerInformationList();
		PhysicianInformation.emptyPhysicianInformationList();
		ClaimAdministratorInformation.emptyClaimAdministratorInformationList();
		CreateNewUser.emptyCreateNewUserList();
		LegalFlag.emptyLegalFlagList();
		DocumentAttachment.emptyDocumentAttachmentList();
		TreatmentDetails.emptyTreatmentDetailsList();
		CreateNewAccount.emptyCreateNewAccountList();
		FieldsSavedDraft.emptyfieldsSavedDraftList();
		URTreatmentType.emptyURTreatmentTypeList();

		setTheStage(Cast.ofStandardActors());
		theActorCalled(FilePath.getHostName());
		theActorInTheSpotlight().can(
				BrowseTheWeb.with(OwnWebDriver.withBrowser("chrome").setURL(Selenium.parameters().getProperty("url"))));
	}

	@After
	public void after(Scenario scenario) {
		OwnWebDriver.getDriver().quit();
		try {
			ChromeWebDriver.getDriver().quit();
		} catch (Exception e) {
//			System.out.println("Quit Additional Driver " + e.getMessage());
		}
	}

	@Given("^I am authenticated in the aplication$")
	public void iAmAuthenticatedInTheAplication(List<UserAuthentication> userAutentication) {
		UserAuthentication.saveUserAuthenticationList(userAutentication.get(0));
		theActorInTheSpotlight().attemptsTo(SingIn.withTheUser(UserAuthentication.readData(0).getUserName())
				.andPassword(UserAuthentication.readData(0).getPassword()));
	}

	@And("^Select the option edit of Row (.+)$")
	public void selectTheOptionEditOfRow(String rowNumber) {
		theActorInTheSpotlight().attemptsTo(EditRow.number(rowNumber));
	}

}