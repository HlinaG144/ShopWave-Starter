// Hlina Girum/ATE/3417/14

package com.ShopWave.ShopWave_Starter.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private String orderNumber;


    @Column
    private String description;

    @Positive
    @Column
    private BigDecimal price;

    public enum OrderStatus {
        PENDING,
        SHIPPED,
        DELIVERED,
        CANCELLED
    }

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private OrderStatus status;

    @Column
    private BigDecimal totalAmount;

    @CreationTimestamp
    @CreatedDate
    @Column
    private LocalDateTime auto;

    @OneToMany
    @Column
    private OrderItem items;
}
