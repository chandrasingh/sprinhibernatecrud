package com.imaginea.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.imaginea.model.EmployeeDetails;

@Repository
public class EmployeeDetailsDAOImpl implements EmployeeDetailsDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	public void createEmployeeDetail(EmployeeDetails employee) {
		sessionFactory.getCurrentSession().save(employee);
	}

	public List<EmployeeDetails> readEmployeeDetail() {
		return sessionFactory.getCurrentSession().createQuery("from EmployeeDetails").list();
	}

	public void updateEmployeeDetail(EmployeeDetails employee) {
		sessionFactory.getCurrentSession().save(employee);

	}

	public void deleteEmployeeDetail(EmployeeDetails employee) {
		sessionFactory.getCurrentSession().delete(employee);
	}

}
