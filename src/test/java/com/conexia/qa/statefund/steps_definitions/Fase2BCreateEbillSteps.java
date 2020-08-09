package com.conexia.qa.statefund.steps_definitions;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

import com.conexia.qa.statefund.interactions.AgreeTermsAndPolicies;
import com.conexia.qa.statefund.interactions.RFASearch;
import com.conexia.qa.statefund.interactions.SelectEbillType;
import com.conexia.qa.statefund.questions.TheEbillNumberExist;
import com.conexia.qa.statefund.questions.TheEbillNumberIsCreate;
import com.conexia.qa.statefund.tasks.Fill1450PatientInsuredCondition;
import com.conexia.qa.statefund.tasks.Fill1450PatientInsuredInformation;
import com.conexia.qa.statefund.tasks.Fill1450ProcedureSelection;
import com.conexia.qa.statefund.tasks.Fill1450ProviderInformation;
import com.conexia.qa.statefund.tasks.Fill1450RequestedServices;
import com.conexia.qa.statefund.tasks.Fill1500PatientInsuredCondition;
import com.conexia.qa.statefund.tasks.Fill1500PatientInsuredInformation;
import com.conexia.qa.statefund.tasks.Fill1500ProcedureSelection;
import com.conexia.qa.statefund.tasks.Fill1500ProviderInformation;
import com.conexia.qa.statefund.tasks.Fill1500RequestedServices;
import com.conexia.qa.statefund.tasks.FillADAPatientInsuredInformation;
import com.conexia.qa.statefund.tasks.FillADAProcedureSelection;
import com.conexia.qa.statefund.tasks.FillADAProviderInformation;
import com.conexia.qa.statefund.tasks.FillADARequestedServices;
import com.conexia.qa.statefund.tasks.FillADATreatmentInformation;
import com.conexia.qa.statefund.tasks.GoToRFAHistory;
import com.conexia.qa.statefund.tasks.SummaryADA2006;
import com.conexia.qa.statefund.tasks.SummaryCMS1450;
import com.conexia.qa.statefund.tasks.SummaryCMS1500;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.GivenWhenThen;

public class Fase2BCreateEbillSteps {

	@When("^I create a 1500 Ebill with RFA ID (.*)$")
	public void iCreateA1500EbillWithRFA(String rfaID) {
		theActorInTheSpotlight().attemptsTo(AgreeTermsAndPolicies.afterLogin(), RFASearch.byRFAid(rfaID),
				SelectEbillType.cms1500(), Fill1500ProcedureSelection.form(), Fill1500PatientInsuredInformation.form(),
				Fill1500PatientInsuredCondition.form(), Fill1500RequestedServices.form(),
				Fill1500ProviderInformation.form(), SummaryCMS1500.form());
	}

	@When("^I create a 1450 Ebill with RFA ID (.*)$")
	public void iCreateA1450EbillWithRFA(String rfaID) {
		theActorInTheSpotlight().attemptsTo(AgreeTermsAndPolicies.afterLogin(), RFASearch.byRFAid(rfaID),
				SelectEbillType.cms1450(), Fill1450ProcedureSelection.form(), Fill1450PatientInsuredInformation.form(),
				Fill1450PatientInsuredCondition.form(), Fill1450RequestedServices.form(),
				Fill1450ProviderInformation.form(), SummaryCMS1450.form());
	}

	@When("^I create an ADA Ebill with RFA ID (.*)$")
	public void iCreateAnADAEbillWithRFA(String rfaID) {
		theActorInTheSpotlight().attemptsTo(AgreeTermsAndPolicies.afterLogin(), RFASearch.byRFAid(rfaID),
				SelectEbillType.ada2006(), FillADAProcedureSelection.form(), FillADAPatientInsuredInformation.form(),
				FillADATreatmentInformation.form(), FillADARequestedServices.form(), FillADAProviderInformation.form(),
				SummaryADA2006.form());
	}

	@Then("^The Ebill number is displayed$")
	public void theEbillNumberIsDisplayed() {
		theActorInTheSpotlight().should(seeThat(TheEbillNumberIsCreate.correctly()));
	}

	@Then("^The history shows the Ebill$")
	public void theHistoryShowsTheEbill() {
		theActorInTheSpotlight().attemptsTo(GoToRFAHistory.fromEbill());
		theActorInTheSpotlight().should(GivenWhenThen.seeThat(TheEbillNumberExist.onHistory()));
	}

}