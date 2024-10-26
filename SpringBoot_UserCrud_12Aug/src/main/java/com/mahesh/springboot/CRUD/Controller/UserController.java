package com.mahesh.springboot.CRUD.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mahesh.springboot.CRUD.Service.UserService;
import com.mahesh.springboot.CRUD.entity.User;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
	UserService userservice;
    
	@GetMapping("/users")
	public List<User> getAllUsers(){
		return userservice.getAllUsers();
	}
	
	@GetMapping("/user/{id}")
	 public User getUser(@PathVariable("id") int id) {
		return  userservice.getUserById(id);
	}
	
	@DeleteMapping("/user/{id}")
	public void deleteUser(@PathVariable("id") int id) {
		userservice.deleteUserById(id);
	}
	
	@PostMapping("/user")
	public void addUser(@RequestBody User user) {
		userservice.saveorUpdate(user);
	}
	@PutMapping("/user")
	public void updateUser(@RequestBody User user) {
		userservice.saveorUpdate(user);
	}
	
	
}
