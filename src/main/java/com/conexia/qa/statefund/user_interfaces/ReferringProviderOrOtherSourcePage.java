package com.conexia.qa.statefund.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;

public class ReferringProviderOrOtherSourcePage {

	private ReferringProviderOrOtherSourcePage() {
	}

	private static String init = "//h1[.='Referring Provider or Other Source']/ancestor-or-self::div[@class='seccion-header']/following-sibling::div//";

	public static final Target TITTLE = Target.the("Referring Provider or Other Source")
			.locatedBy("//h1[.='Referring Provider or Other Source']");
	public static final Target FIRST_NAME = Target.the("Referring Physician's First Name").locatedBy(
			init + "label[.=\"Referring Physician's First Name\"]/ancestor-or-self::div/following-sibling::*/input");
	public static final Target MIDDLE_NAME = Target.the("Referring Physician's Middle Name").locatedBy(
			init + "label[.=\"Referring Physician's Middle Name\"]/ancestor-or-self::div/following-sibling::*/input");
	public static final Target LAST_NAME = Target.the("Referring Physician's Last Name").locatedBy(
			init + "label[.=\"Referring Physician's Last Name\"]/ancestor-or-self::div/following-sibling::*/input");
	public static final Target QUAL_ID = Target.the("Qual.ID")
			.locatedBy(init + "label[.='Qual.ID']/ancestor-or-self::div/following-sibling::*/input");
	public static final Target LICENSE = Target.the("License")
			.locatedBy(init + "label[.='License']/ancestor-or-self::div/following-sibling::*/input");
	public static final Target NPI_NUMBER = Target.the("NPI #")
			.locatedBy(init + "label[.='NPI #']/ancestor-or-self::div/following-sibling::*/input");

}