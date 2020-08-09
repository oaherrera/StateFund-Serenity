package com.conexia.qa.statefund.questions;

import com.conexia.qa.statefund.models.WorkerInformation;
import com.conexia.qa.statefund.user_interfaces.ClaimDetailsPage;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class TheClaimInformation implements Question<String> {

	private String numberClaim;
	private String workerName;
	private String dateOfBirth;
	private String dateOfInjury;
	private String employerName;
//	private String rfaID;

	@Override
	public String answeredBy(Actor actor) {
		numberClaim = Text.of(ClaimDetailsPage.CLAIM_NUMBER.of(WorkerInformation.readData(0).getClaimNumber()))
				.viewedBy(actor).asString().replace("Claim Details - Claim Number: ", "");
		workerName = Text.of(ClaimDetailsPage.INJURED_WORKER_NAME).viewedBy(actor).asString();
		dateOfBirth = Text.of(ClaimDetailsPage.DATE_OF_BIRTH).viewedBy(actor).asString();
		dateOfInjury = Text.of(ClaimDetailsPage.DATE_OF_INJURY).viewedBy(actor).asString();
		employerName = Text.of(ClaimDetailsPage.EMPLOYER_NAME).viewedBy(actor).asString();
//		rfaID = Text.of(ClaimDetailsPage.RFA_ID.of(WorkerInformation.readData(0).getRfaType())).viewedBy(actor)
//				.asString();
		Serenity.takeScreenshot();
		return numberClaim + " - " + workerName + " - " + dateOfBirth + " - " + dateOfInjury + " - " + employerName;
//				+ " - " + rfaID;
	}

	public static TheClaimInformation is() {
		return new TheClaimInformation();
	}

}