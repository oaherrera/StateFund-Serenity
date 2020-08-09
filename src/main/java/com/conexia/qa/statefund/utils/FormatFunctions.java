package com.conexia.qa.statefund.utils;

public class FormatFunctions {

	public static void main(String[] args) {
		System.out.println(phoneNumberFormat("3017152246"));
	}

	public static int firstCharacter(String text) {
		return Integer.parseInt(text.substring(0, 1));
	}

	public static String dateFormat(String date) {
		return date.substring(0, 2) + "/" + date.substring(2, 4) + "/" + date.substring(4, 8);
	}

	public static String phoneNumberFormat(String date) {
		return "(" + date.substring(0, 3) + ") " + date.substring(3, 6) + "-" + date.substring(6, 10);
	}

	public static String periodID(String period) {
		switch (period) {
		case "1":
			return "Daily";// Validado
		case "2":
			return "Weekly";
		case "3":
			return "Bi-Weekly";// Validado
		case "4":
			return "Bi-Monthly";// Validado
		case "5":
			return "Monthly";
		case "6":
			return "Yearly";
		default:
			return null;
		}
	}

}