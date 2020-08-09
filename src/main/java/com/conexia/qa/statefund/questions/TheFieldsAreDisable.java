package com.conexia.qa.statefund.questions;

import static com.conexia.qa.statefund.user_interfaces.EditUserPage.ACCESS_LEVEL_DIV;
import static com.conexia.qa.statefund.user_interfaces.EditUserPage.ACTIVE_MARK_DIV;
import static com.conexia.qa.statefund.user_interfaces.EditUserPage.EMAIL_ADDRESS;
import static com.conexia.qa.statefund.user_interfaces.EditUserPage.FIRST_NAME;
import static com.conexia.qa.statefund.user_interfaces.EditUserPage.LAST_NAME;
import static com.conexia.qa.statefund.user_interfaces.EditUserPage.MIDDLE_INITIAL;
import static com.conexia.qa.statefund.user_interfaces.EditUserPage.MOBILE;
import static com.conexia.qa.statefund.user_interfaces.EditUserPage.PHYSICIAN;
import static com.conexia.qa.statefund.user_interfaces.EditUserPage.TELEPHONE;
import static com.conexia.qa.statefund.user_interfaces.EditUserPage.USERNAME;
import static com.conexia.qa.statefund.user_interfaces.EditUserPage.WORKPLACE;
import static net.serenitybdd.core.Serenity.takeScreenshot;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

/**
 * @author ChristianSchottlaender
 **/
public class TheFieldsAreDisable implements Question<Boolean> {

	public boolean isUserAdmin;

	public TheFieldsAreDisable(boolean isUserAdmin) {
		this.isUserAdmin = isUserAdmin;
	}

	@Override
	public Boolean answeredBy(Actor actor) {
		takeScreenshot();
		if (FIRST_NAME.resolveFor(actor).isEnabled()) {
			System.out.println("FIRST_NAME:" + FIRST_NAME.resolveFor(actor).isEnabled());
			return false;
		}
		if (LAST_NAME.resolveFor(actor).isEnabled()) {
			System.out.println("LAST_NAME:" + LAST_NAME.resolveFor(actor).isEnabled());
			return false;
		}
		if (EMAIL_ADDRESS.resolveFor(actor).isEnabled()) {
			System.out.println("EMAIL_ADDRESS:" + EMAIL_ADDRESS.resolveFor(actor).isEnabled());
			return false;
		}
		if (MIDDLE_INITIAL.resolveFor(actor).isEnabled()) {
			System.out.println("MIDDLE_INITIAL:" + MIDDLE_INITIAL.resolveFor(actor).isEnabled());
			return false;
		}
		if (USERNAME.resolveFor(actor).isEnabled()) {
			System.out.println("USERNAME:" + USERNAME.resolveFor(actor).isEnabled());
			return false;
		}
		if (TELEPHONE.resolveFor(actor).isEnabled()) {
			System.out.println("TELEPHONE:" + TELEPHONE.resolveFor(actor).isEnabled());
			return false;
		}
		if (MOBILE.resolveFor(actor).isEnabled()) {
			System.out.println("MOBILE:" + MOBILE.resolveFor(actor).isEnabled());
			return false;
		}
		takeScreenshot();
		if (isUserAdmin) {
			if (!ACCESS_LEVEL_DIV.resolveFor(actor).getAttribute("class").contains("ui-state-disabled")) {
				System.out.println("ACCESS_LEVEL_DIV:" + ACCESS_LEVEL_DIV.resolveFor(actor).getAttribute("class"));
				return false;
			}
			if (!WORKPLACE.resolveFor(actor).getAttribute("class").contains("ui-state-disabled")) {
				System.out.println("WORKPLACE:" + WORKPLACE.resolveFor(actor).getAttribute("class"));
				return false;
			}
			if (!PHYSICIAN.resolveFor(actor).getAttribute("class").contains("ui-state-disabled")) {
				System.out.println("PHYSICIAN:" + PHYSICIAN.resolveFor(actor).getAttribute("class"));
				return false;
			}
			if (ACTIVE_MARK_DIV.resolveFor(actor).isEnabled()) {
				System.out.println("ACTIVE_MARK:" + ACTIVE_MARK_DIV.resolveFor(actor).isEnabled());
				return false;
			}
		}
		return true;
	}

	public static TheFieldsAreDisable inFormEditUser() {
		return new TheFieldsAreDisable(false);
	}

	public static TheFieldsAreDisable inFormEditUserAdmin() {
		return new TheFieldsAreDisable(true);
	}

}