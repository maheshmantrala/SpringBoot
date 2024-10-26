package com.mahesh.milestone3.service;

import java.util.HashMap;
import java.util.Map;


import org.springframework.stereotype.Service;

import com.mahesh.milestone3.model.User;

@Service
public class UserService {
   private final Map<String,User>userProfiles=new HashMap<>();
   
  
   public boolean createUserProfile(String id,User userProfile) {
	   if(userProfiles.containsKey(id)) {
		   return false;
	   }
	   userProfile.setId(id);
	   userProfiles.put(id, userProfile);
	   return true;
   }
   

   // Get a user profile by ID
   public User getUserProfileById(String id) {
       return userProfiles.getOrDefault(id, null);
   }

   
  public boolean deleteUserProfile(String id) {
	  if (userProfiles.remove(id)!= null){
		  return true;
	  }
	  return false;
	  
  }
  public boolean updateUserProfile(String id,User updatedProfile) {
	  if(!userProfiles.containsKey(id)) {
		  return false;
	  }
	  updatedProfile.setId(id);
	 userProfiles.put(id, updatedProfile);
	 return true;
  }
  
  public Map<String,User> getAllUser(){
	  return new HashMap<>(userProfiles);
  } 
}
   

