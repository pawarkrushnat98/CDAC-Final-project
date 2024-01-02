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
@Table(name="profile")
public class Profile {
 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int profile_id;
	
	@OneToOne
	@JoinColumn(name = "case_id")
	private Case case_id;
	
	@Column
	private String details;

	public Profile() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Profile(Case case_id, String details) {
		super();
		this.case_id = case_id;
		this.details = details;
	}

	public int getProfile_id() {
		return profile_id;
	}

	public void setProfile_id(int profile_id) {
		this.profile_id = profile_id;
	}

	public Case getCase_id() {
		return case_id;
	}

	public void setCase_id(Case case_id) {
		this.case_id = case_id;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}
	
	
	
	
	
	
}
