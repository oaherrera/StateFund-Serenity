package com.conexia.qa.statefund.models;

public class ProcedureType {

	private static String id;
	private static String description;

	public static String getId() {
		return id;
	}

	public static void setId(String id) {
		ProcedureType.id = id;
	}

	public static String getDescription() {
		return description;
	}

	public static void setDescription(String description) {
		ProcedureType.description = description;
	}

}