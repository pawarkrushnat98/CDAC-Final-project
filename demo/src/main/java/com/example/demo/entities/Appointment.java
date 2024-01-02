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

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="appointments")
public class Appointment {

	//appointment_id, case_id, nextdate, remark, status
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int appointment_id;
	
	@ManyToOne
	@JoinColumn(name="case_id")
	private Case case_id;
	
    //@JsonFormat(pattern = "yyyy-MM-dd")
	@Column
	private Date appointment_date;
	
	@Column
	private String remark;
	

	@Column
	private boolean status;
	
	

	public Appointment() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	



	public Appointment(Case case_id, Date appointment_date, String remark, boolean status) {
		super();
		this.case_id = case_id;
		this.appointment_date = appointment_date;
		this.remark = remark;
		this.status = status;
	}







	public int getAppointment_id() {
		return appointment_id;
	}

	public void setAppointment_id(int appointment_id) {
		this.appointment_id = appointment_id;
	}

	public Case getCase_id() {
		return case_id;
	}

	public void setCase_id(Case case_id) {
		this.case_id = case_id;
	}

	public Date getAppointment_date() {
		return appointment_date;
	}

	public void setAppointment_date(Date appointment_date) {
		this.appointment_date = appointment_date;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	
	
	
	
	
	
	
}
