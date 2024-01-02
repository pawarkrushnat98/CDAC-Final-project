package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Counsellor;
import com.example.demo.entities.Profile;
import com.example.demo.repositories.ProfileRepository;

@Service
public class ProfileService 
{
    @Autowired
	ProfileRepository prepo;
    
    
    public List<Profile> getCounsellorBlogDetails(Counsellor counsellor_id)
    {
    	
    	return prepo.getCounsellorBlogDetails(counsellor_id);
    	
    	
    }
    
    
    public Profile  saveCaseBlogDetails(Profile p)
    {
    	return prepo.save(p);
    }
}
