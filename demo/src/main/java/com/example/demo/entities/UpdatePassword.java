package com.example.demo.entities;

public class UpdatePassword 
{
	
	private String login_id;
	
	
	private String password;


	public UpdatePassword() {
		super();
		// TODO Auto-generated constructor stub
	}


	public UpdatePassword(String login_id, String password) {
		super();
		this.login_id = login_id;
		this.password = password;
	}


	public String getLogin_id() {
		return login_id;
	}


	public void setLogin_id(String login_id) {
		this.login_id = login_id;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	
	

}
