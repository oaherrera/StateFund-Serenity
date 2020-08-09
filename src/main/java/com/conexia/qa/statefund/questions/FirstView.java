package com.conexia.qa.statefund.questions;

import static com.conexia.qa.statefund.user_interfaces.HomePage.CARRUSEL_NEXT_IMAGE;
import static com.conexia.qa.statefund.user_interfaces.HomePage.COPYRIGHT;
import static com.conexia.qa.statefund.user_interfaces.HomePage.HOME_PAGE;
import static com.conexia.qa.statefund.user_interfaces.HomePage.IMAGE_CARRUSEL;
import static net.serenitybdd.core.Serenity.takeScreenshot;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.actions.Click;

public class FirstView implements Question<Boolean> {

	private String whatSee;

	public FirstView(String whatSee) {
		this.whatSee = whatSee;
	}

	@Override
	public Boolean answeredBy(Actor actor) {
		switch (whatSee) {
		case "homePage":
			takeScreenshot();
			return HOME_PAGE.resolveFor(actor).isVisible();
		case "carruselImage":
			takeScreenshot();
			int index = 1;
			while (index <= 3) {
				actor.attemptsTo(Click.on(CARRUSEL_NEXT_IMAGE));
				if (!IMAGE_CARRUSEL.of("" + index).resolveFor(actor).isPresent()) {
					return false;
				}
				takeScreenshot();
				index++;
			}
			return true;
		case "copyRight":
			takeScreenshot();
			return COPYRIGHT.resolveFor(actor).isVisible();
		}
		return false;
	}

	public static FirstView homePage() {
		return new FirstView("homePage");
	}

	public static FirstView carruselImage() {
		return new FirstView("carruselImage");
	}

	public static FirstView copyRight() {
		return new FirstView("copyRight");
	}

}