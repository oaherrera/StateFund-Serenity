package com.conexia.qa.statefund.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;

public class RelatedClaimsPage {

	private RelatedClaimsPage() {
	}

	public static final Target ROW_DATA = Target.the("Row data").locatedBy("//*[@id='relatedClaim_data']/tr");
	public static final Target PAGINATOR = Target.the("Paginator")
			.locatedBy("//*[@id='requestedBodyPartsDialog_content']//div[4]/span[1]");
	public static final Target PREVIOUS_PAGE = Target.the("Previous page")
			.locatedBy("//*[@id='relatedClaim_paginator_bottom']/a[2]");
	public static final Target NEXT_PAGE = Target.the("Next page")
			.locatedBy("//*[@id='relatedClaim_paginator_bottom']/a[3]");
	public static final Target CURRENT_PAGE = Target.the("Current page")
			.locatedBy("//*[@id='relatedClaim_paginator_bottom']/span[2]/a");

}