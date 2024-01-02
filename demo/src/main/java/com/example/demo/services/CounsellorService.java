package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Counsellor;
import com.example.demo.entities.Login;
import com.example.demo.repositories.CounsellorRepository;

@Service
public class CounsellorService {
	
	@Autowired
	CounsellorRepository crepo;
	
	public Counsellor registerCounsellor(Counsellor d)
	{
		return crepo.save(d);
	}
	
	public List<Counsellor> getAllCounsellor()
	{
		return crepo.findAll();
	}
	
	public Counsellor getCounsellor(Login l)
	{
		return crepo.getCounsellor(l);
	}
	
	public List<Counsellor> getUnapprovedCounsellor()
	{
		return crepo.getUnapprovedCounsellor();
	}
	
	public void setApproval()
	{
		
	}
	public List<Counsellor> approvedCounsellor()
	{
		return crepo.getapprovedList();
	}
	
	public  Counsellor getCounsellorById(int Counsellor_id)
	{
		return crepo.findById(Counsellor_id).get();
	}
	
	
	
	
	

}
