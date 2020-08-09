package com.conexia.qa.statefund.questions;

import static com.conexia.qa.statefund.user_interfaces.CreateNewUserPage.ACCESS_LEVEL_MSG_ERROR;
import static com.conexia.qa.statefund.user_interfaces.CreateNewUserPage.END_DATE_MSG_ERROR;
import static com.conexia.qa.statefund.user_interfaces.CreateNewUserPage.PHYSICIANS_MSG_ERROR;
import static com.conexia.qa.statefund.user_interfaces.CreateNewUserPage.START_DATE_MSG_ERROR;
import static com.conexia.qa.statefund.user_interfaces.CreateNewUserPage.USERNAME_MSG_ERROR;
import static com.conexia.qa.statefund.user_interfaces.CreateNewUserPage.WORKPLACES_MSG_ERROR;
import static net.serenitybdd.core.Serenity.takeScreenshot;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

/**
 * @author ChristianSchottlander
 **/
public class ShowTheMessageInNewUser implements Question<Boolean> {

	private String message;
	private String field;

	public ShowTheMessageInNewUser(String message, String field) {
		this.message = message.trim();
		this.field = field.trim();
	}

	@Override
	public Boolean answeredBy(Actor actor) {
		takeScreenshot();
		switch (field) {
		case "start date":
			return START_DATE_MSG_ERROR.of(message).resolveFor(actor).isVisible();
		case "end date":
			return END_DATE_MSG_ERROR.of(message).resolveFor(actor).isVisible();
		case "username":
			return USERNAME_MSG_ERROR.of(message).resolveFor(actor).isVisible();
		case "access level":
			return ACCESS_LEVEL_MSG_ERROR.of(message).resolveFor(actor).isVisible();
		case "workplace":
			return WORKPLACES_MSG_ERROR.of(message).resolveFor(actor).isVisible();
		case "physician":
			return PHYSICIANS_MSG_ERROR.of(message).resolveFor(actor).isVisible();
		}
		return false;
	}

	public static ShowTheMessageInNewUser forField(String message, String field) {
		return new ShowTheMessageInNewUser(message, field);
	}

}