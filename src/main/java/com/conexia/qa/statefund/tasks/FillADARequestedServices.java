package com.conexia.qa.statefund.tasks;

import static com.conexia.qa.statefund.user_interfaces.AdditionalDocumentAttachmentPage.DOCUMENT_TYPE;
import static com.conexia.qa.statefund.user_interfaces.AdditionalDocumentAttachmentPage.PATH_FILE;
import static com.conexia.qa.statefund.user_interfaces.AdditionalDocumentAttachmentPage.TITTLE;
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

public class FillADARequestedServices implements Task {

	private String file;

	public FillADARequestedServices() {
		this.file = FilePath.sampleAttachment();
	}

	@Override
	@Step("{0} Fill the Patient Insured Condition ADA form")
	public <T extends Actor> void performAs(T actor) {
		Serenity.takeScreenshot();
		actor.attemptsTo(FillADADiagnosis.form(),
				DocumentAttach.file(file).byVisibleText("22104101 - Correspondence").into(TITTLE, DOCUMENT_TYPE,
						PATH_FILE),
				FillMissingTeethInformation.form(), FillADAServices.form(), Click.on(NEXT), WaitLoading.page());
	}

	public static FillADARequestedServices form() {
		return Tasks.instrumented(FillADARequestedServices.class);
	}

}