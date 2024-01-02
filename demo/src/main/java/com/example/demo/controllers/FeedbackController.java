package com.example.demo.controllers;

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
import com.example.demo.entities.Feedback;
import com.example.demo.entities.Feedbackset;
import com.example.demo.services.CaseService;
import com.example.demo.services.CounsellorService;
import com.example.demo.services.FeedbackService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class FeedbackController 
{
	
	@Autowired
	FeedbackService fservice;
	
	@Autowired
	CaseService cservice;
	
	@Autowired
	CounsellorService counsellorservice;
	
	@PostMapping("/giveFeedback")
	public Feedback giveFeedback(@RequestBody Feedbackset f)
	{
		
		System.out.println(f.getCase_id());
		System.out.println(f.getComment());
		Case c=cservice.getCaseById(f.getCase_id());
		Feedback d=new Feedback();
		d.setCase_id(c);
		d.setComment(f.getComment());
		return fservice.saveFeedback(d);
		
	}
	
	@GetMapping("/getallfeedbackbycounsellor")
	public List<Feedback>  getAllFeedbackByCounsellor(@RequestParam ("counsellor_id") int counsellor_id)
	{
		Counsellor d=counsellorservice.getCounsellorById(counsellor_id);
		return fservice.getAllFeedbackByCounsellor(d);
		
		
	}
	
	
	
	
	
	

}
