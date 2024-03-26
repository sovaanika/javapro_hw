package org.java.homework.hw5.repositories;

import org.java.homework.hw5.entities.ProductEntity;
import java.util.List;

public interface ProductRepo {
    List<ProductEntity> getAllProducts();
    List<ProductEntity> getProductsByUserId(Long userId);
    List<ProductEntity> getProductByProductId(Long id);
}
