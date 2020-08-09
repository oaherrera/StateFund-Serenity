package com.conexia.qa.statefund.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;

public class TreatmentHistoryPage {

	private TreatmentHistoryPage() {
	}

	public static final Target TREATMENT_HISTORY = Target.the("Treatment History")
			.locatedBy("//*[text()='Treatment History']");
	public static final Target RFA_ID = Target.the("RFA ID # {0}").locatedBy("//span[text()='RFA ID # {0}']");
	public static final Target RFA_ID_UNDEFINED = Target.the("RFA ID").locatedBy("//span[contains(text(),'RFA ID #')]");
	public static final Target ROW_SPECIFICATION_RFA = Target.the("Row for specification of RFA ID #")
			.locatedBy("//*[@aria-label='Toggle Row']");
	public static final Target CONTENT_RFA = Target.the("Content RFA")
			.locatedBy("//*[@id='seccion:rfaTable_data']/tr[@class='ui-expanded-row-content ui-widget-content']");

	public static final Target EXPAND_ROW = Target.the("EXPAND ROW")
			.locatedBy("//*[@id='seccion:rfaTable_data']/tr[1]/td[1]/div");

	public static final Target DIAGNOSIS_CODE_DESCRIPCTION = Target.the("Diagnosis Code - Description").locatedBy(
			"//tbody[contains(@id,'dataTableRFA_data')]//span[text()='Diagnosis Code - Description']/following-sibling::text()");
	public static final Target PROCEDURE_TYPE_AND_CODE = Target.the("Procedure Type & Code").locatedBy(
			"//tbody[contains(@id,'dataTableRFA_data')]//span[text()='Procedure Type & Code']/following-sibling::text()");
	public static final Target PROCEDURE_DESCRIPCTION = Target.the("Procedure Description").locatedBy(
			"//tbody[contains(@id,'dataTableRFA_data')]//span[text()='Procedure Description']/following-sibling::text()");
	public static final Target AUTHORIZED_QUANTITY = Target.the("Authorized Quantity").locatedBy(
			"//tbody[contains(@id,'dataTableRFA_data')]//span[text()='Authorized Quantity']/following-sibling::text()");
	public static final Target DECISION = Target.the("Decision")
			.locatedBy("//tbody[contains(@id,'dataTableRFA_data')]//span[text()='Decision']/following-sibling::text()");
	public static final Target DATE_OF_SUBMISION = Target.the("Date Of Submission").locatedBy(
			"//tbody[contains(@id,'dataTableRFA_data')]//span[text()='Date Of Submission']/following-sibling::text()");
	public static final Target SHOW_DPF = Target.the("Show PDF")
			.locatedBy("//span[text()='Show PDF']/ancestor::button[contains(@id,'rfaTable:0')]");
	public static final Target SEE_ATTACHED_DOCUMENTS = Target.the("See Attached Documents of {0}")
			.locatedBy("//*[text()='{0}']/ancestor::tbody/tr[2]//button[normalize-space(.)='See Attached Documents']");

}