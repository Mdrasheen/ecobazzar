package com.ecobazzar.ecobazzar.controller;

import com.ecobazzar.ecobazzar.model.CartItem;
import com.ecobazzar.ecobazzar.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController

@RequestMapping("/api/cart")

public class CartController {


private final CartService cartService; // dependency declared as final


// Constructor injection — no @Autowired needed

public CartController(CartService cartService) {

this.cartService = cartService;

}
//Add item to cart

@PostMapping

public CartItem addToCart(@RequestBody CartItem cartItem) {

return cartService.addToCart(cartItem);

}


//View all cart items for a user

@GetMapping("/{userId}")

public List<CartItem> getCart(@PathVariable Long userId) {

return cartService.getCartByUserId(userId);

}


//Delete item from cart

@DeleteMapping("/{id}")

public String removeFromCart(@PathVariable Long id) {

cartService.removeFromCart(id);

return "Item removed from cart!";

}

}
