package com.conexia.qa.statefund.models;

import java.util.ArrayList;
import java.util.List;

public class TreatmentDetails {

	private String diagnosisCode;
	private String procedureType;
	private String procedutreCode;
	private String relatedBodyPart;
	private String relatedDiagnosis;
	private String urTreatmentType;
	private String additionalComments;
	private String frequency;
	private String period;
	private String quantity;
	private String startDate;
	private String endDate;

	public static List<TreatmentDetails> treatmentData = new ArrayList<>();

	public static void saveTreatmentDetailsList(TreatmentDetails treatmentDetails) {
		treatmentData.add(treatmentDetails);
	}

	public static TreatmentDetails readData(int index) {
		return treatmentData.get(index);
	}

	public static void emptyTreatmentDetailsList() {
		treatmentData = new ArrayList<>();
	}

	public String getDaignosisCode() {
		return diagnosisCode;
	}

	public void setDaignosisCode(String diagnosisCode) {
		this.diagnosisCode = diagnosisCode;
	}

	public String getProcedureType() {
		return procedureType;
	}

	public void setProcedureType(String procedureType) {
		this.procedureType = procedureType;
	}

	public String getProcedutreCode() {
		return procedutreCode;
	}

	public void setProcedutreCode(String procedutreCode) {
		this.procedutreCode = procedutreCode;
	}

	public String getRelatedBodyPart() {
		return relatedBodyPart;
	}

	public void setRelatedBodyPart(String relatedBodyPart) {
		this.relatedBodyPart = relatedBodyPart;
	}

	public String getRelatedDiagnosis() {
		return relatedDiagnosis;
	}

	public void setRelatedDiagnosis(String relatedDiagnosis) {
		this.relatedDiagnosis = relatedDiagnosis;
	}

	public String getUrTreatmentType() {
		return urTreatmentType;
	}

	public void setUrTreatmentType(String urTreatmentType) {
		this.urTreatmentType = urTreatmentType;
	}

	public String getAdditionalComments() {
		return additionalComments;
	}

	public void setAdditionalComments(String additionalComments) {
		this.additionalComments = additionalComments;
	}

	public String getFrecuency() {
		return frequency;
	}

	public void setFrecuency(String frequency) {
		this.frequency = frequency;
	}

	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

}