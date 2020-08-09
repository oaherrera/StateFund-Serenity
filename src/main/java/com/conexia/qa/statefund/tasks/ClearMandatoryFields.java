package com.conexia.qa.statefund.tasks;

import static com.conexia.qa.statefund.user_interfaces.EditUserPage.DELETE_PHYSICIAN;
import static com.conexia.qa.statefund.user_interfaces.EditUserPage.DELETE_WORKPLACE;
import static com.conexia.qa.statefund.user_interfaces.EditUserPage.END_DATE;
import static com.conexia.qa.statefund.user_interfaces.EditUserPage.START_DATE;
import static net.serenitybdd.core.Serenity.takeScreenshot;

import java.util.List;

import com.conexia.qa.statefund.interactions.Sleep;
import com.conexia.qa.statefund.interactions.Swipe;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Enter;

public class ClearMandatoryFields implements Task {

	@Override
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(Swipe.vertical(500));
		takeScreenshot();
		List<WebElementFacade> buttonsDeletePhysician = DELETE_PHYSICIAN.resolveAllFor(actor);
		List<WebElementFacade> buttonsDeleteWorkplace = DELETE_WORKPLACE.resolveAllFor(actor);
		int index = 0;
		while (index < buttonsDeletePhysician.size()) {
			buttonsDeletePhysician.get(index).click();
			index++;
		}
		index = 0;
		while (index < buttonsDeleteWorkplace.size()) {
			buttonsDeleteWorkplace.get(index).click();
			index++;
		}
		actor.attemptsTo(Enter.theValue(" ").into(START_DATE));
		actor.attemptsTo(Enter.theValue(" ").into(END_DATE));
		actor.attemptsTo(Sleep.by(1000));
		takeScreenshot();
	}

	public static ClearMandatoryFields inEditUser() {
		return Tasks.instrumented(ClearMandatoryFields.class);
	}

}