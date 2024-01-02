package com.example.demo.entities;

public class AvailabilityDemo {
	
	private boolean monday,tuesday,wednesday,thursday,friday;
	
	private int cid;
	
	private int availid;

	public AvailabilityDemo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AvailabilityDemo(boolean monday, boolean tuesday, boolean wednesday, boolean thursday, boolean friday,
			int cid, int availid) {
		super();
		this.monday = monday;
		this.tuesday = tuesday;
		this.wednesday = wednesday;
		this.thursday = thursday;
		this.friday = friday;
		this.cid = cid;
		this.availid = availid;
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

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public int getAvailid() {
		return availid;
	}

	public void setAvailid(int availid) {
		this.availid = availid;
	}
	
	
	
	

}
