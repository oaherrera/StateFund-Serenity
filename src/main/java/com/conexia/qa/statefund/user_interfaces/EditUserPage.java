package com.conexia.qa.statefund.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;

/**
 * @author ChristianSchottlaender
 **/
public class EditUserPage {

	private EditUserPage() {
	}

	public static final Target TITLE = Target.the("Title")
			.locatedBy("//h1[@class='cnx-cabecera-label' and .='Modify User']");
	public static final Target FIRST_NAME = Target.the("First Name")
			.locatedBy("//input[contains(@id,'inputTextUserFirstNameId')]");
	public static final Target LAST_NAME = Target.the("Last Name")
			.locatedBy("//input[contains(@id,'inputTextUserLastNameId')]");
	public static final Target EMAIL_ADDRESS = Target.the("Email Address")
			.locatedBy("//input[contains(@id,'inputTextUserEmailId')]");
	public static final Target MIDDLE_INITIAL = Target.the("Middle Initial")
			.locatedBy("//input[contains(@id,'inputMiddleNameId')]");
	public static final Target USERNAME = Target.the("Username")
			.locatedBy("//input[contains(@id,'inputTextUsernameId')]");
	public static final Target TELEPHONE = Target.the("Telephone")
			.locatedBy("//input[contains(@id,'inputTextUserPhoneId')]");
	public static final Target MOBILE = Target.the("Mobile")
			.locatedBy("//input[contains(@id,'inputTextUserMobileId')]");

	public static final Target START_DATE = Target.the("Start Date")
			.locatedBy("//input[contains(@id,'calendarStartDateId_input')]");
	public static final Target END_DATE = Target.the("End Date")
			.locatedBy("//input[contains(@id,'calendarEndDateId_input')]");

	public static final Target ACCESS_LEVEL_DIV = Target.the("Access Level {0}")
			.locatedBy("//div[contains(@id,'selectOneMenuAccessLevelId') and @role='combobox']");
	public static final Target ACCESS_LEVEL = Target.the("Access Level {0}")
			.locatedBy("//label[contains(@id,'selectOneMenuAccessLevelId_label')]");
	public static final Target ACCESS_LEVEl_SELECT = Target.the("Access Level {0}")
			.locatedBy("//li[contains(@id,'selectOneMenuAccessLevelId_') and text()='{0}']");

	public static final Target WORKPLACE = Target.the("Workplace")
			.locatedBy("//div[contains(@id,'selectCheckBoxMenuUserWrokplace') and @role='combobox']");
	public static final Target WORKPLACE_SELECT = Target.the("Workplace {0}")
			.locatedBy("//li[contains(@class,'selectcheckboxmenu-list-item') and .='{0}']");

	public static final Target PHYSICIAN = Target.the("Physician")
			.locatedBy("//div[contains(@id,'selectCheckBoxMenuUserPhysician') and @role='combobox']");
	public static final Target PHYSICIAN_SELECT = Target.the("Physician {}")
			.locatedBy("//li[contains(@class,'selectcheckboxmenu-list-item') and contains(.,'{0}')][1]");

	public static final Target ACTIVE_MARK = Target.the("Active Mark")
			.locatedBy("//div[contains(@id,'selectBooleanCheckBoxUserActiveId')]//span");
	public static final Target ACTIVE_MARK_DIV = Target.the("Active Mark")
			.locatedBy("//input[contains(@id,'selectBooleanCheckBoxUserActiveId')]");

	public static final Target DELETE_PHYSICIAN = Target.the("Delete physician")
			.locatedBy("//div[contains(@id,'MenuUserPhysician')]//li/span[contains(@class,'ui-icon-close')]");

	public static final Target DELETE_WORKPLACE = Target.the("Delete Workplace")
			.locatedBy("//div[contains(@id,'MenuUserWrokplace')]//li/span[contains(@class,'ui-icon-close')]");

	public static final Target START_DATE_IS_REQUERED = Target.the("Stert Date ")
			.locatedBy("//div[contains(@id,'msgcalendarStartDateId')]/span[.='{0}']");
	public static final Target END_DATE_IS_REQUERED = Target.the("End Date ")
			.locatedBy("//div[contains(@id,'msgcalendarEndDateId')]/span[.='{0}']");
	public static final Target ACCESS_LEVEL_IS_REQUERED = Target.the("Access Level {0}")
			.locatedBy("//div[contains(@id,'msgselectOneMenuAccessLevelIde')]/span[.='{0}']");
	public static final Target WORKPLACE_IS_REQUERED = Target.the("Workplace {0}")
			.locatedBy("//div[contains(@id,'msgselectCheckBoxMenuUserWrokplace')]/span[.='{0}']");
	public static final Target PHYSICIAN_IS_REQUERED = Target.the("Phisicia {0}")
			.locatedBy("//div[contains(@id,'msgselectCheckBoxMenuUserPhysician')]/span[.='{0}']");

}