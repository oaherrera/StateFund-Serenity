package com.conexia.qa.statefund.tasks;

import static com.conexia.qa.statefund.user_interfaces.TreatmentHistoryPage.EXPAND_ROW;
import static com.conexia.qa.statefund.user_interfaces.TreatmentHistoryPage.RFA_ID_UNDEFINED;
import static com.conexia.qa.statefund.user_interfaces.TreatmentHistoryPage.SEE_ATTACHED_DOCUMENTS;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

import com.conexia.qa.statefund.interactions.Swipe;
import com.conexia.qa.statefund.interactions.WaitLoading;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.questions.Text;

public class ViewFiles implements Task {

	@Override
	public <T extends Actor> void performAs(T actor) {
		theActorInTheSpotlight().attemptsTo(Swipe.vertical(500), WaitLoading.page());
		Serenity.takeScreenshot();
		theActorInTheSpotlight().attemptsTo(Click.on(EXPAND_ROW), WaitLoading.page());
		Serenity.takeScreenshot();
		theActorInTheSpotlight().attemptsTo(Swipe.vertical(200), WaitLoading.page());
		actor.attemptsTo(Click.on(SEE_ATTACHED_DOCUMENTS.of(Text.of(RFA_ID_UNDEFINED).viewedBy(actor).asString())),
				WaitLoading.page());
		Serenity.takeScreenshot();
	}

	public static ViewFiles associated() {
		return Tasks.instrumented(ViewFiles.class);
	}

}