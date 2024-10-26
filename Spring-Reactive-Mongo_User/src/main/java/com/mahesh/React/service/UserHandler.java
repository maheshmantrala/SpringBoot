package com.mahesh.React.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import com.mahesh.React.model.User;
import com.mahesh.React.repository.UserRepository;

import reactor.core.publisher.Mono;



@Service
public class UserHandler {
 
	@Autowired
	 private UserRepository userRepo;
	
	 public Mono<ServerResponse> addUser(ServerRequest request){
    	 return request.bodyToMono(User.class)
    			 .flatMap(data->{
    				 return ServerResponse.ok()
    						 .body(userRepo.save(data),User.class);
    			 });
     }
	 
	 public  Mono<ServerResponse>  UpdateUserByEmailId(ServerRequest request) {
    	 return request.bodyToMono(User.class)
    			 .flatMap(data->{
    				 return userRepo.findById(data.getEmailid()).flatMap(change -> {
    				change.setEmailid(data.getEmailid());
    				change.setFname(data.getFname());
    				change.setLname(data.getLname());
    				change.setPassword(data.getPassword());
    				change.setMobile(data.getMobile());
    				 return ServerResponse.ok().body(userRepo.save(change),User.class);
       			 }).switchIfEmpty(ServerResponse.ok().bodyValue("NO USER DATA FOUND"));
     });
     }
	  public  Mono<ServerResponse> deleteUsertByEmailId(ServerRequest request){
	    	 return request.bodyToMono(User.class)
	    			 .flatMap(data->{
	    				 return ServerResponse.ok().body(userRepo.deleteById(data.getEmailid()),User.class);
	    				 }).switchIfEmpty(ServerResponse.ok().bodyValue("NO USER DATA FOUND"));
	    			 }
	    		
	  public  Mono<ServerResponse> getAllUsers(ServerRequest request){
	    	 return request.bodyToMono(User.class).flatMap(data->{
	    		 return ServerResponse.ok().body(userRepo.findAll(),User.class);
	    		  }).switchIfEmpty(ServerResponse.ok().bodyValue("NO USER DATA FOUND"));
	    			 
	    }
}
