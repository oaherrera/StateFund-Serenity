package com.conexia.qa.statefund.tasks;

import static com.conexia.qa.statefund.user_interfaces.DocumentAttachmentPage.DOCUMENT_TYPE;

import com.conexia.qa.statefund.interactions.SelectAndAttach;
import com.conexia.qa.statefund.models.DocumentAttachment;
import com.conexia.qa.statefund.utils.FilePath;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Scroll;
import net.thucydides.core.annotations.Step;

public class SelectDocumentAttachmentBiggerThan32MB implements Task {

	private String documentType;
	private String attachment;

	public SelectDocumentAttachmentBiggerThan32MB(String documentType) {
		this.documentType = documentType;
		if (DocumentAttachment.readData(0).getAttachment().equals("")) {
			this.attachment = FilePath.sampleAttachmentBig();
		} else {
			this.attachment = DocumentAttachment.readData(0).getAttachment();
		}
	}

	@Override
	@Step("{0} Select the Document Attachment")
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(Scroll.to(DOCUMENT_TYPE), SelectAndAttach.document(documentType, attachment));
		Serenity.takeScreenshot();
	}

	public static SelectDocumentAttachmentBiggerThan32MB type(String documentType) {
		return Tasks.instrumented(SelectDocumentAttachmentBiggerThan32MB.class, documentType);
	}

}