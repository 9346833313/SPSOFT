package com.example.git.service;

import java.util.List;
import java.util.Optional;

import com.example.git.entity.Student;

public interface StudentService {
	

		public List<Student> getAllStudents() ;
			
		
	    public Optional<Student> getStudentById(Long id) ;
	    	
	    
	    public Student createStudent(Student student) ;
			
	    public Student updateStudent(Long id, Student studentDetails) ;
	       

	    public void deleteStudent(Long id) ;
	        
	    }