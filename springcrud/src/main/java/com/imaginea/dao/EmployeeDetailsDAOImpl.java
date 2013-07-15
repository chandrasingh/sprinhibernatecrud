package com.imaginea.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.imaginea.model.EmployeeDetails;

@Repository
public class EmployeeDetailsDAOImpl implements EmployeeDetailsDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	public void createEmployeeDetail(EmployeeDetails employee) {
		sessionFactory.getCurrentSession().save(employee);
	}

	@Transactional
	public List<EmployeeDetails> readEmployeeDetail() {
		System.out.println("in dao readempdetails");
		return sessionFactory.getCurrentSession().createQuery("from EmployeeDetails").list();
	}

	@Transactional
	public void updateEmployeeDetail(EmployeeDetails employee) {
		System.out.println("in dao updateEmployeeDetail");
		System.out.println("employee.id: " + employee.getId().toString());
		System.out.println("employee.managerId: " + employee.getManagerId().toString());
		System.out.println("employee.getFirstName: " + employee.getFirstName());
		System.out.println("employee.getLastName: " + employee.getLastName());
		System.out.println("employee.getEmail: " + employee.getEmail());
		System.out.println("employee.getUserName: " + employee.getUserName());
		
		
		sessionFactory.getCurrentSession().update(employee);

	}

	@Transactional
	public void deleteEmployeeDetail(EmployeeDetails employee) {
		sessionFactory.getCurrentSession().delete(employee);
	}

	@Transactional
	public EmployeeDetails getEmployeeDetail(Integer id) {
		return (EmployeeDetails) sessionFactory.getCurrentSession().get(EmployeeDetails.class, id);
	}

}
