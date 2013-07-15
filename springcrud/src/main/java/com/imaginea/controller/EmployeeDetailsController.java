package com.imaginea.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.imaginea.services.EmployeeService;

@Controller
public class EmployeeDetailsController {
	
	@Autowired
	EmployeeService employeeService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(ModelMap model) {
		System.out.println("in index");
		model.addAttribute("message", "Its Working");
		model.addAttribute("message2", "Its Really working.");
		return "index";
	}

}
