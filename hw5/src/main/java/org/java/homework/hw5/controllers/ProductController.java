package org.java.homework.hw5.controllers;

import org.java.homework.hw5.dtos.ProductDto;
import org.java.homework.hw5.services.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;
    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping("/")
    public List<ProductDto> getAllProducts() {
        return productService.getAllProducts().stream()
                .map(p -> new ProductDto(p.getProductId(), p.getAccountNumber(), p.getBalance(), p.getProductType()))
                .collect(Collectors.toList());
    }

    @GetMapping("/{productId}")
    public List<ProductDto> getProductByProductId(@PathVariable Long productId) {
        return productService.getProductByProductId(productId).stream()
                .map(p -> new ProductDto(p.getProductId(), p.getAccountNumber(), p.getBalance(), p.getProductType()))
                .collect(Collectors.toList());
    }

    @GetMapping("/user/{userId}")
    public List<ProductDto> getProductsByUserId(@PathVariable Long userId) {
        return productService.getProductsByUserId(userId).stream()
                .map(p -> new ProductDto(p.getProductId(), p.getAccountNumber(), p.getBalance(), p.getProductType()))
                .collect(Collectors.toList());
    }
}
