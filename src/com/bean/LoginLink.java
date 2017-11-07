package com.bean;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="loginlink")
public class LoginLink {
	
	@Id
	private String userId;
	
	private String link;
	private Calendar expiry;
	private String userEmail;
	
	
	private static int EXPIRY_MINUTES = 15;
	
	//constructor, we just need userId and link
	public LoginLink(String userId, String link){
		this.userId = userId;
		this.link = link;
	}
	
	public LoginLink(){
		//default
	}
	
	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	
	public Calendar getExpiry() {
		return expiry;
	}
	public void setExpiry() {
		System.out.println("Setting expiry");
		Calendar now = Calendar.getInstance();
		now.add(Calendar.MINUTE, EXPIRY_MINUTES);
		this.expiry = now;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	

}
