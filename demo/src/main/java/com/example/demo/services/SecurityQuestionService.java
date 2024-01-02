package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.SecurityQuestion;
import com.example.demo.repositories.SecurityQuestionRepository;

@Service
public class SecurityQuestionService {

	@Autowired
	 SecurityQuestionRepository srepo;
	
	public List<SecurityQuestion> getAll()
	{
		return srepo.findAll();
	}
	
	public SecurityQuestion findById(int question_id)
	{
		return srepo.findById(question_id).get();
	}
	
	
}
