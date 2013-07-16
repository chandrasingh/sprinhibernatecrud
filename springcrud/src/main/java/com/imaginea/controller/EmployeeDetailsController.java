package com.imaginea.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.imaginea.model.EmployeeDetails;
import com.imaginea.services.EmployeeService;

@Controller
public class EmployeeDetailsController {

	@Autowired
	EmployeeService employeeService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(ModelMap model, HttpServletRequest request) {
		System.out.println("in index");
		String action = request.getParameter("action");
		String strId = request.getParameter("id");
		Integer id;
		EmployeeDetails employee;
		
		if (action != null && action.equals("edit")) {
			id = new Integer(strId);
			model.addAttribute(action, employeeService.getEmployeeDetail(id));
		}
		else if(action != null && action.equals("delete")){
			id = new Integer(strId);
			employee = employeeService.getEmployeeDetail(id);
			if(employee != null){
				employeeService.deleteEmployeeDetail(employee);
				model.addAttribute("message", "Employee "+ employee.getFirstName() +" with email id " + employee.getEmail() + " was successfull deleted.");
			}else{
				model.addAttribute("message", "Employee id " + strId + " was not found!");
			}
		}

		List<EmployeeDetails> employeeList = employeeService.getEmployeeDetail();

		model.addAttribute("employees", employeeList);
		return "index";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(HttpServletRequest request) {
		System.out.println("in update");

		String id = request.getParameter("id");
		String managerID = request.getParameter("managerID");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String userName = request.getParameter("userName");
		String email = request.getParameter("email");
		
		System.out.println("managerID: " + managerID);

		EmployeeDetails employeeDetails = new EmployeeDetails();

		employeeDetails.setId(new Integer(id));
		employeeDetails.setManagerId(new Integer(managerID));
		employeeDetails.setFirstName(firstName);
		employeeDetails.setLastName(lastName);
		employeeDetails.setUserName(userName);
		employeeDetails.setEmail(email);

		employeeService.updateEmployeeDetail(employeeDetails);

		return "redirect:/";
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(HttpServletRequest request) {
		System.out.println("in create");

		String managerID = request.getParameter("managerID");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");

		EmployeeDetails employeeDetails = new EmployeeDetails();

		employeeDetails.setManagerId(new Integer(managerID));
		employeeDetails.setFirstName(firstName);
		employeeDetails.setLastName(lastName);
		employeeDetails.setUserName(email);//this is for internal use. needs to be unique
		employeeDetails.setEmail(email);

		employeeService.createEmployeeDetail(employeeDetails);

		return "redirect:/";
	}
}
