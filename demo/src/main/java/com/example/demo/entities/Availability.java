package com.example.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Availability {
	
	//availability_id, counsellor_id, monday, tuesday, wednesday, thursday, friday
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int availability_id;
	
	
	@OneToOne
	@JoinColumn(name="counsellor_id")
	private Counsellor counsellor_id;
	
	
	@Column
	private boolean monday, tuesday, wednesday, thursday, friday;


	public Availability() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Availability(Counsellor counsellor_id, boolean monday, boolean tuesday, boolean wednesday, boolean thursday,
			boolean friday) {
		super();
		this.counsellor_id = counsellor_id;
		this.monday = monday;
		this.tuesday = tuesday;
		this.wednesday = wednesday;
		this.thursday = thursday;
		this.friday = friday;
	}


	public int getAvailability_id() {
		return availability_id;
	}


	public void setAvailability_id(int availability_id) {
		this.availability_id = availability_id;
	}


	public Counsellor getCounsellor_id() {
		return counsellor_id;
	}


	public void setCounsellor_id(Counsellor counsellor_id) {
		this.counsellor_id = counsellor_id;
	}


	public boolean isMonday() {
		return monday;
	}


	public void setMonday(boolean monday) {
		this.monday = monday;
	}


	public boolean isTuesday() {
		return tuesday;
	}


	public void setTuesday(boolean tuesday) {
		this.tuesday = tuesday;
	}


	public boolean isWednesday() {
		return wednesday;
	}


	public void setWednesday(boolean wednesday) {
		this.wednesday = wednesday;
	}


	public boolean isThursday() {
		return thursday;
	}


	public void setThursday(boolean thursday) {
		this.thursday = thursday;
	}


	public boolean isFriday() {
		return friday;
	}


	public void setFriday(boolean friday) {
		this.friday = friday;
	}
	
	
	
	

}
