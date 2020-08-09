package com.conexia.qa.statefund.questions;

import com.conexia.qa.statefund.interactions.Swipe;
import com.conexia.qa.statefund.interactions.ViewAttachmentDocument;
import com.conexia.qa.statefund.interactions.WaitLoading;
import com.conexia.qa.statefund.user_interfaces.AttachedDocumentsPage;
import com.conexia.qa.statefund.user_interfaces.TreatmentHistoryPage;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.questions.Text;

public class TheAttachmentDocument implements Question<Boolean> {

	@Override
	public Boolean answeredBy(Actor actor) {
		actor.attemptsTo(WaitLoading.page(), Scroll.to(TreatmentHistoryPage.TREATMENT_HISTORY), Swipe.vertical(-50));
		Serenity.takeScreenshot();
		actor.attemptsTo(Click.on(TreatmentHistoryPage.ROW_SPECIFICATION_RFA), WaitLoading.page());
		Serenity.takeScreenshot();
		actor.attemptsTo(
				Click.on(TreatmentHistoryPage.SEE_ATTACHED_DOCUMENTS
						.of(Text.of(TreatmentHistoryPage.RFA_ID_UNDEFINED).viewedBy(actor).asString())),
				WaitLoading.page());
		Serenity.takeScreenshot();
		actor.attemptsTo(Click.on(AttachedDocumentsPage.SEE_DOCUMENT), ViewAttachmentDocument.opened());
		return true;
	}

	public static TheAttachmentDocument is() {
		return new TheAttachmentDocument();
	}

}