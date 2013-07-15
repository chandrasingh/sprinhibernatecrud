package com.imaginea.dao;

import java.util.List;

import com.imaginea.model.EmployeeDetails;

public interface EmployeeDetailsDAO {
	public void createEmployeeDetail(EmployeeDetails employee);
	public List<EmployeeDetails> readEmployeeDetail();
	public void updateEmployeeDetail(EmployeeDetails employee);
	public void deleteEmployeeDetail(EmployeeDetails employee);
}
