package com.conexia.qa.statefund.models;

import java.util.ArrayList;
import java.util.List;

public class LegalFlag {

	private String comment;
	private String submittedDate;

	public static List<LegalFlag> legalFlagData = new ArrayList<>();

	public static void saveLegalFlagList(LegalFlag legalFlag) {
		legalFlagData.add(legalFlag);
	}

	public static LegalFlag readData(int index) {
		return legalFlagData.get(index);
	}

	public static void emptyLegalFlagList() {
		legalFlagData = new ArrayList<>();
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getSubmittedDate() {
		return submittedDate;
	}

	public void setSubmittedDate(String submittedDate) {
		this.submittedDate = submittedDate;
	}

}