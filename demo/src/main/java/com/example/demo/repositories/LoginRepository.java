package com.example.demo.repositories;

import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Login;
import com.example.demo.entities.SecurityQuestion;

@Repository
public interface LoginRepository extends JpaRepository<Login, Integer> 
{
    @Query("select a from Login a where email_id=:email_id and password=:password")
	public Optional<Login> getLogin(String email_id,String password);
    
   
    @Query("select a from Login a where email_id=:email_id and question_id=:question_id and answer=:answer")
    public Optional<Login> getLoginForForgotPassword(String email_id,SecurityQuestion question_id,String answer);
    
}
