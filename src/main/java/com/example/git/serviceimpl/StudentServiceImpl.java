package com.example.git.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.git.entity.Student;
import com.example.git.repository.StudentRepository;
import com.example.git.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	private StudentRepository studentRepository;

	@Override
	public List<Student> getAllStudents() {
		
		return studentRepository.findAll();
	}

	@Override
	public Optional<Student> getStudentById(Long id) {
		
		return studentRepository.findById(id);
	}

	@Override
	public Student createStudent(Student student) {
		
		return studentRepository.save(student);
	}

	@Override
	public Student updateStudent(Long id, Student studentDetails) {
		Student s=studentRepository.findById(id).get();
		 Student student = studentRepository.findById(id).get();
	        student.setName(studentDetails.getName());
	        student.setBranch(studentDetails.getBranch());
	        return studentRepository.save(student);
	    }

	    public void deleteStudent(Long id) {
	        studentRepository.deleteById(id);
	    }
	    	
	    }