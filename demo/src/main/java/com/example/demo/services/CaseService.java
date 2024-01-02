package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Case;
import com.example.demo.entities.Counsellor;
import com.example.demo.entities.Patient;
import com.example.demo.repositories.CaseRepository;

@Service
public class CaseService {

	@Autowired
	CaseRepository crepo;
	
	
	
	public Case caseRegister(Case case_id)
	{
		return crepo.save(case_id);
	}
	
	
	public Case getCaseById(int case_id)
	{
		return crepo.findById(case_id).get();
	}
	
	public List<Case> getAllClosedCases()
	{
		return crepo.getAllClosedCases();
	}
	
	public List<Case> getAllClosedCasesByCounsellor(Counsellor counsellor_id)
	{
		return crepo.getAllClosedCasesByCounsellor(counsellor_id);
	}
	
	public List<Case>  getAllClosedCasesByPatient(Patient patient_id)
	{
		return crepo.getAllClosedCasesByPatient(patient_id);
	}
	
	
	
}
