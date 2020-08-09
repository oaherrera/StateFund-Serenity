package com.conexia.qa.sql_developer.models;

public class ClaimType {

	private static String id;
	private static String description;

	public static String getId() {
		return id;
	}

	public static void setId(String id) {
		ClaimType.id = id;
	}

	public static String getDescription() {
		return description;
	}

	public static void setDescription(String description) {
		ClaimType.description = description;
	}

}