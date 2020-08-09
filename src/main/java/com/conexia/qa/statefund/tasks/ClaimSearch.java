package com.conexia.qa.statefund.tasks;

import static com.conexia.qa.statefund.user_interfaces.ClaimSearchPage.CLAIM;
import static com.conexia.qa.statefund.user_interfaces.ClaimSearchPage.CLAIM_NUMBER;
import static com.conexia.qa.statefund.user_interfaces.ClaimSearchPage.DATE_OF_INJURY;
import static com.conexia.qa.statefund.user_interfaces.ClaimSearchPage.FIRST_NAME;
import static com.conexia.qa.statefund.user_interfaces.ClaimSearchPage.LAST_NAME;
import static com.conexia.qa.statefund.user_interfaces.ClaimSearchPage.WORKER_INFORMATION;
import static com.conexia.qa.statefund.user_interfaces.CommonPage.SEARCH;

import com.conexia.qa.statefund.interactions.Type;
import com.conexia.qa.statefund.interactions.WaitLoading;
import com.conexia.qa.statefund.models.WorkerInformation;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;

public class ClaimSearch implements Task {

	private String searchBy;
	private String firstName;
	private String lastName;
	private String dateOfInjury;
	private String claimNumber;

	public ClaimSearch(String searchBy) {
		if (searchBy == null) {
			this.searchBy = "Worker Information";
		} else {
			this.searchBy = searchBy;
		}
		if (WorkerInformation.readData(0).getWorkerFirstName() == null) {
			this.firstName = "";
		} else {
			this.firstName = WorkerInformation.readData(0).getWorkerFirstName();
		}
		if (WorkerInformation.readData(0).getWorkerLastName() == null) {
			this.lastName = "";
		} else {
			this.lastName = WorkerInformation.readData(0).getWorkerLastName();
		}
		if (WorkerInformation.readData(0).getDateOfInjury() == null) {
			this.dateOfInjury = "";
		} else {
			this.dateOfInjury = WorkerInformation.readData(0).getDateOfInjury();
		}
		this.claimNumber = WorkerInformation.readData(0).getClaimNumber();
	}

	@Override
	@Step("{0} Claims Search by #searchBy")
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(AccessToClaimSearch.menu());
		switch (searchBy) {
		case "Worker Information":
			actor.attemptsTo(Click.on(WORKER_INFORMATION), Enter.theValue(firstName).into(FIRST_NAME),
					Enter.theValue(lastName).into(LAST_NAME), Type.theNumber(dateOfInjury).into(DATE_OF_INJURY));
			break;
		case "Claim":
			actor.attemptsTo(Click.on(CLAIM), Enter.theValue(claimNumber).into(CLAIM_NUMBER));
			break;
		default:
			break;
		}
		actor.attemptsTo(Click.on(SEARCH), WaitLoading.page());
		Serenity.takeScreenshot();
	}

	public static ClaimSearch by(String searchBy) {
		return Tasks.instrumented(ClaimSearch.class, searchBy);
	}

}