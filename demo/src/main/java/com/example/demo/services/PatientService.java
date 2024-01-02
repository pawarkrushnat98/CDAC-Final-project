package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Login;
import com.example.demo.entities.Patient;
import com.example.demo.repositories.PatientRepository;

@Service
public class PatientService 
{
    @Autowired
	PatientRepository prepo;
    
    public Patient registerPatient(Patient p)
    {
    	return prepo.save(p);
    }
	
    public List<Patient> getAllPatient()
    {
    	return prepo.findAll();
    }
    
    public Patient  getPatient(Login l)
    {
    	return prepo.getPatient(l);
    }
    
    public Patient getPatientById(int patient_id)
    {
    	return prepo.findById(patient_id).get();
    }
}
