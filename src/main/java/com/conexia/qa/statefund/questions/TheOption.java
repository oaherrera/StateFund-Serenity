package com.conexia.qa.statefund.questions;

import java.util.List;

import org.openqa.selenium.interactions.Actions;

import com.conexia.qa.statefund.drivers.OwnWebDriver;
import com.conexia.qa.statefund.interactions.ChooseMultiple;
import com.conexia.qa.statefund.interactions.SelectList;
import com.conexia.qa.statefund.interactions.SelectMultipleOption;
import com.conexia.qa.statefund.interactions.Swipe;
import com.conexia.qa.statefund.interactions.Type;
import com.conexia.qa.statefund.interactions.WaitLoading;
import com.conexia.qa.statefund.models.TreatmentDetails;
import com.conexia.qa.statefund.user_interfaces.ClaimAdministratorInformationPage;
import com.conexia.qa.statefund.user_interfaces.CommonPage;
import com.conexia.qa.statefund.user_interfaces.TreatmentDetailsPage;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.targets.Target;

public class TheOption implements Question<Boolean> {

	private String option, field;
	private List<TreatmentDetails> treatmentDetails;

	private TheOption(String option) {
		this.option = option;
	}

	@Override
	public Boolean answeredBy(Actor actor) {
		Actions accion = new Actions(OwnWebDriver.getDriver());
		int pixels = 0;
		Target element = null, options = null, labelElement = null;
		switch (field) {
		case "Address":
			element = ClaimAdministratorInformationPage.ADDRESS;
			options = ClaimAdministratorInformationPage.ADDRESS_OPTIONS;
			labelElement = ClaimAdministratorInformationPage.ADDRESS_LABEL;
			option = option.replace("address ", "");
			pixels = -150;
			break;
		case "Procedure Type":
			actor.attemptsTo(Scroll.to(CommonPage.NEXT), Click.on(CommonPage.NEXT), WaitLoading.page());
			element = TreatmentDetailsPage.PROCEDURE_TYPE;
			options = TreatmentDetailsPage.PROCEDURE_TYPE_OPTIONS;
			labelElement = TreatmentDetailsPage.PROCEDURE_TYPE_LABEL;
			option = option.replace("procedure type ", "");
			pixels = -150;
			break;
		case "Period":
			TreatmentDetails.saveTreatmentDetailsList(treatmentDetails.get(0));
			actor.attemptsTo(
					ChooseMultiple.options(TreatmentDetails.readData(0).getDaignosisCode())
							.into(TreatmentDetailsPage.DIAGNOSIS_CODE_DESC, TreatmentDetailsPage.DIAGNOSIS_OPTION),
					Scroll.to(TreatmentDetailsPage.DIAGNOSIS_CODE_DESC), Click.on(TreatmentDetailsPage.PROCEDURE_TYPE));
			for (int i = 0; i < TreatmentDetailsPage.PROCEDURE_TYPE_OPTIONS.resolveAllFor(actor).size(); i++) {
				accion.moveToElement(TreatmentDetailsPage.PROCEDURE_TYPE_OPTIONS.resolveAllFor(actor).get(i)).build()
						.perform();
				if (TreatmentDetailsPage.PROCEDURE_TYPE_OPTIONS.resolveAllFor(actor).get(i).getText()
						.equalsIgnoreCase(TreatmentDetails.readData(0).getProcedureType())) {
					actor.attemptsTo(Click.on(TreatmentDetailsPage.PROCEDURE_TYPE_OPTIONS.resolveAllFor(actor).get(i)),
							WaitLoading.page());
					break;
				}
			}
			actor.attemptsTo(WaitLoading.page(),
					SelectList.text(TreatmentDetails.readData(0).getProcedutreCode()).into(
							TreatmentDetailsPage.PROCEDURE_CODE_DESC, TreatmentDetailsPage.PROCEDURE_CODE_DESC_OPTION),
					SelectFromOptions.byVisibleText(TreatmentDetails.readData(0).getRelatedBodyPart())
							.from(TreatmentDetailsPage.RELATED_BODY_PART),
					SelectMultipleOption.text(TreatmentDetails.readData(0).getRelatedDiagnosis())
							.into(TreatmentDetailsPage.ALL_RELATED_DIAGNOSIS,
									TreatmentDetailsPage.ONE_RELATED_DIAGNOSIS
											.of(TreatmentDetails.readData(0).getRelatedDiagnosis()),
									TreatmentDetailsPage.RELATED_DIAGNOSIS)
							.andClose(TreatmentDetailsPage.CLOSE_RELATED_DIAGNOSIS),
					SelectFromOptions.byVisibleText(TreatmentDetails.readData(0).getUrTreatmentType())
							.from(TreatmentDetailsPage.UR_TREATMENT_TYPE_SELECT),
					Enter.theValue(TreatmentDetails.readData(0).getAdditionalComments())
							.into(TreatmentDetailsPage.ADDITIONAL_COMMENTS));
			Serenity.takeScreenshot();
			actor.attemptsTo(Scroll.to(TreatmentDetailsPage.ADD_PROCEDURE),
					Click.on(TreatmentDetailsPage.ADD_PROCEDURE), Scroll.to(TreatmentDetailsPage.FREQUENCY),
					Enter.theValue(TreatmentDetails.readData(0).getFrecuency()).into(TreatmentDetailsPage.FREQUENCY),
					Enter.theValue(TreatmentDetails.readData(0).getQuantity()).into(TreatmentDetailsPage.QUANTITY),
					Type.theNumber(TreatmentDetails.readData(0).getStartDate()).into(TreatmentDetailsPage.START_DATE),
					Type.theNumber(TreatmentDetails.readData(0).getEndDate()).into(TreatmentDetailsPage.END_DATE));
			element = TreatmentDetailsPage.PERIOD;
			options = TreatmentDetailsPage.PERIOD_OPTIONS;
			labelElement = TreatmentDetailsPage.PERIOD_LABEL;
			option = option.replace("period ", "");
			break;
		default:
			break;
		}
		actor.attemptsTo(Scroll.to(element), Swipe.vertical(pixels), Click.on(element));
		for (int i = 0; i < options.resolveAllFor(actor).size(); i++) {
			accion.moveToElement(options.resolveAllFor(actor).get(i)).build().perform();
			if (options.resolveAllFor(actor).get(i).getText().equalsIgnoreCase(option)) {
				actor.attemptsTo(Click.on(options.resolveAllFor(actor).get(i)), WaitLoading.page());
				break;
			}
		}
		Serenity.takeScreenshot();
		return labelElement.resolveFor(actor).getText().equalsIgnoreCase(option);
	}

	public static TheOption isDisplayed(String option) {
		return new TheOption(option);
	}

	public TheOption from(String field) {
		this.field = field;
		return this;
	}

	public TheOption withDataTreatmentDetails(List<TreatmentDetails> treatmentDetails) {
		this.treatmentDetails = treatmentDetails;
		return this;
	}

}