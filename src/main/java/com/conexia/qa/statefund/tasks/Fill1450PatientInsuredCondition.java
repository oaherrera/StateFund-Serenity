package com.conexia.qa.statefund.tasks;

import static com.conexia.qa.statefund.user_interfaces.CommonPage.NEXT;

import com.conexia.qa.statefund.interactions.WaitLoading;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.thucydides.core.annotations.Step;

public class Fill1450PatientInsuredCondition implements Task {

	@Override
	@Step("{0} Fill the Patient Insured Condition 1450 form")
	public <T extends Actor> void performAs(T actor) {
		Serenity.takeScreenshot();
		actor.attemptsTo(FillInpatientAdmission.form(), FillHospitalizationInformation.form(),
				FillSurgeryInformation.form(), Scroll.to(NEXT), Click.on(NEXT), WaitLoading.page());
	}

	public static Fill1450PatientInsuredCondition form() {
		return Tasks.instrumented(Fill1450PatientInsuredCondition.class);
	}

}