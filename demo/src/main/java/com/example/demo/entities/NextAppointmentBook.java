package com.example.demo.entities;

public class NextAppointmentBook 
{
	private int case_id;
	
	private String bookdate;

	public NextAppointmentBook() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NextAppointmentBook(int case_id, String bookdate) {
		super();
		this.case_id = case_id;
		this.bookdate = bookdate;
	}

	public int getCase_id() {
		return case_id;
	}

	public void setCase_id(int case_id) {
		this.case_id = case_id;
	}

	public String getBookdate() {
		return bookdate;
	}

	public void setBookdate(String bookdate) {
		this.bookdate = bookdate;
	}

	
	
}
