package com.bean;

public class User {
	private String username , password ,email,mobileNumber;
	private int id;
	public User() {};
	
	public User(int id ,String username, String password, String email, String mobileNumber) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.mobileNumber = mobileNumber;
		
	}

	public User(String username, String password, String email, String mobileNumber) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.mobileNumber = mobileNumber;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", email=" + email + ", mobileNumber="
				+ mobileNumber + ", id=" + id + "]";
	}
	
}
