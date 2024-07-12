package com.example.git.service;

import java.util.List;

import com.example.git.entity.Staff;

public interface StaffService {

	public Staff createStaff(Staff staff);

	public Staff getStaffById(Long staffId);

	public List<Staff> getAllStaff();

	public Staff UpdateStaff(Staff staff);

	public void deleteStaff(Long staffId);

}
