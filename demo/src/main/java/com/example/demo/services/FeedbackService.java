package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Counsellor;
import com.example.demo.entities.Feedback;
import com.example.demo.repositories.FeedbackRepository;

@Service
public class FeedbackService {
    
	@Autowired
	FeedbackRepository frepo;
	
	public Feedback saveFeedback(Feedback p)
	{
		return frepo.save(p);
	}
	
	public  List<Feedback> getAllFeedbackByCounsellor(Counsellor counsellor_id)
	{
		return frepo.getFeedbackByCounsellor(counsellor_id);
	}
}
