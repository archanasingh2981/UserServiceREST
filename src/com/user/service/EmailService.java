package com.user.service;

import com.bean.LoginLink;

public class EmailService {
	
	private static String CONTENT = "Hi, We recived your request, Please click on the following link to retrieve your details";
	
	private LoginLink loginLink;

	public LoginLink getLoginLink() {
		return loginLink;
	}

	public void setLoginLink(LoginLink loginLink) {
		this.loginLink = loginLink;
	}
	
	public  void sendEmail(){
		//To Do
		//fetch loginLink.getUserEmail() 
		//requires SMTP Server
		
		System.out.println("Email sent successfully to "+loginLink.getUserEmail());
	}
	

}
