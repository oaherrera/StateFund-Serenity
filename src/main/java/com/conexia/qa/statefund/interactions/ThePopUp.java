package com.conexia.qa.statefund.interactions;

import com.conexia.qa.statefund.user_interfaces.ClaimDetailsPage;
import com.conexia.qa.statefund.user_interfaces.RelatedClaimsPage;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.questions.Text;
import net.thucydides.core.annotations.Step;

public class ThePopUp implements Interaction {

	@Override
	@Step("{0} Verify pagination from related claims pop up")
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(Scroll.to(ClaimDetailsPage.REQUESTED_BODY_PARTS), Swipe.vertical(-100));
		Serenity.takeScreenshot();
		actor.attemptsTo(Click.on(ClaimDetailsPage.REQUESTED_BODY_PARTS), WaitLoading.page());
		Serenity.takeScreenshot();
		int pages = Integer.valueOf(
				Text.of(RelatedClaimsPage.PAGINATOR).viewedBy(actor).asString().replace("(1 of ", "").replace(")", ""));
		if (pages > 1) {
			for (int i = 1; i <= (pages - 1); i++) {
				actor.attemptsTo(Click.on(RelatedClaimsPage.NEXT_PAGE));
				Serenity.takeScreenshot();
				if (RelatedClaimsPage.ROW_DATA.resolveFor(actor).isVisible()
						&& (RelatedClaimsPage.ROW_DATA.resolveAllFor(actor).size() > 1)) {
					for (int j = 1; j <= RelatedClaimsPage.ROW_DATA.resolveAllFor(actor).size(); j++) {
						System.out.println(i);
					}
				}
			}
		}
	}

	public static ThePopUp hasThreeRelatedClaimsPerPage() {
		return Tasks.instrumented(ThePopUp.class);
	}

}