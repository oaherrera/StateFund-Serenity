package com.conexia.qa.statefund.questions;

import com.conexia.qa.sql_developer.models.QueryResponse;
import com.conexia.qa.statefund.models.LegalFlag;
import com.conexia.qa.statefund.models.WorkerInformation;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class TheLegalFlagDescription implements Question<String> {

	@Override
	public String answeredBy(Actor actor) {
		String message = QueryResponse.getJsonString().replace("{", "").replace("}", "").replace("[", "")
				.replace("]", "").replace("\"", "").replace(":", "").replace(",", "");
		String claimNumber[] = message.split("claimNumber");
		String comments[] = message.split("comments");
		String submittedDate[] = message.split("submittedDate");
		return claimNumber[1].substring(0, WorkerInformation.readData(0).getClaimNumber().length()) + " - "
				+ comments[1].substring(0, LegalFlag.readData(0).getComment().length()) + " - "
				+ submittedDate[1].substring(0, 10);
	}

	public static TheLegalFlagDescription submitted() {
		return new TheLegalFlagDescription();
	}

}