package com.example.demo.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Counsellor;
import com.example.demo.entities.Profile;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Integer> {

    @Query("select a from Profile a where a.case_id.counsellor_id=:cid")
	public List<Profile> getCounsellorBlogDetails(Counsellor cid);
}
