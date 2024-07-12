package com.example.git.service;

import java.util.List;

import com.example.git.entity.Employee;

public interface EmployeeService {

	public Employee saveEmployee(Employee employee);

	public List<Employee> getAllEmployees();

	public Employee getEmployeeById(long id);

	public Employee updateEmployee(Employee employee, long id);

	public void deleteEmployeeById(long id);
}
