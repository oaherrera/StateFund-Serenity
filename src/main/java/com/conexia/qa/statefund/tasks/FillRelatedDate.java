package com.conexia.qa.statefund.tasks;

import static com.conexia.qa.statefund.user_interfaces.RelatedDatePage.DATE_PATIENT_FROM;
import static com.conexia.qa.statefund.user_interfaces.RelatedDatePage.HOSPITALIZATION_DATE_FROM;
import static com.conexia.qa.statefund.user_interfaces.RelatedDatePage.HOSPITALIZATION_DATE_TO;
import static com.conexia.qa.statefund.user_interfaces.RelatedDatePage.TITTLE;

import com.conexia.qa.statefund.interactions.Type;
import com.conexia.qa.statefund.user_interfaces.RelatedDatePage;
import com.conexia.qa.statefund.utils.DateFunctions;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Scroll;
import net.thucydides.core.annotations.Step;

public class FillRelatedDate implements Task {

	private String datePatientFrom;
	private String datePatientTo;
	private String hospitalizationDateFrom;
	private String hospitalizationDateTo;

	public FillRelatedDate() {
		this.datePatientFrom = DateFunctions.aWeekBefore();
		this.datePatientTo = DateFunctions.actualDate();
		this.hospitalizationDateFrom = DateFunctions.aWeekBefore();
		this.hospitalizationDateTo = DateFunctions.actualDate();
	}

	@Override
	@Step("{0} Fill the Related Date")
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(Scroll.to(TITTLE), Type.theNumber(datePatientFrom).into(DATE_PATIENT_FROM),
				Type.theNumber(datePatientTo).into(RelatedDatePage.DATE_PATIENT_TO),
				Type.theNumber(hospitalizationDateFrom).into(HOSPITALIZATION_DATE_FROM),
				Type.theNumber(hospitalizationDateTo).into(HOSPITALIZATION_DATE_TO));
		Serenity.takeScreenshot();
	}

	public static FillRelatedDate from() {
		return Tasks.instrumented(FillRelatedDate.class);
	}

}