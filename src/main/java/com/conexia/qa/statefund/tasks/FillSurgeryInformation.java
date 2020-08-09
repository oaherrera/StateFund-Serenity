package com.conexia.qa.statefund.tasks;

import static com.conexia.qa.statefund.user_interfaces.CommonPage.NEXT;
import static com.conexia.qa.statefund.user_interfaces.SurgeryInformationPage.ADD;
import static com.conexia.qa.statefund.user_interfaces.SurgeryInformationPage.CODE;
import static com.conexia.qa.statefund.user_interfaces.SurgeryInformationPage.DATE;
import static com.conexia.qa.statefund.user_interfaces.SurgeryInformationPage.TITTLE;
import static com.conexia.qa.statefund.user_interfaces.SurgeryInformationPage.TYPE;
import static com.conexia.qa.statefund.user_interfaces.SurgeryInformationPage.WAS_A_SURGERY_PERFORMED;

import com.conexia.qa.statefund.interactions.Type;
import com.conexia.qa.statefund.interactions.WaitLoading;
import com.conexia.qa.statefund.utils.DateFunctions;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.thucydides.core.annotations.Step;

public class FillSurgeryInformation implements Task {

	private String wasASurgeryPerformed;
	private String code;
	private String date;

	public FillSurgeryInformation() {
		this.wasASurgeryPerformed = "Yes";
		this.code = "72170";
		this.date = DateFunctions.actualDate();
	}

	@Override
	@Step("{0} Fill the Surgery Information form")
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(Scroll.to(TITTLE), Click.on(WAS_A_SURGERY_PERFORMED.of(wasASurgeryPerformed)));
		if (wasASurgeryPerformed.equals("Yes")) {
			actor.attemptsTo(Enter.theValue(code).into(CODE), Type.theNumber(date).into(DATE), Click.on(TYPE),
					Click.on(ADD), WaitLoading.page());
			actor.attemptsTo(Scroll.to(NEXT), AddAttendingSurgery.information(), WaitLoading.page(),
					AddOperatingSurgery.information(), WaitLoading.page(), AddOtherSurgery.information(),
					WaitLoading.page());
		}
		Serenity.takeScreenshot();
	}

	public static FillSurgeryInformation form() {
		return Tasks.instrumented(FillSurgeryInformation.class);
	}

}