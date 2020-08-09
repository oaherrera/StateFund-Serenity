package com.conexia.qa.sql_developer.models;

public class User {

	private static int id;
	private static String userName;
	private static String email;
	private static String firstName;
	private static String lastName;
	private static String middleName;
	private static String telephone;
	private static String mobile;
	private static String active;
	private static String delete;
	private static int countProvider;

	public static int getId() {
		return id;
	}

	public static void setId(int id) {
		User.id = id;
	}

	public static String getUserName() {
		return userName;
	}

	public static void setUserName(String userName) {
		User.userName = userName;
	}

	public static String getEmail() {
		return email;
	}

	public static void setEmail(String email) {
		User.email = email;
	}

	public static String getFirstName() {
		return firstName;
	}

	public static void setFirstName(String firstName) {
		User.firstName = firstName;
	}

	public static String getLastName() {
		return lastName;
	}

	public static void setLastName(String lastName) {
		User.lastName = lastName;
	}

	public static String getMiddleName() {
		return middleName;
	}

	public static void setMiddleName(String middleName) {
		User.middleName = middleName;
	}

	public static String getTelephone() {
		return telephone;
	}

	public static void setTelephone(String telephone) {
		User.telephone = telephone;
	}

	public static String getMobile() {
		return mobile;
	}

	public static void setMobile(String mobile) {
		User.mobile = mobile;
	}

	public static String getActive() {
		return active;
	}

	public static void setActive(String active) {
		User.active = active;
	}

	public static String getDelete() {
		return delete;
	}

	public static void setDelete(String delete) {
		User.delete = delete;
	}

	public static int getCountProvider() {
		return countProvider;
	}

	public static void setCountProvider(int countProvider) {
		User.countProvider = countProvider;
	}

}