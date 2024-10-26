package com.mahesh.springboot.BookCRUD.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.mahesh.springboot.BookCRUD.entity.Book;
import com.mahesh.springboot.BookCRUD.repository.BookRepository;

@Service
public class BookService {
      @Autowired
	 private BookRepository bookrepository;
      
     //add a book
 
      public ResponseEntity<Book> createBook(@RequestBody Book book) {
    	  try {
    		  Book booksaved= bookrepository.save(book);
    	  
      	return new ResponseEntity<>(booksaved,HttpStatus.CREATED);
      	}
      	catch(Exception e) {
      		return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
      }
    	
      }
      //get all books
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
