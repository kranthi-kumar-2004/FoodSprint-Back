package com.example.FoodSprint_Back.Entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "menu_items")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MenuItems {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id", nullable = false)
    @JsonBackReference 
    private Restaurants restaurant;

    @NotBlank(message = "Menu item name is required")
    @Size(max = 150)
    @Column(nullable = false, length = 150)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Size(max = 100)
    private String category;

    @NotNull(message = "Price is required")
    @DecimalMin(value = "0.01")
    @Digits(integer = 8, fraction = 2)
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal price;

    @Size(max = 500)
    @Column(name = "image_url", length = 500)
    private String imageUrl;

    @Column(name = "is_vegetarian")
    private Boolean isVegetarian = false;

    @Column(name = "is_available")
    private Boolean isAvailable = true;

    @Column(name = "is_bestseller")
    private Boolean isBestseller = false;

    @Column(name = "preparation_time")
    private Integer preparationTime;

    @Column(name = "created_at", updatable = false,
            insertable = false,
            columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createdAt;
}