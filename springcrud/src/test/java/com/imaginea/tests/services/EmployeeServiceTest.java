package com.imaginea.tests.services;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.imaginea.model.EmployeeDetails;
import com.imaginea.services.EmployeeService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:mvc-dispatcher-servlet.xml")
@Transactional
public class EmployeeServiceTest {
	@Autowired
	private EmployeeService service;
	

	EmployeeDetails emp, empRetrieved;
	List<EmployeeDetails> empList;
	Integer empID;
	
	@Test
	public void createEmployeeDetails(){
		emp = new EmployeeDetails();
		emp.setEmail("email_createEmployeeDetails");
		emp.setFirstName("firstName_createEmployeeDetails");
		emp.setLastName("lastName_createEmployeeDetails");
		emp.setUserName("userName_createEmployeeDetails");
		emp.setManagerId(new Integer(0));
		
		empID = service.createEmployeeDetail(emp);
		
		empRetrieved = service.getEmployeeDetail(empID);
		
		Assert.assertEquals(emp.getEmail(), empRetrieved.getEmail());
		Assert.assertEquals(emp.getFirstName(), empRetrieved.getFirstName());
		Assert.assertEquals(emp.getLastName(), empRetrieved.getLastName());
		Assert.assertEquals(emp.getUserName(), empRetrieved.getUserName());
		Assert.assertEquals(emp.getManagerId(), empRetrieved.getManagerId());
	}
	
	@Test
	public void deleteEmployeeDetail(){
		emp = new EmployeeDetails();
		emp.setEmail("email_deleteEmployeeDetail");
		emp.setFirstName("firstName_deleteEmployeeDetail");
		emp.setLastName("lastName_deleteEmployeeDetail");
		emp.setUserName("userName_deleteEmployeeDetail");
		emp.setManagerId(new Integer(0));
		
		empID = service.createEmployeeDetail(emp);
		empRetrieved = service.getEmployeeDetail(empID);
		service.deleteEmployeeDetail(empRetrieved);
		
		empRetrieved = service.getEmployeeDetail(empID);
		Assert.assertEquals(empRetrieved, null);
	}
	
	@Test
	public void updateEmployeeDetail(){
		emp = new EmployeeDetails();
		emp.setEmail("email_newEmployeeDetail");
		emp.setFirstName("firstName_newEmployeeDetail");
		emp.setLastName("lastName_newEmployeeDetail");
		emp.setUserName("userName_newEmployeeDetail");
		emp.setManagerId(new Integer(0));

		emp.setEmail("email_updatedEmployeeDetail");
		emp.setFirstName("firstName_updatedEmployeeDetail");
		emp.setLastName("lastName_updatedEmployeeDetail");
		emp.setUserName("userName_updatedEmployeeDetail");
		emp.setManagerId(new Integer(1));
		
		empID = service.createEmployeeDetail(emp);
		service.updateEmployeeDetail(emp);
		empRetrieved = service.getEmployeeDetail(empID);
		
		Assert.assertEquals(emp.getEmail(), empRetrieved.getEmail());
		Assert.assertEquals(emp.getFirstName(), empRetrieved.getFirstName());
		Assert.assertEquals(emp.getLastName(), empRetrieved.getLastName());
		Assert.assertEquals(emp.getUserName(), empRetrieved.getUserName());
		Assert.assertEquals(emp.getManagerId(), empRetrieved.getManagerId());
	}
	
	@Test
	public void getEmployeeDetail_parameter(){
		emp = new EmployeeDetails();
		emp.setEmail("email_getEmployeeDetailEmployeeDetail");
		emp.setFirstName("firstName_getEmployeeDetailEmployeeDetail");
		emp.setLastName("lastName_getEmployeeDetailEmployeeDetail");
		emp.setUserName("userName_getEmployeeDetailEmployeeDetail");
		emp.setManagerId(new Integer(0));
		
		empID = service.createEmployeeDetail(emp);
		empList = service.getEmployeeDetail("email", "email_getEmployeeDetailEmployeeDetail");
		
		empRetrieved = (EmployeeDetails)empList.get(0);
		
		Assert.assertEquals(emp.getEmail(), empRetrieved.getEmail());
		Assert.assertEquals(emp.getFirstName(), empRetrieved.getFirstName());
		Assert.assertEquals(emp.getLastName(), empRetrieved.getLastName());
		Assert.assertEquals(emp.getUserName(), empRetrieved.getUserName());
		Assert.assertEquals(emp.getManagerId(), empRetrieved.getManagerId());
	}
	
	@Test
	public void getEmployeeDetail_all(){
		emp = new EmployeeDetails();
		emp.setEmail("email_getEmployeeDetailEmployeeDetail");
		emp.setFirstName("firstName_getEmployeeDetailEmployeeDetail");
		emp.setLastName("lastName_getEmployeeDetailEmployeeDetail");
		emp.setUserName("userName_getEmployeeDetailEmployeeDetail");
		emp.setManagerId(new Integer(0));
		
		empID = service.createEmployeeDetail(emp);
		empList = service.getEmployeeDetail();
		empRetrieved = (EmployeeDetails)empList.get(empList.size() - 1);
		
		Assert.assertTrue(empList.size() > 0);
		Assert.assertEquals(emp.getEmail(), empRetrieved.getEmail());
		Assert.assertEquals(emp.getFirstName(), empRetrieved.getFirstName());
		Assert.assertEquals(emp.getLastName(), empRetrieved.getLastName());
		Assert.assertEquals(emp.getUserName(), empRetrieved.getUserName());
		Assert.assertEquals(emp.getManagerId(), empRetrieved.getManagerId());
	}
}
