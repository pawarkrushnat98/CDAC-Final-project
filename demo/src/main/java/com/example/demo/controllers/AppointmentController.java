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
import com.example.demo.entities.Case;
import com.example.demo.entities.Counsellor;
import com.example.demo.entities.NextAppointmentBook;
import com.example.demo.entities.Patient;
import com.example.demo.entities.Remark;
import com.example.demo.services.AppointmentServices;
import com.example.demo.services.CaseService;
import com.example.demo.services.CounsellorService;
import com.example.demo.services.PatientService;

@CrossOrigin(origins="http://localhost:3000")
@RestController
public class AppointmentController {

	@Autowired
	AppointmentServices apservice;
	
	@Autowired
	CounsellorService cservice;
	
	@Autowired
	CaseService caseservice;
	
	@Autowired
	PatientService pservice;
	
	@GetMapping("/getallappointmnets")
	public List<Appointment> getAllAppointments()
	{
		return apservice.getAllAppointment();
	}
	
	@GetMapping("/getappointmentbyid")
	public Appointment getAppointmentById(@RequestParam("appointment_id") int appointment_id)
	{
		return apservice.getAppointmentById(appointment_id);
	}
	
	@GetMapping("/getrunningappointment")
	public List<Appointment>  getRunningAppointmentByCounsellor(@RequestParam("counsellor_id") int counsellor_id)
	{
		Counsellor s=cservice.getCounsellorById(counsellor_id);
		return apservice.getRunningAppointmentByCounsellor(s);
	}
	@GetMapping("/getcompletedappointment")
	public List<Appointment>  getCompletedAppointmentByCounsellor (@RequestParam("counsellor_id") int counsellor_id)
	{
		Counsellor s=cservice.getCounsellorById(counsellor_id);
		return apservice.getCompletedAppointmentByCounsellor(s);
	}
	
	@PostMapping("/makeRemark")
	public Appointment setRemark(@RequestBody Remark r)
	{
		
		System.out.println(r.getAppointment_id());
		System.out.println(r.getRemark());
		int appointment_id=r.getAppointment_id();
		Appointment m=apservice.getAppointmentById(appointment_id);
		m.setRemark(r.getRemark());
		m.setStatus(true);
	   return apservice.saveAppointment(m);
		
	}
	
	@PostMapping("/bookNextAppointment")
	public Appointment  makeNextAppointment(@RequestBody NextAppointmentBook l)
	{
		System.out.println(l.getCase_id());
		System.out.println(l.getBookdate());
		
		int case_id=l.getCase_id();
		Case df =caseservice.getCaseById(case_id);
		
		String s=l.getBookdate();
		
		Date e=Date.valueOf(s);
		Appointment ld=new Appointment(df,e,null,false);
		return apservice.appointmentRegister(ld);
		
	}
	
	@GetMapping("/getrunningappointmentbypatient")
	public List<Appointment> getAllRunningAppointmentByPatient(@RequestParam("patient_id") int patient_id)
	{
		Patient p=pservice.getPatientById(patient_id);
		return apservice.getRunningAppointmentByPatient(p);
	}
	
}
