package com.mahesh.springboot.BookCRUD.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mahesh.springboot.BookCRUD.entity.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Integer> {
  
	List<Book> findByTitleContaining(String title);
}
