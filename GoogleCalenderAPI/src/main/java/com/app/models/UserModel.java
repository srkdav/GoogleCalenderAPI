package com.app.models;

public class UserModel {

	private String name;
	private String email;
	public UserModel() {
		super();
	}
	public UserModel(String name, String email) {
		super();
		this.name = name;
		this.email = email;
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
	@Override
	public String toString() {
		return "UserModel [name=" + name + ", email=" + email + "]";
	}
		
}
