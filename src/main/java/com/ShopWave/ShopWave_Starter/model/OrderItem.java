// Hlina Girum/ATE/3417/14

package com.ShopWave.ShopWave_Starter.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @Column
    private String product;

    @Column
    private Integer quantity;

    @Column
    private BigDecimal unitPrice;
}
