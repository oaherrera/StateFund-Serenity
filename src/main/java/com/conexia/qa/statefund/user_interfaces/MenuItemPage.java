package com.conexia.qa.statefund.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;

public class MenuItemPage {

	private MenuItemPage() {
	}

	public static final Target AGREE_TERMS_AND_POLICIES = Target.the("Agree Terms and Policies")
			.locatedBy("//span[text()='Agree']/ancestor-or-self::button");
	public static final Target CLAIM = Target.the("Claim option")
			.locatedBy("//label[(contains(text(),' Claim'))]/ancestor-or-self::a");
	public static final Target CLAIM_SEARCH = Target.the("Claim Search")
			.locatedBy("//a[normalize-space(.)='Claim Search']");

	public static final Target EBILL = Target.the("Ebill").locatedBy("//label[.=' Ebill']/ancestor-or-self::a");
	public static final Target RFA_SEARCH = Target.the("RFA Search").locatedBy("//a[normalize-space(.)='RFA Search']");
	public static final Target HISTORY = Target.the("History").locatedBy("//a[normalize-space(.)='History']");

	public static final Target USER_MANAGEMENT = Target.the("User management")
			.locatedBy("//label[contains(text(),'User management')]");
	public static final Target SEARCH_USER = Target.the("Search User")
			.locatedBy("//a[normalize-space(.)='Search user']");
	public static final Target CREATE_NEW_USER = Target.the("Create new user")
			.locatedBy("//a[normalize-space(.)='Create new user']");
	public static final Target INBOX = Target.the("Inbox").locatedBy("//a[normalize-space(.)='Inbox']");

}