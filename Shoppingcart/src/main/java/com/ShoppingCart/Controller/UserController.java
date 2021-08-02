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
//import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ShoppingCart.Service.UserService;
import com.ShoppingCart.model.User;

@RestController
@RequestMapping(path ="api/v1/user")
public class UserController {
	@Autowired
	private UserService userService;
	
	@GetMapping("/dislay")
    public List<User> list() {
	     return userService.listAll();
	}
	
	@GetMapping("/{bookId}")
	public ResponseEntity <User> get(@PathVariable Integer userId) {
		try {
			User user = userService.get(userId);
			return new ResponseEntity<User>(user, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/adduser")
	public void add(@RequestBody User user) {
		userService.save(user);
	}
	
	@PutMapping("/{userId}")
		public ResponseEntity<User> update(@RequestBody User user, @PathVariable Integer userId) {
		try {
		userService.update(userId, user);
		return new ResponseEntity<User>(user, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	@DeleteMapping("/{userId}")
	public void delete (@PathVariable Integer userId) {
		userService.delete(userId);
	}


}
