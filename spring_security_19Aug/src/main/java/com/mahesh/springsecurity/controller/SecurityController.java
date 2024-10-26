package com.mahesh.springsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api")
public class SecurityController {
	@GetMapping("/welcome")
  public String welcome() {
	  return "Welcome to Spring Security";
  }
	@GetMapping("/admin")
	  public String admin() {
		  return "admin.html";
	  }
	@GetMapping("/login")
	  public String login() {
		  return "login.html";
	  }
}
