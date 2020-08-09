package com.conexia.qa.statefund.tasks;

import com.conexia.qa.statefund.interactions.Swipe;
import com.conexia.qa.statefund.interactions.WaitLoading;
import com.conexia.qa.statefund.user_interfaces.ClaimDetailsPage;
import com.conexia.qa.statefund.user_interfaces.CommonPage;
import com.conexia.qa.statefund.user_interfaces.TreatmentHistoryPage;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.questions.Text;
import net.thucydides.core.annotations.Step;

public class SpecificationClaimDetails implements Task {

	@Override
	@Step("{0} Specification Claim Details")
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(Scroll.to(ClaimDetailsPage.CLAIM_DETAILS), Swipe.vertical(-50));
		Serenity.takeScreenshot();
		actor.attemptsTo(Click.on(ClaimDetailsPage.REQUESTED_BODY_PARTS), WaitLoading.page());
		Serenity.takeScreenshot();
		actor.attemptsTo(Click.on(CommonPage.CLOSE_POP_UP), Click.on(ClaimDetailsPage.RELATED_CLAIMS),
				WaitLoading.page());
		Serenity.takeScreenshot();
		actor.attemptsTo(Click.on(CommonPage.CLOSE_POP_UP), Click.on(TreatmentHistoryPage.ROW_SPECIFICATION_RFA),
				WaitLoading.page());
		Serenity.takeScreenshot();
		actor.attemptsTo(
				Click.on(TreatmentHistoryPage.SEE_ATTACHED_DOCUMENTS
						.of(Text.of(TreatmentHistoryPage.RFA_ID_UNDEFINED).viewedBy(actor).asString())),
				WaitLoading.page());
		Serenity.takeScreenshot();
		actor.attemptsTo(Click.on(CommonPage.CLOSE_POP_UP), Scroll.to(ClaimDetailsPage.SUBMIT_RFA));
		Serenity.takeScreenshot();
	}

	public static SpecificationClaimDetails view() {
		return Tasks.instrumented(SpecificationClaimDetails.class);
	}

}