package com.conexia.qa.statefund.tasks;

import static com.conexia.qa.statefund.user_interfaces.DocumentAttachmentPage.DOWNLOAD;

import com.conexia.qa.statefund.interactions.AcceptNotification;
import com.conexia.qa.statefund.interactions.AgreeTermsAndPolicies;
import com.conexia.qa.statefund.interactions.WaitLoading;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

public class DownloadNonClaim implements Task {

	@Override
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(AgreeTermsAndPolicies.ofTransaction(), WaitLoading.page(), AcceptNotification.popUp(DOWNLOAD));
	}

	public static DownloadNonClaim rfa() {
		return Tasks.instrumented(DownloadNonClaim.class);
	}

}