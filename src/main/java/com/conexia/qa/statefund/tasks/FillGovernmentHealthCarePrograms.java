package com.conexia.qa.statefund.tasks;

import static com.conexia.qa.statefund.user_interfaces.GovernmentHealthCareProgramsPage.DOES_THE_PATIENT_HAVE_AN_INSURED_ID_NUMBER_OR_SOCIAL_SECURITY_NUMBER;
import static com.conexia.qa.statefund.user_interfaces.GovernmentHealthCareProgramsPage.INSURED_ID_NUMBER;
import static com.conexia.qa.statefund.user_interfaces.GovernmentHealthCareProgramsPage.INSURED_PLAN_NAME_OR_PROGRAM_NAME;
import static com.conexia.qa.statefund.user_interfaces.GovernmentHealthCareProgramsPage.INSURED_POLICY_GROUP_OR_FECA_NUMBER;
import static com.conexia.qa.statefund.user_interfaces.GovernmentHealthCareProgramsPage.TITTLE;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.thucydides.core.annotations.Step;

public class FillGovernmentHealthCarePrograms implements Task {

	private String insuredPlanNameOrProgramName;
	private String haveSocialSecurityNumber;
	private String insuredPolicyGroup;
	private String insuredIDNumber;

	public FillGovernmentHealthCarePrograms() {
		this.insuredPlanNameOrProgramName = "Plan Name 123456";
		this.haveSocialSecurityNumber = "Yes";
		this.insuredPolicyGroup = "33333333";
		this.insuredIDNumber = "222222222";
	}

	@Override
	@Step("{0} Fill the Government Health Care Programs")
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(Scroll.to(TITTLE),
				Enter.theValue(insuredPlanNameOrProgramName).into(INSURED_PLAN_NAME_OR_PROGRAM_NAME),
				Click.on(DOES_THE_PATIENT_HAVE_AN_INSURED_ID_NUMBER_OR_SOCIAL_SECURITY_NUMBER
						.of(haveSocialSecurityNumber)),
				Enter.theValue(insuredPolicyGroup).into(INSURED_POLICY_GROUP_OR_FECA_NUMBER));
		if (haveSocialSecurityNumber.equals("Yes")) {
			actor.attemptsTo(Enter.theValue(insuredIDNumber).into(INSURED_ID_NUMBER));
		}
		Serenity.takeScreenshot();
	}

	public static FillGovernmentHealthCarePrograms form() {
		return Tasks.instrumented(FillGovernmentHealthCarePrograms.class);
	}

}