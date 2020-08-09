package com.conexia.qa.statefund.interactions;

import static com.conexia.qa.statefund.user_interfaces.DocumentAttachmentPage.DOCUMENT_TYPE;
import static com.conexia.qa.statefund.user_interfaces.DocumentAttachmentPage.DOCUMENT_TYPE_OPTION;
import static com.conexia.qa.statefund.user_interfaces.DocumentAttachmentPage.PATH_FILE;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;

public class SelectAndAttach implements Interaction {

	private String attachment;
	private String documentType;

	public SelectAndAttach(String documentType, String attachment) {
		this.documentType = documentType;
		this.attachment = attachment;
	}

	@Override
	@Step("{0} attach the documents #documentType")
	public <T extends Actor> void performAs(T actor) {
		String[] options = documentType.split(";");
		for (int i = 0; i < options.length; i++) {
			actor.attemptsTo(Click.on(DOCUMENT_TYPE), Click.on(DOCUMENT_TYPE_OPTION.of(documentType.split(";")[i])));
			actor.attemptsTo(Attach.file(attachment).into(PATH_FILE), WaitLoading.page());
		}
	}

	public static SelectAndAttach document(String documentType, String attachment) {
		return Tasks.instrumented(SelectAndAttach.class, documentType, attachment);
	}

}