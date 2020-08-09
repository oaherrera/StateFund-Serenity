package com.conexia.qa.statefund.models;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ChristianCamiloSchottlaender
 */
public class FieldsSavedDraft {

	private String claimNumberField;
	private String injuredWorkerField;
	private String dateOfInjuryField;
	private String savedDateField;
	private String orderBy;
	private String claimNumber;
	private String injuredWorker;
	private String dateOfInjury;
	private String savedDate;
	private String id;
	private String createBy;

	public static List<FieldsSavedDraft> fieldsSavedDraftInformation = new ArrayList<FieldsSavedDraft>();

	public static void savefieldsSavedDraftList(FieldsSavedDraft fieldsSavedDraftData) {
		fieldsSavedDraftInformation.add(fieldsSavedDraftData);
	}

	public static FieldsSavedDraft readData(int index) {
		return fieldsSavedDraftInformation.get(index);
	}

	public static void emptyfieldsSavedDraftList() {
		fieldsSavedDraftInformation = new ArrayList<FieldsSavedDraft>();
	}

	public String getClaimNumberField() {
		return claimNumberField;
	}

	public void setClaimNumberField(String claimNumberField) {
		this.claimNumberField = claimNumberField;
	}

	public String getInjuredWorkerField() {
		return injuredWorkerField;
	}

	public void setInjuredWorkerField(String injuredWorkerField) {
		this.injuredWorkerField = injuredWorkerField;
	}

	public String getDateOfInjuryField() {
		return dateOfInjuryField;
	}

	public void setDateOfInjuryField(String dateOfInjuryField) {
		this.dateOfInjuryField = dateOfInjuryField;
	}

	public String getSavedDateField() {
		return savedDateField;
	}

	public void setSavedDateField(String savedDateField) {
		this.savedDateField = savedDateField;
	}

	public String getClaimNumber() {
		return claimNumber;
	}

	public void setClaimNumber(String claimNumber) {
		this.claimNumber = claimNumber;
	}

	public String getInjuredWorker() {
		return injuredWorker;
	}

	public void setInjuredWorker(String injuredWorker) {
		this.injuredWorker = injuredWorker;
	}

	public String getDateOfInjury() {
		return dateOfInjury;
	}

	public void setDateOfInjury(String dateOfInjury) {
		this.dateOfInjury = dateOfInjury;
	}

	public String getSavedDate() {
		return savedDate;
	}

	public void setSavedDate(String savedDate) {
		this.savedDate = savedDate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public String getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}

}