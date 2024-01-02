package com.example.demo.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="cases")
public class Case {
	
	//case_id, patient_id, counsellor_id, problem, date, status
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int case_id;
	
	@ManyToOne
	@JoinColumn(name="patient_id")
	private Patient patient_id;
	
	@ManyToOne
	@JoinColumn(name="counsellor_id")
	private Counsellor counsellor_id;
	
	@Column
	private String problem;
	
	
	
	@Column
	private boolean status;

	public Case() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Case(Patient patient_id, Counsellor counsellor_id, String problem, boolean status) {
		super();
		this.patient_id = patient_id;
		this.counsellor_id = counsellor_id;
		this.problem = problem;
		this.status = status;
	}

	public int getCase_id() {
		return case_id;
	}

	public void setCase_id(int case_id) {
		this.case_id = case_id;
	}

	public Patient getPatient_id() {
		return patient_id;
	}

	public void setPatient_id(Patient patient_id) {
		this.patient_id = patient_id;
	}

	public Counsellor getCounsellor_id() {
		return counsellor_id;
	}

	public void setCounsellor_id(Counsellor counsellor_id) {
		this.counsellor_id = counsellor_id;
	}

	public String getProblem() {
		return problem;
	}

	public void setProblem(String problem) {
		this.problem = problem;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	

	
	
	

}
