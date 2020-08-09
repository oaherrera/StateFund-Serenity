package com.conexia.qa.statefund.tasks;

import static com.conexia.qa.statefund.user_interfaces.EmployerInformationPage.EMPLOYER_NAME;
import static com.conexia.qa.statefund.user_interfaces.WorkersInformationPage.DATE_OF_BIRTH;
import static com.conexia.qa.statefund.user_interfaces.WorkersInformationPage.DATE_OF_INJURY;
import static com.conexia.qa.statefund.user_interfaces.WorkersInformationPage.WORKER_FIRST_NAME;
import static com.conexia.qa.statefund.user_interfaces.WorkersInformationPage.WORKER_LAST_NAME;
import static com.conexia.qa.statefund.user_interfaces.WorkersInformationPage.WORKER_MIDDLE_NAME;

import com.conexia.qa.statefund.interactions.RFAType;
import com.conexia.qa.statefund.interactions.Type;
import com.conexia.qa.statefund.models.WorkerInformation;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.thucydides.core.annotations.Step;

public class FillWorkerInformation implements Task {

	private String workerFirstName;
	private String workerMiddleName;
	private String workerLastName;
	private String dateOfBirth;
	private String dateOfInjury;
	private String employerName;
	private String rfaType;

	public FillWorkerInformation(String workerFirstName) {
		this.workerFirstName = workerFirstName;
		this.workerMiddleName = WorkerInformation.readData(0).getWorkerMiddleName();
		this.workerLastName = WorkerInformation.readData(0).getWorkerLastName();
		this.dateOfBirth = WorkerInformation.readData(0).getDateOfBirth();
		this.dateOfInjury = WorkerInformation.readData(0).getDateOfInjury();
		this.employerName = WorkerInformation.readData(0).getEmployerName();
	}

	@Override
	@Step("{0} Fill the worker information")
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(Enter.theValue(workerFirstName).into(WORKER_FIRST_NAME),
				Enter.theValue(workerMiddleName).into(WORKER_MIDDLE_NAME),
				Enter.theValue(workerLastName).into(WORKER_LAST_NAME));
		actor.attemptsTo(Type.theNumber(dateOfBirth).into(DATE_OF_BIRTH));
		actor.attemptsTo(Type.theNumber(dateOfInjury).into(DATE_OF_INJURY));
		actor.attemptsTo(Enter.theValue(employerName).into(EMPLOYER_NAME));
		Serenity.takeScreenshot();
		actor.attemptsTo(Scroll.to(DATE_OF_INJURY), RFAType.option(rfaType));
	}

	public static FillWorkerInformation withTheWorker(String workerFirstName) {
		return Tasks.instrumented(FillWorkerInformation.class, workerFirstName);
	}

	public FillWorkerInformation andRFATypeIs(String rfaType) {
		this.rfaType = rfaType;
		return this;
	}

}