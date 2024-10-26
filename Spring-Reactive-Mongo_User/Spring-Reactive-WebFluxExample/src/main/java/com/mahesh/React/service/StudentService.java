package com.mahesh.React.service;

import org.springframework.stereotype.Service;
import com.mahesh.React.entity.Student;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class StudentService {

	public Mono<Student> getPersonByName(String name) {
	        Student s = new Student(name, 30);
	        return Mono.just(s);
	    }

	    public  Flux<Student> getAllStudents() {
	Student mahesh=new Student("mahesh",1);
	Student neeraj=new Student("neeraj",2);
	    List<Student> students = List.of(mahesh,neeraj);
	     return Flux.fromIterable(students);  
	     
    }
	}

