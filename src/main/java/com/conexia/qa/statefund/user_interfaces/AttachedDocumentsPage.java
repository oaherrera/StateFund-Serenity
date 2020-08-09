package com.conexia.qa.statefund.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;

public class AttachedDocumentsPage {

	private AttachedDocumentsPage() {
	}

	public static final Target SEE_DOCUMENT = Target.the("See Document").locatedBy("(//*[@title='See Document'])[2]");
	public static final Target DOWNLOAD = Target.the("Download").locatedBy("(//*[@title='See Document'])[1]");

}