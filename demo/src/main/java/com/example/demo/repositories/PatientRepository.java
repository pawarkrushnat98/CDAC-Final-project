package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.example.demo.entities.Login;
import com.example.demo.entities.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {

	
	@Query("select c from Patient c where login_id= :l")
	public Patient getPatient(Login l);
}
