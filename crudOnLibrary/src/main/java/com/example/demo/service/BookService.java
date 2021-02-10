package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Book;

public interface BookService {
	Book addBook(Book book);
	Book getBookById(long id);
	List<Book> getBooks();
	void deleteBook(Long id);
	Book updateBook(Book book);		
}
