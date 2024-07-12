package com.example.git.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.git.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
