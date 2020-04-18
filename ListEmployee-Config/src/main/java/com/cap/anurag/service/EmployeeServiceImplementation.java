package com.cap.anurag.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cap.anurag.dao.EmployeeDao;
import com.cap.anurag.entity.Employee;


@Service
@Transactional
public class EmployeeServiceImplementation implements EmployeeService {
@Autowired
EmployeeDao  empDao;
@Override
public List<Employee> findAllEmployees() {
	// TODO Auto-generated method stub
	return empDao.findAll();
}
@Override
public Employee findEmployee(Integer empId) {
	// TODO Auto-generated method stub
	return empDao.findOne(empId);
}

}
