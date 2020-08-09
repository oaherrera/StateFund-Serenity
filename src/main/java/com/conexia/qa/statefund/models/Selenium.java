package com.conexia.qa.statefund.models;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Selenium extends Properties {

	private static final long serialVersionUID = 1L;

	public static Properties parameters() {
		Properties properties = new Selenium();
		InputStream inputStream = null;
		try {
			inputStream = new FileInputStream(System.getProperty("user.dir") + "\\selenium.properties");
			properties.load(inputStream);
		} catch (Exception e) {
			try {
				inputStream = new FileInputStream(System.getProperty("user.dir") + "/selenium.properties");
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				properties.load(inputStream);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return properties;
	}

}