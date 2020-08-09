package com.conexia.qa.statefund.drivers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

import com.conexia.qa.statefund.models.Selenium;
import com.conexia.qa.statefund.utils.FilePath;

public class OwnWebDriver {

	private WebDriver driver;

	private static List<OwnWebDriver> listOwnWebDriver = new ArrayList<>();

	public static OwnWebDriver withBrowser(String browser) {
		String downloadPath = FilePath.downloadPath();
		int timeOut = 20;
		switch (browser.toLowerCase()) {
		case "chrome":
			ChromeOptions chromeOptions = new ChromeOptions();
			HashMap<String, Object> chromePrefs = new HashMap<String, Object>();

			if (Selenium.parameters().getProperty("headless.mode").equals("true")) {
				chromePrefs.put("Page.setDownloadBehavior",
						"{ behavior: 'allow' , downloadPath: '" + downloadPath + "'}");
				chromeOptions.setHeadless(true);
				chromeOptions.addArguments("" + "--window-size=1920x1080 " + "--no-sandbox "
						+ "--disable-dev-shm-usage " + "--ignore-certificate-errors " + "--disable-extensions ");
			} else {
				chromePrefs.put("download.default_directory", downloadPath);
				chromeOptions.addArguments("" + "--start-maximized " + "--ignore-certificate-errors "
						+ "--disable-extensions " + "--incognito");
			}
			chromeOptions.setExperimentalOption("prefs", chromePrefs).setExperimentalOption("excludeSwitches",
					new String[] { "enable-automation" });
			switch (Selenium.parameters().getProperty("operativeSystem").toLowerCase()) {
			case "windows":
				break;
			case "linux":
				System.setProperty("webdriver.chrome.driver",
						"/home/oherrera/Documentos/Selenium/Drivers/chromedriver");
				break;
			default:
				break;
			}
			listOwnWebDriver.add(new OwnWebDriver());
			listOwnWebDriver.get(listOwnWebDriver.size() - 1).driver = new ChromeDriver(chromeOptions);
			listOwnWebDriver.get(listOwnWebDriver.size() - 1).driver.manage().timeouts().implicitlyWait(timeOut,
					TimeUnit.SECONDS);
			if (Selenium.parameters().getProperty("operativeSystem").equalsIgnoreCase("linux")) {
				listOwnWebDriver.get(listOwnWebDriver.size() - 1).driver.manage().window().maximize();
			}
			return listOwnWebDriver.get(listOwnWebDriver.size() - 1);
		case "ie":
			InternetExplorerOptions ieOptions = new InternetExplorerOptions();
//			ieOptions.BrowserCommandLineArguments = "--private";

			listOwnWebDriver.add(new OwnWebDriver());
			listOwnWebDriver.get(listOwnWebDriver.size() - 1).driver = new InternetExplorerDriver(ieOptions);
			listOwnWebDriver.get(listOwnWebDriver.size() - 1).driver.manage().deleteAllCookies();
			listOwnWebDriver.get(listOwnWebDriver.size() - 1).driver.manage().window().maximize();
			listOwnWebDriver.get(listOwnWebDriver.size() - 1).driver.manage().timeouts().implicitlyWait(10,
					TimeUnit.SECONDS);
			return listOwnWebDriver.get(listOwnWebDriver.size() - 1);
		case "firefox":
			FirefoxOptions firefoxOptions = new FirefoxOptions();
			firefoxOptions.addArguments("--start-maximized --ignore-certificate-errors --disable-infobars");

			listOwnWebDriver.add(new OwnWebDriver());
			listOwnWebDriver.get(listOwnWebDriver.size() - 1).driver = new FirefoxDriver(firefoxOptions);
			listOwnWebDriver.get(listOwnWebDriver.size() - 1).driver.manage().deleteAllCookies();
			listOwnWebDriver.get(listOwnWebDriver.size() - 1).driver.manage().window().maximize();
			listOwnWebDriver.get(listOwnWebDriver.size() - 1).driver.manage().timeouts().implicitlyWait(timeOut,
					TimeUnit.SECONDS);
			return listOwnWebDriver.get(listOwnWebDriver.size() - 1);
		default:
			System.out.println("Invalid browser");
			return null;
		}
	}

	public WebDriver setURL(String url) {
		driver.get(url);
		return listOwnWebDriver.get(listOwnWebDriver.size() - 1).driver;
	}

	public static WebDriver getDriver() {
		return listOwnWebDriver.get(listOwnWebDriver.size() - 1).driver;
	}

}