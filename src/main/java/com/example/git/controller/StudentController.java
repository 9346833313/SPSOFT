package com.example.git.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.git.entity.Student;
import com.example.git.service.StudentService;

@RestController
@RequestMapping("/api/students")

	public class StudentController {
	    @Autowired
	    private StudentService studentService;

	    @GetMapping
	    public List<Student> getAllStudents() {
	        return studentService.getAllStudents();
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<Optional<Student>> getStudentById(@PathVariable Long id) {
	        Optional<Student> student = studentService.getStudentById(id);
	        return ResponseEntity.ok().body(student);
	    }

	    @PostMapping
	    public Student createStudent(@RequestBody Student student) {
	        return studentService.createStudent(student);
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student studentDetails) {
	        Student updatedStudent = studentService.updateStudent(id, studentDetails);
	        return ResponseEntity.ok(updatedStudent);
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
	        studentService.deleteStudent(id);
	        return ResponseEntity.noContent().build();
	    }
	}
