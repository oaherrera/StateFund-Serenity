package com.conexia.qa.statefund.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;

public class TreatmentDetailsPage {

	private TreatmentDetailsPage() {
	}

	public static final Target TREATMENT_DETAILS = Target.the("Treatment Details")
			.locatedBy("//h1[text()='Treatment Details']");
	public static final Target DIAGNOSIS_CODE_DESC = Target.the("Diagnosis Code/Desc.")
			.locatedBy("//input[contains(@id,'autocompleteDiagnosis_input')]");
	public static final Target DIAGNOSIS_OPTION = Target.the("Diagnosis Code {0}")
			.locatedBy("//span[text()='{0}']/ancestor-or-self::li");
	public static final Target DIAGNOSIS_CODE_TABLE = Target.the("Diagnosis Code in table")
			.locatedBy("//span[text()='Diagnosis Code']/following-sibling::span[text()='{0}']");
	public static final Target DIAGNOSIS_DESCRIPTION_TABLE = Target.the("Diagnosis description in table")
			.locatedBy("//span[text()='Diagnosis Description']/following-sibling::span[text()='{0}']");
	public static final Target PROCEDURE_TYPE = Target.the("Procedure Type")
			.locatedBy("//div[contains(@id,'selectProcedureType') and @role='combobox']");
	public static final Target PROCEDURE_TYPE_OPTIONS = Target.the("Procedure Type options")
			.locatedBy("//li[contains(@id,'selectProcedureType')]");
	public static final Target PROCEDURE_TYPE_LABEL = Target.the("Procedure Type label")
			.locatedBy("//*[contains(@id,'selectProcedureType_label')]");
	public static final Target RELATED_BODY_PART = Target.the("Related Body Part")
			.locatedBy("//select[contains(@id,'bodyPartSelect')]");
	public static final Target UR_TREATMENT_TYPE = Target.the("UR Treatment Type")
			.locatedBy("//div[contains(@id,'selectURTreatmentType') and @role='combobox']");
	public static final Target UR_TREATMENT_TYPE_SELECT = Target.the("UR Treatment Type select")
			.locatedBy("//select[contains(@id,'selectURTreatmentType')]");
	public static final Target UR_TREATMENT_TYPE_OPTIONS = Target.the("UR Treatment Type options")
			.locatedBy("//li[contains(@id,'selectURTreatmentType')]");
	public static final Target PROCEDURE_CODE_DESC = Target.the("Procedure Code/Desc")
			.locatedBy("//input[contains(@id,'autocompleteProcedure_input')]");
	public static final Target PROCEDURE_CODE_DESC_OPTION = Target.the("Procedure Code/Desc option")
			.locatedBy("//*[contains(@id,'autocompleteProcedure_panel')]//li[1]");
	public static final Target PROCEDURE_CODE_DESC_OPTIONS = Target.the("Procedure Code/Desc options")
			.locatedBy("//*[contains(@id,'autocompleteProcedure_panel')]//li");
	public static final Target RELATED_DIAGNOSIS = Target.the("Related Diagnosis")
			.locatedBy("//div[contains(@id,'relatedDiagnosisSelect')]/ul");
	public static final Target ALL_RELATED_DIAGNOSIS = Target.the("All Related Diagnosis").locatedBy(
			"//div[contains(@id,'relatedDiagnosisSelect_panel')]//input[@type='checkbox' and @aria-label='Select All']/ancestor-or-self::div[1]/following-sibling::div/span");
	public static final Target ONE_RELATED_DIAGNOSIS = Target.the("Related Diagnosis {0}")
			.locatedBy("//div[contains(@id,'relatedDiagnosisSelect_panel')]//label[contains(text(),'{0}')]");
	public static final Target CLOSE_RELATED_DIAGNOSIS = Target.the("Close Related Diagnosis")
			.locatedBy("//div[contains(@id,'relatedDiagnosisSelect_panel')]//a[@aria-label='Close']");
	public static final Target ADDITIONAL_COMMENTS = Target.the("Additional Comments")
			.locatedBy("//textarea[contains(@id,'comments')]");
	public static final Target ADD_PROCEDURE = Target.the("Add procedure")
			.locatedBy("//span[text()='Add procedure']/ancestor-or-self::button");
	public static final Target FREQUENCY = Target.the("Frequency")
			.locatedBy("//input[contains(@id,'procedureFrequency_input')]");
	public static final Target PERIOD = Target.the("Period")
			.locatedBy("//div[contains(@id,'procedurePeriod') and @role='combobox']");
	public static final Target PERIOD_OPTIONS = Target.the("Period options")
			.locatedBy("//li[contains(@id,'procedurePeriod')]");
	public static final Target PERIOD_LABEL = Target.the("Period label")
			.locatedBy("//*[contains(@id,'procedurePeriod_label')]");
	public static final Target QUANTITY = Target.the("Quantity").locatedBy("//input[contains(@id,'quantity_input')]");
	public static final Target START_DATE = Target.the("Start Date")
			.locatedBy("//input[contains(@id,'startDateCalendar')]");
	public static final Target END_DATE = Target.the("End Date").locatedBy("//input[contains(@id,'endDateCalendar')]");

}