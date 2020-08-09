package com.conexia.qa.statefund.tasks;

import static com.conexia.qa.statefund.user_interfaces.EditUserPage.ACCESS_LEVEL;
import static com.conexia.qa.statefund.user_interfaces.EditUserPage.ACCESS_LEVEl_SELECT;
import static com.conexia.qa.statefund.user_interfaces.EditUserPage.ACTIVE_MARK;
import static com.conexia.qa.statefund.user_interfaces.EditUserPage.END_DATE;
import static com.conexia.qa.statefund.user_interfaces.EditUserPage.PHYSICIAN;
import static com.conexia.qa.statefund.user_interfaces.EditUserPage.PHYSICIAN_SELECT;
import static com.conexia.qa.statefund.user_interfaces.EditUserPage.START_DATE;
import static com.conexia.qa.statefund.user_interfaces.EditUserPage.WORKPLACE;
import static com.conexia.qa.statefund.user_interfaces.EditUserPage.WORKPLACE_SELECT;
import static net.serenitybdd.core.Serenity.takeScreenshot;

import com.conexia.qa.statefund.interactions.Swipe;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

/**
 * @author ChristianSchottlaender
 **/
public class EditUser implements Task {

	private String startDate;
	private String endDate;
	private String typeEdit;
	private String accessLeven;
	private String physician;
	private String workplace;

	public EditUser(String startDate, String endDate, String accessLeven, String workplace, String physician,
			String typeEdit) {
		this.startDate = startDate;
		this.endDate = endDate;
		this.accessLeven = accessLeven;
		this.typeEdit = typeEdit;
		this.workplace = workplace;
		this.physician = physician;
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		takeScreenshot();
		switch (typeEdit) {
		case "Dates":
			actor.attemptsTo(Enter.theValue(startDate).into(START_DATE));
			actor.attemptsTo(Enter.theValue(endDate).into(END_DATE));
			break;
		case "accessLevel":
			actor.attemptsTo(Click.on(ACCESS_LEVEL));
			actor.attemptsTo(Click.on(ACCESS_LEVEl_SELECT.of(accessLeven)));
			break;
		case "Workplace":
			actor.attemptsTo(Click.on(WORKPLACE));
			actor.attemptsTo(Click.on(WORKPLACE_SELECT.of(workplace)));
			break;
		case "physician":
			actor.attemptsTo(Swipe.vertical(200));
			takeScreenshot();
			actor.attemptsTo(Click.on(PHYSICIAN));
			actor.attemptsTo(Click.on(PHYSICIAN_SELECT.of(physician)));
			break;
		case "activeMarck":
			actor.attemptsTo(Swipe.vertical(200));
			takeScreenshot();
			actor.attemptsTo(Click.on(ACTIVE_MARK));
			break;
		default:
			break;
		}
		takeScreenshot();
		actor.attemptsTo(Swipe.vertical(200));
		takeScreenshot();
	}

	public static EditUser withFiels(String startDate, String endDate) {
		return Tasks.instrumented(EditUser.class, startDate, endDate, null, null, null, "Dates");
	}

	public static EditUser accessLevel(String accessLevel) {
		return Tasks.instrumented(EditUser.class, null, null, accessLevel, null, null, "accessLevel");
	}

	public static EditUser workplace(String Workplace) {
		return Tasks.instrumented(EditUser.class, null, null, null, Workplace, null, "Workplace");
	}

	public static EditUser physician(String physician) {
		return Tasks.instrumented(EditUser.class, null, null, null, null, physician, "physician");
	}

	public static EditUser activeMark() {
		return Tasks.instrumented(EditUser.class, null, null, null, null, null, "activeMarck");
	}

}