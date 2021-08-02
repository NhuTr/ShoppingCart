package com.ShoppingCart.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ShoppingCart.Repository.UserRepository;
import com.ShoppingCart.model.User;

@Service
public class UserService {
	
	
	@Autowired
	private UserRepository userRepo;
	public UserService(UserRepository userRepo) {
	    this.userRepo = userRepo;
	    
	}
	
	public List<User> listAll(){
		return userRepo.findAll();	
		}
	
	public void save(User user) {
		userRepo.save(user);
	}
	
	public User get(Integer userId) {
		return userRepo.findById(userId).get();
		}
	public void update(Integer userId, User user) {
		User userdata = userRepo.findById(userId).get();
		userdata.setPassword(user.getName());
		userdata.setEmail(user.getEmail());
		userdata.setAddress(user.getAddress());
		userRepo.save(user);
	}

	public void delete(Integer bookId) {
		userRepo.deleteById(bookId);
		
	}

}
