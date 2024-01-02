package com.example.demo.entities;


public class AppointmentBook 
{
	/*counsellor_id: counselloprofile.counsellor_id,
    patient_id: patientprofile.patient_id,
    problem:counselloprofile.specialization,
    datebook: datebooks*/
	
	private int counsellor_id;
	
	
	private int patient_id;
	
	
	private String problem;
	
	
	private String datebook;


	public AppointmentBook() {
		super();
		// TODO Auto-generated constructor stub
	}


	public AppointmentBook(int counsellor_id, int patient_id, String problem, String datebook) {
		super();
		this.counsellor_id = counsellor_id;
		this.patient_id = patient_id;
		this.problem = problem;
		this.datebook = datebook;
	}


	public int getCounsellor_id() {
		return counsellor_id;
	}


	public void setCounsellor_id(int counsellor_id) {
		this.counsellor_id = counsellor_id;
	}


	public int getPatient_id() {
		return patient_id;
	}


	public void setPatient_id(int patient_id) {
		this.patient_id = patient_id;
	}


	public String getProblem() {
		return problem;
	}


	public void setProblem(String problem) {
		this.problem = problem;
	}


	public String getDatebook() {
		return datebook;
	}


	public void setDatebook(String datebook) {
		this.datebook = datebook;
	}


	
	
}
