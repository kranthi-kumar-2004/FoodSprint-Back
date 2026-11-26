package com.example.FoodSprint_Back.Entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "restaurants")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Restaurants {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 150)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    private String address;

    private String city;

    private BigDecimal latitude;

    private BigDecimal longitude;

    private String phone;

    private String email;

    @Column(name = "image_url", length = 500)
    private String imageUrl;

    private BigDecimal rating = BigDecimal.ZERO;

    @Column(name = "delivery_time")
    private Integer deliveryTime;

    @Column(name = "delivery_fee")
    private BigDecimal deliveryFee;

    @Column(name = "minimum_order")
    private BigDecimal minimumOrder;

    @Column(name = "is_open")
    private Boolean isOpen = true;

    @Column(name = "created_at", updatable = false,
            insertable = false,
            columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createdAt;

    @OneToMany(
        mappedBy = "restaurant",
        cascade = CascadeType.ALL,
        orphanRemoval = true
    ) 
    @JsonManagedReference 
    private List<MenuItems> menuItems = new ArrayList<>();
}