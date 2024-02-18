package com.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.StreamingHttpOutputMessage.Body;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entities.Employee;
import com.app.service.EmployeeService;

@RestController
@RequestMapping("/employees")
@CrossOrigin(origins = "http://localhost:3000")
public class EmployeeController {

	  @Autowired
	    private EmployeeService employeeService;

	    @GetMapping("/employee")
	    public List<Employee> getAllEmployees() {
	        return employeeService.getAllEmployees();
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
	        Optional<Employee> employee = employeeService.getEmployeeById(id);
	        return employee.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	    }

	    @PostMapping
	    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
	        Employee savedEmployee = employeeService.saveEmployee(employee);
	        return ResponseEntity.status(HttpStatus.CREATED).body(savedEmployee);
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<String> updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
	        String updatedemployee=employeeService.updateEmployee(id,employee);
	        return ResponseEntity.status(HttpStatus.CREATED).body(updatedemployee );
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<String> deleteEmployee(@PathVariable Long id) {

	    	return ResponseEntity.status(HttpStatus.ACCEPTED).body(  employeeService.deleteEmployee(id));
	    }
}
