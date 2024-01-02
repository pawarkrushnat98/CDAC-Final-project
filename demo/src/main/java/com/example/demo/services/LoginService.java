package com.example.demo.services;

import java.util.Optional;

import org.aspectj.weaver.patterns.TypePatternQuestions.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Login;
import com.example.demo.entities.SecurityQuestion;
import com.example.demo.repositories.LoginRepository;

@Service
public class LoginService {

	@Autowired
	LoginRepository loginrepo;
	
	public Login getLogin(String email_id,String password)
	{
		Login r;
		Optional<Login> a1=loginrepo.getLogin(email_id, password);
		try
		{
			r=a1.get();
		}
		catch(Exception e)
		{
			r=null;
			
		}
		return r;
	}
	
	public Login save(Login l)
	{
		return loginrepo.save(l);
	}
	
	public Login getById(int login_id)
	{
		return loginrepo.findById(login_id).get();
	}
	
	public Login getLoginForForgetPassword(String email_id,SecurityQuestion question_id,String answer) 
	{
		Login r;
		Optional<Login> a1=loginrepo.getLoginForForgotPassword(email_id, question_id, answer);
		try
		{
			r=a1.get();
		}
		catch(Exception e)
		{
			r=null;
		}
		
		return r;
	} 
	
}
