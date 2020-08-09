package com.conexia.qa.statefund.tasks;

import com.conexia.qa.statefund.user_interfaces.HomePage;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

public class SelectPhysician implements Task {

	private String physician;

	public SelectPhysician(String physician) {
		this.physician = physician;
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(Click.on(HomePage.NAME_And_LAST_NAME));
		Serenity.takeScreenshot();
		actor.attemptsTo(Click.on(HomePage.PHYSICIAN_LIST));
		Serenity.takeScreenshot();
		actor.attemptsTo(Click.on(HomePage.PHYSICIAN.of(physician)));
	}

	public static SelectPhysician by(String physician) {
		return Tasks.instrumented(SelectPhysician.class, physician);
	}

}