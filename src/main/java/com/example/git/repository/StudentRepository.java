package com.example.git.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.git.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{

}
