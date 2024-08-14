package edu.miu.cs.cs425.eshop.product.service;

import edu.miu.cs.cs425.eshop.product.model.Product;

import java.util.List;

public interface ProductService {
     Product createProduct(Product product);
     Product getProductById(Integer id);
     List<Product> getAllProducts();
}
