package com.example.demo.entities;

public class ForgotPassword 
{
	
	private String email_id;
	
	
	private String question_id;
	
	
	private String answer;


	public ForgotPassword() {
		super();
		// TODO Auto-generated constructor stub
	}


	public ForgotPassword(String email_id, String question_id, String answer) {
		super();
		this.email_id = email_id;
		this.question_id = question_id;
		this.answer = answer;
	}


	public String getEmail_id() {
		return email_id;
	}


	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}


	public String getQuestion_id() {
		return question_id;
	}


	public void setQuestion_id(String question_id) {
		this.question_id = question_id;
	}


	public String getAnswer() {
		return answer;
	}


	public void setAnswer(String answer) {
		this.answer = answer;
	}


	
	

}
