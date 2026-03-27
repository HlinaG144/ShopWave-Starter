// Hlina Girum/ATE/3417/14

package com.ShopWave.ShopWave_Starter.repository;

import com.ShopWave.ShopWave_Starter.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByCategoryId(Long categoryId);
    List<Product> findByPriceLessThanEqual(BigDecimal maxPrice);
    List<Product> findByNameContainingIgnoreCase(String keyword);
    Optional<Product> findTopByOrderByPriceDesc();
}
