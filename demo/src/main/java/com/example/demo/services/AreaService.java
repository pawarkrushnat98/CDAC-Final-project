package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Area;
import com.example.demo.entities.City;
import com.example.demo.repositories.AreaRepository;

@Service
public class AreaService {
	
	@Autowired
	AreaRepository arepo;
	
	public List<Area> getAll()
	{
		return arepo.findAll();
	}
	
	public List<Area> getAllByCityId(City cityid)
	{
		return arepo.getAllByCityId(cityid);
	}
	
	public Area findById(int area_id)
	{
		return arepo.findById(area_id).get();
	}

}
