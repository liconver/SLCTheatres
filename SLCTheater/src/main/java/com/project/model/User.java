package com.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class User {
	
	/*@Id
	@Column(name="user_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int userid;*/
	
	@Id
	@Column(name="username",unique=true,nullable=false)
	private String username;
	
	@Column(name="user_password",nullable=false)
	private String password;
	
	@Column(name="firstname",nullable=false)
	private String lastname;
	
	@Column(name="lastname",nullable=false)
	private String firstname;
	
	@Column(name="email",unique=true,nullable=false)
	private String email;

	public User() {
	}


	public User(String username, String password, String lastname, String firstname, String email) {
		super();
		this.username = username;
		this.password = password;
		this.lastname = lastname;
		this.firstname = firstname;
		this.email = email;
	}
	
	public User(String username) {
		this.username = username;
	}
	
	

	/*public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}*/

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", lastname=" + lastname
				+ ", firstname=" + firstname + ", email=" + email + "]";
	}
	
	
	
	
	

}
