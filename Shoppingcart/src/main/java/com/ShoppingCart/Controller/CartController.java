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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ShoppingCart.Repository.CartRepository;
import com.ShoppingCart.Repository.UserRepository;
import com.ShoppingCart.Service.CartService;
import com.ShoppingCart.model.Cart;


@RestController
@RequestMapping(path ="/cart")
public class CartController {
	
	@Autowired
	CartRepository cartRepo;
	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
    CartService cartService;
	
	@GetMapping
	List<Cart> getCart(){
		return cartRepo.findAll();
		}
	
	@GetMapping("/{cartId}")
	public ResponseEntity <Cart> get(@PathVariable("cartId") Integer cartId) {
		try {
			Cart cart = cartService.get(cartId);
			return new ResponseEntity<Cart>(cart, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Cart>(HttpStatus.NOT_FOUND);
		}
	}
	@PostMapping
	public void add(@RequestBody Cart cart) {
		cartService.save(cart);
	}
	
	
	
    @PutMapping("/adduser/{userId}/{cartId}")
    public Cart assignCartToUSer(
    	     @PathVariable Integer userId,@PathVariable Integer cartId
    	  ) 
    {
    	    return cartService.assignCarttoUser(userId,cartId);
    }
    
    @PutMapping("/addbook/{bookId}/{cartId}")
    public Cart assignBookToCart(
    	      @PathVariable Integer bookId,@PathVariable("cartId") Integer cartId
    	  )
    {
    	
    	    return cartService.assignBooktoCart(bookId,cartId);
    	  }
    @PutMapping("/update/{cartId}")
	public ResponseEntity<Cart> update(@RequestBody Cart cart, @PathVariable("cartId") Integer cartId
			) {
	try {
	     cartService.updateQuantity(cartId, cart);
	return new ResponseEntity<Cart>(cart, HttpStatus.OK);
	} catch (NoSuchElementException e) {
		return new ResponseEntity<Cart>(HttpStatus.NOT_FOUND);
	}
}
  
    
    @DeleteMapping("/delete/{cartId}")
	public void delete (@PathVariable Integer cartId) {
		cartService.delete(cartId);
	}

    
	
}
