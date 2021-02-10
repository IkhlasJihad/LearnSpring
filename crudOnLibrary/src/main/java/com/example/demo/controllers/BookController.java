package com.example.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Book;
import com.example.demo.repo.BookRepository;
import com.example.demo.service.BookServiceImp;

@RestController
public class BookController {
	@Autowired
	private BookServiceImp bookservice;

	@PostMapping(value = "/addBook")
	public Book addBook(@RequestBody Book book) {
		return bookservice.addBook(book);
	}
	
	@GetMapping("/books")
	public List<Book> getAllBooks(){
		return bookservice.getBooks();
	}
	
	@GetMapping("/books/{id}")
	public Book getBookById(@PathVariable(value="id") long id){
		return bookservice.getBookById(id);
	}	
	
	@PutMapping("/updateBook/{id}")
	public Book updateBook(@PathVariable(value="id") long id, 
			               @RequestBody Book retrievedBook) {
		Book newBook = bookservice.getBookById(id);
		newBook.setAuthorName(retrievedBook.getAuthorName());
		newBook.setIsbn(retrievedBook.getIsbn());
		newBook.setName(retrievedBook.getName());
		return bookservice.updateBook(newBook);
	}
	
	@DeleteMapping("/deleteBook/{id}")
	public void deleteBook(@PathVariable(value="id") long id) {
		bookservice.deleteBook(id);
	}
	
	
}
