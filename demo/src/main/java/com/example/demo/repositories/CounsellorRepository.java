package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entities.Counsellor;
import com.example.demo.entities.Login;

@Repository
@Transactional
public interface CounsellorRepository extends JpaRepository<Counsellor, Integer> {
	
	@Query("select c from Counsellor c where login_id= :l")
	public Counsellor getCounsellor(Login l);

	@Query("select c from Counsellor c where login_id.status=false")
	public List<Counsellor>  getUnapprovedCounsellor();
	
	
   @Query("update Counsellor c set login_id.status=true where counsellor_id=:counsellor_id")
   public void setApproveCounsellor(int counsellor_id);
   
   @Query("select c from Counsellor c where login_id.status=true")
   public List<Counsellor>  getapprovedList();
   

}
