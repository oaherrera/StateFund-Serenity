package com.conexia.qa.statefund.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;

public class NotificationPage {

	private NotificationPage() {
	}

	public static final Target SHOW_ALL = Target.the("Show All")
			.locatedBy("//button[@type='submit']/span[.='Show all']");
	public static final Target NOTIFICATIONS_TYPE = Target.the("Notifications {0}")
			.locatedBy("//tbody[contains(@id,'notificationsPage_data')]/tr/td/span[.='{0}'] ");

}