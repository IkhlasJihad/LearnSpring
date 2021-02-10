package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.id.CompositeNestedGeneratedValueGenerator.GenerationPlan;
import org.hibernate.tuple.GeneratedValueGeneration;

@Entity
@Table(name= "book")
public class Book {
	@Id
	@GeneratedValue
	private long id;
	
	@Column
	private String name;
	
	@Column(name = "author_name")
	private String authorName;
	
	@Column
	private String isbn;

	public Book() {}
	
	public Book(String name, String authorName, String isbn) {
		this.name = name;
		this.authorName = authorName;
		this.isbn = isbn;
	}
	public Book(long id, String name, String authorName, String isbn) {
		this.id = id;
		this.name = name;
		this.authorName = authorName;
		this.isbn = isbn;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}	
}
