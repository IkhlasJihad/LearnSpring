package com.example.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.model.Book;
import com.example.demo.repo.BookRepository;

@Service
@Transactional
public class BookServiceImp implements BookService {
	@Autowired
	private BookRepository bookRepository;
	
	@Override
	public Book addBook(Book book) {
		return bookRepository.save(book);		
	}
	@Override
	public Book getBookById(long id) {
		return bookRepository.findById(id).get();
	}
	@Override
	public List<Book> getBooks(){
		return bookRepository.findAll();
	}
	
	@Override
	public Book updateBook(Book book){
		if(!bookRepository.findById(book.getId()).isPresent()) {
			throw new ResourceNotFoundException("Record not found with id: " + book.getId());
		}
		else
			return bookRepository.save(book);
	}
	@Override
	public void deleteBook(Long id) {
		if(!bookRepository.findById(id).isPresent()) {
			throw new ResourceNotFoundException("Record not found with id: " + id);
		}
		else
			bookRepository.delete(bookRepository.findById(id).get());
	}
}
