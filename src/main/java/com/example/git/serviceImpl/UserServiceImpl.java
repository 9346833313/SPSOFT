package com.example.git.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.git.entity.User;
import com.example.git.repository.UserRepository;
import com.example.git.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public ResponseEntity<?> createUser(User user) {

		userRepository.save(user);
		System.out.println("added testing ");
		return new ResponseEntity<>("User created successfully", HttpStatus.CREATED);

	}

	@Override
	public ResponseEntity<?> getUsers() {
		return new ResponseEntity<>(userRepository.findAll(), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> getById(long id) {
		Optional<User> findById = userRepository.findById(id);
		if (findById.isPresent()) {
			User user = findById.get();
			return new ResponseEntity<>(user, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public ResponseEntity<?> updateUser(User user, long id) {
		Optional<User> findById = userRepository.findById(id);
		if (findById.isPresent()) {
			User existingUser = findById.get();

			existingUser.setUserName(user.getUserName());
			existingUser.setEmailId(user.getEmailId());
			existingUser.setPhnoneNo(user.getPhnoneNo());

			userRepository.save(existingUser);
			return new ResponseEntity<>("User updated successfully", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public ResponseEntity<?> deleteUser(long id) {

		Optional<User> findById = userRepository.findById(id);
		if (findById.isPresent()) {
			User user = findById.get();
			userRepository.delete(user);
			return new ResponseEntity<>("User deleted successfully", HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
		}

	}

}
