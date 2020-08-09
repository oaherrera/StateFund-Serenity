package com.conexia.qa.statefund.tasks;

import static com.conexia.qa.statefund.user_interfaces.AncillaryClaimTreatmentInformationPage.AUTO_ACCIDENT_STATE;
import static com.conexia.qa.statefund.user_interfaces.AncillaryClaimTreatmentInformationPage.DATE_APPLIANCE_PLACED;
import static com.conexia.qa.statefund.user_interfaces.AncillaryClaimTreatmentInformationPage.DATE_PRIOR_REPLACEMENT;
import static com.conexia.qa.statefund.user_interfaces.AncillaryClaimTreatmentInformationPage.IS_TREATMENT_FOR_ORTHODONTICS;
import static com.conexia.qa.statefund.user_interfaces.AncillaryClaimTreatmentInformationPage.MODEL;
import static com.conexia.qa.statefund.user_interfaces.AncillaryClaimTreatmentInformationPage.MONTHS_OF_TREATMENT_REMAINING;
import static com.conexia.qa.statefund.user_interfaces.AncillaryClaimTreatmentInformationPage.ORAL_IMAGES;
import static com.conexia.qa.statefund.user_interfaces.AncillaryClaimTreatmentInformationPage.PLACE_OF_TREATMENT;
import static com.conexia.qa.statefund.user_interfaces.AncillaryClaimTreatmentInformationPage.RADIOGRAPH;
import static com.conexia.qa.statefund.user_interfaces.AncillaryClaimTreatmentInformationPage.REPLACEMENT_OF_PROTHESIS;
import static com.conexia.qa.statefund.user_interfaces.AncillaryClaimTreatmentInformationPage.TITTLE;
import static com.conexia.qa.statefund.user_interfaces.AncillaryClaimTreatmentInformationPage.TREATMENT_RESULTING_FROM;

import com.conexia.qa.statefund.interactions.Swipe;
import com.conexia.qa.statefund.interactions.Type;
import com.conexia.qa.statefund.interactions.WaitElement;
import com.conexia.qa.statefund.utils.DateFunctions;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.thucydides.core.annotations.Step;

public class FillAncillaryClaimTreatmentInformation implements Task {

	private String placeOfTreatment;
	private String radiographNumber;
	private String oralImagesNumber;
	private String modelNumber;
	private String isTreatmentForOrthodontics;
	private String replacementOfProthesis;
	private String treatmentResultingFrom;
	private String dateAppliancePlaced;
	private String monthsOfTreatmentRemaining;
	private String datePriorReplacement;
	private String autoAccidentState;

	public FillAncillaryClaimTreatmentInformation() {
		this.placeOfTreatment = "Provider's Office";
		this.radiographNumber = "2";
		this.oralImagesNumber = "4";
		this.modelNumber = "10";
		this.isTreatmentForOrthodontics = "Yes";
		this.replacementOfProthesis = "Yes";
		this.treatmentResultingFrom = "Auto Accident";
		this.dateAppliancePlaced = DateFunctions.actualDate();
		this.monthsOfTreatmentRemaining = "12";
		this.datePriorReplacement = DateFunctions.actualDate();
		this.autoAccidentState = "ALABAMA";
	}

	@Override
	@Step("{0} Fill the Ancillary Claim Treatment Information form")
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(WaitElement.untilAppears(TITTLE), Scroll.to(TITTLE), Swipe.vertical(-150),
				Click.on(PLACE_OF_TREATMENT.of(placeOfTreatment)), Enter.theValue(radiographNumber).into(RADIOGRAPH),
				Enter.theValue(oralImagesNumber).into(ORAL_IMAGES), Enter.theValue(modelNumber).into(MODEL));
		actor.attemptsTo(Click.on(IS_TREATMENT_FOR_ORTHODONTICS.of(isTreatmentForOrthodontics)));
		if (isTreatmentForOrthodontics.equals("Yes")) {
			actor.attemptsTo(Type.theNumber(dateAppliancePlaced).into(DATE_APPLIANCE_PLACED),
					Enter.theValue(monthsOfTreatmentRemaining).into(MONTHS_OF_TREATMENT_REMAINING));
		}
		actor.attemptsTo(Click.on(REPLACEMENT_OF_PROTHESIS.of(replacementOfProthesis)));
		if (replacementOfProthesis.equals("Yes")) {
			actor.attemptsTo(Type.theNumber(datePriorReplacement).into(DATE_PRIOR_REPLACEMENT));
		}
		actor.attemptsTo(Click.on(TREATMENT_RESULTING_FROM.of(treatmentResultingFrom)));
		if (treatmentResultingFrom.equals("Auto Accident")) {
			actor.attemptsTo(SelectFromOptions.byVisibleText(autoAccidentState).from(AUTO_ACCIDENT_STATE));
		}
		Serenity.takeScreenshot();
	}

	public static FillAncillaryClaimTreatmentInformation form() {
		return Tasks.instrumented(FillAncillaryClaimTreatmentInformation.class);
	}

}