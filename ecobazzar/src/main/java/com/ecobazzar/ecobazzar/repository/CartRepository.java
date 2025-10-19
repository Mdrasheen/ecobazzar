package com.ecobazzar.ecobazzar.repository;

import com.ecobazzar.ecobazzar.model.CartItem;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface CartRepository extends JpaRepository<CartItem, Long> {

List<CartItem> findByUserId(Long userId); // To get all cart items for one user

}