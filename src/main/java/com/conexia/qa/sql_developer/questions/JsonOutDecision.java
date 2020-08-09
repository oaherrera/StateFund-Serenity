package com.conexia.qa.sql_developer.questions;

import com.conexia.qa.sql_developer.models.QueryResponse;
import com.jayway.jsonpath.JsonPath;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class JsonOutDecision implements Question<String> {

	@Override
	public String answeredBy(Actor actor) {
		return JsonPath.read(QueryResponse.getJsonString(), "$.treatment[0].decision");
	}

	public static JsonOutDecision is() {
		return new JsonOutDecision();
	}

}