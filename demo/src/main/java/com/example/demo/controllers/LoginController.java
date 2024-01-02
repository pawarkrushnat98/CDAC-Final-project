package com.example.demo.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.ForgotPassword;
import com.example.demo.entities.Login;
import com.example.demo.entities.LoginCheck;
import com.example.demo.entities.PassBasedEnc;
import com.example.demo.entities.SaltValue;
import com.example.demo.entities.SecurityQuestion;
import com.example.demo.entities.UpdatePassword;
import com.example.demo.services.LoginService;
import com.example.demo.services.SecurityQuestionService;



@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class LoginController
{
	@Autowired
	LoginService loginservice;
	
	@Autowired
	SecurityQuestionService securityservice;
	
	@Autowired
	SaltValue sservice;
	
	
	
	
	
	@PostMapping("/checklogin")
	public Login checkLogin(@RequestBody LoginCheck lcheck)
	{
		System.out.println(sservice.getSalt());
		String encrypted=PassBasedEnc.generateSecurePassword(lcheck.getPassword(), sservice.getSalt());
		System.out.println(encrypted);
		return loginservice.getLogin(lcheck.getEmail_id(), encrypted);
		
	}
	
	@PostMapping("/checkloginforpassword")
	public Login getLoginForForgetPassword(@RequestBody ForgotPassword f)
	{
		System.out.println(f.getAnswer());
		System.out.println(f.getEmail_id());
		System.out.println(f.getQuestion_id());
		
		int a=Integer.parseInt(f.getQuestion_id());
		
	SecurityQuestion s=	securityservice.findById(a);
	
	 return loginservice.getLoginForForgetPassword(f.getEmail_id(), s, f.getAnswer());
	
		
		
		
	}
	
	@PostMapping("/updatepassword")
	public Login  updatePassword(@RequestBody UpdatePassword p)
	{
		System.out.println(p.getLogin_id());
		System.out.println(p.getPassword());
		
		String encrypted=PassBasedEnc.generateSecurePassword(p.getPassword(), sservice.getSalt());
		
		int a=Integer.parseInt(p.getLogin_id());
		  Login l=loginservice.getById(a);
		  l.setPassword(encrypted);
		 return loginservice.save(l);
		
	}
	
	
	
	
	
	
	
	

}
