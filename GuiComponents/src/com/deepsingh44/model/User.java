package com.deepsingh44.model;

public class User {
	private String name;
	private String email;
	private String pass;
	private String mobile;
	private String image;

	public User(String name, String email, String pass, String mobile, String image) {
		this.name = name;
		this.email = email;
		this.pass = pass;
		this.mobile = mobile;
		this.image = image;
	}

	public User() {

	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

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

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

}
