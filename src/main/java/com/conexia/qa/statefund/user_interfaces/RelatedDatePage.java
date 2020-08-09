package com.conexia.qa.statefund.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;

public class RelatedDatePage {

	private RelatedDatePage() {
	}

	private static String init = "//h1[.='Related Dates']/ancestor-or-self::div[@class='seccion-header']/following-sibling::div//";

	public static final Target TITTLE = Target.the("Related Dates").locatedBy("//h1[.='Related Dates']");
	public static final Target DATE_PATIENT_FROM = Target.the("Dates patient unable to work in current occupation From")
			.locatedBy(init
					+ "label[.='Dates patient unable to work in current occupation']/following-sibling::*//label[.='From']/following-sibling::*//input");
	public static final Target DATE_PATIENT_TO = Target.the("Dates patient unable to work in current occupation To")
			.locatedBy(init
					+ "label[.='Dates patient unable to work in current occupation']/following-sibling::*//label[.='To']/following-sibling::*//input");
	public static final Target HOSPITALIZATION_DATE_FROM = Target
			.the("Hospitalization dates related to current services From").locatedBy(init
					+ "label[.='Hospitalization dates related to current services']/following-sibling::*//label[.='From']/following-sibling::*//input");
	public static final Target HOSPITALIZATION_DATE_TO = Target
			.the("Hospitalization dates related to current services To").locatedBy(init
					+ "label[.='Hospitalization dates related to current services']/following-sibling::*//label[.='To']/following-sibling::*//input");

}