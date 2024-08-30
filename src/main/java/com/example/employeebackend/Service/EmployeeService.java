package com.example.employeebackend.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.employeebackend.Entity.Employee;
import com.example.employeebackend.Repository.EmployeeRepository;
import com.example.employeebackend.exception.ResourceNotFoundException;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository emp;

	public Employee createEmployee(Employee emp2) {
		
		return emp.save(emp2);
	}

	public Employee getEmployeeById(Long employeeId) throws ResourceNotFoundException {
		
		Employee e= emp.findById(employeeId)
				.orElseThrow(()->new ResourceNotFoundException("Employee id is not exists"+employeeId));
		return e;
	}

	public List<Employee> getAllEmployees() {
		
		return emp.findAll();
	}

	public Employee updateEmployee(Long eid, Employee updateemp) throws ResourceNotFoundException {
		Employee e=emp.findById(eid).orElseThrow(()->new ResourceNotFoundException("Employee id is not exists"+eid));
		e.setFirstName(updateemp.getFirstName());
		e.setLastName(updateemp.getLastName());
		e.setEmail(updateemp.getEmail());
		return emp.save(e);
		
	}

	public void deleteEmployee(Long employeeId) throws ResourceNotFoundException {
		Employee e=emp.findById(employeeId).orElseThrow(()->new ResourceNotFoundException("Employee id is not exists"+employeeId));
		 emp.deleteById(employeeId);
	}
	
	
	

}
