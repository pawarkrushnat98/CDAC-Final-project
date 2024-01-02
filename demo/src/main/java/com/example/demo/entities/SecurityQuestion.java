package com.example.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="securityquestions")
public class SecurityQuestion 
{
	@Id
	private int question_id;
	
	@Column
	private String question_name;

	public int getQuestion_id() {
		return question_id;
	}

	public void setQuestion_id(int question_id) {
		this.question_id = question_id;
	}

	public String getQuestion_name() {
		return question_name;
	}

	public void setQuestion_name(String question_name) {
		this.question_name = question_name;
	}

	public SecurityQuestion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SecurityQuestion(String question_name) {
		super();
		this.question_name = question_name;
	}
	
	

}
