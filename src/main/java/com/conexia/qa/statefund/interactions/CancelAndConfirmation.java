package com.conexia.qa.statefund.interactions;

import static net.serenitybdd.core.Serenity.takeScreenshot;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

/**
 * @author ChristianSchottlaender
 **/
public class CancelAndConfirmation implements Task {

	public boolean yesOrNot;

	public CancelAndConfirmation(boolean yesOrNot) {
		this.yesOrNot = yesOrNot;
	}

	public CancelAndConfirmation() {
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(Swipe.vertical(400));
		takeScreenshot();
		if (yesOrNot) {
			actor.attemptsTo(ClickOn.buttonCancel());
			takeScreenshot();
			actor.attemptsTo(ClickOn.buttonConfirmateYes());
		} else {
			actor.attemptsTo(ClickOn.buttonCancel());
			takeScreenshot();
			actor.attemptsTo(ClickOn.buttonConfirmateNo());
		}
		takeScreenshot();
	}

	public static CancelAndConfirmation withoutSaving(boolean yesOrNot) {
		return Tasks.instrumented(CancelAndConfirmation.class, yesOrNot);
	}

}