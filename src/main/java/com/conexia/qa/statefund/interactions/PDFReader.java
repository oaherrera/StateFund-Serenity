package com.conexia.qa.statefund.interactions;

import static com.conexia.qa.statefund.user_interfaces.DocumentAttachmentPage.PDF_CONTENT;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import com.conexia.qa.statefund.drivers.ChromeWebDriver;
import com.conexia.qa.statefund.models.DocumentAttachment;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Step;

public class PDFReader implements Interaction {

	private String documentPath;

	public PDFReader(String documentPath) {
		this.documentPath = documentPath;
	}

	@Override
	@Step("{0} read the PDF downloaded")
	public <T extends Actor> void performAs(T actor) {
		actor.can(BrowseTheWeb.with(ChromeWebDriver.browser().setURL(documentPath)));
		String Currentlink = ChromeWebDriver.getDriver().getCurrentUrl();
		URL url;
		actor.attemptsTo(WaitElement.untilAppears(PDF_CONTENT));
		Serenity.takeScreenshot();
		try {
			url = new URL(Currentlink);
			InputStream inputStream = url.openStream();
			BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
			PDDocument document = null;
			document = PDDocument.load(bufferedInputStream);
			String pdfContent = new PDFTextStripper().getText(document);
			Serenity.takeScreenshot();
			document.close();
			bufferedInputStream.close();
			inputStream.close();
			DocumentAttachment.setPdfContent(pdfContent);
			actor.attemptsTo(ExtractClaimRFA.information(DocumentAttachment.getPdfContent()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static PDFReader contentOf(String documentPath) {
		return Tasks.instrumented(PDFReader.class, documentPath);
	}

}