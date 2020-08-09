package com.conexia.qa.statefund.questions;

import static com.conexia.qa.statefund.models.FieldsSavedDraft.readData;
import static com.conexia.qa.statefund.user_interfaces.SavedDraftForClaimPage.CLAIM_NUMBER;
import static com.conexia.qa.statefund.user_interfaces.SavedDraftForClaimPage.CLAIM_NUMBER_VALUE;
import static com.conexia.qa.statefund.user_interfaces.SavedDraftForClaimPage.DATE_OF_INJURY;
import static com.conexia.qa.statefund.user_interfaces.SavedDraftForClaimPage.DATE_OF_INJURY_VALUE;
import static com.conexia.qa.statefund.user_interfaces.SavedDraftForClaimPage.INJURED_WORKER;
import static com.conexia.qa.statefund.user_interfaces.SavedDraftForClaimPage.INJURED_WORKER_VALUE;
import static com.conexia.qa.statefund.user_interfaces.SavedDraftForClaimPage.SAVED_DATE;
import static com.conexia.qa.statefund.user_interfaces.SavedDraftForClaimPage.SAVED_DATE_VALUE;

import com.conexia.qa.sql_developer.interactions.SearchDraftSavedDB;
import com.conexia.qa.statefund.models.FieldsSavedDraft;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

/**
 * @author ChristianCamiloSchottlaender
 */
public class InSavedDraftIsDisplayed implements Question<Boolean> {

	private String claimNumber;
	private String createdBy;
	private String claimNumberField;
	private String injuredWorderField;
	private String dateOfInjuryField;
	private String savedDateField;
	private String orderBy;

	public InSavedDraftIsDisplayed(String claimNumber, String createdBy, String claimNumberField,
			String injuredWorderField, String dateOfInjuryField, String savedDateField, String orderBy) {
		this.claimNumber = claimNumber;
		this.createdBy = createdBy;
		this.claimNumberField = claimNumberField;
		this.injuredWorderField = injuredWorderField;
		this.dateOfInjuryField = dateOfInjuryField;
		this.savedDateField = savedDateField;
		this.orderBy = orderBy;
	}

	@Override
	public Boolean answeredBy(Actor actor) {
		// Validate Fields
		if (!CLAIM_NUMBER.of(claimNumberField).resolveFor(actor).isVisible()) {
			System.out.println("claimNumber - false");
			return false;
		}
		if (!INJURED_WORKER.of(injuredWorderField).resolveFor(actor).isVisible()) {
			System.out.println("injuredWorder - false");
			return false;
		}
		if (!DATE_OF_INJURY.of(dateOfInjuryField).resolveFor(actor).isVisible()) {
			System.out.println("dateOfInjury- false");
			return false;
		}
		if (!SAVED_DATE.of(savedDateField).resolveFor(actor).isVisible()) {
			System.out.println("savedDate - false");
			return false;
		}
		// Validate values of results
		int indice = 0;
		actor.attemptsTo(SearchDraftSavedDB.forFilds(createdBy, claimNumber, orderBy));
		while (indice < FieldsSavedDraft.fieldsSavedDraftInformation.size()) {
			if (!CLAIM_NUMBER_VALUE.of("" + (indice + 1), readData(indice).getClaimNumber()).resolveFor(actor)
					.isEnabled()) {
				System.out.println("claimNumber Value- false");
				return false;
			}
			if (!INJURED_WORKER_VALUE.of("" + (indice + 1), readData(indice).getInjuredWorker()).resolveFor(actor)
					.isEnabled()) {
				System.out.println("injuredWorder Value- false");
				return false;
			}
			if (!DATE_OF_INJURY_VALUE.of("" + (indice + 1), readData(indice).getDateOfInjury()).resolveFor(actor)
					.isEnabled()) {
				System.out.println("dateOfInjury Value- false");
				return false;
			}
			if (!SAVED_DATE_VALUE.of("" + (indice + 1), readData(indice).getSavedDate()).resolveFor(actor)
					.isEnabled()) {
				System.out.println("savedDate Value- false");
				return false;
			}
			indice = indice + 1;
		}
		return true;
	}

	public static InSavedDraftIsDisplayed fields(String claimNumber, String createdBy, String claimNumberField,
			String injuredWorderField, String dateOfInjuryField, String savedDateField, String orderBy) {
		return new InSavedDraftIsDisplayed(claimNumber, createdBy, claimNumberField, injuredWorderField,
				dateOfInjuryField, savedDateField, orderBy);
	}

}