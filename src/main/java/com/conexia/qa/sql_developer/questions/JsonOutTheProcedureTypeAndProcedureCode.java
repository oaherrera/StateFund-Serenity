package com.conexia.qa.sql_developer.questions;

import com.conexia.qa.sql_developer.models.QueryResponse;
import com.jayway.jsonpath.JsonPath;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class JsonOutTheProcedureTypeAndProcedureCode implements Question<String> {

	@Override
	public String answeredBy(Actor actor) {
		return JsonPath.read(QueryResponse.getJsonString(), "$.treatment[0].procedureType").toString() + " - "
				+ JsonPath.read(QueryResponse.getJsonString(), "$.treatment[0].procedureCode").toString();
	}

	public static JsonOutTheProcedureTypeAndProcedureCode are() {
		return new JsonOutTheProcedureTypeAndProcedureCode();
	}

}