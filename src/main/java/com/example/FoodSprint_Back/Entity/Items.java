package com.example.FoodSprint_Back.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "items")
public class Items {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;

private String name;

private double price;

@ManyToOne
@JoinColumn(name = "rest_id")
private Restaurants restaurant;


}
