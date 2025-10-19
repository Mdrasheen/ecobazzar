package com.ecobazzar.ecobazzar.model;

import jakarta.persistence.*;

import lombok.EqualsAndHashCode;

import lombok.ToString;


@Entity

@Table(name = "cart_item")

@EqualsAndHashCode

@ToString

public class CartItem {


@Id

@GeneratedValue(strategy = GenerationType.IDENTITY)

private Long id;


private Long userId; // ID of the user who added the product

private Long productId; // ID of the product

private int quantity; // Number of units


// ----------------------------

// Constructors

// ----------------------------


public CartItem() {
	// Default constructor required by JPA

	}


	public CartItem(Long id, Long userId, Long productId, int quantity) {

	this.id = id;

	this.userId = userId;

	this.productId = productId;

	this.quantity = quantity;

	}


	// ----------------------------

	// Getters and Setters

	// ----------------------------


	public Long getId() {

	return id;

	}


	public void setId(Long id) {

	this.id = id;

	}


	public Long getUserId() {

	return userId;
	}
	public void setUserId(Long userId) {

		this.userId = userId;

		}


		public Long getProductId() {

		return productId;

		}


		public void setProductId(Long productId) {

		this.productId = productId;

		}


		public int getQuantity() {

		return quantity;

		}


		public void setQuantity(int quantity) {

		this.quantity = quantity;

		}

		}
