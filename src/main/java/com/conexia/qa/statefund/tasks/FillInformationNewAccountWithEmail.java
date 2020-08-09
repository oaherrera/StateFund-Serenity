package com.conexia.qa.statefund.tasks;

import com.conexia.qa.statefund.interactions.Sleep;
import com.conexia.qa.statefund.interactions.Type;
import com.conexia.qa.statefund.interactions.WaitLoading;
import com.conexia.qa.statefund.models.CreateNewAccount;
import com.conexia.qa.statefund.questions.SendMail;
import com.conexia.qa.statefund.user_interfaces.SignUpPage;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;

public class FillInformationNewAccountWithEmail implements Task {
	private String firstName;
	private String middleInitial;
	private String lastName;
	private String userName;
	private String email;
	private String confirmEmail;
	private String telephone;
	private String mobile;
	private String password;
	private String confirmPassword;
	private String active;

	public FillInformationNewAccountWithEmail(int index) {
		this.firstName = CreateNewAccount.readData(index).getFirstName();
		this.middleInitial = CreateNewAccount.readData(index).getMiddleInitial();
		this.lastName = CreateNewAccount.readData(index).getLastName();
		this.userName = CreateNewAccount.readData(index).getUserName();
		this.email = CreateNewAccount.readData(index).getEmail();
		this.confirmEmail = CreateNewAccount.readData(index).getConfirmEmail();
		this.telephone = CreateNewAccount.readData(index).getTelephone();
		this.mobile = CreateNewAccount.readData(index).getMobile();
		this.password = CreateNewAccount.readData(index).getPassword();
		this.confirmPassword = CreateNewAccount.readData(index).getConfirmPassword();
		this.active = CreateNewAccount.readData(index).getActive();
	}

	@Override
	@Step("{0} Fill Information New Account")
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(Enter.theValue(firstName).into(SignUpPage.FIRST_NAME),
				Enter.theValue(middleInitial).into(SignUpPage.MIDDLE_INITIAL),
				Enter.theValue(lastName).into(SignUpPage.LAST_NAME));
		if (!userName.isEmpty() && !email.isEmpty() && !confirmEmail.isEmpty()) {
			actor.attemptsTo(Enter.theValue(userName).into(SignUpPage.USERNAME),
					Enter.theValue(email).into(SignUpPage.EMAIL),
					Enter.theValue(confirmEmail).into(SignUpPage.CONFIRM_EMAIL));
		} else {
			actor.attemptsTo(NavigationBetweenTabs.createNewTab());
			actor.attemptsTo(NavigationBetweenTabs.switchTo(2));
			actor.attemptsTo(GenericEmail.goToPage());
			actor.attemptsTo(GenericEmail.readEmailGenerated());
			actor.attemptsTo(NavigationBetweenTabs.switchTo(1), Sleep.by(200));
			actor.attemptsTo(Enter.theValue(GenericEmailModel.GenericEmail.getEmailTemp()).into(SignUpPage.USERNAME),
					Enter.theValue(GenericEmailModel.GenericEmail.getEmailTemp()).into(SignUpPage.EMAIL),
					Enter.theValue(GenericEmailModel.GenericEmail.getEmailTemp()).into(SignUpPage.CONFIRM_EMAIL),
					Sleep.by(200));

		}
		actor.attemptsTo(Type.theNumber(telephone).into(SignUpPage.TELEPHONE),
				Type.theNumber(mobile).into(SignUpPage.MOBILE), Enter.theValue(password).into(SignUpPage.PASSWORD),
				Enter.theValue(confirmPassword).into(SignUpPage.CONFIRM_PASSWORD));
		Serenity.takeScreenshot();
		if (active.equalsIgnoreCase("yes")) {
			actor.attemptsTo(Sleep.by(1000), Click.on(SignUpPage.ACTIVE_CHECKBOX), Sleep.by(1000));
		}
		actor.attemptsTo(Click.on(SignUpPage.BUTTON_CONFIRM), WaitLoading.page(),Sleep.by(1000));
		

	}

	public static FillInformationNewAccountWithEmail fields(int index) {
		return Tasks.instrumented(FillInformationNewAccountWithEmail.class, index);
	}

}
