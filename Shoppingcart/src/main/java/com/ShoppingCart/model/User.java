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
@Table(name= "user")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	
	
	  @JsonIgnore
	  
	  @OneToMany(mappedBy = "user") 
	  private Set<Cart> cart = new HashSet<>();
	 
	 
	private String username, password, name, email, address;
	
	
	

	public User() {
		
	}
	

	public User(int userId, String username, String password) {
		
		this.userId = userId;
		this.username = username;
		this.password = password;
	}



	public User(String username, String password, String name, String email) {
	
		this.username = username;
		this.password = password;
		this.name = name;
		this.email = email;
	}



	public User(String username, String password, String name,String email, String address) {
		this.username = username;
		this.password = password;
		this.name = name;
		this.email=email;
		this.address = address;
		
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	
	
	  public Set<Cart> getCart() { 
		  return cart; 
		  }
	  
	  public void setCart(Set<Cart> cart) {
		  this.cart = cart; 
		  }
	 
	 


	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", password=" + password + ", name=" + name
				+ ", email=" + email + "]";
	}
	
	

	}
	
	
