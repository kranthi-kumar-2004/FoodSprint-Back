package com.example.FoodSprint_Back.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity 
@Data 
@NoArgsConstructor 
@AllArgsConstructor 
public class User {
    @Id 
    @GeneratedValue (strategy=GenerationType.IDENTITY)
    private Integer id;
    private String restaurantName;
    private String description;
    private String ownerName;
    private String email;
    private String phone;
    private String password;
    private String address;
    private String city;
    private String state;
    private String pincode;
}
