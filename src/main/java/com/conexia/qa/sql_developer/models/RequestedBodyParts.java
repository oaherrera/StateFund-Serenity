package com.conexia.qa.sql_developer.models;

public class RequestedBodyParts {

	private static String description;
	private static String decision;

	public static String getDescription() {
		return description;
	}

	public static void setDescription(String description) {
		RequestedBodyParts.description = description;
	}

	public static String getDecision() {
		return decision;
	}

	public static void setDecision(String decision) {
		RequestedBodyParts.decision = decision;
	}

}