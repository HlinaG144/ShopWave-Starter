//Hlina Girum ATE/3417/14

package com.ShopWave.ShopWave_Starter.service;

import com.ShopWave.ShopWave_Starter.dto.CreateProductRequest;
import com.ShopWave.ShopWave_Starter.dto.ProductDTO;
import com.ShopWave.ShopWave_Starter.mapper.ProductMapper;
import com.ShopWave.ShopWave_Starter.model.Category;
import com.ShopWave.ShopWave_Starter.model.Product;
import com.ShopWave.ShopWave_Starter.repository.CategoryRepository;
import com.ShopWave.ShopWave_Starter.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @Mock
    private CategoryRepository categoryRepository;

    @Mock
    private ProductMapper productMapper;

    @InjectMocks
    private ProductServiceImp productService;

    @Test
    void createProduct_shouldCreateProduct_whenCategoryExists() {
        CreateProductRequest request = CreateProductRequest.builder()
                .name("Laptop")
                .description("Business laptop")
                .price(new BigDecimal("1299.99"))
                .stock(10)
                .categoryId(1L)
                .build();

        Category category = Category.builder()
                .id(1L)
                .name("Electronics")
                .description("Electronic items")
                .build();

        Product savedProduct = Product.builder()
                .id(100L)
                .name("Laptop")
                .description("Business laptop")
                .price(new BigDecimal("1299.99"))
                .stock(10)
                .category(category)
                .createdAt(LocalDateTime.now())
                .build();

        ProductDTO response = ProductDTO.builder()
                .id(100L)
                .name("Laptop")
                .description("Business laptop")
                .price(new BigDecimal("1299.99"))
                .stock(10)
                .categoryId(1L)
                .categoryName("Electronics")
                .createdAt(savedProduct.getCreatedAt())
                .build();

        when(categoryRepository.findById(1L)).thenReturn(Optional.of(category));
        when(productRepository.save(any(Product.class))).thenReturn(savedProduct);
        when(productMapper.toDTO(savedProduct)).thenReturn(response);

        ProductDTO result = productService.createProduct(request);

        assertNotNull(result);
        assertEquals(100L, result.getId());
        assertEquals("Laptop", result.getName());
        assertEquals("Electronics", result.getCategoryName());

        verify(categoryRepository).findById(1L);
        verify(productRepository).save(any(Product.class));
        verify(productMapper).toDTO(savedProduct);
    }

    @Test
    void createProduct_shouldThrowException_whenCategoryNotFound() {
        CreateProductRequest request = CreateProductRequest.builder()
                .name("Laptop")
                .description("Business laptop")
                .price(new BigDecimal("1299.99"))
                .stock(10)
                .categoryId(99L)
                .build();

        when(categoryRepository.findById(99L)).thenReturn(Optional.empty());

        EntityNotFoundException ex = assertThrows(
                EntityNotFoundException.class,
                () -> productService.createProduct(request)
        );

        assertEquals("Category not found with id: 99", ex.getMessage());
        verify(categoryRepository).findById(99L);
        verify(productRepository, never()).save(any(Product.class));
        verify(productMapper, never()).toDTO(any(Product.class));
    }
}
