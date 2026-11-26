package com.example.FoodSprint_Back.Entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "restaurants")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Restaurants {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

@NotBlank(message = "Restaurant name is required")
@Size(max = 150)
@Column(name = "name", nullable = false, length = 150)
private String name;

@Column(name = "description", columnDefinition = "TEXT")
private String description;

@NotBlank (message = "Address is required")
@Size(max = 255)
@Column(name = "address", nullable = false, length = 255)
private String address;

@Size (max = 100)
@Column(name = "city", length = 100)
private String city;

@Digits(integer = 3, fraction = 7)
@Column(name = "latitude", precision = 10, scale = 7)
private BigDecimal latitude;

@Digits (integer = 3, fraction = 7)
@Column(name = "longitude", precision = 10, scale = 7)
private BigDecimal longitude;

@Size (max = 15)
@Column(name = "phone", length = 15)
private String phone;

@Email (message = "Enter a valid a valid email address")
@Size (max = 150)
@Column(name = "email", length = 150)
private String email;

@Size (max = 500)
@Column(name = "image_url", length = 500)
private String imageUrl;

@DecimalMin ("0.0")
@Digits (integer = 1, fraction = 1)
@Column(name = "rating", precision = 2, scale = 1)
private BigDecimal rating = BigDecimal.ZERO;

@Column(name = "delivery_time")
private Integer deliveryTime;

@DecimalMin ("0.0")
@Digits (integer = 8,fraction = 2)
@Column(name = "delivery_fee", precision = 10, scale = 2)
private BigDecimal deliveryFee = BigDecimal.ZERO;

@DecimalMin ("0.0")
@Digits (integer = 8, fraction = 2)
@Column(name = "minimum_order", precision = 10, scale = 2)
private BigDecimal minimumOrder = BigDecimal.ZERO;

@Column(name = "is_open")
private Boolean isOpen = true;

@Column(name = "created_at", updatable = false,
        insertable = false,
        columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
private LocalDateTime createdAt;


}
