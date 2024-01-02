package com.example.demo.entities;

public class Remark {
	
	/*
	 appointment_id: appointmentprofile.appointment_id,
              remark: remarks
	 */
	
	private int  appointment_id;
	
	private String remark;

	public Remark() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Remark(int appointment_id, String remark) {
		super();
		this.appointment_id = appointment_id;
		this.remark = remark;
	}

	public int getAppointment_id() {
		return appointment_id;
	}

	public void setAppointment_id(int appointment_id) {
		this.appointment_id = appointment_id;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	
	

}
