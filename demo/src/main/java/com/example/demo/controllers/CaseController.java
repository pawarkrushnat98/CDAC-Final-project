package com.example.demo.controllers;



import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Appointment;
import com.example.demo.entities.AppointmentBook;
import com.example.demo.entities.Case;
import com.example.demo.entities.CloseCase;
import com.example.demo.entities.Counsellor;
import com.example.demo.entities.Patient;
import com.example.demo.services.AppointmentServices;
import com.example.demo.services.CaseService;
import com.example.demo.services.CounsellorService;
import com.example.demo.services.PatientService;



@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class CaseController {

	@Autowired
	CaseService cservice;
	
	@Autowired
    CounsellorService counsellorservice;
    
    
    @Autowired
    PatientService pservice;
    
    @Autowired
    AppointmentServices aservice;
    
    
   
	

	@PostMapping("/bookAppointment")
	public Appointment bookAppointment(@RequestBody AppointmentBook a)
	{
		System.out.println(a.getCounsellor_id());
		System.out.println(a.getPatient_id());
		System.out.println(a.getProblem());
		System.out.println(a.getDatebook());
		Counsellor s=counsellorservice.getCounsellorById(a.getCounsellor_id());
		Patient p=pservice.getPatientById(a.getPatient_id());
		Case d=new Case(p,s,a.getProblem(),false);
		cservice.caseRegister(d);
		String s1=a.getDatebook();
		System.out.println("----"+s1+"------");
		
		
		
		Date e=Date.valueOf(s1);
		
	
	
	/*	Date d1=null;
		try {
		   d1=   sdf1.parse(a.getDatebook());
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		*/
	Appointment l=new Appointment(d,e,null,false);
		return aservice.appointmentRegister(l);
		
	}
	
	
	@PostMapping("/closecase")
	public boolean  caseClose(@RequestBody CloseCase l)
	{
		int id=l.getCase_id();
		
		Case df=cservice.getCaseById(id);
		
		df.setStatus(true);
		
		Case c= cservice.caseRegister(df);
		
		return c.isStatus();
		 
		 
	}
	
	@GetMapping("/getallclosedcases")
	public List<Case> getAllClosedCases()
	{
		return cservice.getAllClosedCases();
	}
	
	@GetMapping("/getcasebyid")
	public Case getCaseById(@RequestParam ("case_id") int case_id)
	{
		return cservice.getCaseById(case_id);
	}
	
	@GetMapping("/getallclosedcasesbycounsellor")
	public List<Case>  getAllClosedCasesByCounsellorId(@RequestParam ("counsellor_id") int counsellor_id)
	{
		Counsellor s=counsellorservice.getCounsellorById(counsellor_id);
		return cservice.getAllClosedCasesByCounsellor(s);
	}
	 
	@GetMapping("/getallclosedcasesbypatient")
	public List<Case>  getAllClosedCasesByPatientId(@RequestParam ("patient_id") int patient_id)
	{
		Patient p=pservice.getPatientById(patient_id);
		
		return cservice.getAllClosedCasesByPatient(p);
	}
}
