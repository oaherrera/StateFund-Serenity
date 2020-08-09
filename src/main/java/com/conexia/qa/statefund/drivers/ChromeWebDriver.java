package com.conexia.qa.statefund.drivers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.conexia.qa.statefund.models.Selenium;

public class ChromeWebDriver {

	private WebDriver driver;

	private static List<ChromeWebDriver> listOwnWebDriver = new ArrayList<>();

	public static ChromeWebDriver browser() {
		int timeOut = 10;
		ChromeOptions chromeOptions = new ChromeOptions();
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		if (Selenium.parameters().getProperty("headless.mode").equals("true")) {
			chromeOptions.addArguments("" + "--headless " + "--window-size=1920x1080 " + "--no-sandbox "
					+ "--disable-dev-shm-usage " + "--disable-gpu " + "--ignore-certificate-errors "
					+ "--disable-extensions " + "--incognito");
		} else {
			chromeOptions.addArguments("" + "--start-maximized " + "--ignore-certificate-errors "
					+ "--disable-extensions " + "--incognito");
		}
		chromeOptions.setExperimentalOption("prefs", chromePrefs);
		listOwnWebDriver.add(new ChromeWebDriver());
		listOwnWebDriver.get(listOwnWebDriver.size() - 1).driver = new ChromeDriver(chromeOptions);
		listOwnWebDriver.get(listOwnWebDriver.size() - 1).driver.manage().timeouts().implicitlyWait(timeOut,
				TimeUnit.SECONDS);
		return listOwnWebDriver.get(listOwnWebDriver.size() - 1);
	}

	public WebDriver setURL(String url) {
		driver.get(url);
		return listOwnWebDriver.get(listOwnWebDriver.size() - 1).driver;
	}

	public static WebDriver getDriver() {
		return listOwnWebDriver.get(listOwnWebDriver.size() - 1).driver;
	}

}