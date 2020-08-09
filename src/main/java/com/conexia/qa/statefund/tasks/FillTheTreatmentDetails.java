package com.conexia.qa.statefund.tasks;

import static com.conexia.qa.statefund.user_interfaces.CommonPage.NEXT;
import static com.conexia.qa.statefund.user_interfaces.TreatmentDetailsPage.ADDITIONAL_COMMENTS;
import static com.conexia.qa.statefund.user_interfaces.TreatmentDetailsPage.ADD_PROCEDURE;
import static com.conexia.qa.statefund.user_interfaces.TreatmentDetailsPage.ALL_RELATED_DIAGNOSIS;
import static com.conexia.qa.statefund.user_interfaces.TreatmentDetailsPage.CLOSE_RELATED_DIAGNOSIS;
import static com.conexia.qa.statefund.user_interfaces.TreatmentDetailsPage.DIAGNOSIS_CODE_DESC;
import static com.conexia.qa.statefund.user_interfaces.TreatmentDetailsPage.DIAGNOSIS_OPTION;
import static com.conexia.qa.statefund.user_interfaces.TreatmentDetailsPage.END_DATE;
import static com.conexia.qa.statefund.user_interfaces.TreatmentDetailsPage.FREQUENCY;
import static com.conexia.qa.statefund.user_interfaces.TreatmentDetailsPage.ONE_RELATED_DIAGNOSIS;
import static com.conexia.qa.statefund.user_interfaces.TreatmentDetailsPage.PROCEDURE_CODE_DESC;
import static com.conexia.qa.statefund.user_interfaces.TreatmentDetailsPage.PROCEDURE_CODE_DESC_OPTION;
import static com.conexia.qa.statefund.user_interfaces.TreatmentDetailsPage.QUANTITY;
import static com.conexia.qa.statefund.user_interfaces.TreatmentDetailsPage.RELATED_BODY_PART;
import static com.conexia.qa.statefund.user_interfaces.TreatmentDetailsPage.RELATED_DIAGNOSIS;
import static com.conexia.qa.statefund.user_interfaces.TreatmentDetailsPage.START_DATE;
import static com.conexia.qa.statefund.user_interfaces.TreatmentDetailsPage.UR_TREATMENT_TYPE_SELECT;
import static java.util.concurrent.TimeUnit.SECONDS;

import org.openqa.selenium.interactions.Actions;

import com.conexia.qa.statefund.drivers.OwnWebDriver;
import com.conexia.qa.statefund.interactions.ChooseMultiple;
import com.conexia.qa.statefund.interactions.SelectList;
import com.conexia.qa.statefund.interactions.SelectMultipleOption;
import com.conexia.qa.statefund.interactions.Type;
import com.conexia.qa.statefund.interactions.WaitLoading;
import com.conexia.qa.statefund.models.TreatmentDetails;
import com.conexia.qa.statefund.user_interfaces.CommonPage;
import com.conexia.qa.statefund.user_interfaces.TreatmentDetailsPage;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.thucydides.core.annotations.Step;

public class FillTheTreatmentDetails implements Task {

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

	public FillTheTreatmentDetails() {
		this.diagnosisCode = TreatmentDetails.readData(0).getDaignosisCode();
		this.procedureType = TreatmentDetails.readData(0).getProcedureType();
		this.procedutreCode = TreatmentDetails.readData(0).getProcedutreCode();
		this.relatedBodyPart = TreatmentDetails.readData(0).getRelatedBodyPart();
		this.relatedDiagnosis = TreatmentDetails.readData(0).getRelatedDiagnosis();
		this.urTreatmentType = TreatmentDetails.readData(0).getUrTreatmentType();
		this.additionalComments = TreatmentDetails.readData(0).getAdditionalComments();
		this.frequency = TreatmentDetails.readData(0).getFrecuency();
		this.period = TreatmentDetails.readData(0).getPeriod();
		this.quantity = TreatmentDetails.readData(0).getQuantity();
		this.startDate = TreatmentDetails.readData(0).getStartDate();
		this.endDate = TreatmentDetails.readData(0).getEndDate();
	}

	@Override
	@Step("{0} Fill the Treatment Details")
	public <T extends Actor> void performAs(T actor) {
		Actions accion = new Actions(OwnWebDriver.getDriver());
		actor.attemptsTo(ChooseMultiple.options(diagnosisCode).into(DIAGNOSIS_CODE_DESC, DIAGNOSIS_OPTION),
				Scroll.to(DIAGNOSIS_CODE_DESC), Click.on(TreatmentDetailsPage.PROCEDURE_TYPE));
		for (int i = 0; i < TreatmentDetailsPage.PROCEDURE_TYPE_OPTIONS.resolveAllFor(actor).size(); i++) {
			accion.moveToElement(TreatmentDetailsPage.PROCEDURE_TYPE_OPTIONS.resolveAllFor(actor).get(i)).build()
					.perform();
			if (TreatmentDetailsPage.PROCEDURE_TYPE_OPTIONS.resolveAllFor(actor).get(i).getText()
					.equalsIgnoreCase(procedureType)) {
				actor.attemptsTo(Click.on(TreatmentDetailsPage.PROCEDURE_TYPE_OPTIONS.resolveAllFor(actor).get(i)),
						WaitLoading.page());
				break;
			}
		}
		actor.attemptsTo(SelectList.text(procedutreCode).into(PROCEDURE_CODE_DESC, PROCEDURE_CODE_DESC_OPTION),
				SelectFromOptions.byVisibleText(relatedBodyPart).from(RELATED_BODY_PART),
				SelectMultipleOption.text(relatedDiagnosis)
						.into(ALL_RELATED_DIAGNOSIS, ONE_RELATED_DIAGNOSIS.of(relatedDiagnosis), RELATED_DIAGNOSIS)
						.andClose(CLOSE_RELATED_DIAGNOSIS),
				SelectFromOptions.byVisibleText(urTreatmentType).from(UR_TREATMENT_TYPE_SELECT),
				Enter.theValue(additionalComments).into(ADDITIONAL_COMMENTS));
		Serenity.takeScreenshot();
		actor.attemptsTo(Scroll.to(ADD_PROCEDURE), Click.on(ADD_PROCEDURE), Scroll.to(FREQUENCY),
				Enter.theValue(frequency).into(FREQUENCY), Click.on(TreatmentDetailsPage.PERIOD));
		for (int i = 0; i < TreatmentDetailsPage.PERIOD_OPTIONS.resolveAllFor(actor).size(); i++) {
			accion.moveToElement(TreatmentDetailsPage.PERIOD_OPTIONS.resolveAllFor(actor).get(i)).build().perform();
			if (TreatmentDetailsPage.PERIOD_OPTIONS.resolveAllFor(actor).get(i).getText().equalsIgnoreCase(period)) {
				actor.attemptsTo(Click.on(TreatmentDetailsPage.PERIOD_OPTIONS.resolveAllFor(actor).get(i)),
						WaitLoading.page());
				break;
			}
		}
		actor.attemptsTo(Enter.theValue(quantity).into(QUANTITY), Type.theNumber(startDate).into(START_DATE),
				Type.theNumber(endDate).into(END_DATE), Click.on(NEXT), WaitLoading.page());
		OwnWebDriver.getDriver().manage().timeouts().implicitlyWait(2, SECONDS);
		if (CommonPage.ERROR_POP_UP.resolveFor(actor).isVisible()) {
			Serenity.takeScreenshot();
		}
		OwnWebDriver.getDriver().manage().timeouts().implicitlyWait(20, SECONDS);
	}

	public static FillTheTreatmentDetails fields() {
		return Tasks.instrumented(FillTheTreatmentDetails.class);
	}

}