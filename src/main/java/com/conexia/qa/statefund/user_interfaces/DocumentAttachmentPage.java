package com.conexia.qa.statefund.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;

public class DocumentAttachmentPage {

	private DocumentAttachmentPage() {
	}

	public static final Target DOCUMENT_TYPE = Target.the("Document type")
			.locatedBy("//label[contains(@id,'fileTypeResponse') and contains(text(),'Select')]");
	public static final Target DOCUMENT_TYPE_OPTION = Target.the("Document type {0}")
			.locatedBy("//li[contains(text(),'{0}')]");
	public static final Target ATTACH = Target.the("Attach")
			.locatedBy("//span[text()='Attach']/ancestor-or-self::span[@role='button']");
	public static final Target PATH_FILE = Target.the("Attach").locatedBy("//input[contains(@id,'fileUpload_input')]");
	public static final Target DOCUMENT_LOADED = Target.the("Document")
			.locatedBy("//span[text()='Document Name']/following-sibling::span");
	public static final Target PROCEED = Target.the("Proceed").locatedBy(
			"//span[text()='Proceed']/ancestor-or-self::button[contains(@id,'SummaryProceed') or contains(@id,'form:finalSubmissionProceed')]");
	public static final Target DOWNLOAD = Target.the("Download")
			.locatedBy("//span[text()='Download']/ancestor-or-self::button");

	public static final Target PDF_CONTENT = Target.the("PDF Content").locatedBy("//embed[@type='application/pdf']");
	public static final Target TRASH = Target.the("Trash")
			.locatedBy("//button[contains(@id,'form:seccion3:DT:0:trash')]");
	public static final Target MESSAGE_RECORD_NOT_FOUND = Target.the("Message record not found")
			.locatedBy("//td[contains(text(),'No records found.')]");
	public static final Target MESSAGE_INVALID_FILE = Target.the("Message Invalid File")
			.locatedBy("//span[contains(text(),'Invalid file type')]");
	public static final Target MESSAGE_INVALID_FILE_SIZE = Target.the("Message Invalid File Size")
			.locatedBy("//span[contains(text(),'Invalid file size')]");

}