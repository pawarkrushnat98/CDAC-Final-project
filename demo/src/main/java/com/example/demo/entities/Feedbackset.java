package com.example.demo.entities;

public class Feedbackset 
{
  
	private int case_id;
	
	private String comment;

	public Feedbackset() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Feedbackset(int case_id, String comment) {
		super();
		this.case_id = case_id;
		this.comment = comment;
	}

	public int getCase_id() {
		return case_id;
	}

	public void setCase_id(int case_id) {
		this.case_id = case_id;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	
	
	
}
