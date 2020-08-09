package com.conexia.qa.statefund.questions;

import static com.conexia.qa.statefund.user_interfaces.NotificationPage.NOTIFICATIONS_TYPE;

import com.conexia.qa.statefund.interactions.Sleep;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ShowAllNotification implements Question<Boolean> {

	private String messageNotification;

	private ShowAllNotification(String messageNotification) {
		this.messageNotification = messageNotification.trim();
	}

	@Override
	public Boolean answeredBy(Actor actor) {
		actor.attemptsTo(Sleep.by(1000));

		switch (messageNotification) {
		case "You have an Update for Claim Number/RFA Number Claim Number":
			System.out.println("entro");
			int CountNotification = NOTIFICATIONS_TYPE.of("NEW CLAIM").resolveAllFor(actor).size();
			System.out.println("Cantidad:" + CountNotification);
			if (CountNotification >= 1) {
				return true;
			}
			break;
		}
		return false;
	}

	public static ShowAllNotification ofMessage(String messageNotification) {
		return new ShowAllNotification(messageNotification);
	}

}