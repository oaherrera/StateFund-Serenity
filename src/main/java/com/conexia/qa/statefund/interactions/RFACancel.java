package com.conexia.qa.statefund.interactions;

import static com.conexia.qa.statefund.user_interfaces.CommonPage.CANCEL;
import static net.serenitybdd.core.Serenity.takeScreenshot;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;

public class RFACancel implements Interaction {

	public RFACancel() {
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		takeScreenshot();
		actor.attemptsTo(Scroll.to(CANCEL), Click.on(CANCEL));
		takeScreenshot();
	}

	public static RFACancel toProcess() {
		return Tasks.instrumented(RFACancel.class);
	}

}