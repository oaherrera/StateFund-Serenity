package com.conexia.qa.statefund.models;

import java.util.ArrayList;
import java.util.List;

import com.conexia.qa.statefund.utils.DateFunctions;

public class CreateNewUser {

	private String firstName;
	private String middleInitial;
	private String lastName;
	private String user;
	private String emailAddress;
	private String telephone;
	private String mobile;
	private String startDate;
	private String endDate;
	private String accessLevel;
	private String workplaces;
	private String physicians;
	private String active;

	public static List<CreateNewUser> createNewUserData = new ArrayList<>();

	public static void saveCreateNewUserList(CreateNewUser createNewUser) {
		createNewUserData.add(createNewUser);
	}

	public static CreateNewUser readData(int index) {
		return createNewUserData.get(index);
	}

	public static void emptyCreateNewUserList() {
		createNewUserData = new ArrayList<>();
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

	public String getUser() {
		return user;
	}

	public void setUser(String userName) {
		this.user = userName;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
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

	public String getStartDate() {
		if (startDate.trim().equals("now")) {
			startDate = DateFunctions.actualDateWithFormat("MM/dd/YYYY");
		}
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		if (endDate.trim().equals("now")) {
			endDate = DateFunctions.actualDateWithFormat("MM/dd/YYYY");
		}
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getAccessLevel() {
		return accessLevel;
	}

	public void setAccessLevel(String accessLevel) {
		this.accessLevel = accessLevel;
	}

	public String getWorkplaces() {
		return workplaces;
	}

	public void setWorkplaces(String workplaces) {
		this.workplaces = workplaces;
	}

	public String getPhysicians() {
		return physicians;
	}

	public void setPhysicians(String physicians) {
		this.physicians = physicians;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

}