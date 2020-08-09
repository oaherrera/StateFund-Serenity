package com.conexia.qa.statefund.tasks;

import static com.conexia.qa.statefund.user_interfaces.ClaimSearchPage.ACTION_VIEW;
import static com.conexia.qa.statefund.user_interfaces.ClaimSearchPage.CLAIM_NUMBER_LABEL;
import static com.conexia.qa.statefund.user_interfaces.ClaimSearchPage.SUBMIT_RFA;

import com.conexia.qa.statefund.interactions.WaitElement;
import com.conexia.qa.statefund.interactions.WaitLoading;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.thucydides.core.annotations.Step;

public class ViewClaimDetail implements Task {

	private String claimNumber;

	public ViewClaimDetail(String claimNumber) {
		this.claimNumber = claimNumber;
	}

	@Override
	@Step("{0} view claim details - Claim Numbre: #claimNumber")
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(Click.on(ACTION_VIEW), WaitLoading.page(),
				WaitElement.untilAppears(CLAIM_NUMBER_LABEL.of(claimNumber)));
		Serenity.takeScreenshot();
		actor.attemptsTo(Scroll.to(SUBMIT_RFA), Click.on(SUBMIT_RFA), WaitLoading.page());
	}

	public static ViewClaimDetail number(String claimNumber) {
		return Tasks.instrumented(ViewClaimDetail.class, claimNumber);
	}

}