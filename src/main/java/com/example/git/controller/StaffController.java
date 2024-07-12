package com.example.git.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.git.entity.Staff;
import com.example.git.serviceImpl.StaffServiceImpl;

@RestController
@RequestMapping("/api")
public class StaffController {
	@Autowired
	private StaffServiceImpl staffService;

	@PostMapping("/staff")
	public ResponseEntity<Staff> createStaff(@RequestBody Staff staff) {
		Staff savedStaff = staffService.createStaff(staff);
		return new ResponseEntity<>(savedStaff, HttpStatus.CREATED);

	}

	@GetMapping("staff/{id}")
	public ResponseEntity<Staff> getStudentId(@PathVariable("id") Long StaffId) {
		Staff staff = staffService.getStaffById(StaffId);
		return new ResponseEntity<>(staff, HttpStatus.OK);

	}

	@GetMapping("/staff")
	public ResponseEntity<List<Staff>> getAllStaff() {
		List<Staff> list = staffService.getAllStaff();
		return new ResponseEntity<List<Staff>>(list, HttpStatus.OK);

	}

	@PutMapping("staff/{id}")
	public ResponseEntity<Staff> updateStaff(@PathVariable("id") Long staffId, @RequestBody Staff staff) {
		staff.setId(staffId);
		Staff updatedStaff = staffService.UpdateStaff(staff);
		return new ResponseEntity<>(updatedStaff, HttpStatus.OK);

	}

	@DeleteMapping("staff/{id}")
	public ResponseEntity<String> deleteStaff(@PathVariable("id") Long staffId) {
		staffService.deleteStaff(staffId);
		return new ResponseEntity<>("Staff Id successfully deleted!", HttpStatus.OK);
	}
}
