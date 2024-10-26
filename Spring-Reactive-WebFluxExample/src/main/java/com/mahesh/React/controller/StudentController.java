package com.mahesh.React.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import com.mahesh.React.entity.Student;
import com.mahesh.React.service.StudentService;
@RestController
@RequestMapping("/students")
public class StudentController {
	private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

	
	@GetMapping("/name")
    public Mono<Student> getStudent(@PathVariable String name) {
        return studentService.getPersonByName(name);
    }

	    @GetMapping
	    public Flux<Student> getAllStudents() {
	        return studentService.getAllStudents();
	    }
}
