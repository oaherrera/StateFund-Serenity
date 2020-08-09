package com.conexia.qa.statefund.tasks;

import static com.conexia.qa.statefund.user_interfaces.OtherHealthPlanPage.INSURANCE_PLAN_NUMBER_OR_PROGRAM_NAME;
import static com.conexia.qa.statefund.user_interfaces.OtherHealthPlanPage.INSURED_FIRST_NAME;
import static com.conexia.qa.statefund.user_interfaces.OtherHealthPlanPage.INSURED_LAST_NAME;
import static com.conexia.qa.statefund.user_interfaces.OtherHealthPlanPage.INSURED_MIDDLE_NAME;
import static com.conexia.qa.statefund.user_interfaces.OtherHealthPlanPage.INSURE_POLICY_OR_GROUP_NUMBER;
import static com.conexia.qa.statefund.user_interfaces.OtherHealthPlanPage.IS_THERE_ANOTHER_HEALTH_BENEFIT_PLAN;
import static com.conexia.qa.statefund.user_interfaces.OtherHealthPlanPage.RESERVED_FOR_NUCC_USE_ONE;
import static com.conexia.qa.statefund.user_interfaces.OtherHealthPlanPage.RESERVED_FOR_NUCC_USE_TWO;
import static com.conexia.qa.statefund.user_interfaces.OtherHealthPlanPage.TITTLE;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.thucydides.core.annotations.Step;

public class FillOtherHealthPlan implements Interaction {

	private String benefitPlan;
	private String firstName;
	private String middleName;
	private String lastName;
	private String groupNumber;
	private String programName;
	private String nuccUseOne;
	private String nuccUseTwo;

	public FillOtherHealthPlan() {
		this.benefitPlan = "Yes";
		this.firstName = "Pepe";
		this.middleName = "P";
		this.lastName = "Carnitas";
		this.groupNumber = "AN1500";
		this.programName = "PNTest";
		this.nuccUseOne = "NUCC 1";
		this.nuccUseTwo = "NUCC 2";
	}

	@Override
	@Step("{0} Fill the Other Health Plan")
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(Scroll.to(TITTLE), Click.on(IS_THERE_ANOTHER_HEALTH_BENEFIT_PLAN.of(benefitPlan)));
		if (benefitPlan.equals("Yes")) {
			actor.attemptsTo(Scroll.to(TITTLE), Enter.theValue(firstName).into(INSURED_FIRST_NAME),
					Enter.theValue(middleName).into(INSURED_MIDDLE_NAME),
					Enter.theValue(lastName).into(INSURED_LAST_NAME),
					Enter.theValue(groupNumber).into(INSURE_POLICY_OR_GROUP_NUMBER));
			actor.attemptsTo(Enter.theValue(programName).into(INSURANCE_PLAN_NUMBER_OR_PROGRAM_NAME),
					Enter.theValue(nuccUseOne).into(RESERVED_FOR_NUCC_USE_ONE),
					Enter.theValue(nuccUseTwo).into(RESERVED_FOR_NUCC_USE_TWO));
		}
		Serenity.takeScreenshot();
	}

	public static FillOtherHealthPlan form() {
		return Tasks.instrumented(FillOtherHealthPlan.class);
	}

}