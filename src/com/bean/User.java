package com.bean;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="C")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private	Long id = 0L;
	
	private String name;
	private String email;
	private String pincode;
	private String userId;
	
	public User(){}
	

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public long getId(){
		return id;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public void setId(long id){
		this.id= id;
	}
	public String getUserId(){
		return userId;
	}
	public void setUserId(){
		this.userId = this.name + "_" + this.email;
	}
	
	
}
