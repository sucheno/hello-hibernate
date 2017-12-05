package com.suchen.hibernate;
import javax.persistence.*;

@Entity
@Table(name="book")
public class Book {

	@Id
	@Column(name="book_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String title;
	private String author;
	private float price;
	
	public Book() {
		super();		
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}	
	
}
