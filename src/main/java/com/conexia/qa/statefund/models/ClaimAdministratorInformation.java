package com.conexia.qa.statefund.models;

import java.util.ArrayList;
import java.util.List;

public class ClaimAdministratorInformation {

	private String companyName;

	public static List<ClaimAdministratorInformation> claimData = new ArrayList<>();

	public static void saveClaimAdministratorInformationList(
			ClaimAdministratorInformation claimAdministratorInformation) {
		claimData.add(claimAdministratorInformation);
	}

	public static ClaimAdministratorInformation readData(int index) {
		return claimData.get(index);
	}

	public static void emptyClaimAdministratorInformationList() {
		claimData = new ArrayList<>();
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

}