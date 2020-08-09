package com.conexia.qa.statefund.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;

/**
 * @author ChristianCamiloSchottlaender
 */
public class SavedDraftForClaimPage {

	private SavedDraftForClaimPage() {
	}

	public static final Target CLAIM_NUMBER = Target.the("See claim number title")
			.locatedBy("(//thead[@id='form:draftsSection:tableDrafts_head'])/tr[1]/th[2]/span[.='{0}']");
	public static final Target INJURED_WORKER = Target.the("See Injured worker title")
			.locatedBy("(//thead[@id='form:draftsSection:tableDrafts_head'])/tr[1]/th[3]/span[.='{0}']");
	public static final Target DATE_OF_INJURY = Target.the("See Date of Injury")
			.locatedBy("(//thead[@id='form:draftsSection:tableDrafts_head'])/tr[1]/th[4]/span[.='{0}']");
	public static final Target SAVED_DATE = Target.the("See Saved date")
			.locatedBy("(//thead[@id='form:draftsSection:tableDrafts_head'])/tr[1]/th[5]/span[.='{0}']");

	public static final Target CLAIM_NUMBER_VALUE = Target.the("See claim number value")
			.locatedBy("(//tbody[@id='form:draftsSection:tableDrafts_data'])/tr[{0}]/td[2 and contains(text(),'{1}')]");
	public static final Target INJURED_WORKER_VALUE = Target.the("See Injured worker value")
			.locatedBy("(//tbody[@id='form:draftsSection:tableDrafts_data'])/tr[{0}]/td[3 and contains(text(),'{1}')]");
	public static final Target DATE_OF_INJURY_VALUE = Target.the("See Date of Injury value")
			.locatedBy("(//tbody[@id='form:draftsSection:tableDrafts_data'])/tr[{0}]/td[4 and contains(text(),'{1}')]");
	public static final Target SAVED_DATE_VALUE = Target.the("See Saved date value")
			.locatedBy("(//tbody[@id='form:draftsSection:tableDrafts_data'])/tr[{0}]/td[5 and contains(text(),'{1}')]");

	public static final Target CHECK_OF_ROW = Target.the("Check of Row")
			.locatedBy("(//div[contains(@class,'ui-chkbox-box')])[{0}]");
	public static final Target ROW_SELECTED = Target.the("Row Selected")
			.locatedBy("(//div[contains(@class,'ui-chkbox-box')])[{0}]/ancestor::tr");
	public static final Target DELETE_BY_ID = Target.the("Delete by id {0}")
			.locatedBy("//tr[@data-rk='{0}']//button[@title='Delete' ]");
	public static final Target YES_CONFIRM = Target.the("Confirm yes")
			.locatedBy("//button[@type='submit' and contains(@id,'confirmationButton')]/span[.='Yes']");
	public static final Target NO_CONFIRM = Target.the("Confirm No")
			.locatedBy("//button[@type='submit' and contains(@id,'buttonCancel')]/span[.='No']");

	public static final Target DELETE_MASSIVE = Target.the("Deleted Massive")
			.locatedBy("//button[@type='submit']/span[.='Delete Drafts']");
	public static final Target YES_CONFIRM_MASSIVE = Target.the("Confirm yes")
			.locatedBy("//button[@type='submit' and contains(@id,'buttonYes')]/span[.='Yes']");
	public static final Target NO_CONFIRM_MASSIVE = Target.the("Confirm No")
			.locatedBy("//button[@type='submit' and contains(@id,'buttonNo')]/span[.='No']");

	public static final Target EDIT_BY_ID = Target.the("Edit by id {0}")
			.locatedBy("//tr[@data-rk='{0}']//button[@title='Edit']");

	public static final Target ORDER_BY_SAVED_DATE = Target.the("Order by Saved Date")
			.locatedBy("//th[contains(@aria-label,'Saved date')]");

}