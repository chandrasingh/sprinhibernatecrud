package com.imaginea.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employees_details")
public class EmployeeDetails {
	
	@Id
	@Column(name = "id")
	@GeneratedValue
	private Integer id;
	
	@Column(name="email")
	private String email;
	
	@Column(name="manager_id")
	private Integer managerId;
	
	@Column(name="user_name")
	private String userName;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;

	public Integer getId(){
		return id;
	}

	public void setId(Integer value){
		id = value;
	}
	
	public Integer getManagerId(){
		return managerId;
	}

	public void setManagerId(Integer value){
		managerId = value;
	}

	public String getEmail(){
		return email;
	}
	
	public void setEmail(String value){
		email = value;
	}
	
	public String getUserName(){
		return userName;
	}
	
	public void setUserName(String value){
		email = userName;
	}
	
	public String getFirstName(){
		return firstName;
	}
	
	public void setFirstName(String value){
		firstName = value;
	}
	
	public String getLastName(){
		return lastName;
	}
	
	public void setLastName(String value){
		lastName = value;
	}
}
