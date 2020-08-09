package com.conexia.qa.statefund.tasks;

import static com.conexia.qa.statefund.user_interfaces.CommonPage.SAVE_DRAFT;
import static com.conexia.qa.statefund.user_interfaces.DocumentAttachmentPage.DOCUMENT_TYPE;

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

public class SaveAsDraft implements Task {

	private String documentType;
	private String attachment;

	public SaveAsDraft(String documentType) {
		this.documentType = documentType;
		if (DocumentAttachment.readData(0).getAttachment().equals("")) {
			this.attachment = FilePath.sampleAttachment();
		} else {
			this.attachment = DocumentAttachment.readData(0).getAttachment();
		}
	}

	@Override
	@Step("{0} Select the Document Attachment and save draft")
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(Scroll.to(DOCUMENT_TYPE), SelectAndAttach.document(documentType, attachment));
		Serenity.takeScreenshot();
		actor.attemptsTo(Scroll.to(SAVE_DRAFT), Click.on(SAVE_DRAFT), WaitLoading.page());
		Serenity.takeScreenshot();
	}

	public static SaveAsDraft type(String documentType) {
		return Tasks.instrumented(SaveAsDraft.class, documentType);
	}

}