package com.conexia.qa.statefund.tasks;

public class GenericEmailModel {

	private String emailTemp;

	public static GenericEmailModel GenericEmail = new GenericEmailModel();
	
	public String getEmailTemp() {
		return emailTemp;
	}

	public static void setEmailTemp(String emailTemp) {
		GenericEmail.emailTemp = emailTemp;
	}
	
	public static GenericEmailModel getGenericEmail() {
		return GenericEmail;
	}
}
