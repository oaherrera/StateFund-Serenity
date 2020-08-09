package com.conexia.qa.statefund.interactions;

import static com.conexia.qa.statefund.user_interfaces.CommonPage.LOADER;
import static java.util.concurrent.TimeUnit.SECONDS;

import com.conexia.qa.statefund.drivers.OwnWebDriver;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.thucydides.core.annotations.Step;

public class WaitLoading implements Interaction {

	@Override
	@Step("{0} Wait Loading Page...")
	public <T extends Actor> void performAs(T actor) {
		OwnWebDriver.getDriver().manage().timeouts().implicitlyWait(2, SECONDS);
		while (LOADER.resolveFor(actor).isVisible()) {
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
			}
		}
		OwnWebDriver.getDriver().manage().timeouts().implicitlyWait(10, SECONDS);
	}

	public static WaitLoading page() {
		return Tasks.instrumented(WaitLoading.class);
	}

}