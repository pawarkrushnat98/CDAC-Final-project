package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Case;
import com.example.demo.entities.Counsellor;
import com.example.demo.entities.Patient;

@Repository
public interface CaseRepository extends JpaRepository<Case, Integer> {
	
	@Query("select c from Case c where status=true")
	public List<Case>  getAllClosedCases();
	
	@Query("select c from Case c where status=true and counsellor_id=:counsellor_id")
	public List<Case>  getAllClosedCasesByCounsellor(Counsellor counsellor_id);
	
	@Query("select c from Case c where status=true and patient_id=:patient_id")
	public List<Case>  getAllClosedCasesByPatient (Patient patient_id);
	
		
	

	
	
	
}
