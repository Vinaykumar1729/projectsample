package com.example.employeebackend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.employeebackend.Entity.Employee;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long>{
	

}
