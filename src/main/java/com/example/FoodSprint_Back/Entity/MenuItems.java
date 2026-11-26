package com.example.FoodSprint_Back.Entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "menu_items")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class MenuItems {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

// Many menu items belong to one restaurant
@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "restaurant_id", nullable = false)
private Restaurants restaurant;

@NotBlank (message = "Menu item name is required")
@Size (max = 150)
@Column(name = "name", nullable = false, length = 150)
private String name;

@Column(name = "description", columnDefinition = "TEXT")
private String description;

@Size (max = 100)
@Column(name = "category", length = 100)
private String category;

@NotNull (message = "Price is required")
@DecimalMin (value = "0.01", message = "Price must be greater than Zero")
@Digits (integer = 8,fraction = 2)
@Column(name = "price", nullable = false, precision = 10, scale = 2)
private BigDecimal price;

@Size (max = 500)
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
