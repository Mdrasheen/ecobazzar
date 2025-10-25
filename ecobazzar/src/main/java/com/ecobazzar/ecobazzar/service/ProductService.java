package com.ecobazzar.ecobazzar.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ecobazzar.ecobazzar.model.Product;
import com.ecobazzar.ecobazzar.repository.ProductRepository;

@Service

public class ProductService {


private final ProductRepository productRepository;
public List<Product> getEcoCertifiedProducts() {

return productRepository.findByEcoCertifiedTrue();

}
public List<Product> getEcoCertifiedSortedByCarbonImpact() {

return productRepository.findByEcoCertifiedTrueOrderByCarbonImpactAsc();

}


// Constructor injection

public ProductService(ProductRepository productRepository) {

this.productRepository = productRepository;

}


// CREATE

public Product addProduct(Product product) {

return productRepository.save(product);

}


// READ

public List<Product> getAllProducts() {

return productRepository.findAll();

}
public Product updateProduct(Long id, Product updatedProduct) {

return productRepository.findById(id)

.map(product -> {

product.setName(updatedProduct.getName());

product.setDetails(updatedProduct.getDetails());

product.setPrice(updatedProduct.getPrice());

product.setCarbonImpact(updatedProduct.getCarbonImpact());

product.setEcoCertified(updatedProduct.getEcoCertified());

product.setSellerId(updatedProduct.getSellerId());

return productRepository.save(product);

})

.orElseThrow(() -> new RuntimeException("Product not found"));

}


// DELETE

public void deleteProduct(Long id) {

productRepository.deleteById(id);

}


}