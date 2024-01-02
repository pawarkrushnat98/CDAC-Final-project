package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Counsellor;
import com.example.demo.entities.Feedback;
@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, Integer> {

	@Query("select c from Feedback c where case_id.counsellor_id=:counsellor_id")
	public List<Feedback> getFeedbackByCounsellor(Counsellor counsellor_id);
	
}
