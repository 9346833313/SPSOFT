package com.example.git.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.git.entity.Staff;

public interface StaffRepository extends JpaRepository<Staff, Long> {

}
