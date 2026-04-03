// Hlina Girum/ATE/3417/14

package com.ShopWave.ShopWave_Starter.dto;

import lombok.Builder;
import lombok.Data;
import java.math.BigDecimal;

@Builder
@Data

public class CreateProductRequest {
    private String name;
    private BigDecimal price;
    private Integer stock;
    private String description;
    private Long categoryId;
}
