package com.conexia.qa.sql_developer.questions;

import com.conexia.qa.sql_developer.models.QueryResponse;
import com.conexia.qa.statefund.utils.FormatFunctions;
import com.jayway.jsonpath.JsonPath;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class JsonOutThePeriodFequencyAndQuantity implements Question<String> {

	@Override
	public String answeredBy(Actor actor) {
		return FormatFunctions.periodID(JsonPath.read(QueryResponse.getJsonString(), "$.treatment[0].period")) + " - "
				+ JsonPath.read(QueryResponse.getJsonString(), "$.treatment[0].frequency") + " - "
				+ JsonPath.read(QueryResponse.getJsonString(), "$.treatment[0].quantity");
	}

	public static JsonOutThePeriodFequencyAndQuantity are() {
		return new JsonOutThePeriodFequencyAndQuantity();
	}

}