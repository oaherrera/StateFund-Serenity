package com.conexia.qa.statefund.interactions;

import com.conexia.qa.statefund.models.PDFInformation;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.thucydides.core.annotations.Step;

/*
 * parate el texto del PDF non Claim
 */
public class ExtractClaimRFA implements Interaction {

	private String pdfContent;
	private String temporaryRFAID;
	private String dateOfBirth;
	private String dateOfInjury;
	private String lastName;
	private String firstName;
	private String workerName;
	private String procedureCode;
	private String bodyPart;
	private String frequency;
	private String period;
	private String quantity;
	private String startDate;
	private String provisionalDecision;
	private String endDate;
	private String diagnosisCode;

	public ExtractClaimRFA(String pdfContent) {
		this.pdfContent = pdfContent;
	}

	@SuppressWarnings("unused")
	@Override
	@Step("{0} Extract Claim RFA information of PDF")
	public <T extends Actor> void performAs(T actor) {
		String[] content = pdfContent.split("\n");

		temporaryRFAID = content[0].split(":")[1].replace(" ", "").replace("\r", "");
		dateOfBirth = content[2].split("\\|")[0].split(":")[1].replace(" ", "");
		dateOfInjury = content[2].split("\\|")[1].split(":")[1].replace(" ", "").replace("\r", "");
		try {
			lastName = content[1].split("  ")[1].replace("\r", "");
			firstName = content[1].split("  ")[0];
		} catch (Exception e) {
			firstName = content[1].split(" ")[0] + " " + content[1].split(" ")[1];
			lastName = content[1].split(" ")[2].replace("\r", "");
		}
		workerName = content[4].replace("\r", "");
		procedureCode = content[9].split(" ")[0];
		bodyPart = content[9].split(" ")[1];
		frequency = content[9].split(" ")[2];
		period = content[9].split(" ")[3];
		quantity = content[9].split(" ")[4];
		startDate = content[9].split(" ")[5];

		int size = content[9].split(" ").length;
		provisionalDecision = content[9].split(" ")[size - 1].replace("\r", "");
		if (content[9].split(" ")[6].contains("/")) {
			endDate = content[9].split(" ")[6];
		} else {
			endDate = "";
		}
		PDFInformation pdfInformation = new PDFInformation(temporaryRFAID, dateOfBirth, dateOfInjury, lastName,
				firstName, workerName, procedureCode, bodyPart, frequency, period, quantity, startDate,
				provisionalDecision, endDate, diagnosisCode);
	}

	public static ExtractClaimRFA information(String pdfContent) {
		return Tasks.instrumented(ExtractClaimRFA.class, pdfContent);
	}

}