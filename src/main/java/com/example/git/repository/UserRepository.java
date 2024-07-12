package com.example.git.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.git.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}

