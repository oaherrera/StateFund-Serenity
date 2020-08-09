package com.conexia.qa.statefund.models;

import java.util.ArrayList;
import java.util.List;

public class URTreatmentType {

	private String description;

	public static List<String> URTreatmentTypeData = new ArrayList<>();

	public static void saveURTreatmentTypeList(String URTreatmentType) {
		URTreatmentTypeData.add(URTreatmentType);
	}

	public static String readData(int index) {
		return URTreatmentTypeData.get(index);
	}

	public static void emptyURTreatmentTypeList() {
		URTreatmentTypeData = new ArrayList<>();
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}