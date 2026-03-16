package com.be.drinkshop.service;

import com.be.drinkshop.dto.CreateProductDTO;
import com.be.drinkshop.dto.StatisticDTO;
import com.be.drinkshop.dto.UpdateProductDTO;
import com.be.drinkshop.model.Product;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface ProductService {
    List<Product> getAllProducts(Long categoryId, Double minPrice, Double maxPrice, String search);

    Optional<Product> getProductById(Long id);

    List<Product> getProductsByCategory(Long categoryId);

    Product createProduct(CreateProductDTO product);

    Product updateProduct(Long id, UpdateProductDTO updateProductDTO);

    void deleteProduct(Long id);

    void addProductToFavorite(Long userId, Long productId);

    void removeProductFromFavorite(Long userId, Long productId);

    Set<Product> getFavoriteProducts(Long userId);

    StatisticDTO getTotalProductsStat();

    void updateQuantitySold(Long productId, int quantity);

    List<Product> getTopSoldProducts(int limit);
}
