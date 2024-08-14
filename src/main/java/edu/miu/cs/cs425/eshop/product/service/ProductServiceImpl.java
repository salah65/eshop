package edu.miu.cs.cs425.eshop.product.service;

import edu.miu.cs.cs425.eshop.product.model.Product;
import edu.miu.cs.cs425.eshop.product.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product createProduct(Product product) {
        productRepository.save(product);
        return productRepository.findById(product.getId().longValue()).orElseThrow();
    }

    @Override
    public Product getProductById(Integer id) throws NoSuchElementException {
       return productRepository.findById(id.longValue()).orElseThrow();
    }

    @Override
    public List<Product> getAllProducts() {
        return (List<Product>) productRepository.findAll();
    }
}
