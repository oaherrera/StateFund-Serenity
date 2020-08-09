package com.conexia.qa.sql_developer.questions;

import com.conexia.qa.sql_developer.models.User;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class TheUserAsignedUniqueProvider implements Question<Boolean> {

	@Override
	public Boolean answeredBy(Actor actor) {
		if (User.getCountProvider() == 1) {
			return true;
		} else {
			return false;
		}
	}

	public static TheUserAsignedUniqueProvider inDataBase() {
		return new TheUserAsignedUniqueProvider();
	}

}