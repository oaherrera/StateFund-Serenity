package com.conexia.qa.statefund.models;

public class PDFInformation {

	private static String temporaryRFAID;
	private static String dateOfBirth;
	private static String dateOfInjury;
	private static String lastName;
	private static String firstName;
	private static String workerName;
	private static String procedureCode;
	private static String bodyPart;
	private static String frequency;
	private static String period;
	private static String quantity;
	private static String startDate;
	private static String provisionalDecision;
	private static String endDate;
	private static String diagnosisCode;

	public PDFInformation() {
	}

	public PDFInformation(String temporaryRFAID, String dateOfBirth, String dateOfInjury, String lastName,
			String firstName, String workerName, String procedureCode, String bodyPart, String frequency, String period,
			String quantity, String startDate, String provisionalDecision, String endDate, String diagnosisCode) {
		PDFInformation.temporaryRFAID = temporaryRFAID;
		PDFInformation.dateOfBirth = dateOfBirth;
		PDFInformation.dateOfInjury = dateOfInjury;
		PDFInformation.lastName = lastName;
		PDFInformation.firstName = firstName;
		PDFInformation.workerName = workerName;
		PDFInformation.procedureCode = procedureCode;
		PDFInformation.bodyPart = bodyPart;
		PDFInformation.frequency = frequency;
		PDFInformation.period = period;
		PDFInformation.quantity = quantity;
		PDFInformation.startDate = startDate;
		PDFInformation.provisionalDecision = provisionalDecision;
		PDFInformation.endDate = endDate;
		PDFInformation.diagnosisCode = diagnosisCode;
	}

	public String getTemporaryRFAID() {
		return temporaryRFAID;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public String getDateOfInjury() {
		return dateOfInjury;
	}

	public String getLastName() {
		return lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getWorkerName() {
		return workerName;
	}

	public String getProcedureCode() {
		return procedureCode;
	}

	public String getBodyPart() {
		return bodyPart;
	}

	public String getFrequency() {
		return frequency;
	}

	public String getPeriod() {
		return period;
	}

	public String getQuantity() {
		return quantity;
	}

	public String getStartDate() {
		return startDate;
	}

	public String getProvisionalDecision() {
		return provisionalDecision;
	}

	public String getEndDate() {
		return endDate;
	}

	public String getDiagnosisCode() {
		return diagnosisCode;
	}

}