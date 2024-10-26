package com.mahesh.SpringBottWebMVC_07Aug_Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SpringMvcController {
	@RequestMapping(value="/",method=RequestMethod.GET)
 public String MyHome() {
	 return "home";
 } 
}
