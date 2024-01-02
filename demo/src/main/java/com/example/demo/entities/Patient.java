package com.example.demo.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="patients")
public class Patient 
{
	//patient_id, fname, mname, lname, contact, address_line, area_id, gender, login_id
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int patient_id;
	
	@Column
	private String fname;
	
	@Column
	private String mname;
	
	@Column
	private String lname;
	
	@Column
	private String contact;
	
	@Column
	private String address_line;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "area_id")
	private Area area_id;
	
	
	@Column
	private String gender;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "login_id")
	private Login login_id;

	public Patient() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Patient(String fname, String mname, String lname, String contact, String address_line, Area area_id,
			String gender, Login login_id) {
		super();
		this.fname = fname;
		this.mname = mname;
		this.lname = lname;
		this.contact = contact;
		this.address_line = address_line;
		this.area_id = area_id;
		this.gender = gender;
		this.login_id = login_id;
	}

	public int getPatient_id() {
		return patient_id;
	}

	public void setPatient_id(int patient_id) {
		this.patient_id = patient_id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getAddress_line() {
		return address_line;
	}

	public void setAddress_line(String address_line) {
		this.address_line = address_line;
	}

	public Area getArea_id() {
		return area_id;
	}

	public void setArea_id(Area area_id) {
		this.area_id = area_id;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Login getLogin_id() {
		return login_id;
	}

	public void setLogin_id(Login login_id) {
		this.login_id = login_id;
	}
	
	
	
	

}
