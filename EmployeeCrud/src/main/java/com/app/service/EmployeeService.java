package com.app.service;

import java.util.List;
import java.util.Optional;

import com.app.entities.Employee;

public interface EmployeeService {

	 public List<Employee> getAllEmployees();
	 
	 public Optional<Employee> getEmployeeById(Long id) ;
	 
	 public Employee saveEmployee(Employee employee);
	 
	 public String deleteEmployee(Long id);
	 
	 public String updateEmployee(Long id, Employee employee);

}
