package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.app.entities.Employee;
import com.app.repository.EmployeeRepo;

@Service

public class EmployeeServiceImpl  implements EmployeeService {

	@Autowired
	private EmployeeRepo empRepo;
	
	@Override
	public List<Employee> getAllEmployees() {
		
		return empRepo.findAll();
	}

	@Override
	public Optional<Employee> getEmployeeById(Long id) {
		// TODO Auto-generated method stub
		return empRepo.findById(id);
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		
		return empRepo.save(employee);
	}

	@Override
	public String deleteEmployee(Long id) {
		
		
		String mesg="Id invalid cannot delete record";
		if(empRepo.existsById(id))
		{
			empRepo.deleteById(id);
			mesg="Deleted Successfully";
		}
		
		return mesg;
		
		
	}

	@Override
	public String updateEmployee(Long id, Employee employee) {
		
		String msg="Employee details updated successfully";
		 if (!empRepo.getEmployeeById(id).isPresent()) {
	            msg = "Employye details update failed";
		 }
		 employee.setId(id);
	        Employee updatedEmployee = empRepo.save(employee);
	        if(updatedEmployee == null)
	        {
	        	msg="Employye details update failed";
	        }
	        return msg;
	}

}
