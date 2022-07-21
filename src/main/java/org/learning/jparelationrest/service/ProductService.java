package org.learning.jparelationrest.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.learning.jparelationrest.mapper.ProductMapper;
import org.learning.jparelationrest.modal.dto.ProductDTO;
import org.learning.jparelationrest.modal.entity.Products;
import org.learning.jparelationrest.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public Products createProduct(ProductDTO productDto) {
        Products products = productMapper.toEntity(productDto);
        return productRepository.save(products);
    }

    public Products getProduct(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Failed to find the Products"));
    }

    public List<Products> getAllProducts() {
        return productRepository.findAll();
    }
}
