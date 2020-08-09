package com.conexia.qa.statefund.questions;

import static com.conexia.qa.statefund.user_interfaces.CreateNewUserPage.ACCESS_LEVEL_MSG_ERROR;
import static com.conexia.qa.statefund.user_interfaces.CreateNewUserPage.EMAIL_ADDRESS_MSG_ERROR;
import static com.conexia.qa.statefund.user_interfaces.CreateNewUserPage.END_DATE_MSG_ERROR;
import static com.conexia.qa.statefund.user_interfaces.CreateNewUserPage.FIRST_NAME_MSG_ERROR;
import static com.conexia.qa.statefund.user_interfaces.CreateNewUserPage.LAST_NAME_MSG_ERROR;
import static com.conexia.qa.statefund.user_interfaces.CreateNewUserPage.PHYSICIANS_MSG_ERROR;
import static com.conexia.qa.statefund.user_interfaces.CreateNewUserPage.START_DATE_MSG_ERROR;
import static com.conexia.qa.statefund.user_interfaces.CreateNewUserPage.TELEPHONE_MSG_ERROR;
import static com.conexia.qa.statefund.user_interfaces.CreateNewUserPage.USERNAME_MSG_ERROR;
import static com.conexia.qa.statefund.user_interfaces.CreateNewUserPage.WORKPLACES_MSG_ERROR;
import static com.conexia.qa.statefund.user_interfaces.EditUserPage.ACCESS_LEVEL_IS_REQUERED;
import static com.conexia.qa.statefund.user_interfaces.EditUserPage.END_DATE_IS_REQUERED;
import static com.conexia.qa.statefund.user_interfaces.EditUserPage.PHYSICIAN_IS_REQUERED;
import static com.conexia.qa.statefund.user_interfaces.EditUserPage.START_DATE_IS_REQUERED;
import static com.conexia.qa.statefund.user_interfaces.EditUserPage.WORKPLACE_IS_REQUERED;
import static net.serenitybdd.core.Serenity.takeScreenshot;

import com.conexia.qa.statefund.interactions.Swipe;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

/**
 * @author ChristianSchottlaender
 **/
public class SeeDisplaysAlertRequiredFields implements Question<Boolean> {

	private String form;
	private String message;

	public SeeDisplaysAlertRequiredFields(String form, String message) {
		this.form = form;
		this.message = message.trim();
	}

	@Override
	public Boolean answeredBy(Actor actor) {
		int fail = 0;

		takeScreenshot();

		switch (form) {
		case "edit user":
			if (!START_DATE_IS_REQUERED.of(message).resolveFor(actor).isVisible()) {
				fail++;
			}
			if (!END_DATE_IS_REQUERED.of(message).resolveFor(actor).isVisible()) {
				fail++;
			}
			if (!ACCESS_LEVEL_IS_REQUERED.of(message).resolveFor(actor).isVisible()) {
				fail++;
			}
			if (!PHYSICIAN_IS_REQUERED.of(message).resolveFor(actor).isVisible()) {
				fail++;
			}
			if (!WORKPLACE_IS_REQUERED.of(message).resolveFor(actor).isVisible()) {
				fail++;
			}
			break;
		case "new user":
			if (!FIRST_NAME_MSG_ERROR.of(message).resolveFor(actor).isVisible()) {
				fail++;
			}
			if (!LAST_NAME_MSG_ERROR.of(message).resolveFor(actor).isVisible()) {
				fail++;
			}
			if (!EMAIL_ADDRESS_MSG_ERROR.of(message).resolveFor(actor).isVisible()) {
				fail++;
			}
			if (!USERNAME_MSG_ERROR.of(message).resolveFor(actor).isVisible()) {
				fail++;
			}
			if (!TELEPHONE_MSG_ERROR.of(message).resolveFor(actor).isVisible()) {
				fail++;
			}
			if (!START_DATE_MSG_ERROR.of(message).resolveFor(actor).isVisible()) {
				fail++;
			}
			if (!END_DATE_MSG_ERROR.of(message).resolveFor(actor).isVisible()) {
				fail++;
			}
			actor.attemptsTo(Swipe.vertical(300));
			if (!ACCESS_LEVEL_MSG_ERROR.of(message).resolveFor(actor).isVisible()) {
				fail++;
			}
			if (!WORKPLACES_MSG_ERROR.of(message).resolveFor(actor).isVisible()) {
				fail++;
			}
			if (!PHYSICIANS_MSG_ERROR.of(message).resolveFor(actor).isVisible()) {
				fail++;
			}
			break;
		}
		takeScreenshot();
		if (fail > 0) {
			return false;
		} else {
			return true;
		}
	}

	public static SeeDisplaysAlertRequiredFields inEditUser(String message) {
		return new SeeDisplaysAlertRequiredFields("edit user", message);
	}

	public static SeeDisplaysAlertRequiredFields inNewUser(String message) {
		return new SeeDisplaysAlertRequiredFields("new user", message);
	}

}