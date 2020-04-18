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
@RequestMapping("/delete")
@CrossOrigin("http://localhost:4981")
public class EmployeeRestController {

	@Autowired
	
	EmployeeService empService;
	
	@Autowired
	RestTemplate rest;
	
	//*************************
    @DeleteMapping("/deleteEmpById/{empId}")
    public void deleteEmp(@PathVariable ("empId") int empId)
    {
    	Employee e= rest.getForObject("http://localhost:1001/list/findById/"+empId ,Employee.class);
	     
    	if(e==null)
	     {
	    	System.out.println("no records to delelte with the given id"+empId); 
	     }
	     else
	     {
	    	 
    	empService.deleteEmpById(e);
	     }
	 
    }
    
  

@DeleteMapping("/deleteallEmployees")
public void deleteallEmp()
{
	List l1= (List) rest.getForObject("http://localhost:1001/list/ListAllEmployees", Employee.class);
  empService.deleteallEmp();
  

}
}



