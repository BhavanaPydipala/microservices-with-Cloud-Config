package com.cap.anurag.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cap.anurag.entity.Employee;
import com.cap.anurag.service.EmployeeService;

@RestController
@RequestMapping("/create")
@CrossOrigin("http://localhost:4981")
public class EmployeeRestController {

	@Autowired
	EmployeeService empService;
	
	//*************************
	@PostMapping("/CreateAccount")
	public String createAccount(@RequestBody Employee emp)
	{
		Employee employee=empService.createEmployee(emp);
		if(employee==null)
		{
			return "Insertion Failed!!!!!";
		}
		else
		{
			return "Inserted the record Successfully!!!!!!";
		}
		
	}
	
	
	}



