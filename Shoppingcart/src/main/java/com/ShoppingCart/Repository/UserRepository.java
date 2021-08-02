package com.ShoppingCart.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ShoppingCart.model.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
	
}
