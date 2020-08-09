package com.conexia.qa.statefund.models;

import java.util.ArrayList;
import java.util.List;

public class PhysicianInformation extends TreatmentDetails {

	private String physicianName;
	private String rfaType;

	public static List<PhysicianInformation> physicianData = new ArrayList<>();

	public static void savePhysicianInformationList(PhysicianInformation physicianInformation) {
		physicianData.add(physicianInformation);
	}

	public static PhysicianInformation readData(int index) {
		return physicianData.get(index);
	}

	public static void emptyPhysicianInformationList() {
		physicianData = new ArrayList<>();
	}

	public String getPhysicianName() {
		return physicianName;
	}

	public void setPhysicianName(String physicianName) {
		this.physicianName = physicianName;
	}

	public String getRfaType() {
		return rfaType;
	}

	public void setRfaType(String rfaType) {
		this.rfaType = rfaType;
	}

}