package com.conexia.qa.statefund.tasks;

import com.conexia.qa.statefund.user_interfaces.GenericEmailPage;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Open;

public class GenericEmail implements Task {

	private boolean goToPage;

	public GenericEmail(boolean goToPage) {
		this.goToPage = goToPage;
	}

	@Override
	public <T extends Actor> void performAs(T actor) {

		if (goToPage) {
			actor.attemptsTo(Open.url("https://correotemporal.org"));
		} else {
			GenericEmailModel.setEmailTemp(GenericEmailPage.EMAIL_TEMP.resolveFor(actor).getAttribute("value"));
		}
	}

	public static GenericEmail readEmailGenerated() {
		return Tasks.instrumented(GenericEmail.class, false);
	}

	public static GenericEmail goToPage() {
		return Tasks.instrumented(GenericEmail.class, true);
	}

}
