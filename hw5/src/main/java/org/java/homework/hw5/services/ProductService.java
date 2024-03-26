package org.java.homework.hw5.services;

import org.java.homework.hw5.entities.ProductEntity;
import java.util.List;

public interface ProductService {
    List<ProductEntity> getProductsByUserId(Long userId);
    List<ProductEntity> getProductByProductId(Long id);
    List<ProductEntity> getAllProducts();
}

