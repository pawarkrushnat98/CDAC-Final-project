package com.example.demo.entities;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SaltValue 
{
    @Value("${spring.saltvalue}")
	private String salt;

	public SaltValue() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SaltValue(String salt) {
		super();
		this.salt = salt;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}
    
    
}
