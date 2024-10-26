package com.mahesh.springboot.CRUD.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mahesh.springboot.CRUD.Repository.UserRepository;
import com.mahesh.springboot.CRUD.entity.User;

@Service
public class UserService {
	
	@Autowired
	UserRepository userrepo;
	
	public List<User> getAllUsers() {
		List<User> users=new ArrayList<User>();
		userrepo.findAll().forEach(user->users.add(user));	
		return users;
	} 
	public User getUserById(int id) {
		Optional<User>user= userrepo.findById(id);
		if(user.isPresent())
			return user.get();
		return null;
	}
	public void saveorUpdate(User user) {
		userrepo.save(user);
	}
	public void deleteUserById(int id) {
		userrepo.deleteById(id);
	}

}
