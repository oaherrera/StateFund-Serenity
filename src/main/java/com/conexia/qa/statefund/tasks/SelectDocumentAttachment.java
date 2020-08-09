package com.conexia.qa.statefund.tasks;

import static com.conexia.qa.statefund.user_interfaces.CommonPage.SUBMIT;
import static com.conexia.qa.statefund.user_interfaces.DocumentAttachmentPage.DOCUMENT_TYPE;
import static com.conexia.qa.statefund.user_interfaces.DocumentAttachmentPage.PROCEED;

import com.conexia.qa.statefund.interactions.AcceptNotification;
import com.conexia.qa.statefund.interactions.SelectAndAttach;
import com.conexia.qa.statefund.models.DocumentAttachment;
import com.conexia.qa.statefund.utils.FilePath;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.thucydides.core.annotations.Step;

public class SelectDocumentAttachment implements Task {

	private String documentType;
	private String attachment;

	public SelectDocumentAttachment(String documentType) {
		this.documentType = documentType;
		if (DocumentAttachment.readData(0).getAttachment().equals("")) {
			this.attachment = FilePath.sampleAttachment();
		} else {
			this.attachment = DocumentAttachment.readData(0).getAttachment();
		}
	}

	@Override
	@Step("{0} Select the Document Attachment")
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(Scroll.to(DOCUMENT_TYPE), SelectAndAttach.document(documentType, attachment));
		Serenity.takeScreenshot();
		actor.attemptsTo(Scroll.to(SUBMIT), Click.on(SUBMIT), AcceptNotification.popUp(PROCEED));
	}

	public static SelectDocumentAttachment type(String documentType) {
		return Tasks.instrumented(SelectDocumentAttachment.class, documentType);
	}

}