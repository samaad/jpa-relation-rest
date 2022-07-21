package org.learning.jparelationrest.controller;

import java.util.List;
import org.learning.jparelationrest.modal.dto.ProductDTO;
import org.learning.jparelationrest.modal.entity.Products;
import org.learning.jparelationrest.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {


    @Autowired
    private ProductService productService;


    @PostMapping
    @ResponseBody
    public Products saveProduct(@RequestBody ProductDTO productDTO) {
        Products saveProduct = productService.createProduct(productDTO);
        return saveProduct;
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Products getProductByid(@PathVariable Long id) {
        Products saveProduct = productService.getProduct(id);
        return saveProduct;
    }

    @GetMapping()
    @ResponseBody
    public List<Products> getProduct() {
        List<Products> saveProduct = productService.getAllProducts();
        return saveProduct;
    }
}
