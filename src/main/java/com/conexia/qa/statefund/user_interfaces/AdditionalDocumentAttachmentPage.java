package com.conexia.qa.statefund.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;

public class AdditionalDocumentAttachmentPage {

	private AdditionalDocumentAttachmentPage() {
	}

	public static final Target TITTLE = Target.the("Document Attachment").locatedBy("//h1[.='Document Attachment']");
	public static final Target DOCUMENT_TYPE = Target.the("Document type").locatedBy(
			"//h1[.='Document Attachment']/ancestor-or-self::div[@class='seccion-header']/following-sibling::*//select[contains(@id,'fileType')]");
	public static final Target PATH_FILE = Target.the("Attach")
			.locatedBy("//input[@type='file' and contains(@id,'fileUpload_input')]");
	public static final Target TITTLE_ = Target.the("Additional Document Attachment")
			.locatedBy("//h1[.='Additional Document Attachment']");
	public static final Target DOCUMENT_TYPE_ = Target.the("Document type").locatedBy(
			"//h1[.='Additional Document Attachment']/ancestor-or-self::div[@class='seccion-header']/following-sibling::*//select[contains(@id,'fileType')]");
	public static final Target PATH_FILE_ = Target.the("Attach")
			.locatedBy("//input[@type='file' and contains(@id,'AttachmentAdditional')]");

}