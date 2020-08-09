package com.conexia.qa.statefund.tasks;

import static com.conexia.qa.statefund.user_interfaces.InpatientAdmissionPage.ACCIDENT_STATE;
import static com.conexia.qa.statefund.user_interfaces.InpatientAdmissionPage.ADD_CODE;
import static com.conexia.qa.statefund.user_interfaces.InpatientAdmissionPage.ADD_REASON;
import static com.conexia.qa.statefund.user_interfaces.InpatientAdmissionPage.ADMISSION_HOUR;
import static com.conexia.qa.statefund.user_interfaces.InpatientAdmissionPage.ADMISSION_OF_CARE_DATE;
import static com.conexia.qa.statefund.user_interfaces.InpatientAdmissionPage.ADMITING_DIAGNOSIS_CODE;
import static com.conexia.qa.statefund.user_interfaces.InpatientAdmissionPage.CODE;
import static com.conexia.qa.statefund.user_interfaces.InpatientAdmissionPage.OPTION_ADMITING_DIAGNOSIS_CODE;
import static com.conexia.qa.statefund.user_interfaces.InpatientAdmissionPage.POINT_OF_ORIGIN;
import static com.conexia.qa.statefund.user_interfaces.InpatientAdmissionPage.PRIORITY_TYPE_OF_VISIT;
import static com.conexia.qa.statefund.user_interfaces.InpatientAdmissionPage.PROSPECTIVE_PAYMENT_SYSTEM_CODE;
import static com.conexia.qa.statefund.user_interfaces.InpatientAdmissionPage.REASON;
import static com.conexia.qa.statefund.user_interfaces.InpatientAdmissionPage.RESERVED_FOR_ASSIGMENT_ONE;
import static com.conexia.qa.statefund.user_interfaces.InpatientAdmissionPage.RESERVED_FOR_ASSIGMENT_TWO;
import static com.conexia.qa.statefund.user_interfaces.InpatientAdmissionPage.TITTLE;

import com.conexia.qa.statefund.interactions.ChooseMultiple;
import com.conexia.qa.statefund.interactions.Sleep;
import com.conexia.qa.statefund.interactions.Swipe;
import com.conexia.qa.statefund.interactions.Type;
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

public class FillInpatientAdmission implements Task {

	private String admisionOfCareDate;
	private String admisionHour;
	private String admitingDiagnosisCode;
	private String accidentState;
	private String priorityTypeOfVisit;
	private String pointOfOriginAdmisionOrVisit;
	private String prospectivePaymentSystemCode;
	private String reservedForAssigmentByTheNUBCOne;
	private String reason;
	private String code;
	private String reservedForAssigmentByTheNUBCTwo;

	public FillInpatientAdmission() {
		this.admisionOfCareDate = DateFunctions.actualDate();
		this.admisionHour = DateFunctions.actualHour();
		this.admitingDiagnosisCode = "G54";
		this.accidentState = "IDAHO";
		this.priorityTypeOfVisit = "A";
		this.pointOfOriginAdmisionOrVisit = "B";
		this.prospectivePaymentSystemCode = "C12";
		this.reservedForAssigmentByTheNUBCOne = "nubcOne";
		this.reason = "reason";
		this.code = "code";
		this.reservedForAssigmentByTheNUBCTwo = "nubcTwo";
	}

	@Override
	@Step("{0} Fill the Inpatient Admission form")
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(Scroll.to(TITTLE), Swipe.vertical(-150));
		actor.attemptsTo(Type.theNumber(admisionOfCareDate).into(ADMISSION_OF_CARE_DATE),
				Type.theNumber(admisionHour).into(ADMISSION_HOUR));
		actor.attemptsTo(
				ChooseMultiple.options(admitingDiagnosisCode).into(ADMITING_DIAGNOSIS_CODE,
						OPTION_ADMITING_DIAGNOSIS_CODE.called(admitingDiagnosisCode)),
				SelectFromOptions.byVisibleText(accidentState).from(ACCIDENT_STATE));
		actor.attemptsTo(Enter.theValue(priorityTypeOfVisit).into(PRIORITY_TYPE_OF_VISIT),
				Enter.theValue(pointOfOriginAdmisionOrVisit).into(POINT_OF_ORIGIN),
				Enter.theValue(prospectivePaymentSystemCode).into(PROSPECTIVE_PAYMENT_SYSTEM_CODE),
				Enter.theValue(reservedForAssigmentByTheNUBCOne).into(RESERVED_FOR_ASSIGMENT_ONE));
		actor.attemptsTo(Click.on(REASON), Enter.theValue(reason).into(REASON), Click.on(ADD_REASON));
		actor.attemptsTo(Enter.theValue(code).into(CODE), Sleep.by(350));
		actor.attemptsTo(Click.on(ADD_CODE),
				Enter.theValue(reservedForAssigmentByTheNUBCTwo).into(RESERVED_FOR_ASSIGMENT_TWO));
		Serenity.takeScreenshot();
	}

	public static FillInpatientAdmission form() {
		return Tasks.instrumented(FillInpatientAdmission.class);
	}

}