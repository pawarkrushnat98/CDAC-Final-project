package com.example.demo.services;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Availability;
import com.example.demo.entities.Counsellor;
import com.example.demo.repositories.AvailabilityRepository;


@Service
public class AvailabilityService {
	@Autowired
	AvailabilityRepository avrepo;
    
	
	public Availability  getSchedule(Counsellor counsellor_id)
	{
		return avrepo.getSchedule(counsellor_id);
	}
	
	public Availability saveSchedule(Availability e)
	{
		return avrepo.save(e);
	}
	
	public Availability getAvailabilityById(int appointment_id)
	{
		return avrepo.findById(appointment_id).get();
	}
}
