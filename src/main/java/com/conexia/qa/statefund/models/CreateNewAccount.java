package com.conexia.qa.statefund.models;

import java.util.ArrayList;
import java.util.List;

public class CreateNewAccount {

	private String firstName;
	private String middleInitial;
	private String lastName;
	private String userName;
	private String email;
	private String confirmEmail;
	private String telephone;
	private String mobile;
	private String password;
	private String confirmPassword;
	private String active;

	public static List<CreateNewAccount> createNewAccountData = new ArrayList<>();

	public static void saveInformationNewAccount(CreateNewAccount createNewAccount) {
		createNewAccountData.add(createNewAccount);
	}

	public static CreateNewAccount readData(int index) {
		return createNewAccountData.get(index);
	}

	public static void emptyCreateNewAccountList() {
		createNewAccountData = new ArrayList<>();
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleInitial() {
		return middleInitial;
	}

	public void setMiddleInitial(String middleInitial) {
		this.middleInitial = middleInitial;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getConfirmEmail() {
		return confirmEmail;
	}

	public void setConfirmEmail(String confirmEmail) {
		this.confirmEmail = confirmEmail;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

}