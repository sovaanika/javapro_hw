package org.java.homework.hw5.services;

import org.java.homework.hw5.entities.ProductEntity;
import org.java.homework.hw5.repositories.ProductRepo;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepo productRepo;

    public ProductServiceImpl(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    @Override
    public List<ProductEntity> getProductsByUserId(Long userId) {
        return productRepo.getProductsByUserId(userId);
    }

    @Override
    public List<ProductEntity> getProductByProductId(Long id) {
        return productRepo.getProductByProductId(id);
    }

    @Override
    public List<ProductEntity> getAllProducts() {
        return productRepo.getAllProducts();
    }
}
