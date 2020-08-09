package com.conexia.qa.statefund.interactions;

import java.util.ArrayList;

import com.conexia.qa.statefund.drivers.OwnWebDriver;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.thucydides.core.annotations.Step;

public class ViewAttachmentDocument implements Interaction {

	@Override
	@Step("{0} View the attachment document")
	public <T extends Actor> void performAs(T actor) {
//		OwnWebDriver.getDriver().getWindowHandles().size();
		String oldTab = OwnWebDriver.getDriver().getWindowHandle();
		ArrayList<String> tabs = new ArrayList<String>(OwnWebDriver.getDriver().getWindowHandles());
		tabs.remove(oldTab);
		OwnWebDriver.getDriver().switchTo().window(tabs.get(0));
		Serenity.takeScreenshot();
		actor.attemptsTo(Sleep.by(500));
		OwnWebDriver.getDriver().close();
		actor.attemptsTo(Sleep.by(500));
		OwnWebDriver.getDriver().switchTo().window(oldTab);
	}

	public static ViewAttachmentDocument opened() {
		return Tasks.instrumented(ViewAttachmentDocument.class);
	}

}