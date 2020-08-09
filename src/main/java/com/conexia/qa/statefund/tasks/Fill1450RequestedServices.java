package com.conexia.qa.statefund.tasks;

import static com.conexia.qa.statefund.user_interfaces.AdditionalDocumentAttachmentPage.DOCUMENT_TYPE_;
import static com.conexia.qa.statefund.user_interfaces.AdditionalDocumentAttachmentPage.PATH_FILE;
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

public class Fill1450RequestedServices implements Task {

	private String file;

	public Fill1450RequestedServices() {
		this.file = FilePath.sampleAttachment();
	}

	@Override
	@Step("{0} Fill the Requested Services 1450 form")
	public <T extends Actor> void performAs(T actor) {
		Serenity.takeScreenshot();
		actor.attemptsTo(Fill1450Diagnosis.form(), FillValueCodesAndAmount.form(),
				DocumentAttach.file(file).byVisibleText("CM - Correspondence").into(TITTLE_, DOCUMENT_TYPE_, PATH_FILE),
				Fill1450Services.form(), Click.on(NEXT), WaitLoading.page());
	}

	public static Fill1450RequestedServices form() {
		return Tasks.instrumented(Fill1450RequestedServices.class);
	}

}