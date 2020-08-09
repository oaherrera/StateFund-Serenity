package com.conexia.qa.sql_developer.questions;

import com.conexia.qa.sql_developer.interactions.JsonOutDB;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class TheJsonOut implements Question<String> {

	private String rfaID;

	public TheJsonOut(String rfaID) {
		this.rfaID = rfaID;
	}

	@Override
	public String answeredBy(Actor actor) {
		actor.attemptsTo(JsonOutDB.ofClaimId(rfaID));
		return actor.gaveAsThe("test_uno").toString();
	}

	public static TheJsonOut ofClaimId(String rfaID) {
		return new TheJsonOut(rfaID);
	}

}