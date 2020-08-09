package com.conexia.qa.statefund.models;

import java.util.ArrayList;
import java.util.List;

public class DocumentAttachment {

	private String documentType;
	private String attachment;
	private static String pdfContent;

	public static List<DocumentAttachment> attachementInformation = new ArrayList<>();

	public static void saveDocumentAttachmentList(DocumentAttachment documentAttachment) {
		attachementInformation.add(documentAttachment);
	}

	public static DocumentAttachment readData(int index) {
		return attachementInformation.get(index);
	}

	public static void emptyDocumentAttachmentList() {
		attachementInformation = new ArrayList<>();
	}

	public static String getPdfContent() {
		return pdfContent;
	}

	public static void setPdfContent(String pdfContent) {
		DocumentAttachment.pdfContent = pdfContent;
	}

	public String getDocumentType() {
		return documentType;
	}

	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}

	public String getAttachment() {
		return attachment;
	}

	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}

}