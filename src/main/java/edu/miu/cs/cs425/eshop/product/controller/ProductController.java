package edu.miu.cs.cs425.eshop.product.controller;

import edu.miu.cs.cs425.eshop.category.model.Category;
import edu.miu.cs.cs425.eshop.category.service.CategoryService;
import edu.miu.cs.cs425.eshop.product.dto.ProductRequest;
import edu.miu.cs.cs425.eshop.product.dto.ProductResponse;
import edu.miu.cs.cs425.eshop.product.mapper.ProductMapper;
import edu.miu.cs.cs425.eshop.product.model.Product;
import edu.miu.cs.cs425.eshop.product.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("eshop/api/products")
public class ProductController {
    private final ProductService productService;
    private final ProductMapper productMapper;
    private final CategoryService categoryService;

    public ProductController(
            ProductService productService,
            CategoryService categoryService,
            ProductMapper productMapper
    ) {
        this.productService = productService;
        this.productMapper = productMapper;
        this.categoryService = categoryService;
    }

    @PostMapping
    public ResponseEntity<ProductResponse> createProduct(@Valid @RequestBody ProductRequest productRequest) {
        Product product = productMapper.mapToDomain(productRequest);
        Category category=categoryService.getCategoryById(productRequest.getCategoryId());
        product.setCategories(category);
        Product savedProduct = productService.createProduct(product);
        return ResponseEntity.ok(productMapper.mapToResponse(savedProduct));
    }

    @GetMapping
    public ResponseEntity<List<ProductResponse>> getAllProducts() {
        List<Product> savedProduct = productService.getAllProducts();
        return ResponseEntity.ok(productMapper.mapToResponses(savedProduct));
    }

    @GetMapping(params = "productId")
    public ResponseEntity<ProductResponse> getProductById(@RequestParam("productId") Integer id) {
        Product savedProduct = productService.getProductById(id);
        return ResponseEntity.ok(productMapper.mapToResponse(savedProduct));
    }
}
