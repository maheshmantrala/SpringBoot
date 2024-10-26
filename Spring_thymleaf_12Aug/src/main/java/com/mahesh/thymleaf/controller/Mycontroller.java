package com.mahesh.thymleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class Mycontroller {

@GetMapping("/greet/thymleaf")
	 public String myTemplate(@RequestParam(value="name",defaultValue="Thymleaf") String name, Model model) {
	      model.addAttribute("name",name);
		return "thymleafTemplate";
	}
}
