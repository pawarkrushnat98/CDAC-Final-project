 package com.example.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="areas")
public class Area {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int area_id;
	
	@Column
	private String area_name;
	
	@ManyToOne
	@JoinColumn(name = "city_id")
	private City city_id;
	
	

	public Area() {
		super();
		// TODO Auto-generated constructor stub
	}
    
	public Area(String area_name, City city_id) {
		super();
		this.area_name = area_name;
		this.city_id = city_id;
	}

	public int getArea_id() {
		return area_id;
	}

	public void setArea_id(int area_id) {
		this.area_id = area_id;
	}

	public String getArea_name() {
		return area_name;
	}

	public void setArea_name(String area_name) {
		this.area_name = area_name;
	}

	public City getCity_id() {
		return city_id;
	}

	public void setCity_id(City city_id) {
		this.city_id = city_id;
	}
	
	

}
