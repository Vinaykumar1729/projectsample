package com.example.employeebackend.Controller;

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

import com.example.employeebackend.Entity.Employee;
import com.example.employeebackend.Service.EmployeeService;
import com.example.employeebackend.exception.ResourceNotFoundException;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
	@Autowired
	private EmployeeService emps;
	
	@PostMapping("/create")
	public Employee createEmployee(@RequestBody Employee emp) {
		return emps.createEmployee(emp);
	}
	@GetMapping("{id}")
	public Employee getEmployeeById(@PathVariable("id")Long EmployeeId) throws ResourceNotFoundException {
		return emps.getEmployeeById(EmployeeId);
	}
	@GetMapping("getall")
	public List<Employee> getAllEmployees(){
		return emps.getAllEmployees();
	}
	@PutMapping("{id}")
	public Employee updateEmployee(@PathVariable("id") Long eid,@RequestBody Employee updateemp) throws ResourceNotFoundException {
		return emps.updateEmployee(eid,updateemp);
	}
	@DeleteMapping("{id}")
	public void deleteEmployee(@PathVariable("id") Long employeeId) throws ResourceNotFoundException {
		 emps.deleteEmployee(employeeId);
	}
	

}
