package com.conexia.qa.statefund.tasks;

import static com.conexia.qa.statefund.user_interfaces.MenuItemPage.SEARCH_USER;
import static com.conexia.qa.statefund.user_interfaces.MenuItemPage.USER_MANAGEMENT;
import static com.conexia.qa.statefund.user_interfaces.SearchUserPage.EMAIL;
import static com.conexia.qa.statefund.user_interfaces.SearchUserPage.FIRST_NAME;
import static com.conexia.qa.statefund.user_interfaces.SearchUserPage.LAST_NAME;
import static com.conexia.qa.statefund.user_interfaces.SearchUserPage.MIDDLE_INITIAL;
import static com.conexia.qa.statefund.user_interfaces.SearchUserPage.USERNAME;

import com.conexia.qa.statefund.interactions.AgreeTermsAndPolicies;
import com.conexia.qa.statefund.interactions.WaitLoading;
import com.conexia.qa.statefund.user_interfaces.SearchUserPage;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

public class FillUserField implements Task {

	public String user;
	public String mail;
	public String firstName;
	public String middleInitial;
	public String lastName;
	public String typeSearch;

	public FillUserField(String user, String mail, String firstName, String middleInitial, String lastName,
			String typeSearch) {
		this.user = user;
		this.mail = mail;
		this.firstName = firstName;
		this.middleInitial = middleInitial;
		this.lastName = lastName;
		this.typeSearch = typeSearch;
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(AgreeTermsAndPolicies.afterLogin(), Click.on(USER_MANAGEMENT), Click.on(SEARCH_USER),
				WaitLoading.page());
		switch (typeSearch) {
		case "user":
			actor.attemptsTo(Enter.theValue(user).into(USERNAME));
			break;
		case "mail":
			actor.attemptsTo(Enter.theValue(mail).into(EMAIL));
			break;
		case "firstName":
			actor.attemptsTo(Enter.theValue(firstName).into(FIRST_NAME));
			break;
		case "middleInitial":
			actor.attemptsTo(Enter.theValue(middleInitial).into(MIDDLE_INITIAL));
			break;
		case "lastName":
			actor.attemptsTo(Enter.theValue(lastName).into(LAST_NAME));
			break;
		case "firstName-MiddleInitial-LastName":
			actor.attemptsTo(Enter.theValue(firstName).into(FIRST_NAME));
			actor.attemptsTo(Enter.theValue(middleInitial).into(MIDDLE_INITIAL));
			actor.attemptsTo(Enter.theValue(lastName).into(LAST_NAME));
			break;
		default:
			break;
		}
		actor.attemptsTo(Click.on(SearchUserPage.SEARCH), WaitLoading.page());
	}

	public static FillUserField withUser(String user) {
		return Tasks.instrumented(FillUserField.class, user, null, null, null, null, "user");
	}

	public static FillUserField withMail(String mail) {
		return Tasks.instrumented(FillUserField.class, null, mail, null, null, null, "mail");
	}

	public static FillUserField withFirstName(String firstName) {
		return Tasks.instrumented(FillUserField.class, null, null, firstName, null, null, "firstName");
	}

	public static FillUserField withMiddleInitial(String middleInitial) {
		return Tasks.instrumented(FillUserField.class, null, null, null, middleInitial, null, "middleInitial");
	}

	public static FillUserField withLastName(String lastName) {
		return Tasks.instrumented(FillUserField.class, null, null, null, null, lastName, "lastName");
	}

	public static FillUserField withFirstNameMiddleInitialLastName(String firstName, String middleInitial,
			String lastName) {
		return Tasks.instrumented(FillUserField.class, null, null, firstName, middleInitial, lastName,
				"firstName-MiddleInitial-LastName");
	}

}