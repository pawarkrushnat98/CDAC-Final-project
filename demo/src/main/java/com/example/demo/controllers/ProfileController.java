package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Case;
import com.example.demo.entities.Counsellor;
import com.example.demo.entities.Feedbackset;
import com.example.demo.entities.Profile;
import com.example.demo.services.CaseService;
import com.example.demo.services.CounsellorService;
import com.example.demo.services.ProfileService;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class ProfileController {
	
	@Autowired
	ProfileService pservice;
	
	
	@Autowired
	CounsellorService cservice;
	
	@Autowired
	CaseService caseservice;
	
	@GetMapping("/getCounsellorBlogDetails")
	public List<Profile> getCounsellorBlogDetails(@RequestParam("counsellor_id") int counsellor_id)
	{
		Counsellor c=cservice.getCounsellorById(counsellor_id);
		return pservice.getCounsellorBlogDetails(c);
	}
	
	
	@PostMapping("/giveblog")
	public Profile  saveCaseBlogDetails(@RequestBody Feedbackset f )
	{
		System.out.println(f.getCase_id());
		System.out.println(f.getComment());
	        Case c= caseservice.getCaseById(f.getCase_id());
	        
	        Profile p=new Profile();
	        p.setCase_id(c);
	        p.setDetails(f.getComment());
	        
	      return  pservice.saveCaseBlogDetails(p);
		
	}

}
