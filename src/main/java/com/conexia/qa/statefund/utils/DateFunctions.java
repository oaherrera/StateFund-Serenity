package com.conexia.qa.statefund.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateFunctions {

	public static void main(String[] args) {
		System.out.println(actualHour());
	}

	public static String actualHour() {
		SimpleDateFormat formatter = new SimpleDateFormat("HHmm");
		Date date = new Date();
		return formatter.format(date);
	}

	public static String actualDate() {
		SimpleDateFormat formatter = new SimpleDateFormat("MMddYYYY");
		Date date = new Date();
		return formatter.format(date);
	}

	public static String actualDateWithFormat() {
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/YYYY");
		Date date = new Date();
		return formatter.format(date);
	}

	public static String actualDateWithFormat(String format) {
		SimpleDateFormat formatter = new SimpleDateFormat(format);
		Date date = new Date();
		return formatter.format(date);
	}

	public static String yesterdayDate() {
		SimpleDateFormat formatter = new SimpleDateFormat("MMddYYYY");
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -1);
		return formatter.format(cal.getTime());
	}

	public static String aWeekLater() {
		SimpleDateFormat formatter = new SimpleDateFormat("MMddYYYY");
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, +7);
		return formatter.format(cal.getTime());
	}

	public static String aWeekBefore() {
		SimpleDateFormat formatter = new SimpleDateFormat("MMddYYYY");
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -7);
		return formatter.format(cal.getTime());
	}

}