package com.conexia.qa.statefund.utils;

import java.net.InetAddress;
import java.net.UnknownHostException;

import com.conexia.qa.statefund.models.Selenium;

public class FilePath {

	public static void main(String[] args) {
		System.out.println(getHostName());
	}

	public static String getHostName() {
		switch (Selenium.parameters().getProperty("operativeSystem").toLowerCase()) {
		case "windows":
			try {
				InetAddress addr;
				addr = InetAddress.getLocalHost();
				return addr.getHostName();
			} catch (UnknownHostException ex) {
				System.out.println("Hostname can not be resolved");
				return "HOSTNAME";
			}
		case "linux":
			return "LINUX HOSTNAME";
		default:
			return null;
		}
	}

	public static String downloadPath() {
		switch (Selenium.parameters().getProperty("operativeSystem").toLowerCase()) {
		case "windows":
			return System.getProperty("user.dir") + "\\lib\\downloads";
		case "linux":
			return System.getProperty("user.dir") + "/lib/downloads";
		default:
			return null;
		}
	}

	public static String sampleAttachment() {
		switch (Selenium.parameters().getProperty("operativeSystem").toLowerCase()) {
		case "windows":
			return System.getProperty("user.dir") + "\\lib\\attachment\\SampleDocument.pdf";
		case "linux":
			return System.getProperty("user.dir") + "/lib/attachment/SampleDocument.pdf";
		default:
			return null;
		}
	}

	public static String sampleAttachmentWord() {
		switch (Selenium.parameters().getProperty("operativeSystem").toLowerCase()) {
		case "windows":
			return System.getProperty("user.dir") + "\\lib\\attachment\\SampleDocument.doc";
		case "linux":
			return System.getProperty("user.dir") + "/lib/attachment/SampleDocument.pdf";
		default:
			return null;
		}
	}

	public static String sampleAttachmentBig() {
		switch (Selenium.parameters().getProperty("operativeSystem").toLowerCase()) {
		case "windows":
			return System.getProperty("user.dir") + "\\lib\\attachment\\SampleDocumentBig.pdf";
		case "linux":
			return System.getProperty("user.dir") + "/lib/attachment/SampleDocument.pdf";
		default:
			return null;
		}
	}

}