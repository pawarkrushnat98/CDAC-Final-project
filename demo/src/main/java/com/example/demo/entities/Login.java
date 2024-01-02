package com.example.demo.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="login")
public class Login 
{
	//login_id, email_id, password, role_id, status, question_id, answer
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int login_id;
	
	@Column
	private String email_id;
	@Column
	private String password;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "role_id")
	private Role role_id;
	
	@Column
	private boolean status;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="question_id")
	private SecurityQuestion question_id;
	
	

	
	@Column
	private String answer;




	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}




	public Login(String email_id, String password, Role role_id, boolean status, SecurityQuestion question_id,
			String answer) {
		super();
		this.email_id = email_id;
		this.password = password;
		this.role_id = role_id;
		this.status = status;
		this.question_id = question_id;
		this.answer = answer;
	}




	public int getLogin_id() {
		return login_id;
	}




	public void setLogin_id(int login_id) {
		this.login_id = login_id;
	}




	public String getEmail_id() {
		return email_id;
	}




	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}




	public String getPassword() {
		return password;
	}




	public void setPassword(String password) {
		this.password = password;
	}




	public Role getRole_id() {
		return role_id;
	}




	public void setRole_id(Role role_id) {
		this.role_id = role_id;
	}




	public boolean isStatus() {
		return status;
	}




	public void setStatus(boolean status) {
		this.status = status;
	}




	public SecurityQuestion getQuestion_id() {
		return question_id;
	}




	public void setQuestion_id(SecurityQuestion question_id) {
		this.question_id = question_id;
	}




	public String getAnswer() {
		return answer;
	}




	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	

}
