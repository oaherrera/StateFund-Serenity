package com.conexia.qa.statefund.questions;

import com.conexia.qa.statefund.interactions.UIEvidences;
import com.conexia.qa.statefund.models.UserAuthentication;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ThePassword implements Question<Boolean> {

	private String password;

	private ThePassword(String password) {
		this.password = password;
	}

	@Override
	public Boolean answeredBy(Actor actor) {
		actor.attemptsTo(UIEvidences.screenshot("Password unencrypted: " + password + "\nPassword encrypted: "
				+ UserAuthentication.readData(0).getPassword()));
		return !UserAuthentication.readData(0).getPassword().equalsIgnoreCase(password);
	}

	public static ThePassword isEncrypted(String password) {
		return new ThePassword(password);
	}

}