package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Area;
import com.example.demo.entities.City;
import com.example.demo.services.AreaService;


@CrossOrigin(origins="http://localhost:3000")
@RestController
public class AreaController {
	
	@Autowired
	AreaService aservice;
	
	@GetMapping("/getAllAreas")
	public List<Area> getAll()
	{
		System.out.println("in the controller");
		return aservice.getAll();
	}
	
	@GetMapping("/getAllAreasById")
	public List<Area> getAllByCityId(@RequestParam int cityid)
	{
		City c=new City();
		c.setCity_id(cityid);
		return aservice.getAllByCityId(c);
	}

}
