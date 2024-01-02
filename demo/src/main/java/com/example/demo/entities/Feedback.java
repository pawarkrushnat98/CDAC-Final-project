package com.example.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="feedbacks")
public class Feedback 
{
	//feedback_id, case_id, comment
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int feedback_id;
	
	@OneToOne
	@JoinColumn(name = "case_id")
	private Case case_id;
	
	@Column
	private String comment;

	public Feedback() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Feedback(Case case_id, String comment) {
		super();
		this.case_id = case_id;
		this.comment = comment;
	}

	public int getFeedback_id() {
		return feedback_id;
	}

	public void setFeedback_id(int feedback_id) {
		this.feedback_id = feedback_id;
	}

	public Case getCase_id() {
		return case_id;
	}

	public void setCase_id(Case case_id) {
		this.case_id = case_id;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
	
}
