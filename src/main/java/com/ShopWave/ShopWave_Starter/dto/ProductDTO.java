// Hlina Girum/ATE/3417/14

package com.ShopWave.ShopWave_Starter.dto;

import lombok.Builder;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Builder
@Data

public class ProductDTO {
    private Long id;
    private String name;
    private int stock;
    private BigDecimal price;
    private String description;
    private String categoryName;
    private Long categoryId;
    private LocalDateTime createdAt;
}
