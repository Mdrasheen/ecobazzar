package com.ecobazzar.ecobazzar.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecobazzar.ecobazzar.model.Product;
import com.ecobazzar.ecobazzar.service.ProductService;

@RestController

@RequestMapping("/products")

public class ProductController {


private final ProductService productService;
@GetMapping("/eco")

public List<Product> getEcoCertified() {

return productService.getEcoCertifiedProducts();

}


// New API 2: Get eco-certified products sorted by carbon impact

@GetMapping("/eco/sorted")

public List<Product> getEcoCertifiedSorted() {

return productService.getEcoCertifiedSortedByCarbonImpact();

}


// Constructor injection

public ProductController(ProductService productService) {

this.productService = productService;

}


// POST /products → add

@PostMapping

public Product addProduct(@RequestBody Product product) {

return productService.addProduct(product);

}


// GET /products → list

@GetMapping
public List<Product> getAllProducts() {

return productService.getAllProducts();

}


// PUT /products/{id} → update

@PutMapping("/{id}")

public Product updateProduct(@PathVariable Long id, @RequestBody Product product) {

return productService.updateProduct(id, product);

}


// DELETE /products/{id} → delete

@DeleteMapping("/{id}")

public void deleteProduct(@PathVariable Long id) {

productService.deleteProduct(id);

}

}