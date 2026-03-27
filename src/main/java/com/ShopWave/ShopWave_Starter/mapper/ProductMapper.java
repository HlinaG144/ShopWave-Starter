// Hlina Girum/ATE/3417/14

package com.ShopWave.ShopWave_Starter.mapper;

import com.ShopWave.ShopWave_Starter.dto.ProductDTO;
import com.ShopWave.ShopWave_Starter.model.Product;

public class ProductMapper {
    public ProductDTO toDTO(Product product){
        if (product == null)
            return null;
        else
            return ProductDTO.builder()
                    .id(product.getId())
                    .name(product.getName())
                    .price(product.getPrice())
                    .stock(product.getStock())
                    .description(product.getDescription())
                    .categoryName(product.getCategory() != null ? product.getCategory().getName():null)
                    .categoryId(product.getCategory() !=null? product.getCategory().getId():null)
                    .createdAt(product.getCreatedAt())
                    .build();
    }
}
