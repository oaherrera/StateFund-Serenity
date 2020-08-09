package com.conexia.qa.statefund.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;

public class CommonPage {

	private CommonPage() {
	}

	public static final Target NEXT = Target.the("Next").locatedBy("//span[text()='Next']/ancestor-or-self::button");
	public static final Target LOADER = Target.the("Loanding...")
			.locatedBy("//img[contains(@src,'loadin')]/ancestor-or-self::div[@aria-hidden='false']");
	public static final Target SEARCH = Target.the("Search")
			.locatedBy("//span[text()='Search']/ancestor-or-self::button");
	public static final Target SUBMIT = Target.the("Submit")
			.locatedBy("//span[text()='Submit']/ancestor-or-self::button");
	public static final Target PROCEED = Target.the("Proceed")
			.locatedBy("//span[text()='Proceed']/ancestor-or-self::button");
	public static final Target ERROR_POP_UP = Target.the("Error Pop-up")
			.locatedBy("//span[@class='ui-growl-image ui-growl-image-error']");
	public static final Target CANCEL = Target.the("Cancel")
			.locatedBy("//button[normalize-space(.)='Cancel' and contains(@id,'form:seccion')]");
	public static final Target CANCEL_BUTTON = Target.the("Cancel")
			.locatedBy("//button[normalize-space(.)='Cancel']");
	public static final Target BACK = Target.the("Back")
			.locatedBy("//button[normalize-space(.)='Back' and contains(@id,'form:seccion')]");

	public static final Target ERROR_MESSAGE = Target.the("Error Message")
			.locatedBy("//span[@class='ui-message-error-detail']");
	public static final Target ERROR_MESSAGES = Target.the("Error Messages")
			.locatedBy("//span[@class='ui-messages-error-detail']");
	public static final Target ERROR_MESSAGE_ALERT = Target.the("Alert error message")
			.locatedBy("(//div/div/div[2]/p)[{0}]");

	public static final Target EBILL_NUMBER = Target.the("Ebill Number").locatedBy("//label[contains(.,'Bill ID: ')]");

	public static final Target ACCEPT = Target.the("Accept").locatedBy("//span[.='Accept']/ancestor-or-self::button");

	public static final Target CLOSE_POP_UP = Target.the("Close Pop-up")
			.locatedBy("//div[@aria-hidden='false']//a[@aria-label='Close']");

	public static final Target BUTTON_SAVE_DRAFT = Target.the("Button Saved Draft")
			.locatedBy("//button[contains(@id,'form:seccion3:button3')]");

	public static final Target RESULT_TABLE_NO_RECORD_FOUND = Target.the("No records found")
			.locatedBy("//table[@role='grid']//td[.='No records found.']");

	public static final Target EDIT_ROW = Target.the("Edit Row Number {0}")
			.locatedBy("//tr[@role='row'][{0}]//button[@title='Edit']/span[1]");

	public static final Target SAVE = Target.the("Save").locatedBy("//button[@type='submit']/span[.='Save']");

	public static final Target CONFIRMATION_YES = Target.the("Confirmation Yes")
			.locatedBy("//div[@role='dialog' and contains(@style,'display: block')]//span[.='Yes']");

	public static final Target CONFIRMATION_NO = Target.the("Confirmation No")
			.locatedBy("//div[@role='dialog' and contains(@style,'display: block')]//span[.='No']");
	public static final Target SAVE_DRAFT = Target.the("Saved Draft").locatedBy("//*[contains(@id,'buttonSaveDraft')]");

	public static final Target NO_MATCHES_FOUND = Target.the("No matches found")
			.locatedBy("//div[@class='ui-autocomplete-emptyMessage ui-widget']");

	public static final Target CALENDAR = Target.the("Calendar").locatedBy("//*[@id='ui-datepicker-div']");

	public static final Target SUMMARY_TITLE = Target.the("Summary Title")
			.locatedBy("//span[contains(@id,'form:dlgFinalSubmission_title')]");
	public static final Target BUTTON_OPEN_MAIL = Target.the("Button Open Mail")
			.locatedBy("(//button[contains(text(),'Abrir')])[1]");
	public static final Target PORTAL_ACCOUNT_ACTIVATION = Target.the("New Message")
			.locatedBy("(//h4[@id='mensaje_modalLabel' and contains(text(),'Portal Account Activation')])");
	

}