package com.conexia.qa.statefund.models;

import java.util.ArrayList;
import java.util.List;

public class WorkerInformation {

	private String searchBy;
	private String workerFirstName;
	private String workerLastName;
	private String dateOfInjury;
	private String claimNumber;
	private String workerMiddleName;
	private String dateOfBirth;
	private String employerName;
	private String rfaType;

	public static List<WorkerInformation> workerData = new ArrayList<>();

	public static void saveWorkerInformationList(WorkerInformation workerInformation) {
		workerData.add(workerInformation);
	}

	public static WorkerInformation readData(int index) {
		return workerData.get(index);
	}

	public static void emptyWorkerInformationList() {
		workerData = new ArrayList<>();
	}

	public String getSearchBy() {
		return searchBy;
	}

	public void setSearchBy(String searchBy) {
		this.searchBy = searchBy;
	}

	public String getWorkerFirstName() {
		return workerFirstName;
	}

	public void setWorkerFirstName(String workerFirstName) {
		this.workerFirstName = workerFirstName;
	}

	public String getWorkerLastName() {
		return workerLastName;
	}

	public void setWorkerLastName(String workerLastName) {
		this.workerLastName = workerLastName;
	}

	public String getDateOfInjury() {
		return dateOfInjury;
	}

	public void setDateOfInjury(String dateOfInjury) {
		this.dateOfInjury = dateOfInjury;
	}

	public String getClaimNumber() {
		return claimNumber;
	}

	public void setClaimNumber(String claimNumber) {
		this.claimNumber = claimNumber;
	}

	public String getWorkerMiddleName() {
		return workerMiddleName;
	}

	public void setWorkerMiddleName(String workerMiddleName) {
		this.workerMiddleName = workerMiddleName;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getEmployerName() {
		return employerName;
	}

	public void setEmployerName(String employerName) {
		this.employerName = employerName;
	}

	public String getRfaType() {
		return rfaType;
	}

	public void setRfaType(String rfaType) {
		this.rfaType = rfaType;
	}

}