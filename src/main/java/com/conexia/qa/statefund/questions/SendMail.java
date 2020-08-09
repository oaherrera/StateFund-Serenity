package com.conexia.qa.statefund.questions;
import static net.serenitybdd.core.Serenity.takeScreenshot;

import com.conexia.qa.statefund.interactions.Sleep;
import com.conexia.qa.statefund.tasks.NavigationBetweenTabs;
import com.conexia.qa.statefund.user_interfaces.CommonPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.actions.Click;

public class SendMail implements Question<Boolean> {

	@Override
	public Boolean answeredBy(Actor actor) {
		actor.attemptsTo(NavigationBetweenTabs.switchTo(2));
		actor.attemptsTo(Click.on(CommonPage.BUTTON_OPEN_MAIL),Sleep.by(2000));
		takeScreenshot();
		return CommonPage.PORTAL_ACCOUNT_ACTIVATION.resolveFor(actor).isVisible();
	}

	public static SendMail isShow() {
		return new SendMail();
	}

}
