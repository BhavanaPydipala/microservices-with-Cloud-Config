package com.cap.anurag.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cap.anurag.entity.Employee;
import com.cap.anurag.service.EmployeeService;

@RestController
@RequestMapping("/update")
@CrossOrigin("http://localhost:4981")
public class EmployeeRestController {

	@Autowired
	EmployeeService empService;
	
	@Autowired
	RestTemplate rest;
	
	@PutMapping("/updateEmp")
	public String updateEmployee(@RequestBody Employee emp) {
		Employee e = rest.getForObject("http://localhost:1001/list/findById/"+emp.getId(), Employee.class);
		if(e != null) {
			/*emp.setEname(e.getEname());
			emp.setEsal(e.getEsal());
			*/
			empService.updateEmployee(emp);
			return "employee details were updated successfully!!";
		}
		else {
			return "not updated the records ";
		}
	}		
	}
	




