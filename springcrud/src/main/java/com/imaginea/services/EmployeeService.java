package com.imaginea.services;

import java.util.List;

import com.imaginea.model.EmployeeDetails;

public interface EmployeeService {
	public void createEmployeeDetail(EmployeeDetails employee);
	public List<EmployeeDetails> readEmployeeDetail();
	public void updateEmployeeDetail(EmployeeDetails employee);
	public void deleteEmployeeDetail(EmployeeDetails employee);
}
