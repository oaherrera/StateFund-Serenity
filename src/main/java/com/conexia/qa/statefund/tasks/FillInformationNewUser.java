package com.conexia.qa.statefund.tasks;

import static com.conexia.qa.statefund.user_interfaces.CreateNewUserPage.ACCESS_LEVEL;
import static com.conexia.qa.statefund.user_interfaces.CreateNewUserPage.ACCESS_LEVEL_LIST;
import static com.conexia.qa.statefund.user_interfaces.CreateNewUserPage.ACTIVE;
import static com.conexia.qa.statefund.user_interfaces.CreateNewUserPage.EMAIL_ADDRESS;
import static com.conexia.qa.statefund.user_interfaces.CreateNewUserPage.END_DATE;
import static com.conexia.qa.statefund.user_interfaces.CreateNewUserPage.FIRST_NAME;
import static com.conexia.qa.statefund.user_interfaces.CreateNewUserPage.LAST_NAME;
import static com.conexia.qa.statefund.user_interfaces.CreateNewUserPage.MIDDLE_INITIAL;
import static com.conexia.qa.statefund.user_interfaces.CreateNewUserPage.MOBILE;
import static com.conexia.qa.statefund.user_interfaces.CreateNewUserPage.PHYSICIANS;
import static com.conexia.qa.statefund.user_interfaces.CreateNewUserPage.PHYSICIANS_LIST;
import static com.conexia.qa.statefund.user_interfaces.CreateNewUserPage.SAVE;
import static com.conexia.qa.statefund.user_interfaces.CreateNewUserPage.START_DATE;
import static com.conexia.qa.statefund.user_interfaces.CreateNewUserPage.TELEPHONE;
import static com.conexia.qa.statefund.user_interfaces.CreateNewUserPage.USER_NAME;
import static com.conexia.qa.statefund.user_interfaces.CreateNewUserPage.WORKPLACES;
import static com.conexia.qa.statefund.user_interfaces.CreateNewUserPage.WORKPLACES_LIST;
import static net.serenitybdd.core.Serenity.takeScreenshot;

import com.conexia.qa.statefund.interactions.Sleep;
import com.conexia.qa.statefund.interactions.Type;
import com.conexia.qa.statefund.interactions.WaitLoading;
import com.conexia.qa.statefund.models.CreateNewUser;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.thucydides.core.annotations.Step;

public class FillInformationNewUser implements Task {

	private String FirstName;
	private String MiddleInitial;
	private String LastName;
	private String UserName;
	private String emailAddress;
	private String Telephone;
	private String Mobile;
	private String StartDate;
	private String EndDate;
	private String AccessLevel;
	private String Workplaces;
	private String Physicians;
	private String Active;

	public FillInformationNewUser() {
		this.FirstName = CreateNewUser.readData(0).getFirstName();
		this.MiddleInitial = CreateNewUser.readData(0).getMiddleInitial();
		this.LastName = CreateNewUser.readData(0).getLastName();
		this.UserName = CreateNewUser.readData(0).getUser();
		this.emailAddress = CreateNewUser.readData(0).getEmailAddress();
		this.Telephone = CreateNewUser.readData(0).getTelephone();
		this.Mobile = CreateNewUser.readData(0).getMobile();
		this.StartDate = CreateNewUser.readData(0).getStartDate();
		this.EndDate = CreateNewUser.readData(0).getEndDate();
		this.AccessLevel = CreateNewUser.readData(0).getAccessLevel();
		this.Workplaces = CreateNewUser.readData(0).getWorkplaces();
		this.Physicians = CreateNewUser.readData(0).getPhysicians();
		this.Active = CreateNewUser.readData(0).getActive();
	}

	@Override
	@Step("{0} Fill Information New User")
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(WaitLoading.page(), Enter.theValue(FirstName).into(FIRST_NAME),
				Enter.theValue(MiddleInitial).into(MIDDLE_INITIAL), Enter.theValue(LastName).into(LAST_NAME),
				Enter.theValue(UserName).into(USER_NAME), Enter.theValue(emailAddress).into(EMAIL_ADDRESS),
				Type.theNumber(Telephone).into(TELEPHONE), Type.theNumber(Mobile).into(MOBILE),
				Type.theNumber(StartDate).into(START_DATE), Type.theNumber(EndDate).into(END_DATE),Sleep.by(200));
		takeScreenshot();
		actor.attemptsTo(Scroll.to(SAVE));
		if (!AccessLevel.trim().equals("")) {
			actor.attemptsTo(Click.on(ACCESS_LEVEL_LIST), Sleep.by(600), Click.on(ACCESS_LEVEL.of(AccessLevel)),
					Sleep.by(600));
		}
		if (!Workplaces.trim().equals("")) {
			actor.attemptsTo(Click.on(WORKPLACES_LIST), Sleep.by(600), Click.on(WORKPLACES.of(Workplaces)),
					Sleep.by(600), Click.on(WORKPLACES_LIST));
		}
		if (!Physicians.trim().equals("")) {
			actor.attemptsTo(Click.on(PHYSICIANS_LIST), Sleep.by(600), Click.on(PHYSICIANS.of(Physicians)),
					Sleep.by(600));
		}
		if (Active.trim().equalsIgnoreCase("yes")) {
			actor.attemptsTo(Sleep.by(2000), Click.on(ACTIVE));
		}
		takeScreenshot();
	}

	public static FillInformationNewUser fields() {
		return Tasks.instrumented(FillInformationNewUser.class);
	}

}