package com.example.git.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.git.entity.Employee;
import com.example.git.repository.EmployeeRepository;
import com.example.git.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee getEmployeeById(long id) {
		Optional<Employee> optionalEmployee = employeeRepository.findById(id);
		return optionalEmployee.get();
	}

	@Override
	public Employee updateEmployee(Employee employee, long id) {
		Employee e = employeeRepository.findById(id).get();
		e.setName(employee.getName());
		e.setEmail(employee.getEmail());
		e.setSalary(employee.getSalary());
		return employeeRepository.save(e);
	}

	@Override
	public void deleteEmployeeById(long id) {
		employeeRepository.findById(id).get();
		employeeRepository.deleteById(id);
	}

}
