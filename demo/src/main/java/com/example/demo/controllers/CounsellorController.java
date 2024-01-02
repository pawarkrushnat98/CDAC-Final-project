package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Area;
import com.example.demo.entities.Availability;
import com.example.demo.entities.Counsellor;
import com.example.demo.entities.CounsellorRegister;
import com.example.demo.entities.Login;
import com.example.demo.entities.PassBasedEnc;
import com.example.demo.entities.Role;
import com.example.demo.entities.SaltValue;
import com.example.demo.entities.SecurityQuestion;
import com.example.demo.services.AreaService;
import com.example.demo.services.AvailabilityService;
import com.example.demo.services.CounsellorService;
import com.example.demo.services.LoginService;
import com.example.demo.services.RoleService;
import com.example.demo.services.SecurityQuestionService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class CounsellorController {

	@Autowired
	CounsellorService cservice;
	
	@Autowired
	RoleService rservice;
	
	@Autowired
	SecurityQuestionService sservice;
	
	@Autowired
	AreaService aservice;
	
	@Autowired
	LoginService lservice;
	
	@Autowired
	AvailabilityService availabilityservice;
	
	
	@Autowired
	SaltValue svalue;
	
	@PostMapping("/regCounsellor")
	public Counsellor regCounsellor(@RequestBody CounsellorRegister cr)
	{
		Role r = rservice.getRole(2);
		
		int a=Integer.parseInt(cr.getQuestion_id());
		
		SecurityQuestion s=sservice.findById(a);
		
		System.out.println(svalue.getSalt());
		String encrypted=PassBasedEnc.generateSecurePassword(cr.getPassword(), svalue.getSalt());
	    
		Login l = new Login(cr.getEmail_id(),encrypted,r ,false,s,cr.getAnswer());
		lservice.save(l);
	    
		int d=Integer.parseInt(cr.getArea());
	     
		Area b= aservice.findById(d);
	          
	      Counsellor c=new Counsellor(cr.getFname(),cr.getMname(),cr.getLname(),cr.getContact(),cr.getAddress_line(),b,
	    		 
	     cr.getGender(),cr.getSpecialization(),cr.getExperience(),l);
	     
	     Counsellor db=cservice.registerCounsellor(c);
	     
	     Availability available=new Availability();
	     available.setMonday(false);
	     available.setTuesday(false);
	     available.setWednesday(false);
	     available.setThursday(false);
	     available.setFriday(false);
	     available.setCounsellor_id(db);
	     
	     availabilityservice.saveSchedule(available);
	     return db;
	}
	
	@GetMapping("/getallcounsellor")
	public List<Counsellor> getAllCounsellor()
	{
		return cservice.getAllCounsellor();
		
	}
	
	@GetMapping("/getCounsellor")
	public Counsellor getCounsellor(@RequestParam("login_id") int login_id)
	{
		
		Login l=lservice.getById(login_id);
		return cservice.getCounsellor(l);
	}
	
	@GetMapping("/getcounsellorapprovalchecklist")
	public List<Counsellor>  getUnapprovedCounsellor()
	{
		return cservice.getUnapprovedCounsellor();
	}
	
	@GetMapping("/allapprovedcounsellor")
	public List<Counsellor> getApprovedList()
	{
	      return cservice.approvedCounsellor();
	}
	
	@GetMapping("/approve")
	public boolean approveCounsellor(@RequestParam("counsellor_id") int counsellor_id)
	{
		Counsellor s=cservice.getCounsellorById(counsellor_id);
		s.getLogin_id().setStatus(true);
		Counsellor c= cservice.registerCounsellor(s);
		return c.getLogin_id().isStatus();
	
		
	}
	
	
	@GetMapping("/getcounsellorbyid")
  public Counsellor getCounsellorById(@RequestParam("counsellor_id") int counsellor_id)
  {
	  return cservice.getCounsellorById(counsellor_id);
	  
  }
	
	
	
}
