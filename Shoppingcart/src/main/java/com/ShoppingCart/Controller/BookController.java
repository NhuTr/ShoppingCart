package com.ShoppingCart.Controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ShoppingCart.Service.BookService;
import com.ShoppingCart.model.Book;

@RestController
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@GetMapping("/book")
    public List<Book> list() {
	     return bookService.listAll();
	}
	
	@GetMapping("/book/{bookId}")
	public ResponseEntity <Book> get(@PathVariable Integer bookId) {
		try {
			Book book = bookService.get(bookId);
			return new ResponseEntity<Book>(book, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Book>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/book/addbook")
	public void add(@RequestBody Book book) {
		bookService.save(book);
	}
	
	@PutMapping("/book/{bookId}")
		public ResponseEntity<Book> update(@RequestBody Book book, @PathVariable Integer bookId) {
		try {
		bookService.update(bookId, book);
		return new ResponseEntity<Book>(book, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Book>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	@DeleteMapping("/book/{bookId}")
	public void delete (@PathVariable Integer id) {
		bookService.delete(id);
	}

}