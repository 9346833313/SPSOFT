package com.example.git.controller;






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

import com.example.git.entity.User;
import com.example.git.service.UserService;

;

@RequestMapping("/user")
@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping
	public ResponseEntity<?> createUser(@RequestBody User user){
		return userService.createUser(user);
		
	}
	
	@GetMapping
	public ResponseEntity<?> getAllUsers(){
		return userService.getUsers();
	}
	
	@GetMapping("{id}")
	public ResponseEntity<?> getById(@PathVariable long id){
		return userService.getById(id);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<?> updateUser(@RequestBody User user,@PathVariable long id){
		return userService.updateUser(user, id);
		
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<?> deleteUser(@PathVariable long id){
		return userService.deleteUser(id);
		
	}
	
	
}

