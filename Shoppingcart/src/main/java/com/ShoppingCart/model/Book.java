package com.ShoppingCart.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "book")
public class Book {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer bookId;
	
	@JsonIgnore
	@OneToMany(mappedBy = "book") 
	  private Set<Cart> cart = new HashSet<>();
	
	private String name, author, genre,ISBN;
	


	
	public Book() {
	
	}
	
	
	

	

	public Book(String name, String author, String genre, String iSBN) {
		this.name = name;
		this.author = author;
		this.genre = genre;
		ISBN = iSBN;
	}



	public Book(Integer bookId, String name, String author, String genre, String iSBN) {
		this.bookId = bookId;
		this.name = name;
		this.author = author;
		this.genre = genre;
		ISBN = iSBN;
	}


	public Book(Set<Cart> cart, String name, String author, String genre, String iSBN) {
		this.cart = cart;
		this.name = name;
		this.author = author;
		this.genre = genre;
		this.ISBN = iSBN;
	}






	public Integer getBookId() {
		return bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	public Set<Cart> getCart() {
		return cart;
	}

	public void setCart(Set<Cart> cart) {
		this.cart = cart;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}






	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", name=" + name + ", author=" + author + ", genre=" + genre + ", ISBN="
				+ ISBN + "]";
	}
	

}