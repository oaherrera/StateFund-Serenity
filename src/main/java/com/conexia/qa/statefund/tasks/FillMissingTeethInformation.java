package com.conexia.qa.statefund.tasks;

import static com.conexia.qa.statefund.user_interfaces.MissingTeethInformationPage.IS_THE_PATIENT_MISSING_ANY_TEETH;
import static com.conexia.qa.statefund.user_interfaces.MissingTeethInformationPage.PRIMARY_TEETH;
import static com.conexia.qa.statefund.user_interfaces.MissingTeethInformationPage.TEETH_NUMBER;
import static com.conexia.qa.statefund.user_interfaces.MissingTeethInformationPage.TITTLE;

import com.conexia.qa.statefund.interactions.Swipe;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.thucydides.core.annotations.Step;

public class FillMissingTeethInformation implements Task {

	private String isThePatientMissingAnyTeeth;

	public FillMissingTeethInformation() {
		this.isThePatientMissingAnyTeeth = "Yes";
	}

	@Override
	@Step("{0} Fill the Missing Teeth Information form")
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(Scroll.to(TITTLE), Swipe.vertical(-200));
		actor.attemptsTo(Click.on(IS_THE_PATIENT_MISSING_ANY_TEETH.of(isThePatientMissingAnyTeeth)));
		if (isThePatientMissingAnyTeeth.equals("Yes")) {
			actor.attemptsTo(Click.on(TEETH_NUMBER.of("7")), Click.on(TEETH_NUMBER.of("32")));
			actor.attemptsTo(Click.on(PRIMARY_TEETH), Click.on(TEETH_NUMBER.of("K")), Click.on(TEETH_NUMBER.of("E")));
		}
		Serenity.takeScreenshot();
	}

	public static FillMissingTeethInformation form() {
		return Tasks.instrumented(FillMissingTeethInformation.class);
	}

}