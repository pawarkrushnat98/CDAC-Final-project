package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Area;
import com.example.demo.entities.Counsellor;
import com.example.demo.entities.CounsellorRegister;
import com.example.demo.entities.Login;
import com.example.demo.entities.PassBasedEnc;
import com.example.demo.entities.Patient;
import com.example.demo.entities.PatientRegister;
import com.example.demo.entities.Role;
import com.example.demo.entities.SaltValue;
import com.example.demo.entities.SecurityQuestion;
import com.example.demo.services.AreaService;
import com.example.demo.services.CounsellorService;
import com.example.demo.services.LoginService;
import com.example.demo.services.PatientService;
import com.example.demo.services.RoleService;
import com.example.demo.services.SecurityQuestionService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class PatientController {
	
	@Autowired
	PatientService pservice;
	
	@Autowired
	RoleService rservice;
	
	@Autowired
	SecurityQuestionService sservice;
	
	@Autowired
	AreaService aservice;
	
	@Autowired
	LoginService lservice;
	
	@Autowired
	SaltValue saltservice;
	
	
	@PostMapping("/regpatient")
	public Patient regPatient(@RequestBody PatientRegister pr)
	{
		Role r = rservice.getRole(3);
		
		int a=Integer.parseInt(pr.getQuestion_id());
		
		String encrypted=PassBasedEnc.generateSecurePassword(pr.getPassword(), saltservice.getSalt());
		
		SecurityQuestion s=sservice.findById(a);
	    
		Login l = new Login(pr.getEmail_id(),encrypted,r ,true,s,pr.getAnswer());
		lservice.save(l);
	    
		int d=Integer.parseInt(pr.getArea());
	     
		Area b= aservice.findById(d);
	          
	      Patient p = new Patient(pr.getFname(),pr.getMname(),pr.getLname(),pr.getContact(),pr.getAddress_line(),b,
	    		 
	     pr.getGender(),l);
	     
	     return pservice.registerPatient(p);
	}
	
	@GetMapping("/getallpatient")
	public List<Patient> getAllPatient()
	{
		return pservice.getAllPatient();
	}
	
	@GetMapping("/getPatient")
	public Patient getPatient(@RequestParam("login_id") int login_id)
	{
		Login l=lservice.getById(login_id);
		return pservice.getPatient(l);
		
	}
	
}
