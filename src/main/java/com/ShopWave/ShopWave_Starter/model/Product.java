package com.ShopWave.ShopWave_Starter.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column (nullable = false)
    private String name;

    @Column
    private String description;

    @Positive(message ="")
    @Column
    private BigDecimal price;

    @Column
    @Min(0)
    private Integer stock;

    @ManyToOne
    private Category category;
}
