package com.ecobazzar.ecobazzar.service;

import com.ecobazzar.ecobazzar.model.CartItem;

import com.ecobazzar.ecobazzar.repository.CartRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;


@Service

public class CartService {


private final CartRepository cartRepository;


public CartService(CartRepository cartRepository) {

this.cartRepository = cartRepository;

}

// Add item to cart

public CartItem addToCart(CartItem cartItem) {

return cartRepository.save(cartItem);

}


// View cart by user ID

public List<CartItem> getCartByUserId(Long userId) {
	return cartRepository.findByUserId(userId);

	}


	// Remove an item

	public void removeFromCart(Long id) {

	cartRepository.deleteById(id);

	}

	}
