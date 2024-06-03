package com.employee.crudspringboot.service;

import java.util.List;
import java.util.Optional;

import com.employee.crudspringboot.entity.Employee;

public interface EmployeeService {

	List<Employee> getAllEmployees();

	Employee save(Employee employee);

	Optional<Employee> getEmployeeById(long id);

	Employee updateEmployee(Employee employee, long id);

	void deleteEmployee(long id);

	

}
