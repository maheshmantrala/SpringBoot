package com.mahesh.springboot.BookCRUD.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mahesh.springboot.BookCRUD.entity.Book;
import com.mahesh.springboot.BookCRUD.repository.BookRepository;

@RestController
@RequestMapping("/api")
public class BookController {
	
	 @Autowired
	 private BookRepository bookrepository;
      
     //add a book
     @PostMapping("/books")
      public ResponseEntity<Book> createBook(@RequestBody Book book) {
    	  try {
    		  Book booksaved= bookrepository.save(book);
    	  
      	return new ResponseEntity<>(booksaved,HttpStatus.CREATED);
      	}
      	catch(Exception e) {
      		return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
      }
    	
      }
     
     @GetMapping("/books")
      public ResponseEntity<List<Book>> getAllBooks(@RequestParam(required=false) String title){
    	  List<Book> books=new ArrayList<Book>();
    	 
    	  try{
    		  if(title==null)
    	  
    	     bookrepository.findAll().forEach(books::add);
    	  else
    		  bookrepository.findByTitleContaining(title).forEach(books::add);
    		
    	   	  if(books.isEmpty()) 
    	   		 return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
    	   	  return new ResponseEntity<>(HttpStatus.OK);
    	  
      }
      catch(Exception e) {
    	  return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
      }
      
}}

