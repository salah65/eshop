package edu.miu.cs.cs425.eshop.product.mapper;

import edu.miu.cs.cs425.eshop.core.Mapper;
import edu.miu.cs.cs425.eshop.product.dto.ProductRequest;
import edu.miu.cs.cs425.eshop.product.dto.ProductResponse;
import edu.miu.cs.cs425.eshop.product.model.Product;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductMapper implements Mapper<Product, ProductRequest,ProductResponse> {
    @Override
    public ProductResponse mapToResponse(Product product) {
        return new ProductResponse(product.getId(), product.getName(), product.getDescription());
    }

    @Override
    public Product mapToDomain(ProductRequest productRequest) {
        return new Product(productRequest.getName(), productRequest.getDescription());
    }

    @Override
    public List<ProductResponse> mapToResponses(List<Product> products) {
        return products.stream().map((product) -> new ProductResponse(
                product.getId(), product.getName(), product.getDescription())).toList();

    }
}
