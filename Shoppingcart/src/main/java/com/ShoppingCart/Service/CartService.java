package com.ShoppingCart.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ShoppingCart.Repository.BookRepository;
import com.ShoppingCart.Repository.CartRepository;
import com.ShoppingCart.Repository.UserRepository;
import com.ShoppingCart.model.Book;
import com.ShoppingCart.model.Cart;
import com.ShoppingCart.model.User;

@Service
public class CartService {
	
	
	
	
@Autowired
  private final BookRepository bookRepo;
  private final UserRepository userRepo;
  private final CartRepository cartRepo;




  @Autowired
  public CartService(BookRepository bookRepo,UserRepository userRepo, CartRepository cartRepo) {
	this.bookRepo = bookRepo;
	this.userRepo = userRepo;
	this.cartRepo = cartRepo;
}



  //Returns list of cards / GET METHOD
  public List<Cart> getCart(){
	  return cartRepo.findAll();
  }
  
  public Cart get(Integer cartId) {
		return cartRepo.findById(cartId).get();
		}
  public void save(Cart cart) {
		cartRepo.save(cart);
	}
  
  public void updateQuantity(Integer cartId, Cart cart) {
		Cart cartdata = cartRepo.findById(cartId).get();
		cartdata.setQuantity(cart.getQuantity());
		cartRepo.save(cart);
	}
  public void updateBook(Integer bookId, Book book) {
		Book bookdata = bookRepo.findById(bookId).get();
		bookdata.setBookId(bookId);
		bookRepo.save(book);
	}
  
  
  public Cart assignCarttoUser( Integer userId,Integer cartId) {
	  User user = userRepo.findById(userId).get();
 	  Cart cart = cartRepo.findById(cartId).get();
      cart.assignUser(user);
      return cartRepo.save(cart);
 
  }
  
  public Cart assignBooktoCart(Integer bookId, Integer cartId) {
	  Book book = bookRepo.findById(bookId).get();
	  Cart cart = cartRepo.findById(cartId).get();
	  cart.assignBook(book);
	  return cartRepo.save(cart);
  }
  public void delete(Integer cartId) {
		cartRepo.deleteById(cartId);
		
	}
}



