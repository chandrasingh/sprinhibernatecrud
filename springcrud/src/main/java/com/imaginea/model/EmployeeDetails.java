package com.imaginea.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employees_details")
public class EmployeeDetails {
	
	private Integer id;
	
	private String email;
	
	private Integer managerId;
	
	private String userName;
	
	private String firstName;
	
	private String lastName;
	
	@Id
	@GeneratedValue
	@Column(name = "id")
	public Integer getId(){
		return id;
	}

	public void setId(Integer value){
		id = value;
	}
	
	@Column(name="manager_id")
	public Integer getManagerId(){
		return managerId;
	}

	public void setManagerId(Integer value){
		managerId = value;
	}

	@Column(name="email")
	public String getEmail(){
		return email;
	}
	
	public void setEmail(String value){
		email = value;
	}
	
	@Column(name="user_name")
	public String getUserName(){
		return userName;
	}
	
	public void setUserName(String value){
		email = userName;
	}
	
	@Column(name="first_name")
	public String getFirstName(){
		return firstName;
	}
	
	public void setFirstName(String value){
		firstName = value;
	}
	
	@Column(name="last_name")
	public String getLastName(){
		return lastName;
	}
	
	public void setLastName(String value){
		lastName = value;
	}
}
