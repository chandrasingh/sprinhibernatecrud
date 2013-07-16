package com.imaginea.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imaginea.dao.EmployeeDetailsDAO;
import com.imaginea.model.EmployeeDetails;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	EmployeeDetailsDAO employeeDetailsDao;

	public void createEmployeeDetail(EmployeeDetails employee) {
		employeeDetailsDao.createEmployeeDetail(employee);
	}
	public void updateEmployeeDetail(EmployeeDetails employee) {
		employeeDetailsDao.updateEmployeeDetail(employee);
	}

	public void deleteEmployeeDetail(EmployeeDetails employee) {
		employeeDetailsDao.deleteEmployeeDetail(employee);

	}

	public EmployeeDetails getEmployeeDetail(Integer id) {
		return employeeDetailsDao.getEmployeeDetail(id);
	}

	public List<EmployeeDetails> getEmployeeDetail(String parameter, String value) {
		return employeeDetailsDao.getEmployeeDetail(parameter, value);
	}

	public List<EmployeeDetails> getEmployeeDetail() {
		return employeeDetailsDao.getEmployeeDetail();
	}

}
