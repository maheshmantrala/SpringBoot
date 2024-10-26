package com.mahesh.milestone3.controller;


import com.mahesh.milestone3.model.User;
import com.mahesh.milestone3.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
;

@RestController
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

     @PostMapping("/user")
    public boolean createUserProfile(@RequestParam String id, @RequestBody User userProfile) {
      
        return userService.createUserProfile(id, userProfile);
    }
       
    @GetMapping("user/{id}")
    public User getUserProfile(@PathVariable String id) {
       
        return userService.getUserProfileById(id);
    }
    
    @PutMapping("/user")
    public boolean updateUserProfile(@RequestParam String id,@RequestBody User userProfile) {
    	return userService.updateUserProfile(id, userProfile);
    }

   @DeleteMapping("user/{id}")
   public boolean deleteUser(@PathVariable String id){
	  return userService.deleteUserProfile(id);}
   
   @GetMapping("/users")
   public Map<String,User> getAllUsers(){
	   return userService.getAllUser();
   }
   
}