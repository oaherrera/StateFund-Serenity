package com.conexia.qa.sql_developer.models;

public class QueryResponse {

	private static String jsonString;
	private static String provisionalDecision;
	private static String provisionalSourceOfDecision;
	private static String queryResponse;

	public static String getJsonString() {
		return jsonString;
	}

	public static void setJsonString(String jsonString) {
		QueryResponse.jsonString = jsonString;
	}

	public static String getProvisionalDecision() {
		return provisionalDecision;
	}

	public static void setProvisionalDecision(String provisionalDecision) {
		QueryResponse.provisionalDecision = provisionalDecision;
	}

	public static String getProvisionalSourceOfDecision() {
		return provisionalSourceOfDecision;
	}

	public static void setProvisionalSourceOfDecision(String provisionalSourceOfDecision) {
		QueryResponse.provisionalSourceOfDecision = provisionalSourceOfDecision;
	}

	public static String getQueryResponse() {
		return queryResponse;
	}

	public static void setQueryResponse(String queryResponse) {
		QueryResponse.queryResponse = queryResponse;
	}

}