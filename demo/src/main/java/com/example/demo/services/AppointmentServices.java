package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Appointment;
import com.example.demo.entities.Case;
import com.example.demo.entities.Counsellor;
import com.example.demo.entities.Patient;
import com.example.demo.repositories.AppointmentRepository;

@Service
public class AppointmentServices {

	@Autowired
	AppointmentRepository arepo;
	
	public Appointment appointmentRegister(Appointment appointment_id)
	{
		return arepo.save(appointment_id);
	}
	
	public Appointment getAppointmentById(int appointment_id)
	{
		return arepo.findById(appointment_id).get();
		
	}
	
	public List<Appointment>  getAllAppointment()
	{
		return arepo.findAll();
	}
	
	public List<Appointment>  getAllAppointmentByCounsellor(Counsellor counsellor_id)
	{
		return arepo.getAllAppointmentByCounsellor(counsellor_id);
	}
	
	public List<Appointment>  getRunningAppointmentByCounsellor(Counsellor counsellor_id)
	{
		return arepo.getRunningAppointmentByCounsellor(counsellor_id);
	}
	
	public List<Appointment>  getCompletedAppointmentByCounsellor(Counsellor counsellor_id)
	{
		return arepo.getCompletedAppointmentByCounsellor(counsellor_id);
	}
	
	public Appointment saveAppointment(Appointment p)
	{
		return arepo.save(p);
	}
	
	public List<Appointment>  getRunningAppointmentByPatient(Patient patient_id)
	{
		return arepo.getRunningAppointmentByPatient(patient_id);
		
	}
	/*
	public List<Appointment>  getCompletedAppointmentByPatient(Patient patient_id)
	{
		return arepo.getCompletedAppointmentByPatient(patient_id);
	}*/
    
}
