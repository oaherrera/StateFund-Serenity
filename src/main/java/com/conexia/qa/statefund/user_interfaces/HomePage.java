package com.conexia.qa.statefund.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;

public class HomePage {

	private HomePage() {
	}

	public static final Target HOME = Target.the("Barra Menu").locatedBy("//*[@id='layout-topbar']");
	public static final Target MENU_LEFT = Target.the("Menu left").locatedBy("//*[@id='layout-menu-cover']/ul");
	public static final Target LOGO_STATE_FOUND = Target.the("Logo state found")
			.locatedBy("//*[@id='layout-topbar']/img");
	public static final Target NAME_And_LAST_NAME = Target.the("First Name and Last Name")
			.locatedBy("//*[@id='top-menu']/li[3]");
	public static final Target WORKPLACE = Target.the("Workplace").locatedBy("//*[@id='userForm:console1_label']");
	public static final Target PHYSICIAN_LIST = Target.the("Workplace List")
			.locatedBy("//*[@id='userForm:console2_label']");
	public static final Target PHYSICIAN = Target.the("Physician {0}")
			.locatedBy("//*[@id='userForm:console2_items']/li[contains(text(),'{0}')]");
	public static final Target CLOCK = Target.the("Physician {0}").locatedBy("//*[@id='userForm:clock']");
	public static final Target BELL_NOTIFICATION = Target.the("Notification")
			.locatedBy("//li[@class='ShowOnDesktop']/button/span[contains(@class,'bell')]");
	public static final Target LOGOUT = Target.the("Logout").locatedBy("//button[@id='userForm:btnLogout']/span[1]");
	public static final Target MENU = Target.the("Menu {0}")
			.locatedBy("//li[@role='menuitem']/a//label[contains(text(),'{0}')]");
	public static final Target HOME_PAGE = Target.the("home").locatedBy("//div[@class='ContainerIndent']");
	public static final Target CARRUSEL_NEXT_IMAGE = Target.the("Next Image carrusel")
			.locatedBy("//span[contains(@class,'ui-carousel-next-button')]");
	public static final Target IMAGE_CARRUSEL = Target.the("Image {0}")
			.locatedBy("//div[@class='ui-carousel-viewport']//img[@alt='Slide {0}']");
	public static final Target COPYRIGHT = Target.the("CopyRight")
			.locatedBy("//p[contains(text(),'© Copyright')]//following::p[contains(text(),'All rights reserved')]");

}