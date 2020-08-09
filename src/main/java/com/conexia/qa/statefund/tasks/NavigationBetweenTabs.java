package com.conexia.qa.statefund.tasks;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;

import com.conexia.qa.statefund.drivers.OwnWebDriver;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

public class NavigationBetweenTabs implements Task {

	private int numberTab;
	private static List<String> TabsWindows;

	public NavigationBetweenTabs(int numberTab) {
		this.numberTab = numberTab;
		if (TabsWindows == null) {
			TabsWindows = new ArrayList<String>();
			TabsWindows.add(OwnWebDriver.getDriver().getWindowHandle());
		}
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		// Create new tab
		if (numberTab == -1) {
			((JavascriptExecutor) OwnWebDriver.getDriver()).executeScript("window.open()");
			agregateWindowsList();
		} else {
			String Tab = TabsWindows.get(numberTab-1);
			for (String idDepestaña : OwnWebDriver.getDriver().getWindowHandles()) {
				if (Tab.equals(idDepestaña)) {
					OwnWebDriver.getDriver().switchTo().window(idDepestaña);
				}
			}
		}
	}

	public static NavigationBetweenTabs switchTo(int numberTab) {
		return Tasks.instrumented(NavigationBetweenTabs.class, numberTab);
	}

	public static NavigationBetweenTabs createNewTab() {
		return Tasks.instrumented(NavigationBetweenTabs.class, -1);
	}
	
	private void agregateWindowsList() {
		
		for (String idDepestaña : OwnWebDriver.getDriver().getWindowHandles()) {
			
			int index =0;
			boolean existe = false;
			while(index<TabsWindows.size()) {
				if(TabsWindows.get(index).equals(idDepestaña)) {
					existe = true;
				}
				index=index+1;
			}
			
			if(!existe) {
				TabsWindows.add(idDepestaña);
			}
			
		}
		
		
	}

}
