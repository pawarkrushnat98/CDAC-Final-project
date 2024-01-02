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
@Table(name="admins")
public class Admin {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int admin_id;
	
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

	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Admin(String fname, String mname, String lname, String contact, String address_line, Area area_id,
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

	public int getAdmin_id() {
		return admin_id;
	}

	public void setAdmin_id(int admin_id) {
		this.admin_id = admin_id;
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
