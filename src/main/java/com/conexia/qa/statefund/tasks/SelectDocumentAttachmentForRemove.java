package com.conexia.qa.statefund.tasks;

import static com.conexia.qa.statefund.user_interfaces.DocumentAttachmentPage.DOCUMENT_TYPE;
import static com.conexia.qa.statefund.user_interfaces.DocumentAttachmentPage.TRASH;

import com.conexia.qa.statefund.interactions.SelectAndAttach;
import com.conexia.qa.statefund.interactions.WaitLoading;
import com.conexia.qa.statefund.models.DocumentAttachment;
import com.conexia.qa.statefund.utils.FilePath;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.thucydides.core.annotations.Step;

public class SelectDocumentAttachmentForRemove implements Task {

	private String documentType;
	private String attachment;

	public SelectDocumentAttachmentForRemove(String documentType) {
		this.documentType = documentType;
		if (DocumentAttachment.readData(0).getAttachment().equals("")) {
			this.attachment = FilePath.sampleAttachment();
		} else {
			this.attachment = DocumentAttachment.readData(0).getAttachment();
		}
	}

	@Override
	@Step("{0} Select the Document Attachment for remove")
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(Scroll.to(DOCUMENT_TYPE), SelectAndAttach.document(documentType, attachment));
		Serenity.takeScreenshot();
		actor.attemptsTo(Click.on(TRASH), WaitLoading.page());
		Serenity.takeScreenshot();
	}

	public static SelectDocumentAttachmentForRemove type(String documentType) {
		return Tasks.instrumented(SelectDocumentAttachmentForRemove.class, documentType);
	}

}