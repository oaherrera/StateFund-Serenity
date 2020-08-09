package com.conexia.qa.statefund.questions;

import static com.conexia.qa.statefund.models.FieldsSavedDraft.fieldsSavedDraftInformation;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

/**
 * @author ChristianCamiloSchottlaender
 */
public class DraftIsDelete implements Question<Boolean> {

	public DraftIsDelete() {
	}

	@Override
	public Boolean answeredBy(Actor actor) {
		int countRpws = fieldsSavedDraftInformation.size();
		if (countRpws == 0) {
			return true;
		} else {
			return false;
		}
	}

	public static DraftIsDelete inDataBase() {
		return new DraftIsDelete();
	}

}