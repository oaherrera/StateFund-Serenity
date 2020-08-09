package com.conexia.qa.statefund.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;

public class EbillHistoryPage {

	private EbillHistoryPage() {
	}

	public static final Target EBILL_ID = Target.the("Ebill ID")
			.locatedBy("//span[contains(@id,'billId') and .='{0}']");

}