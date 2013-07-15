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
		if(action!= null && action.equals("edit")){
			Integer id = new Integer(strId);
			model.addAttribute(action, employeeService.getEmployeeDetail(id));
		}
		
		List<EmployeeDetails> employeeList = employeeService.readEmployeeDetail();
		
		model.addAttribute("employees", employeeList);
		return "index";
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(HttpServletRequest request) {
		System.out.println("in update");
		System.out.println("firstName: " + request.getParameter("firstName"));

		String id = request.getParameter("id");
		String managerID = request.getParameter("managerID");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String userName = request.getParameter("userName");
		String email = request.getParameter("email");
		
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

}
