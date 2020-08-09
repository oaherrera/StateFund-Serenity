package com.conexia.qa.statefund.models;

import java.util.ArrayList;
import java.util.List;

public class UserAuthentication {

	private String userName;
	private String password;
	private String acceptTermsAndPolicies;

	public static List<UserAuthentication> userAuthentication = new ArrayList<>();

	public static void saveUserAuthenticationList(UserAuthentication userLogin) {
		userAuthentication.add(userLogin);
	}

	public static UserAuthentication readData(int index) {
		return userAuthentication.get(index);
	}

	public static void emptyUserAuthenticationList() {
		userAuthentication = new ArrayList<>();
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAcceptTermsAndPolicies() {
		return acceptTermsAndPolicies;
	}

	public void setAcceptTermsAndPolicies(String acceptTermsAndPolicies) {
		this.acceptTermsAndPolicies = acceptTermsAndPolicies;
	}

}