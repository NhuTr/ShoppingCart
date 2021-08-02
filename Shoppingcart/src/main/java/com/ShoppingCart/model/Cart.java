package com.ShoppingCart.model;

import javax.persistence.CascadeType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "cart_items")
public class Cart {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private int cartId;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name ="book_id",referencedColumnName= "bookId",
			insertable = true, updatable = true) 
	private Book book;
	 
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name ="user_id", referencedColumnName= "userId",
			insertable = true, updatable = true)
	private User user;
	
	
	
	private int quantity;
	
	
	
	
	public Cart() {

	}
	
	
	public Cart( int quantity) {
		
				this.quantity = quantity;
	}


	public Cart(int cartId, Book book, User user, int quantity) {
		this.cartId = cartId;
		this.book = book;
		this.user = user;
		this.quantity = quantity;
	}
	


	public Cart(Book book, User user, int quantity) {
		super();
		this.book = book;
		this.user = user;
		this.quantity = quantity;
	}


	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	public Book getBook() { 
		  return book;
	} 
	public void setBook(Book book) {
	  this.book = book; 
	}
	 
	
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public void assignUser(User user) {
		this.user = user;
	}
	
	public void assignBook(Book book) {
		this.book = book;
	}
	


	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", quantity=" + quantity + "]";
	}
	
	
	
}

