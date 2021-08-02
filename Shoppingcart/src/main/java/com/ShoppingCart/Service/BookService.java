package com.ShoppingCart.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ShoppingCart.Repository.BookRepository;
import com.ShoppingCart.model.Book;



@Service
public class BookService {
	
	@Autowired
	private BookRepository bookRepo;
	
	public List<Book> listAll(){
		return bookRepo.findAll();	
		}
	
	public void save(Book book) {
		bookRepo.save(book);
	}
	
	public Book get(Integer bookId) {
		return bookRepo.findById(bookId).get();
		}
	public void update(Integer bookId, Book book) {
		Book bookdata = bookRepo.findById(bookId).get();
		bookdata.setName(book.getName());
		bookdata.setAuthor(book.getAuthor());
		bookdata.setGenre(book.getGenre());
		bookdata.setISBN(book.getISBN());
		bookRepo.save(book);
	}

	public void delete(Integer bookId) {
		bookRepo.deleteById(bookId);
		
	}
}
