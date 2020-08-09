package com.conexia.qa.statefund.tasks;

import static com.conexia.qa.statefund.user_interfaces.HomePage.BELL_NOTIFICATION;
import static com.conexia.qa.statefund.user_interfaces.NotificationPage.SHOW_ALL;
import static net.serenitybdd.core.Serenity.takeScreenshot;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

public class GoToAllNotificationUser implements Task {

	@Override
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(Click.on(BELL_NOTIFICATION));
		takeScreenshot();
		actor.attemptsTo(Click.on(SHOW_ALL));
		takeScreenshot();
	}

	public static GoToAllNotificationUser forUser() {
		return Tasks.instrumented(GoToAllNotificationUser.class);
	}

}