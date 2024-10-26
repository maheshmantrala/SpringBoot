package com.mahesh.springboot.BookCRUD.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="bookmaster")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Book {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)

	private int bookid;
	@Column(length=40)
	private String title;
	@Column(length=40)
	private String publisher;
	@Column(length=15)
	private String genre;
	public int getBookid() {
		return bookid;
	}
//	public void setBookid(int bookid) {
//		this.bookid = bookid;
//	}
//	public String getTitle() {
//		return title;
//	}
//	public void setTitle(String title) {
//		this.title = title;
//	}
//	public String getPublisher() {
//		return publisher;
//	}
//	public void setPublisher(String publisher) {
//		this.publisher = publisher;
//	}
//	public String getGenre() {
//		return genre;
//	}
//	public void setGenre(String genre) {
//		this.genre = genre;
//	}
	
}
