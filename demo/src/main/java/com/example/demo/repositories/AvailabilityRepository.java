package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Availability;
import com.example.demo.entities.Counsellor;


@Repository
public interface AvailabilityRepository extends JpaRepository<Availability, Integer> 
{
	@Query("select a from Availability a where counsellor_id=:counsellor_id")
	public Availability getSchedule(Counsellor counsellor_id);
}
