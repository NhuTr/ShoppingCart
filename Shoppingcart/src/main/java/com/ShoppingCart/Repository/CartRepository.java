package com.ShoppingCart.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ShoppingCart.model.Cart;

@Repository
public interface CartRepository extends JpaRepository <Cart,Integer> {


}

