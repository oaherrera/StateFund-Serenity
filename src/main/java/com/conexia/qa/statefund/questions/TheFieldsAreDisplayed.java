package com.conexia.qa.statefund.questions;

import java.util.ArrayList;
import java.util.List;

import com.conexia.qa.statefund.interactions.RFAType;
import com.conexia.qa.statefund.interactions.Swipe;
import com.conexia.qa.statefund.interactions.WaitLoading;
import com.conexia.qa.statefund.models.PhysicianInformation;
import com.conexia.qa.statefund.models.WorkerInformation;
import com.conexia.qa.statefund.tasks.FillPhysicianInformation;
import com.conexia.qa.statefund.tasks.FillTheTreatmentDetails;
import com.conexia.qa.statefund.user_interfaces.ClaimAdministratorInformationPage;
import com.conexia.qa.statefund.user_interfaces.CommonPage;
import com.conexia.qa.statefund.user_interfaces.DocumentAttachmentPage;
import com.conexia.qa.statefund.user_interfaces.RequestForAuthorizationPage;
import com.conexia.qa.statefund.user_interfaces.RequestingPhysicianInformationPage;
import com.conexia.qa.statefund.user_interfaces.TreatmentDetailsPage;
import com.conexia.qa.statefund.user_interfaces.WorkersInformationPage;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;

public class TheFieldsAreDisplayed implements Question<Boolean> {

	@Override
	public Boolean answeredBy(Actor actor) {
		List<Boolean> validations = new ArrayList<Boolean>();
		boolean finalState = false;
		actor.attemptsTo(
				Scroll.to(RequestForAuthorizationPage.CLAIM_NUMBER.of(WorkerInformation.readData(0).getClaimNumber())),
				Swipe.vertical(-200));
		if (WorkersInformationPage.RFA_TYPE_LABEL.resolveFor(actor).isDisplayed()) {
			actor.attemptsTo(Scroll.to(WorkersInformationPage.RFA_TYPE_LABEL), Swipe.vertical(-100),
					RFAType.option(PhysicianInformation.readData(0).getRfaType()));
			Serenity.takeScreenshot();
			validations.add(true);
		}
		actor.attemptsTo(Scroll.to(CommonPage.SAVE_DRAFT));
		if (RequestingPhysicianInformationPage.PHYSICIAN_NAME.resolveFor(actor).isDisplayed()
				&& RequestingPhysicianInformationPage.CONTACT_NAME.resolveFor(actor).isDisplayed()
				&& RequestingPhysicianInformationPage.CITY.resolveFor(actor).isDisplayed()
				&& RequestingPhysicianInformationPage.ZIP_CODE.resolveFor(actor).isDisplayed()
				&& RequestingPhysicianInformationPage.SPECIALITY.resolveFor(actor).isDisplayed()
				&& RequestingPhysicianInformationPage.EMAIL_ADDRESS.resolveFor(actor).isDisplayed()
				&& RequestingPhysicianInformationPage.PRACTICE_NAME.resolveFor(actor).isDisplayed()
				&& RequestingPhysicianInformationPage.ADDRESS.resolveFor(actor).isDisplayed()
				&& RequestingPhysicianInformationPage.STATE.resolveFor(actor).isDisplayed()
				&& RequestingPhysicianInformationPage.TELEPHONE.resolveFor(actor).isDisplayed()
				&& RequestingPhysicianInformationPage.FAX_NUMBER.resolveFor(actor).isDisplayed()
				&& RequestingPhysicianInformationPage.NPI_NUMBER.resolveFor(actor).isDisplayed()) {
			Serenity.takeScreenshot();
			validations.add(true);
		}
		actor.attemptsTo(FillPhysicianInformation.mandatory(PhysicianInformation.readData(0).getPhysicianName()),
				WaitLoading.page(), Scroll.to(CommonPage.SAVE_DRAFT));
		if (ClaimAdministratorInformationPage.CLAIM_ADMINISTRATOR_INFORMATION.resolveFor(actor).isDisplayed()
				&& ClaimAdministratorInformationPage.COMPANY_NAME.resolveFor(actor).isDisplayed()
				&& ClaimAdministratorInformationPage.ADDRESS.resolveFor(actor).isDisplayed()
				&& ClaimAdministratorInformationPage.CITY.resolveFor(actor).isDisplayed()
				&& ClaimAdministratorInformationPage.TELEPHONE.resolveFor(actor).isDisplayed()
				&& ClaimAdministratorInformationPage.EMAIL_ADDRESS.resolveFor(actor).isDisplayed()
				&& ClaimAdministratorInformationPage.CONTACT_NAME.resolveFor(actor).isDisplayed()
				&& ClaimAdministratorInformationPage.STATE.resolveFor(actor).isDisplayed()
				&& ClaimAdministratorInformationPage.ZIP_CODE.resolveFor(actor).isDisplayed()
				&& ClaimAdministratorInformationPage.FAX_NUMBER.resolveFor(actor).isDisplayed()) {
			Serenity.takeScreenshot();
			validations.add(true);
		}
		actor.attemptsTo(Click.on(CommonPage.NEXT), WaitLoading.page(), Swipe.vertical(-500),
				Scroll.to(TreatmentDetailsPage.TREATMENT_DETAILS));
		if (TreatmentDetailsPage.TREATMENT_DETAILS.resolveFor(actor).isDisplayed()
				&& TreatmentDetailsPage.DIAGNOSIS_CODE_DESC.resolveFor(actor).isDisplayed()
				&& TreatmentDetailsPage.PROCEDURE_TYPE.resolveFor(actor).isDisplayed()
				&& TreatmentDetailsPage.RELATED_BODY_PART.resolveFor(actor).isDisplayed()
				&& TreatmentDetailsPage.UR_TREATMENT_TYPE_SELECT.resolveFor(actor).isDisplayed()
				&& TreatmentDetailsPage.PROCEDURE_CODE_DESC.resolveFor(actor).isDisplayed()
				&& TreatmentDetailsPage.RELATED_DIAGNOSIS.resolveFor(actor).isDisplayed()
				&& TreatmentDetailsPage.ADDITIONAL_COMMENTS.resolveFor(actor).isDisplayed()) {
			Serenity.takeScreenshot();
			actor.attemptsTo(Scroll.to(CommonPage.SAVE_DRAFT), Swipe.vertical(-500), FillTheTreatmentDetails.fields());
			validations.add(true);
		}
		actor.attemptsTo(Scroll.to(CommonPage.SUBMIT));
		if (DocumentAttachmentPage.DOCUMENT_TYPE.resolveFor(actor).isDisplayed()
				&& DocumentAttachmentPage.ATTACH.resolveFor(actor).isDisplayed()
				&& DocumentAttachmentPage.PATH_FILE.resolveFor(actor).isDisplayed()) {
			Serenity.takeScreenshot();
			validations.add(true);
		}
		actor.attemptsTo(Click.on(CommonPage.CANCEL), WaitLoading.page());
		Serenity.takeScreenshot();
		for (int i = 0; i < validations.size(); i++) {
			if (validations.get(i).equals(false)) {
				finalState = false;
				break;
			} else if (validations.get(i).equals(true)) {
				finalState = true;
				continue;
			}
		}
		return finalState;
	}

	public static TheFieldsAreDisplayed fromPortalRFAForm() {
		return new TheFieldsAreDisplayed();
	}

}