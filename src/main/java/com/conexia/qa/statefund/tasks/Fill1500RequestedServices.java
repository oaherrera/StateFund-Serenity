package com.conexia.qa.statefund.tasks;

import static com.conexia.qa.statefund.user_interfaces.AdditionalDocumentAttachmentPage.DOCUMENT_TYPE;
import static com.conexia.qa.statefund.user_interfaces.AdditionalDocumentAttachmentPage.DOCUMENT_TYPE_;
import static com.conexia.qa.statefund.user_interfaces.AdditionalDocumentAttachmentPage.PATH_FILE;
import static com.conexia.qa.statefund.user_interfaces.AdditionalDocumentAttachmentPage.PATH_FILE_;
import static com.conexia.qa.statefund.user_interfaces.AdditionalDocumentAttachmentPage.TITTLE;
import static com.conexia.qa.statefund.user_interfaces.AdditionalDocumentAttachmentPage.TITTLE_;
import static com.conexia.qa.statefund.user_interfaces.CommonPage.NEXT;

import com.conexia.qa.statefund.interactions.DocumentAttach;
import com.conexia.qa.statefund.interactions.WaitLoading;
import com.conexia.qa.statefund.utils.FilePath;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;

public class Fill1500RequestedServices implements Task {

	private String file;

	public Fill1500RequestedServices() {
		this.file = FilePath.sampleAttachment();
	}

	@Override
	@Step("{0} Fill the Requested Services 1500 form")
	public <T extends Actor> void performAs(T actor) {
		Serenity.takeScreenshot();
		actor.attemptsTo(
				DocumentAttach.file(file).byVisibleText("27057 - CPT - OB").into(TITTLE, DOCUMENT_TYPE, PATH_FILE),
				DocumentAttach.file(file).byVisibleText("CM - Correspondence").into(TITTLE_, DOCUMENT_TYPE_,
						PATH_FILE_),
				Fill1500Services.form(), Click.on(NEXT), WaitLoading.page());
	}

	public static Fill1500RequestedServices form() {
		return Tasks.instrumented(Fill1500RequestedServices.class);
	}

}