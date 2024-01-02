package com.example.demo.controllers;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Availability;
import com.example.demo.entities.AvailabilityDemo;
import com.example.demo.entities.Counsellor;
import com.example.demo.services.AvailabilityService;
import com.example.demo.services.CounsellorService;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class AvailabilityController 
{
	
	@Autowired
	AvailabilityService aservice;
	
	
	@Autowired
	CounsellorService cservice;
	
	
	@GetMapping("/getschedule")
	public Availability  getSchedule(@RequestParam("counsellor_id") int counsellor_id)
	{
		System.out.println(counsellor_id);
	      Counsellor s= cservice.getCounsellorById(counsellor_id);
	              return aservice.getSchedule(s);
	}
	
	
	@PostMapping("/updateSchedule")
	public Availability updateSchedule (@RequestBody AvailabilityDemo l)
	{
	 System.out.println(l.getAvailid()+"suraj");
	 System.out.println(l.getCid());
	  Availability a=   aservice.getAvailabilityById(l.getAvailid());
	  a.setMonday(l.isMonday());
	  a.setTuesday(l.isTuesday());
	  a.setWednesday(l.isWednesday());
	  a.setThursday(l.isThursday());
	  a.setFriday(l.isFriday());
	  return aservice.saveSchedule(a);
	}
	
	


}
