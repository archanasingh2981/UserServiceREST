package com.bean;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name="usertable")
@XmlRootElement
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private	Long id = 0L;
	
	@XmlElement private String name;
	@XmlElement private String email;
	@XmlElement private String pincode;
	private String userId;
	
	public User(String name, String email, String pincode){
		this.name = name;
		this.email = email;
		this.pincode = pincode;
	}
	
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
